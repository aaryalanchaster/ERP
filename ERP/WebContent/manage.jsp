<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Manager"%>
<%@page import="java.util.List"%>
<%@page import="org.w3c.dom.ls.LSInput"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
	<meta http-equiv="keywords" content="" />
	<meta http-equiv="description" content="" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	<link rel="stylesheet" href="CSS/nav.css" />
	<link rel="stylesheet" href="CSS/add.css" />
	<script src="JS/Admin.js"></script>
	<title>Manage</title>
</head>

<body>

	<%

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

%>
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="LoginController">Dashboard</a>
		<a href="AdminShowController">Profile</a>
		<a href="#">Manage</a>
		<a href="ExitController">Logout</a>
	</div>
	<span style="font-size: 40px; position:fixed;cursor: pointer" onclick="openNav()">&#9776;
	</span>
	<%
		/* List<Products> list = (List<Products>) request.getAttribute("product");
		ArrayList<Manager> al = (ArrayList<Manager>) request.getAttribute("manager");  */
		ArrayList<Manager> list = (ArrayList<Manager>) request.getAttribute("show");
		
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<a name="bottom"></a>
				<h1>Product List</h1>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Product Name</th>
							<th>Price</th>
							<th>Description</th>
							<th>Name</th>
							<th>Designation</th>
						</tr>
					</thead>
					<tbody id="products-list">
						<tr>
							<%
								 for(Manager m : list){ 										
							%>
							<th scope="row"><%=m.getP_id()%></th>
							<td><%=m.getP_name() %> </td>
							<td>&#x20B9;<%=m.getPrice()%></td>
							<td><%=m.getP_desc() %></td>
							<td><%=m.getM_name() %></td>
							<td><%=m.getM_desig() %></td>
						</tr>
						<% 	
							} 
						%>
					</tbody>

				</table>

				<a href="#add"><input type="submit" name="submit" value="add" /></a>
				<a href="#Edit"> <input type="submit" name="submit" value="edit" /></a>
				<hr>
				<div class=right>
					<a name="add"></a>
					<h1>Add new Product</h1>
					<form action="ManageController" id="add-product-form" name="addproductform" method="post">
						<div class="detail">
							<div class="form-group">
								<h2>Product title</h2>
								<input type="text" name="p_name">
							</div>
							<div>
								<div>
									<div class="form-group">
										<h2>Product ID</h2>
										<div class="input-group">
											<input type="text" name="p_id">
										</div>
									</div>
								</div>
							</div>

							<div>
								<div>
									<div class="form-group">
										<h2>Product Price</h2>
										<div class="input-group">
											<input type="text" name="price">
										</div>
									</div>
								</div>
							</div>
							<div class="form-group">
								<h2>Product Description</h2>
								<textarea type="textarea" rows="4" cols="30" name="p_desc"></textarea>
							</div>
							<div>
								<div>
									<div class="form-group">
										<h2>Manager name</h2>
										<div class="input-group">
											<input type="text" name="m_name">
										</div>
									</div>
								</div>
							</div>
							<div>
								<div>
									<div class="form-group">
										<h2>Designation</h2>
										<div class="input-group">
											<input type="text" name="m_desig">
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="add">
							<input type="submit" value="Add" name="add" />
							</a>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="edit">
			<hr>
			<h1>Edit the List</h1>
			<a name="Edit"></a>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Description</th>
						<th>Name</th>
						<th>Designation</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody id="products-list">
					<tr>
						<%
								 for(Manager m : list){ 										
							%>
						<th scope="row"><%=m.getP_id()%></th>
						<td><%=m.getP_name() %> </td>
						<td>&#x20B9;<%=m.getPrice()%></td>
						<td><%=m.getP_desc() %></td>
						<td><%=m.getM_name() %></td>
						<td><%=m.getM_desig() %></td>
						<td><button><a href="ProductController?productID=<%=m.getP_id()%>">Edit</a></button></td>
					</tr>
					<% 	
							} 
						%>

				</tbody>
			</table>
		</div>
	</div>
</body>

</html>