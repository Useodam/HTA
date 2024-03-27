package com.sample.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int page;			// 요청한 페이지 번호
	private int rows;			// 한번에 표시할 데이터 갯수
	private String sort;		// 정렬방식
	private String opt;			// 검색옵션
	private String keyword;		// 검색어
	private int begin;			// 검색시작 범위
	private int end;			// 검색종료 범위
	
}
