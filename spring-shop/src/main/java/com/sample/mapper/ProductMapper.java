package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sample.vo.Product;
import com.sample.web.dto.Criteria;

@Mapper
public interface ProductMapper {
	
	void insertProduct(Product product);
	
	List<Product> getAllProducts();

	Product getProductByNo(int no);
	
	
	int getTotalRows(Criteria criteria);
	List<Product> getProduct(Criteria criteria);

	void deleteProducts(@Param("noList")List<Integer> noList);
}