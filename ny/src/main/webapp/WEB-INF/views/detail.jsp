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

	$(document).ready(()=>{

		$('#btnRemove').on('click', ()=>{
			if(confirm('삭제하겠습니까?')){
				location.href='${contextPath}/remove?no=${board.no}';
			}
		})
		
		$('#btnModify').on('click', ()=>{
			location.href='${contextPath}/modifyPage?no=${board.no}';
		})
		
		$('#btnlist').on('click', ()=>{
			location.href='${contextPath}/list';
		})

	})

</script>
</head>
<body>

	게시글번호	${board.no}<br>
	제목			${board.title}<br>
	내용
	${board.content}<br>
	작성자		${board.writer}<br>
	최초작성일	${board.created}<br>
	최종수정일	${board.lastModified}<br>
	
	<hr>
	
	<input type="button" value="삭제" id="btnRemove">
	<input type="button" value="수정" id="btnModify">
	<input type="button" value="목록" id="btnlist">

</body>
</html>