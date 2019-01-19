package board.service;

import board.dao.BoardDao;
import board.model.BoardVO;

public class WriteServiceImpl implements WriteService {
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public void insertWriting(BoardVO boardVo) {
		this.boardDao.insertArticle(boardVo);
	}

}
