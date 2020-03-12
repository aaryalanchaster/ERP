<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.model.Admin"%>
<html lang="en">

<head>
	<meta charset="UTF-8">

	<title>Profile</title>
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.0.10/css/all.css'>
	<link rel="stylesheet" href="CSS/profile.css">
	<script src="Images/neon.jpg"></script>
	<link rel="stylesheet" href="CSS/nav.css">
	<script src="JS/Admin.js"></script>

	<script type="text/javascript">
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
		List<Admin> list = (List<Admin>) request.getAttribute("data");
	%>
	<%
		for (Admin a : list) {
	%>
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="LoginController">Dashboard</a> <a href="AdminShowController">Profile</a> <a
			href="ManageController">Manage</a>

		<a href="ExitController">Logout</a>
	</div>
	<span style="font-size: 40px; position: fixed; cursor: pointer" onclick="openNav()">&#9776; </span>
	<form method="post">
		<div class="container">
			<img class="profile-img"
				src="https://3.bp.blogspot.com/-aZoSjCnCsv4/Tt3GUh4GOuI/AAAAAAAAB_E/bUldYUINGlw/s1600/HDHuT.BlogSpot.com+%25286%2529.jpg"
				alt="picture">
			<div class="rightbox">
				<div class="profile">

					<h1>Personal Info</h1>
					<h2>Full Name</h2>
					<input type="text" placeholder="Name" name="name" value="<%=a.getName()%>" id="myinput" required />
					<h2>Birthday</h2>
					<input type="text" placeholder="DD-MM-YYYY" name="date" value="<%=a.getDob()%>" id="myinput1"
						required />
					<h2>Gender</h2>
					<input type="text" placeholder="Gender" name="gender" value="<%=a.getGender()%>" id="myinput2"
						required />
					<h2>Email</h2>
					<input type="email" placeholder="Email" name="email" value="<%=a.getEmail()%>" id="myinput3"
						required />
					<h2>Password</h2>
					<input type="password" placeholder="password" name="password" value="<%=a.getPassword()%>"
						id="myinput4" required />
					<input type="submit" formaction="AdminShowController" value="Update" />
					<input type="button" onclick="return resetfun()" value="Reset" />
					<%
						}
					%>
				</div>
			</div>
		</div>
	</form>
</body>

</html>