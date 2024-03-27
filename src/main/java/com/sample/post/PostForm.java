package com.sample.post;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostForm {
	
	@NotEmpty(message = "게시글 제목은 필수 입력항목입니다")
	@Size(max = 200, message = "제목 글자수는 최대 200글자까지 가능합니다")
	private String title;
	
	@NotEmpty(message = "게시글 내용은 필수 입력항목입니다")
	private String content;
	

}
