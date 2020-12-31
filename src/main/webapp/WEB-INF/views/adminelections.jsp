<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css">
	<title>${user.getName()}'s Elections</title>
	<script>
          function clearP() {
              document.getElementById("demo1").innerHTML="";
          }

          function load(link) {
		  	  window.location.href = link;
          }
    </script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark menubar" style="position:sticky;">
		<div class="container">
		  <a class="navbar-brand" href="/home">VoteHub</a>
		  <form class="justify-content-end">
		  	<span class="show-username text-white">${user.name}</span>
		    <button class="btn btn-sm btn-outline-success text-white" onclick="load('/')" style="margin-right: 10px" type="button">Logout</button>
		  </form>
	  	</div>
	</nav>
	<br>
	<br>
	<div class="custom-table">
		<table class="table table-hover">
			<thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Election Name</th>
			      <th scope="col">Status</th>
			      <th scope="col"></th>
			    </tr>
			</thead>			   
		    <tbody>
			   	<c:forEach var="ele" items="${adminElectionList}">
					<tr>
						<td>${ele.getEid()}</td>
						<td>${ele.getEname()}</td>
						<c:choose>
						    <c:when test="${ele.geteStatus() == true}">
						        <td class="success-font">Ongoing</td>
						    </c:when>    
						    <c:otherwise>
						        <td class="error-font">Ended</td>
						    </c:otherwise>
						</c:choose>
						<td><button type="button" onclick="load('showresults?eid=${ele.getEid()}')" class="btn btn-outline-success">Show Results</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>