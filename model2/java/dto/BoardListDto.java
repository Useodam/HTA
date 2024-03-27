package dto;

import java.util.List;

import vo.Board;

/**
 * 게시판 리스트를 표현하는 객체다
 * 게시판 목록은 게시글과 페이징으로 구성된다
 * items는 게시글 정보를 담은 변수다
 * pagination은 페이징정보를 담는 변수다
 */
public class BoardListDto {

	private List<Board> items;
	private Pagination pagination;
	
	public BoardListDto() {}

	public List<Board> getItems() {
		return items;
	}

	public void setItems(List<Board> items) {
		this.items = items;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	
}
