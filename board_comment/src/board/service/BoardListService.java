package board.service;

import java.util.List;

import board.model.BoardVO;

public interface BoardListService {
	Integer getListCount(Object obj);
	List<BoardVO> getBoardList(Object obj);
}
