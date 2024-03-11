package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.ProductCategory;

@Mapper
public interface ProductCategoryMapper {

	List<ProductCategory> getProductCategories();
	ProductCategory getProductCategoryByNo(int no);
}
