package com.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.mapper.CompanyMapper;
import com.sample.mapper.ProductCategoryMapper;
import com.sample.mapper.ProductMapper;
import com.sample.vo.Company;
import com.sample.vo.Product;
import com.sample.vo.ProductCategory;
import com.sample.web.form.ProductForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final CompanyMapper companyMapper;
	private final ProductMapper productMapper;
	private final ProductCategoryMapper productCategoryMapper;
	
	
	/**
	 * 상위 카테고리 정보를 반환한다
	 * @return 상위 카테고리 목록
	 */
	public List<ProductCategory> getProductCategories() {
		return productCategoryMapper.getProductCategories();
	}
	
	/**
	 * 지정된 카테고리의 하위 카테고리 정보를 반환한다
	 * @param categoryNo 상위 카테고리 번호
	 * @return 하위 카테고리 목록
	 */
	public List<ProductCategory> getAllSubProductCategories(int categoryNo){
		return productCategoryMapper.getProductCategoriesByParentNo(categoryNo);
	}
	
	
	/**
	 * 지정된 카테고리에 속하는 상품 목록을 반환한다
	 * @param categoryNo 카테고리 번호
	 * @return 상품 목록
	 */
	public List<Product> getProducts(int categoryNo){
		return productMapper.getProductsByCategoryNo(categoryNo);
	}
	
	/**
	 * 지정된 상품번호에 해당하는 상품정보를 반환한다
	 * @param productNo 상품번호
	 * @return 상품 정보
	 */
	public Product getProduct(int productNo) {
		return productMapper.getProductByNo(productNo);
	}

	public List<Company> getAllCompanies() {
		return companyMapper.getCompanies();
	}

	public void createProduct(ProductForm productForm) {
		Product product = productForm.toProduct();
		productMapper.insertProduct(product);
	}

	public List<Product> getAllProducts() {
		return productMapper.getAllProducts();
	}

	public void updateProduct(Product product) {
		productMapper.updateProduct(product);
		
	}
}
