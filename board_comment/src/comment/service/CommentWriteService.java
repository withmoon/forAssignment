package comment.service;

import comment.model.CommentVO;

public interface CommentWriteService {
	int nextVal();
	CommentVO write(CommentVO message);
}
