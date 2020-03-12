<%@page import="java.util.List"%>
<%@page import="com.model.Manager"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
    <meta http-equiv="keywords" content="" />
    <meta http-equiv="description" content="" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
    <link rel="stylesheet" href="CSS/nav.css">
    <link rel="stylesheet" href="CSS/add.css">
    <script src="JS/Admin.js"></script>
    <title>Manage</title>
</head>

<body>
    <%

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

%>
    <div class=right>
        <a name="add"></a>
        <h1 style="margin-left: 20%;">Update Product</h1>
        <form action="ProductController" id="add-product-form" style="margin-left:10%;" name="addproductform"
            enctype='application/json'>
            <div class="detail">
                <%
                        	ArrayList<Manager> list = (ArrayList<Manager>)request.getAttribute("productshow");
                        %>
                <%
                        	for(Manager m : list)
                        	{		
                        	
                        %>
                <div>
                    <div>
                        <div class="form-group">
                            <h2>Product ID</h2>
                            <div class="input-group">
                                <input type="text" name="id" value="<%=m.getP_id() %>" readonly>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <h2>Product title</h2>
                    <input type="text" name="name" value="<%=m.getP_name() %>">
                </div>
                <div>
                    <div>
                        <div class="form-group">
                            <h2>Product Price</h2>
                            <div class="input-group">
                                <input type="text" name="price" value="<%=m.getPrice() %>">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <h2>Product Description</h2>
                    <textarea type="textarea" name="desc" rows="4" cols="30"><%=m.getP_desc() %></textarea>
                </div>
                <div>
                    <div>
                        <div class="form-group">
                            <h2>Manager name</h2>
                            <div class="input-group">
                                <input type="text" name="mname" value="<%=m.getM_name() %>">
                            </div>
                        </div>
                    </div>
                </div>

                <div>
                    <div>
                        <div class="form-group">
                            <h2>Designation</h2>
                            <div class="input-group">
                                <input type="text" name="mdesig" value="<%=m.getM_desig() %>">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <% } %>
            <div class="add">
                <input type="submit" value="Update" name="add" />
                </a>
            </div>
        </form>
    </div>
    </div>
    </div>
</body>

</html>