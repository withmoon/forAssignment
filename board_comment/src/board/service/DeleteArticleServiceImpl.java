package board.service;

import board.dao.BoardDao;

public class DeleteArticleServiceImpl implements DeleteArticleService {
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public String getPass(Integer num) {
		return this.boardDao.getPass(num);
	}

	@Override
	public void deleteArticle(Integer num) {
		this.boardDao.deleteArticle(num);
	}

}
