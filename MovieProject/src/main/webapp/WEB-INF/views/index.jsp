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

	$(function(){
	    fnSearchAll();
	    fnSearch();
	    fnInit();
	})
	
	function fnSearchAll(){
	    $.ajax({
	          url: '${contextPath}/searchAllMovies',
	          type: 'get',
	          dataType: 'json',
	          success: function(map){
	                alert(map.message);
	                if(map.status == 1){
	                	$('#movies').empty();
	                    $.each(map.movies, function(i, movie){
	                    	$('<tr>')
	                        .append($('<td>').text(movie.title))
	                        .append($('<td>').text(movie.genre))
	                        .append($('<td>').text(movie.description))
	                        .append($('<td>').text(movie.star))
	                        .appendTo('#movies');
	                   })
	                } else if(map.status == 0) {
	                	$('#movies').empty();
						$('<tr>')
	                    .append($('<td colspan="4">').text('검색 결과 없음'))
	                    .appendTo('#movies');
	                }
	          }
	    })
	}
	
	function fnSearch() {
	    $('#btnSearch').on('click', function(){
	          $.ajax({
	                url: '${contextPath}/searchMovie',
	                type: 'post',
	                contentType: 'application/json',
	                data: JSON.stringify({
	                      'column' : $('#column').val(),
	                      'searchText' : $('#searchText').val()
	                }),
	                success: function(result){
	                      alert(result.message);
	                      if (result.status == 1){
	                    	  $('#movies').empty();
	                          $.each(result.movies, function(i, movie){
								  $('<tr>')
		                          .append($('<td>').text(movie.title))
		                          .append($('<td>').text(movie.genre))
		                          .append($('<td>').text(movie.description))
		                          .append($('<td>').text(movie.star))
		                          .appendTo('#movies');
	                          })
	                      } else if(result.status == 0) {
	                    	  $('#movies').empty();
	                            $('<tr>')
	                            .append($('<td colspan="4">').text('검색 결과가 없습니다.'))
	                            .appendTo('#movies');
	                      }
	                },
	                error: function(request,status,error){
						console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}
	          })
	    })
	}
	
	function fnInit() {
		$('#btnInit').on('click', function(){
			location.href="${contextPath}/";
		})
	}

</script>



</head>
<body>

	<select id="column">
		<option value="TITLE">제목</option>
	</select>
	<input type="text" id="searchText">
	<input type="button" value="검색" id="btnSearch">
	<input type="button" value="초기화" id="btnInit">

	<hr>

	<table border="1">
		<thead>
			<tr>
				<td>제목</td>
				<td>장르</td>
				<td>내용</td>
				<td>평점</td>
			</tr>
		</thead>
		<tbody id="movies">
		</tbody>
	</table>


</body>
</html>