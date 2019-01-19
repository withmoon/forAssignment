package comment.dao;

import java.util.List;

import comment.model.CommentVO;

public interface CommentDao {
	public int count();
	public int nextVal();
	public List<CommentVO> select(int begin,int end, int num);
	public void insert(CommentVO message);
	public void delete(int id);
	public void update(CommentVO message);
}
