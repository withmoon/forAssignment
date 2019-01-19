package comment.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import comment.dao.CommentDao;
import comment.model.CommentVO;

public class CommentListImpl implements CommentListService {
	public static final int DEFAULT_PAGE_SIZE=20;
	private int pageSize=DEFAULT_PAGE_SIZE;
	private CommentDao commentDao;
	
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Transactional
	public List<CommentVO> getMessageList(int pageNum, int num) {
		int totalCount=commentDao.count();
		return commentDao.select(1, totalCount, num);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
