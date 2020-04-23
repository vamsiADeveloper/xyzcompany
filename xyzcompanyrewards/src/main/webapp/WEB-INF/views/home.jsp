<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>XYZ Company Rewards</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap  -->
<link rel="stylesheet" href="/resources/css/usable/bootstrap.css">
</head>
<body>
	<form>
		<div class="container">
			<div class="col-md-6" style="padding-top: 200px">WELCOME TO XYZ
				COMPANY REWARDS PORTAL
				</br>Enter admin for both user name and password</div>
			<div class="col-md-6" style="padding-top: 200px">
				<div id="errorField" class="alert alert-danger"
					style="display: none"></div>
				<div class="form-group">
					<label><b>Username</b></label> <input type="text"
						placeholder="Enter Username" id="uname" name="app_username"
						width="auto" required>
				</div>
				<div class="form-group">
					<label><b>Password</b></label> <input type="password"
						placeholder="Enter Password" id="psw" name="app_password" required>
				</div>
				<input type="button" id="loginBtn" class="btn btn-success"
					value="Login"> <input type="button" class="btn btn-danger"
					value="Cancel"> <span class="psw"><a href="#"
					style="color: red;"
					onclick="alert('enter admin, amdin as username and password');">Forgot
						password?</a></span>
			</div>
		</div>
	</form>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
 <script type="text/javascript">       
	 $( document ).ready(function() {
		$('#errorField').html('');
		$('#errorField').hide();	
		$('#uname, #psw').removeClass('error');
	
	$( "#loginBtn" ).click(function() {
 		var errors = [];
		var userName = $("#uname").val();
		var password = $("#psw").val();
		
		if ('' == userName || userName != 'admin') {
			 errors[errors.length] = "Please enter admin as user name";
			 $("#uname").addClass('error');
		     $('#uname').css('border-color', 'red');
		 } else {
	 	 $('#uname').css('border-color', '');
	 	}
		
		if ('' == password ) {
			 errors[errors.length] = "Please enter admin as password";
			 $("#psw").addClass('error');
		     $('#psw').css('border-color', 'red');
		 } else {
	 	 $('#psw').css('border-color', '');
	 	}

		 if (errors.length > 0) {
			 var msg = "Error(s) - missing mandatory information.  </br>";
			 for (var i = 0; i<errors.length; i++) {
			 var numError = i + 1;
			  msg += "</br>" + numError + ". " + errors[i];
			 }
			  $('#errorField').html(msg);
			  $('#errorField').show();	
			} else {
				$.ajax({
				   type: 'GET',    
				   url:"${pageContext.request.contextPath}/login",
				   data:'userName='+ userName+'&password='+ password, 
				   success: function(response) {
				      var url = '${pageContext.request.contextPath}/rewardDetails'+'/'+response.userName;
					   if (true == response.authenticated) {
						   $('#errorField').html('');
		 				  $('#errorField').hide();	
						   $(location).attr('href',url);
					   } else {
						   $('#errorField').html("User name or Password doesnot exist, please check and retry.");
		 				  $('#errorField').show();	
					   }
				   },
					error: function (jqXHR, textStatus, errorThrown) {
					        alert('Error: Please contact support with message - L123');
					}
				}); 
				}
			  });
	});
	 </script>
</html>

