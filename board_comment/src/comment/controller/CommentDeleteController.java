package comment.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import comment.service.CommentDeleteImpl;

public class CommentDeleteController implements Controller {
	private CommentDeleteImpl commentDeleteImpl;
	
	public void setCommentDeleteImpl(CommentDeleteImpl commentDeleteImpl) {
		this.commentDeleteImpl = commentDeleteImpl;
	}

	@RequestMapping("board/deleteComment.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("id"));
		commentDeleteImpl.delete(id);
		
		//�� ����
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("id", id);
		
		//��ȯ���� ModelAndView �ν��Ͻ� ����
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("content.do");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}
