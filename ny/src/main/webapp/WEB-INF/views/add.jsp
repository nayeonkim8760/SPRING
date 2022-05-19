<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.js"></script>
<script>

	$(document).ready(function()=>{

		$('#f').on('submit', (event)=>{
			if($('#writer').val() == '' || $('#title').val() == ''){
				alert('작성자와 제목은 필수입니다.');
				event.preventDefault();
			}
		})

	})

</script>
</head>
<body>

	<form id="f" action=${contextPath}/add method="post">
		<input type="text" name="writer" id="writer" placeholder="작성자" autofocus><br>
		<input type="text" name="title" id="title" placeholder="제목"><br>
		<textarea name="content"></textarea><br><br>
		<button>작성완료</button>
		<input type="reset" value="다시작성">
		<input type="button" value="목록" id="btnlist">
	</form>

</body>
</html>