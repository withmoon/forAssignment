package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import board.model.BoardVO;

public class BoardDaoImpl implements BoardDao{
	private SqlSessionTemplate sqlSession;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int getListCount(Object obj) {
		Map<String, Object> map=new HashMap<String,Object>();
		map=(Map<String,Object>) obj;
		if(map.get("search_type").equals("writer")) {
			return sqlSession.selectOne("board.dao.board.getWriterCount",obj);
		}else if(map.get("search_type").equals("subject")) {
			return sqlSession.selectOne("board.dao.board.getSubjectCount",obj);
		}else if(map.get("search_type").equals("content")) {
			return sqlSession.selectOne("board.dao.board.getContentCount",obj);
		}else {
			return sqlSession.selectOne("board.dao.board.getAllCount",obj);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> getList(Object obj) {
		Map<String, Object> map=new HashMap<String,Object>();
		map=(Map<String,Object>) obj;
		if(map.get("search_type").equals("all")) {
			return sqlSession.selectList("board.dao.board.getAllList",obj);
		}else if(map.get("search_type").equals("writer")) {
			return sqlSession.selectList("board.dao.board.getWriterList",obj);
		}else if(map.get("search_type").equals("subject")) {
			return sqlSession.selectList("board.dao.board.getSubjectList",obj);
		}else if(map.get("search_type").equals("content")) {
			return sqlSession.selectList("board.dao.board.getContentList",obj);
		}else {
			return sqlSession.selectList("board.dao.board.getList",obj);
		}
	}
	
	@Override//�۾���
	public void insertArticle(BoardVO boardVo) {
		sqlSession.insert("board.dao.board.insertArticle",boardVo);
	}
	
	@Override//�ۺ���
	public BoardVO getArticle(Integer num) {
		sqlSession.update("board.dao.board.upReadcount",num);
		return sqlSession.selectOne("board.dao.board.getArticle",num);
	}
	
	@Override//�ۼ���
	public void updateArticle(BoardVO boardVo) {
		sqlSession.update("board.dao.board.updateArticle",boardVo);
	}
	
	@Override //��й�ȣ ��������
	public String getPass(Integer num) {
		return sqlSession.selectOne("board.dao.board.getPass",num);
	}
	
	@Override//�� ����
	public void deleteArticle(Integer num) {
		sqlSession.delete("board.dao.board.deleteArticle",num);
	}
	
}
