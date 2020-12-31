<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css">
	<title>Home</title>
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
	
	<div class="intro-section">
		<div>
			<p class="intro-quote">"The ignorance of one voter in a democracy impairs the security of all" - John F. Kennedy</p>
			<br>
			<div class="intro-button">
				<button type="button" onclick="load('create')" class="btn btn-primary btn-lg">Create Election</button>
				<br>
				<button type="button" onclick="load('adminelections')" class="btn btn-secondary btn-sm">My elections</button>
			</div>
		</div> 
	</div>
	
	<div class="custom-table">
		<table class="table table-hover">
			<thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Election Name</th>
			      <th scope="col">Admin</th>
			    </tr>
			</thead>			   
		    <tbody>
			   	<c:forEach var="ele" items="${electionList}">
			   		
					<tr onclick="load('prompt?id=${ele.getEid()}')">
						<td>${ele.getEid()}</td>
						<td>${ele.getEname()}</td>
						<td>${ele.getAdmin().getUsername()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>