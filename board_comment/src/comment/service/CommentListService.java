package comment.service;

import java.util.List;

import comment.model.CommentVO;

public interface CommentListService {
	List<CommentVO> getMessageList(int pageNum,int num);
}