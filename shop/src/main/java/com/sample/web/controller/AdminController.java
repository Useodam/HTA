package com.sample.web.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.service.ProductService;
import com.sample.service.UserService;
import com.sample.vo.Product;
import com.sample.vo.ProductCategory;
import com.sample.vo.User;
import com.sample.web.dto.ProductDto;
import com.sample.web.dto.UserDto;
import com.sample.web.form.ProductForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
public class AdminController {
	
	private final UserService userService;
	private final ProductService productService;

	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}
	
	// 상품관리에서 상품 목록화면 요청을 처리하는 요청핸들러 메소드
	@GetMapping("/product/list")
	public String products(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "admin/product/list";
	}
	
	// 상품관리에서 상품 등록화면 요청을 처리하는 요청핸들러 메소드
	@GetMapping("/product/create")
	public String productform() {
		return "admin/product/form";
	}
	
	// 상품관리에서 상품 등록 요청을 처리하는 요청핸들러 메소드
	@PostMapping("/product/create")
	public String createProduct(ProductForm productForm) {
		productService.createProduct(productForm);
		return "redirect:/admin/product/list";
	}
	
	@GetMapping("/user/list")
	public String users(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		
		return "admin/user/list";
	}
	
	/*
	 * 요청 방식
	 * 		GET
	 * 요청 URL
	 * 		http://localhost/admin/user/kane
	 * 요청 파라미터
	 * 		없음 
	 * 	요청 내용
	 * 		요청 URL에 포함된 사용자 아이디에 해당하는 사용자정보를 요청한다
	 * 	처리 내용
	 * 		요청 URL에 포함된 사용자 아이디를 @PathValiable 어노테이션을 이용해서 요청핸들러 메소드의 매개변수에 바인딩 시키고,
	 * 		해당 아이디로 사용자를 조회한 다음 UserDto객체를 생성해서 옮겨 담고, 직렬화 시켜서 응답으로 보낸다
	 */
	@GetMapping("/users/{userId}")
	@ResponseBody
	public UserDto user(@PathVariable("userId") String userId) {
		User user = userService.getUser(userId);
		UserDto dto = new UserDto();
		
		BeanUtils.copyProperties(user, dto);
		return dto;
	}
	
	@GetMapping("/product/{productNo}")
	@ResponseBody
	public ProductDto product(@PathVariable("productNo") int no) {
		Product product = productService.getProduct(no);
		ProductDto dto = new ProductDto();
		
		BeanUtils.copyProperties(product, dto);
		return dto;
	}
	
	@GetMapping(path = "/category")
	@ResponseBody      
	public List<ProductCategory> categories(@RequestParam("catNo") int catNo){
		return productService.getAllSubProductCategories(catNo);
	}
	
	@PostMapping("/product/modify")
	@ResponseBody
	public void modifyProduct(@RequestBody Product product) {
		System.out.println(product);
	}
	
	
	
}
