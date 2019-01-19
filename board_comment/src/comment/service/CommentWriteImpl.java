package comment.service;

import org.springframework.transaction.annotation.Transactional;

import comment.dao.CommentDao;
import comment.model.CommentVO;

public class CommentWriteImpl implements CommentWriteService {
	private CommentDao commentDao;
	
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Transactional
	public int nextVal() {
		return commentDao.nextVal();
	}

	@Override
	public CommentVO write(CommentVO message) {
		commentDao.insert(message);
		return message;
	}

}
