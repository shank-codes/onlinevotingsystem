<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css">
	<title>${election.getEname()} Results</title>
	<script>
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
		<h3>${election.getEname()} Results</h3>
		<h6>Admin: ${election.getAdmin().getName()}<br>@${election.getAdmin().getUsername()}</h6>
	</div>
	<br>
	<br>
	
	<div class="container">
		<h2>WINNER</h2>
		
		<c:forEach var="winner" items="${winners}">
			<div class="card text-white bg-success mb-3">
			    <div class="card-body">
			        <h5 class="card-title">Congratulations, ${winner.getCandidateUser().getName() }</h5>
			        <p class="card-text">You've won this election with the support of ${winner.getNoOfVotes()} members. <br>
			        	Age: ${winner.getCandidateUser().getAge()}</p>
			        <p class="card-text">@${winner.getCandidateUser().getUsername()}</p>
			    </div>
			</div>
		</c:forEach>
	</div>
	<br>
	<br>
	
	<div class="container">
	
		<h3>Other Candidates</h3>
	  	<div class="row">
	  	
	  		<c:forEach var="candidate" items="${others}">
			    <div class="col-md-4">
		    		<div class="card border-dark mb-3" style="width: 18rem;">
				      <div class="card-body">
				        <h5 class="card-title">${candidate.getCandidateUser().getName() }</h5>
				        <p class="card-text">${candidate.getNoOfVotes()} members have voted for you.
				        	<br>Age: ${candidate.getCandidateUser().getAge()}</p>
				        <p class="card-text"><small class="text-muted">@${candidate.getCandidateUser().getUsername()}</small></p>
				      </div>
				    </div>
			    </div>
		    </c:forEach>
		    
		</div> 
		
	</div>
	
</body>
</html>