<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="view/color.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript">
	function passCheck(value) {
		if (value == "pass" || value.equals("pass")) {
			alert("비밀번호가 틀렸습니다.");
		}
	}
	window.onload = passCheck("${value}");
</script>
</head>
<body bgcolor="${bodyback_c}">
<div align="center" class="body">
<form method="post" name="writeForm"action="updateForm.do?num=${vo.num}">
<div align="center">
<h3>글수정</h3>
<table style="width: 450px" border="1">
	<tr>
		<td align="center" width="80" bgcolor="${value_c}">작성자</td>
		<td align="left"><input type="text" size="22" name="writer" value="${vo.writer}"/></td>
	</tr>
	<tr>
		<td width="70" bgcolor="${value_c}" align="center">비밀번호</td>
		<td align="left"><input type="password" name="pass" value="${pass}"/></td>
	<tr>
		<td align="center" bgcolor="${value_c}">이메일</td>
		<td align="left" colspan="7">
		<input type="text" size="61" name="email" value="${vo.email}"/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="${value_c}">제목</td>
		<td align="left">
		<input type="text" size="61" name="subject" value="${vo.subject}"/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="${value_c}">내용</td>
		<td><textarea name="content" rows="13" cols="61">${vo.content}</textarea></td>
	</tr>
</table>
<br/>
<input type="button" value="글수정" onclick="writeCheck()"/>
<input type="button" value="목록보기" onclick="window.location='list.do'"/>
</div>
</form>
</div>
</body>
</html>