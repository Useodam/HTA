package com.sample.web.dto;

public class Pagination {

	private int rows = 5;
	private int pages = 5;
	private int totalRows;
	private int totalPages;
	private int totalBlocks;
	private int currentPage;
	private int currentBlock;
	private int begin;
	private int end;
	private int beginPage;
	private int endPage;
	private boolean isFirst;
	private boolean isLast;

	public Pagination(int currentPage, int totalRows) {
		this.totalRows = totalRows;
		this.currentPage = currentPage;
		init();
	}


	public Pagination(int currentPage, int totalRows, int rows) {
		this.totalRows = totalRows;
		this.currentPage = currentPage;
		this.rows = rows;
		init();
	}


	public Pagination(int currentPage, int totalRows, int rows, int pages) {
		this.totalRows = totalRows;
		this.currentPage = currentPage;
		this.rows = rows;
		this.pages = pages;
		init();
	}

	private void init() {

		if (totalRows > 0) {
			this.totalPages = (int) Math.ceil((double) totalRows / rows);
			this.totalBlocks = (int) Math.ceil((double) totalPages / pages);
			this.currentBlock = (int) Math.ceil((double) currentPage / pages);
			this.begin = (currentPage - 1) * rows + 1;
			this.end = currentPage * rows;
			this.beginPage = (currentBlock - 1) * pages + 1;
			this.endPage = currentBlock * pages;
			if (currentBlock == totalBlocks) {
				this.endPage = this.totalPages;
			}
			if (currentPage == 1) {
				this.isFirst = true;
			}
			if (currentPage == totalPages) {
				this.isLast = true;
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getPages() {
		return pages;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getTotalBlocks() {
		return totalBlocks;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public int getBegin() {
		return begin;
	}

	public int getEnd() {
		return end;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public boolean isLast() {
		return isLast;
	}


	@Override
	public String toString() {
		return "Pagination [rows=" + rows + ", pages=" + pages + ", totalRows=" + totalRows + ", totalPages="
				+ totalPages + ", totalBlocks=" + totalBlocks + ", currentPage=" + currentPage + ", currentBlock="
				+ currentBlock + ", begin=" + begin + ", end=" + end + ", beginPage=" + beginPage + ", endPage="
				+ endPage + ", isFirst=" + isFirst + ", isLast=" + isLast + "]";
	}

}
