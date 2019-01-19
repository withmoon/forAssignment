package comment.service;

import comment.dao.CommentDao;

public class CommentDeleteImpl implements CommentDeleteService {
	private CommentDao commentDao;
	
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public void delete(int id) {
		commentDao.delete(id);
	}

}
