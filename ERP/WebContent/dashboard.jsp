<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css'>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/font/material-design-icons/Material-Design-Icons.woff'>
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet" href="CSS/nav.css">
<script src="JS/Admin.js"></script>
</head>
<body>
	<!-- partial:index.partial.html -->
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>

<body>


	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="LoginController">Dashboard</a> <a href="AdminShowController">Profile</a>
		<a href="ManageController">Manage</a>
		<!-- <a href="#">Clients</a> -->
		<a href="ExitController">Logout</a>
	</div>

	<span style="font-size: 40px; position: fixed; cursor: pointer"
		onclick="openNav()">&#9776; </span>

	<main id="main">
		<!-- <h1>Dashboard</h1> -->
		<div class="row">
			<div class="col s6">
				<div style="padding: 35px;" align="center" class="card">
					<div class="row">
						<div class="left card-title">
							<b>User Management</b>
						</div>
					</div>

					<div class="row">
						<a href="#!">
							<div style="padding: 0px;"
								class="grey lighten-3 col s5 waves-effect">
								<i class="indigo-text text-lighten-1 large material-icons">person</i>
								<span class="indigo-text text-lighten-1"><h5>Seller</h5></span>
							</div>
						</a>
						<div class="col s1">&nbsp;</div>
						<div class="col s1">&nbsp;</div>

						<a href="#!">
							<div style="padding: 0px;"
								class="grey lighten-3 col s5 waves-effect">
								<i class="indigo-text text-lighten-1 large material-icons">people</i>
								<span class="indigo-text text-lighten-1"><h5>Customer</h5></span>
							</div>
						</a>
					</div>
				</div>
			</div>

			<div class="col s6">
				<div style="padding: 35px;" align="center" class="card">
					<div class="row">
						<div class="left card-title">
							<b>Product Management</b>
						</div>
					</div>
					<div class="row">
						<a href="#!">
							<div style="padding: 0px;"
								class="grey lighten-3 col s5 waves-effect">
								<i class="indigo-text text-lighten-1 large material-icons">store</i>
								<span class="indigo-text text-lighten-1"><h5>Product</h5></span>
							</div>
						</a>

						<div class="col s1">&nbsp;</div>
						<div class="col s1">&nbsp;</div>

						<a href="#!">
							<div style="padding: 0px;"
								class="grey lighten-3 col s5 waves-effect">
								<i class="indigo-text text-lighten-1 large material-icons">assignment</i>
								<span class="indigo-text text-lighten-1"><h5>Orders</h5></span>
							</div>
						</a>
					</div>
				</div>
			</div>

		</div>

		<div class="fixed-action-btn click-to-toggle"
			style="bottom: 45px; right: 24px;">
			<a class="btn-floating btn-large pink waves-effect waves-light">
				<i class="large material-icons">add</i>
			</a>

			<ul>
				<li><a class="btn-floating red"><i class="material-icons">note_add</i></a>
					<a href="" class="btn-floating fab-tip">Add a note</a></li>

				<li><a class="btn-floating yellow darken-1"><i
						class="material-icons">add_a_photo</i></a> <a href=""
					class="btn-floating fab-tip">Add a photo</a></li>

				<li><a class="btn-floating green"><i class="material-icons">alarm_add</i></a>
					<a href="" class="btn-floating fab-tip">Add an alarm</a></li>

				<li><a class="btn-floating blue"><i class="material-icons">vpn_key</i></a>
					<a href="" class="btn-floating fab-tip">Add a master password</a></li>
			</ul>
		</div>
	</main>


</body>

</html>
<!-- partial -->
<script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js'></script>
<script src="./script.js"></script>

</body>
</html>
