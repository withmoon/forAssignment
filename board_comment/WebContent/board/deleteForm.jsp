<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
<script type="text/javascript">
function passCheck(value){
	if(value=="successDelete"){
		alert("글이 삭제되었습니다.");
		window.location="list.do";
	}
	if(value=="passerror"){
		alert("비밀번호가 틀렸습니다.");
	}
}
window.onload=passCheck("${value}");
</script>
</head>
<body>
<form method="post" action="deleteForm.do?num=${num}">
<table>
<tr>
<td>글을 삭제하시려면 비밀번호를 입력해주세요</td>
</tr>
<tr>
<td><input type="password" name="pass" value="${pass}"/></td>
<td><input type="submit" value="확인"/></td>
</tr>
</table>
</form>

</body>
</html>