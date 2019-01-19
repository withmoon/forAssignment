package board.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.model.BoardVO;
import board.service.GetArticleService;
import comment.model.CommentVO;
import comment.service.CommentListImpl;
import comment.service.CommentWriteImpl;

public class GetArticleController{
	private GetArticleService getArticleService;
	private CommentListImpl commentListImpl;
	private CommentWriteImpl commentWriteImpl;
	private CommentVO comment;
	
	public void setCommentWriteImpl(CommentWriteImpl commentWriteImpl) {
		this.commentWriteImpl = commentWriteImpl;
	}
	public void setCommentListImpl(CommentListImpl commentListImpl) {
		this.commentListImpl = commentListImpl;
	}
	public void setGetArticleService(GetArticleService getArticleService) {
		this.getArticleService=getArticleService;
	}
	@RequestMapping("/board/content.do")
	public ModelAndView getArticle(Integer num) {
		BoardVO boardVo=this.getArticleService.getArticle(num);

		List<CommentVO> list=commentListImpl.getMessageList(1, num);
		System.out.println("list 사이즈 :  "+list.size());
		
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("vo", boardVo);
		model.put("list", list);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/board/content.jsp");
		mav.addAllObjects(model);
		return mav;
	}
/*
	@RequestMapping(value="/board/upComment.do", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		comment=new CommentVO();
		comment.setComment_id(commentWriteImpl.nextVal());
		comment.setNum(Integer.parseInt(request.getParameter("num")));
		comment.setComment_name(request.getParameter("name"));
		comment.setComment(request.getParameter("content"));
		comment.setRegdate(new Date());
		commentWriteImpl.write(comment);
		
		//모델 생성
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("comment", comment);
		
		//반환값인 ModelAndView 인스턴스 생성
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("content.do?num="+comment.getNum()+"&pageNum="+request.getParameter("pageNum"));
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
	*/
}
