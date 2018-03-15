package model;

public class PagingBean {
	private int nowPage;
	private int startPage;
	private int endPage;
	
	public PagingBean() {
		super();
	}

	public PagingBean(int nowPage, int startPage, int endPage) {
		super();
		this.nowPage = nowPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PagingBean [nowPage=" + nowPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
}
