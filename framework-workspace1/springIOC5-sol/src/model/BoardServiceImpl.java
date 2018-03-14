package model;

public class BoardServiceImpl implements BoardService {
	//private BoardDAOImpl boardDAO; --> 이러면 안됩니다
	private BoardDAO boardDAO;//--> 이렇게 해야 합니다. 왜??	
	public BoardServiceImpl(BoardDAO boardDAO) {
		super();
		this.boardDAO = boardDAO;
	}
	@Override
	public String getContentByNo(String no){		
		return boardDAO.getContentByNo(no);
	}
}
