<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css">
	<title>Login</title>
	<script>
          function clearP() {
              document.getElementById("demo1").innerHTML="";
          }
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
		  <a class="navbar-brand brand-style" href="/home">VoteHub</a>
		  <form class="justify-content-end">
		    <button class="btn btn-sm btn-outline-success text-white" onclick="load('register')" style="margin-right: 10px" type="button">Register</button>
		  </form>
	  	</div>
	</nav>
	
        
    <div class="container mt-4">
		<h3>Login</h3>
		<hr>
		
		<form action="authorise" method="POST">
		  <div class="form-group">
		    <label for="inputUsername">Username</label>
		    <input type="text" name="username" class="form-control" id="inputUsername" pattern="[a-z0-9._]+"
		    aria-describedby="emailHelp" placeholder="Enter Username" required>
		  </div>
		  <div class="form-group">
		    <label for="InputPassword">Password</label>
		    <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Enter Password" required>
		    <input type="checkbox" style="margin-top: 10px;" onclick="showPassword()" id="icon1">
            	<label for="icon1">Show Password</label>
		  </div>
		
		  <p class="error-font">${msg}</p>
		
		  <div class="form-group">
               <input type="submit" name="loggedin" class="btn btn-primary" value="Log in">
		  </div>
		  
		</form>
			
	</div>
	
</body>
</html>