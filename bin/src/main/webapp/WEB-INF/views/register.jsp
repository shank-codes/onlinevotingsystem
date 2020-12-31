<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css">
	<title>Create Account</title>
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
		    <button class="btn btn-sm btn-outline-success text-white" onclick="load('/')" style="margin-right: 10px" type="button">Login</button>
		  </form>
	  	</div>
	</nav>

	<div class="container mt-4">
		<h3>Create Account</h3>
		<hr>
		
		<form action= "save" method="POST">
			<div class="form-row">
			    <div class="form-group col-md-6">
			    	<label for="inputName">Name</label>
			    	<input type="text" class="form-control" name="name" id="inputName" placeholder="Name" required>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="inputUsername">Username</label>
			    	<input type="text" pattern="[a-z0-9._]+" title="Must contain only lowercase letters, numbers, . or _"
			    	class="form-control" name="username" id="inputUsername" placeholder="Username" required>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="inputAge">Age</label>
			    	<input type="text" class="form-control" name="age" id="inputAge" placeholder="Age" required>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="inputEmail">Email</label>
			    	<input type="email" class="form-control" name ="email" id="inputEmail" placeholder="Email" required>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="inputPhone">Phone no</label>
			    	<input type="text" class="form-control" name="phone" id="inputPhone" placeholder="Phone no" required>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="inputPassword">Password</label>
			    	<input type="password" class="form-control" name="password" id="inputPassword" placeholder="Password" required>
			    </div>
			</div>
			<p class="error-font">${msg} </p>
			<button type="submit" class="btn btn-primary" name="submit">Sign in</button>
		</form>
	</div>
</body>

</html>