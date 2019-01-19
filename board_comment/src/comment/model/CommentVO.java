package comment.model;

import java.util.Date;

public class CommentVO {
	private int comment_id;
	private int num;
	private String comment_name;
	private String comment;
	private Date regdate;
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getComment_name() {
		return comment_name;
	}
	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
