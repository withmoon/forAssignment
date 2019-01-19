<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="view/color.jspf" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>content</title>
<link href="style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
function updateComment(){
	var form=document.addForm;
	var num=document.getElementsByName("num").value;
	var urlParams = new URLSearchParams(window.location.search);
	var pageNum=urlParams.get('pageNum');
	var num=${vo.num};
	if(form.name.value==null||form.content.value==""){
		alert("이름 또는 내용을 입력해주세요");
		return;
	}

	var url='upComment.do?num='+num+'&pageNum='+pageNum+'&name='+form.name.value+'&content='+form.content.value;
	window.location=url;

}
function deleteComment(id){
	var num=document.getElementsByName("num").value;
	var urlParams = new URLSearchParams(window.location.search);
	var pageNum=urlParams.get('pageNum');
	var num=${vo.num};
	var url='delComment.do?num='+num+'&pageNum='+pageNum+'&id='+id;
	window.location=url;
}
</script>
</head>
<body bgcolor="${bodyback_c}">
<div align="center" class="body">
	<form method="post" name="writeForm">
		<input type="hidden" name="num" value="${vo.num}"/>
		<div align="center">
			<h3>글보기</h3>
			<table style="width:600px" border="1">
				<tr>
				<td align="center" width="100" bgcolor="${value_c}">번호</td>
				<td align="left" width="200">${vo.num}</td>
				<td align="center" width="100" bgcolor="${value_c}">작성일</td>
				<td align="left" width="200">${vo.regdate}</td>
				</tr>
				<tr>
				<td align="center" bgcolor="${value_c}">작성자</td>
				<td align="left">${vo.writer}</td>
				<td align="center" bgcolor="${value_c}">조회수</td>
				<td align="left">${vo.readcount}</td>
				</tr>
				<tr>
				<td align="center" bgcolor="${value_c}">이메일</td>
				<td align="left" colspan="7">${vo.email}</td>
				</tr>
				<tr>
				<td align="center" bgcolor="${value_c}">제목</td>
				<td align="left" colspan="7">${vo.subject}</td>
				</tr>
				<tr>
				<td align="center" bgcolor="${value_c}">내용</td>
				<td align="left" colspan="7" height="100"><pre>${vo.content}</pre></td>
				</tr>
			</table>
			<br/>
			<input type="button" value="글수정" onclick="window.location='updateForm.do?num=${vo.num}'"/>
			<input type="button" value="글삭제" onclick="window.location='deleteForm.do?num=${vo.num}'"/>
			<input type="button" value="목록보기" onclick="window.location='list.do'"/>
		</div>
	</form>
</div>

	<div id="commentList" align="center" class="body">
	
	<c:if test="${fn:length(list) ne 0}">
	<h3>[댓글]</h3>
	<c:forEach items="${list}" var="list">
		<span><b>${list.comment_name}</b>&emsp; ${list.comment}&emsp; <font color="brown">${list.regdate}</font>
		<a onclick="deleteComment(${list.comment_id})">[삭제]</a>
		</span><br/><br/>	
	</c:forEach>
	</c:if>
	
	<c:if test="${fn:length(list) eq 0}">
	<br/>아직 댓글이 없습니다.
	</c:if>

	</div>
	
	<div id="commentAdd" align="center">
		<form name="addForm" method="post">
		<br/>
			이름 : <input type="text" name="name" size="10"></input> 
			 내용 : <textarea name="content" cols="100"></textarea>
			<input type="button" value="등록" onclick="updateComment()"/>
			<input type="reset" value="취소"/>
		</form>
	</div>
</body>
</body>
</html>