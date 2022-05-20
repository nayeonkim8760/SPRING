<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<title>Insert title here</title>
<script src="../resources/js/jquery-3.6.0.js"></script>
<script>

	$(document).ready(function()=>{

		$('#f').on('submit', (event)=>{
			if($('#title').val() == ''){
				alert('제목은 필수입니다.');
				event.preventDefault();
			}
		})

	})

</script>
</head>
<body>

	<form id="f" action=${contextPath}/modify method="post">
		<input type="hidden" name="no" value="${board.no}"><br>
		<input type="text" name="title" id="title" value="${board.title}"><br>
		<textarea name="content">${board.content}</textarea><br><br>
		<button>수정완료</button>
		<input type="reset" value="다시작성">
		<input type="button" value="목록" onclick="location.href='${contextPath}/list'">
	</form>

</body>
</html>