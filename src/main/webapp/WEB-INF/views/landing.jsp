<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to PocketBook!</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/taskStyle.css">
</head>
<body>
	 <body id="landing">
        <div id="landingBox">
          <h2>Become organized in seconds</h2>
          <p>Join our site to get started with your own task list!</p>
          <div>
            <p><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModal" data-backdrop="false">
              Login
              </button> <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#registerModal" data-backdrop="false">
              Register
            </button></p>
			<p class="message">${ message }</p>
          </div>
			<!-- Login Modal -->
						<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
						  <div class="modal-dialog modal-dialog-centered" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 style="color: black" class="modal-title" id="loginModalLongTitle">Login</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div style="color: black" class="modal-body">
									<form action="/login-submit" method="post" autocomplete=off >
										 
										<div class="input-group mb-3">
							  				<div class="input-group-prepend">
							   				 <span class="input-group-text" id="inputGroup-sizing-default">Email</span>
							  				</div>
							  				<input type="email" class="form-control" aria-label="Sizing example input" 
							  				aria-describedby="inputGroup-sizing-default" name="email" autofocus required>
										</div>
										<div class="input-group mb-3">
							  				<div class="input-group-prepend">
							   				 <span class="input-group-text" id="inputGroup-sizing-default">Password</span>
							  				</div>
							  				<input type="password" class="form-control" aria-label="Sizing example input" 
							  				aria-describedby="inputGroup-sizing-default" name="password" required>
										</div>
										
										
										<div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
									        <button type="submit" class="btn btn-primary">Log in</button>
								     	</div>
									</form>
								</div>
						      
						    </div>
						  </div>
						</div>
				
		<!-- Register Modal -->
					<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					  <div class="modal-dialog modal-dialog-centered" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="registerModalLongTitle" style="color: #686a69">Register</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div style="color: black" class="modal-body">
					        <form action="/register-submit" method="post" autocomplete=off >
										<div class="input-group mb-3">
							  				<div class="input-group-prepend">
							   				 <span class="input-group-text" id="inputGroup-sizing-default">Name</span>
							  				</div>
							  				<input type="text" class="form-control" aria-label="Sizing example input" 
							  				aria-describedby="inputGroup-sizing-default" name="name" required>
										</div>
										<div class="input-group mb-3">
							  				<div class="input-group-prepend">
							   				 <span class="input-group-text" id="inputGroup-sizing-default">Email</span>
							  				</div>
							  				<input type="email" class="form-control" aria-label="Sizing example input" 
							  				aria-describedby="inputGroup-sizing-default" name="email" required>
										</div>
										<div class="input-group mb-3">
							  				<div class="input-group-prepend">
							   				 <span class="input-group-text" id="inputGroup-sizing-default">Password</span>
							  				</div>
							  				<input type="text" class="form-control" aria-label="Sizing example input" 
							  				aria-describedby="inputGroup-sizing-default" name="password" required>
										</div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						        <button type="submit" class="btn btn-primary">Register</button>
						      </div>
					      </form>
					      </div>
					    </div>
					  </div>
					</div>
		
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>