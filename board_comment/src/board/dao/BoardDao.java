package board.dao;

import java.util.List;

import board.model.BoardVO;

public interface BoardDao {
	int getListCount(Object obj); //��ü �ۼ� or �˻��� �� ��
	List<BoardVO> getList(Object obj); //��ü �� or �˻��� �� ����Ʈ
	void insertArticle(BoardVO boardVo);//�� �Է�
	BoardVO getArticle(Integer num); //�� ��������
	void updateArticle(BoardVO boardVo); //�� �Է�
	String getPass(Integer num); //��й�ȣ ��������
	void deleteArticle(Integer num); //�� ����
}
