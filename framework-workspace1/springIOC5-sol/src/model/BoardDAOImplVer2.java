package model;

public class BoardDAOImplVer2 implements BoardDAO {
	@Override
	public String getContentByNo(String no){
		System.out.println(this.getClass().getName());
		return no+"번 게시물 정보";
	}
}
