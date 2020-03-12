<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%--   <%@include file="header.jsp"%>  --%>-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>


<link rel="stylesheet" href="CSS/form.css" />
<!--   -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function validate() {
		var name = document.getElementById("email").value;
		var pass = document.getElementById("password").value;

		if (name == "" || name == null) {
			// swal("please enter email");
			// alert ( "enter email" );

			//return false;
		} else if (pass == "" || pass == null) {
			alert("please enter password");
			//return false;
		} else {
			document.submit();
		}

	}
</script>

</head>
<body>
	<div id="login-box">
		<div class="left">

			<h1>Sign in</h1>
			<form action="LoginController" method="post">
				<input type="email" id="email" name="email" placeholder="Email"
					required/> <input type="password" id="password" name="password"
					placeholder="Password" required /> <input type="submit"
					name="signup_submit" value="Sign in" onclick="return validate()" />


			</form>
		</div>
	</div>

</body>
</html>