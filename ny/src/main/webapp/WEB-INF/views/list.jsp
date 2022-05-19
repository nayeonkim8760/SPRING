<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<title>Insert title here</title>
</head>
<body>

	<a href="${contextPath}/addPage">작성하기</a>

	<table border="1">
		<thead>
			<tr>
				<td>제목</td>
				<td>작성자</td>
				<td>최종수정일</td>
			</tr>
		<tbody>
			<c:forEach items="${boards}" var="board">
				<tr>
					<td><a href="${contextPath}/detail?no=${board.no}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.lastModified}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>