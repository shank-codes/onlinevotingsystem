<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create Election</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css">
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
	
	<div class="container mt-4">
		<h3>Create Election</h3>
		<hr>
		
		<form action= "saveelection" method="POST">
			<div class="form-row">
			    <div class="form-group col-md-6">
			    	<label for="inputElectionName">Election Name</label>
			    	<input type="text" class="form-control" name="name" id="inputElectionName" placeholder="Election Name" required>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="inputCandidatecount">No. Of Candidates</label>
			    	<input type="number"
			    	class="form-control" name="noOfCandidates" id="inputCandidatecount" min="2" placeholder="No. Of Candidates" required>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="inputCandidateList">Candidate List</label>
			    	<input type="text" title="Enter usernames of the candidates seperated by comma" pattern="[a-z0-9._,]+"
			    	 class="form-control" name="candidateList" id="inputCandidateList" placeholder="Candidate List" required>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="inputPassword">Password</label>
			    	<input type="password" class="form-control" name="password" id="inputPassword" placeholder="Password" required>
			    </div>
			</div>
			<p class="error-font">${msg} </p>
			<button type="submit" class="btn btn-primary" name="submit">Create</button>
		</form>
	</div>

</body>
</html>