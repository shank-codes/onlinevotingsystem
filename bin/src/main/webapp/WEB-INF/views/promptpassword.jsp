<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css">
	<title>${election.getEname()} Password</title>
	<script>
			function showPassword() {
		        var x = document.getElementById("inputPassword");
		        if (x.type === "password") {
		            x.type = "text";
		        } else {
		            x.type = "password";
		        }
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
	<br>
	<div class="container">
		<form action="vote?id=${election.getEid()}" method="POST">
			  <div class="form-group">
			  	<h4>${election.getEname()}</h4>
			    <label for="InputPassword">Election Password</label>
			    <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Enter Election Password" required>
			    <input type="checkbox" style="margin-top: 10px;" onclick="showPassword()" id="icon1">
	            	<label for="icon1">Show Password</label>
			  </div>
			
			  <p class="error-font">${msg}</p>
			
			  <div class="form-group">
	               <input type="submit" name="loggedin" class="btn btn-primary" value="Proceed">
			  </div>
			  
		</form>
	</div>

</body>
</html>