<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.js"></script>
<script>
	$(document).ready(function(){
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

	<h1>게시글 수정 화면</h1>
	<form id="f" action="${contextPath}/modify" method="post">
	<c:forEach items="${boards}" var="board">
	글번호	${board.no}	<br>
	작성자	${board.writer} <br>
	작성IP	${board.ip} <br>
	조회수	${board.hit} <br>
	작성일	${board.created} <br>
	제목		<input type="text" name="title" id="title" value="${board.title}"><br>
	<textarea name="content" id="content">${board.content}</textarea>
	<button>수정</button>
	<input type="button" value="목록" onclick="location.href='${contextPath}/list'">
	</c:forEach>
	</form>

</body>
</html>