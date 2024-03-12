package com.sample.web.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sample.service.OrderService;
import com.sample.service.ProductService;
import com.sample.vo.Order;
import com.sample.vo.Product;
import com.sample.web.dto.OrderDetailDto;
import com.sample.web.form.OrderForm;

import lombok.RequiredArgsConstructor;


/*
 * @SessionAttributes와 @ModelAttribute
 * 		+ @SessionAttribute
 * 			- Model 객체에 저장되는 데이터를 HttpSession에 저장시키는 어노테이션
 * 			- 컨트롤러 클래스에 @SessionAttributes 어노테이션이 있으면
 * 			  해당 컨트롤러의 요청핸들러 메소드에서 Model객체에 저장되는 데이터를 HttpSession 객체의 속성으로 저장시켜서
 * 			  해당 요청이 완료된 후에도 Model객체에 저장한 데이터가 유지되도록 한다
 * 			- 다른 요청핸들러 메소드에서 Model객체에 저장된 데이터를 공유하기 위해서다
 * 			- Model객체에 저장되는 모든 데이터가 HttpSession에 저장되는 것이 아니라, @SessionAttributes 어노테이션에서
 * 			  지정한 이름과 동일한 이름으로 Model객체에 저장되는 데이터만 대상이 된다
 * 
 * 		+ @ModelAttribute
 * 			- 요청핸들러 메소드의 매개변수에 적용했을 때
 * 			- 예시) public String sample(@ModelAttribute("sampleForm") SampleForm Form) { ... }
 * 				1. @ModelAttribute 어노테이션이 지정된 객체를 자동으로 생성한다
 * 					만약, "sampleForm"이라는 이름으로 HttpSession에 저장된 객체가 있으면 그 객체를 가져온다
 * 				2. 요청객체의 요청파라미터 값을 분석해서 SampleForm객체에 바인딩한다
 * 				3. @ModelAttribute 어노테이션이 지정된 객체는 Model객체에 "sampleForm"이라는 이름으로 저장되고, 뷰페이지에 값을 출력할 수 있다
 * 
 * 			- 메소드에 적용했을 때
 * 			- 예시) @ModelAttribute("categories")
 * 					public List<Category> categories() {
 * 						List<Category> categories = categoryService.getAllCategories();
 * 						return categories;
 * 					}
 * 
 * 				1. 요청핸들러 메소드가 실행되기 전에 @ModelAttribute가 지정된 메소드부터 먼저 실행된다
 * 				2. @ModelAttribute 어노테이션이 부착된 메소드가 반환되는 값을 자동으로 Model객체에 저장된다
 * 				3. 요청핸들러 메소드가 실행된다
 * 				4. 여러 JSP에서 공통으로 사용하는 데이터를 @ModelAttribute 어노테이션을 적용한 메소드로 Model 객체에 저장시키면
 * 					각각의 요청핸들러 메소드에서 그 데이터를 Model객체에 저장시키는 작업을 수행할 필요가 없다
 */

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
@SessionAttributes({"orderForm"})
@PreAuthorize("isAuthenticated()")
public class OrderController {
	
	private final ProductService productService;
	private final OrderService orderService;

	/*
	 * 요청방식
	 * 	GET
	 * 요청 URL
	 * 	localhost/order/step1?no=82
	 * 요청 파라미터
	 * 	no=82
	 * 요청 내용
	 * 	지정된 상품번호에 대한 주문정보 입력폼을 요청한다
	 * 처리 내용
	 * 	요청파라미터로 전달받은 상품정보에 대한 상세정보를 조회해서 모델에 저장하고, 주문정보 입력화면으로 내부이동한다
	 */
	@GetMapping("/step1")
	public String step1(@RequestParam("no")int productNo, Model model) {
		// 주문폼 화면에 출력할 상품정보를 조회하고, Model객체에 저장한다
		Product product = productService.getProduct(productNo);
		model.addAttribute("product", product);
		
		
		// 여러 단계로 구분된 입력작업에서 입력되는 데이터를 저장할 OrderForm객체를 생성하고 Model객체에 저장한다
		// "orderForm"이라는 이름으로 Model객체에 저장되는 데이터는 @SessionAttributes("orderForm")설정 때문에
		// OrderForm객체가 HttpSession에 자동으로 저장된다
		model.addAttribute("orderForm", new OrderForm());
		return "order/orderform";
	}
	
	/*
	 * 요청 방식
	 * 		POST
	 * 요청 URL
	 * 		localhost/order/step2
	 * 요청 파라미터
	 * 		productNo=?
	 * 		&name=?
	 * 		&price?
	 * 		&amount=?
	 * 		&totalPrice=?
	 * 요청 내용
	 * 		1단계 입력폼에서 입력한 내용을 전달하고, 2단계 입력폼을 요청한다
	 * 처리 내용
	 * 		1. @ModelAttribute("orderForm") 어노테이션은 HttpSession에서 "orderForm" 이름으로 저장된 OrderForm객체를 가져온다
	 * 		2. 요청파라미터로 전달된 값을 분석해서 OrderForm객체에 저장한다
	 * 		3. 요청핸들러 메소드의 매개변수 orderForm에 OrderForm객체를 전달한다
	 * 		4. 2단계 입력폼에 표시할 정보를 조회하고, Model에 저장한다
	 * 		5. 2단계 입력폼의 	뷰페이지 이름을 반환한다
	 */
	@PostMapping("/step2")
	public String step2(@ModelAttribute("orderForm") OrderForm orderForm) {
		// 2단계 입력폼에서 필요한 정보를 조회하고, Model에 저장하는 작업을 생략한다
		return "order/payform";
	}
	
	/*
	 * 	요청 방식
	 * 		POST
	 * 	요청 URL
	 * 		localhost/order/step3
	 * 	요청 파라미터
	 * 		payType=card
	 * 		&cardno=1234-5678-1234-5678
	 * 		&months=3
	 * 		&payAmount=1500000
	 * 	요청 내용
	 * 		2단계 입력폼에서 입력한 결재정보를 서버에 제출하고, 주문을 요청한다
	 * 	처리내용
	 * 		1. @ModelAttribute("orderForm") 어노테이션은 HttpSession에서 "orderForm" 이름으로 저장된 OrderForm객체를 가져온다
	 * 		2. 요청파라미터로 전달된 값을 분석해서 OrderForm객체에 저장한다 (결재정보가 OrderForm객체에 저장된다)
	 * 		3. 요청핸들러 메소드의 매개변수로 OrderForm객체를 전달한다
	 * 		4. OrderService객체의 order(OrderForm orderForm)를 실행해서 주문관련 업무로직을 실행시킨다
	 * 		5. 주문정보를 확인할 수 있는 URL을 재요청 URL로 보낸다
	 */
	@PostMapping("/step3")
	public String step3(@ModelAttribute("orderForm") OrderForm orderForm, Principal principal) {
		// 주문관련 업무로직 메소드를 실행한다
		String userId = principal.getName();
		Order order = orderService.saveOrder(orderForm, userId);
		return "redirect:completed?orderNo=" + order.getNo();
	}
	
	@GetMapping("/completed")
	public String completed(int orderNo, Principal principal, Model model) {
		String userId = principal.getName();
		
		OrderDetailDto dto = orderService.getOrderDetail(orderNo, userId);
		model.addAttribute("dto", dto);
		
		return "order/completed";
	}
}
