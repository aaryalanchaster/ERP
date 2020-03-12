<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>Signup/login</title>
	<link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
	<link rel="stylesheet" href="CSS/uregister.css">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<script>
		$(function () {
			change();
			date();
		});
	</script>
</head>

<body>
	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#signup">Sign Up</a></li>
			<li class="tab"><a href="#login">Log In</a></li>
		</ul>

		<div class="tab-content">
			<div id="signup">
				<h1>Sign Up for Free</h1>

				<form method="post">
					<div class="field-wrap">
						<label> Name<span class="req">*</span>
						</label> <input type="text" required autocomplete="off" name="u_name" />
					</div>
					<div class="field-wrap">
						<label> Gender<span class="req">*</span>
						</label> <input type="text" required autocomplete="off" name="u_gender" />
					</div>
					<div class="field-wrap" id="date">
						<label> DOB<span class="req">*</span>
						</label> <input type="text" id="datepicker" required autocomplete="off" name="u_dob" />
					</div>
					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" required autocomplete="off" name="u_email" />
					</div>
					<div class="field-wrap">
						<label> Set A Password<span class="req">*</span>
						</label> <input type="password" id="password" required autocomplete="off" name="u_password" />

					</div>
					<div id="msg"></div>
					<div class="field-wrap">
						<label> Re enter Password<span class="req">*</span>
						</label> <input type="password" id="confirm" required autocomplete="off" name="u_repassword" />
					</div>

					<button type="submit" class="button button-block" formaction="UserController" />
					Get Started
					</button>

				</form>

			</div>

			<div id="login">
				<h1>Welcome Back!</h1>

				<form action="/" method="post">

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" required autocomplete="off" name="email" />
					</div>

					<div class="field-wrap">
						<label> Password<span class="req">*</span>
						</label> <input type="password" required autocomplete="off" name="password" />
					</div>

					<p class="forgot">
						<a href="#">Forgot Password?</a>
					</p>

					<button class="button button-block" formaction="UserLoginController" formmethod="post" />
					Log In
					</button>
				</form>
			</div>
		</div>
	</div>
	<script src="JS/uregister.js"></script>
	<script>
		$(document).ready(
			function () {
				$("#confirm").keyup(
					function () {
						if ($("#password").val() != $("#confirm").val()) {
							$("#msg").html("Password do not match")
								.css("color", "red");
						} else {
							$("#msg").html("Password match").css(
								"color", "green");
						}
					});
			});
	</script>
</body>

</html>