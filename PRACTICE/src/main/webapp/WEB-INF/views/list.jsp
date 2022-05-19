<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="resources/jquery-3.6.0.js"></script>
<script>
/*
$(document).ready(()=>{
		$('#icoRemove').on('click', ()=>{
			if(confirm('삭제하겠습니까?')){
				location.href='${contextPath}/remove?board_no=${board.board_no}';
			}
		})
	})
*/
</script>
</head>
<body>
	<h1>게시글목록화면</h1>
	<a href="${contextPath}/addPage">새글작성</a>
	<table border="1">
		<caption>전체 게시글 개</caption>
			<thead>
				<tr>
					<td>게시글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>작성일자</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boards}" var="board">
					<tr>
						<td>${board.no}</td>
						<td><a href="${contextPath}/modifypage">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.hit}</td>
						<td>${board.created}</td>
						<td><i class="fa-solid fa-trash-can" data-no="${board.no}"></i></td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</body>
</html>