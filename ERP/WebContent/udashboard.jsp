<!DOCTYPE html>
<%@page import="com.model.Products"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>Products</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
		type="text/javascript"></script>

	<link href='https://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/148866/reset.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	<link rel="stylesheet" href="CSS/udashboard.css">

</head>

<body>

	<body>

		<%
		ArrayList<Products> list = (ArrayList<Products>) request.getAttribute("data");
	%>
		<header>
			<h1>Shoppers Place</h1>
			<div id="cd-cart-trigger">
				<a class="cd-img-replace" href="#0">Cart</a>
			</div>
		</header>
		<nav id="main-nav">
			<ul>
				<li><a class="current" href="DashBoardShow">Home</a></li>
				<li><a href="UserShowController">Profile</a></li>
				<li><a href="UserExitController">Logout</a></li>
			</ul>
		</nav>
		<main>
			<ul id="cd-gallery-items" class="cd-container">
				<%
				for (Products p : list) {
			%>
				<li>
					<img src="https://i.telegraph.co.uk/multimedia/archive/01603/latin-venezuela_1603708a.jpg"
						alt="Preview image">
					<ul>
						<li>
							<h2><%=p.getP_name()%></h2>
							<p><%=p.getP_desc()%></p>
							<h4><%=p.getPrice()%></h4>
						</li>
						<li>
							<button>&#43;</button>
						</li>
					</ul>
				</li>
				<%
				}
			%>
			</ul>
		</main>
		<div id="cd-shadow-layer"></div>
		<div id="cd-cart">
			<h2>Cart</h2>
			<ul class="cd-cart-items">
				<% for (Products p : list){ %>
				<li><span class="cd-qty">1x</span> <%=p.getP_name() %>
					<div class="cd-price"><%=p.getPrice() %></div> <a href="#0"
						class="cd-item-remove cd-img-replace">Remove</a></li>
				<% } %>
			</ul>
			<div class="cd-cart-total">
				<p>
					Total <span>$39.96</span>
				</p>
			</div>
			<a href="#0" class="checkout-btn">Checkout</a>
			<p class="cd-go-to-cart">
				<a href="#0">Go to cart page</a>
			</p>
		</div>

	</body>

	<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="JS/udashboard.js"></script>

</body>

</html>