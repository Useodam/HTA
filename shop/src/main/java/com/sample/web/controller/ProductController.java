package com.sample.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.service.ProductService;
import com.sample.vo.Product;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	/*
	 * 요청 URL
	 * 		localhost/product/list?catNo=902
	 * 요청 파라미터
	 * 		catNo=902
	 * 요청 내용
	 * 		쿼리스트링으로 전달한 카테고리번호에 속하는 상품 목록화면을 요청한다
	 * 처리 내용
	 * 		쿼리스트링으로 전달한 카테고리번호에 해당하는 상품 목록 정보를 조회해서 Model 객체에 저장하고,
	 * 		"/WEB-INF/views/" + product/list + ".jsp" 페이지로 내부이동시킨다
	 */
	@GetMapping("/list")
	public String list(@RequestParam("catNo") int categoryNo, Model model) {
		List<Product> products = productService.getProducts(categoryNo);
		model.addAttribute("products", products);
		
		return "product/list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("no") int productNo, Model model) {
		Product product = productService.getProduct(productNo);
		model.addAttribute("product", product);
		
		return "product/detail";
	}
}
