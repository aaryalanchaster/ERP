<!DOCTYPE html>
<%@page import="com.model.User"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>Profile</title>
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.0.10/css/all.css'>
	<link rel="stylesheet" href="CSS/uprofile.css">
	<!-- <link rel="stylesheet" href="style.css"> -->
	<link rel="stylesheet" href="CSS/unav.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
	<!-- <link rel="stylesheet" href="CSS/nav.css"> -->
	<script>
		function resetfun() {

			document.getElementById("myinput").value = "";
			document.getElementById("myinput1").value = "";
			document.getElementById("myinput2").value = "";
			document.getElementById("myinput3").value = "";
			document.getElementById("myinput4").value = "";

		}
	</script>
</head>

<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	%>
	<%
		List<User> list = (List<User>) request.getAttribute("data");
	%>
	<%
		for (User u : list) {
	%>
	<div>
		<header>

			<h1 id="saasta">Shoppers Place</h1>
			<!-- <div id="cd-hamburger-menu"><a class="cd-img-replace" href="#0">Menu</a></div> -->
			<div id="cd-cart-trigger">
				<a class="cd-img-replace" href="#0">Cart</a>
			</div>
		</header>
		<div id="cd-shadow-layer"></div>
		<div id="cd-cart">
			<h2>Cart</h2>
			<ul class="cd-cart-items">
				<li><span class="cd-qty">1x</span> Product Name
					<div class="cd-price">$9.99</div> <a href="#0" class="cd-item-remove cd-img-replace">Remove</a></li>

				<li><span class="cd-qty">2x</span> Product Name
					<div class="cd-price">$19.98</div> <a href="#0" class="cd-item-remove cd-img-replace">Remove</a>
				</li>

				<li><span class="cd-qty">1x</span> Product Name
					<div class="cd-price">$9.99</div> <a href="#0" class="cd-item-remove cd-img-replace">Remove</a></li>
			</ul>
			<!-- cd-cart-items -->

			<div class="cd-cart-total">
				<p>
					Total <span>$39.96</span>
				</p>
			</div>
			<!-- cd-cart-total -->

			<a href="#0" class="checkout-btn">Checkout</a>

			<p class="cd-go-to-cart">
				<a href="#0">Go to cart page</a>
			</p>
		</div>
		<nav id="main-nav">
			<ul>
				<li><a href="DashBoardShow">Home</a></li>
				<!-- <li><a href="#0"></a></li> -->
				<li><a class="current" href="UserShowController">Profile</a></li>
				<!-- <li><a href="#0"></a></li> -->
				<li><a href="UserExitController">Logout</a></li>
			</ul>
		</nav>
	</div>
	<form method="post">
		<div class="container">
			<img class="profile-img"
				src="https://www.nationalgeographic.com/content/dam/news/photos/000/842/84214.ngsversion.1422286683017.adapt.1900.1.jpg"
				alt="hello">
			<div class="rightbox">
				<div class="profile">
					<h1 id="info">Personal Info</h1>
					<br>
					<h2>Full Name</h2>

					<input type="text" placeholder="Name" name="name" value="<%=u.getU_name()%>" id="myinput" />
					<h2>Birthday</h2>
					<input type="text" placeholder="DD/MM/YYYY" name="date" value="<%=u.getU_dob()%>" id="myinput1" />


					<h2>Gender</h2>
					<input type="text" placeholder="Gender" name="gender" value="<%=u.getU_gender()%> " id="myinput2" />

					<h2>Email</h2>
					<input type="email" placeholder="Email" name="email" value="<%=u.getU_email()%>" id="myinput3" />

					<h2>Password</h2>

					<input type="password" placeholder="password" name="password" value="<%=u.getU_password()%>" id="myinput4" />
					<input type="submit" formaction="UserShowController" value="Update" name="update" />
					<input type="button" value="Reset" onclick="return resetfun()" name="reset" />
					<%
						}
					%>
				</div>
			</div>
	</form>

	<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
	<script src="JS/udashboard.js"></script>

</body>

</html>