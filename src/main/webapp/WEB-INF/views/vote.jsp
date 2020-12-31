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
	<div class="container"> 
		<h3>${election.getEname() }</h3>
		<h6>Admin: ${election.getAdmin().getName()}<br>@${election.getAdmin().getUsername()}</h6>
	</div>
	<br>
	<br>
	<div>
		<div class="container">
			<p class="error-font">${errormsg}</p>
			<p class="success-font">${savemsg}</p>
		
			<!--  <div class="row">
				<c:forEach var="candidate" items="${candidateList}">
				    <div class="col-sm-4">
				    	<div class="card border-secondary mb-3" style="width: 18rem;">
						    <img src="/user-image.png" class="card-img-top" alt="Candidate Image">
						    <div class="card-body">
						      <h5 class="card-title">${candidate.getCandidateUser().getName()}</h5>
						      <p class="card-text">@${candidate.getCandidateUser().getUsername()}<br>
								Age: ${candidate.getCandidateUser().getAge()}
						      </p>
						      <a href="#" class="btn btn-success full-width">Vote</a>
						    </div>
						</div>
				    </div>
			    </c:forEach>
		    </div>-->
		    <div class="row">
				<c:forEach var="candidate" items="${candidateList}">
				    <div class="col-sm-4">
				    	<div class="card border-secondary mb-3" style="width: 18rem;">
						    <img src="/user-image.png" class="card-img-top" alt="Candidate Image">
						    <div class="card-body">
						      <h5 class="card-title">${candidate.getCandidateUser().getName()}</h5>
						      <p class="card-text"> @${candidate.getCandidateUser().getUsername()}<br>
								Age: ${candidate.getCandidateUser().getAge()}
						      </p>
						      <a href="savevote?eid=${election.getEid()}&cid=${candidate.getCandidateUser().getUsername()}" class="btn btn-success full-width">Vote</a>
						    </div>
						</div>
				    </div>
			    </c:forEach>
		    </div>
		    
		</div>
		
	</div>
</body>
</html>