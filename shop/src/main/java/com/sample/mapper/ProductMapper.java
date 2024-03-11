package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Product;

@Mapper
public interface ProductMapper {

	List<Product> getProductsByCategoryNo(int categoryNo);
	Product getProductByNo(int no);
}
