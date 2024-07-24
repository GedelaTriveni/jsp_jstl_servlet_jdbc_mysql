<%@page import="models.swiggy"%>
<%@page import="java.util.List"%>
<%@page import="dbconnections.swiggydbconnections"%>
<%@page import="services.swiggyservices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Swiggy Registration List</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRS4ItnHpJivB6Xyu0_DQnY43uFV1cNKc7TaA&s');
        background-size: cover;
        background-repeat: no-repeat;
        background-attachment: fixed;
    }
    .container {
        background: rgba(255, 255, 255, 0.8); /* White background with opacity for readability */
        border-radius: 10px;
        padding: 20px;
        margin-top: 20px;
        background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRS4ItnHpJivB6Xyu0_DQnY43uFV1cNKc7TaA&s'); /* Image URL for the container */
        background-size: cover; /* Adjust image to cover the container */
        background-position: center; /* Center the image */
    }
    h1 {
        text-align: center;
        color: blue; /* Color adjustment for better contrast */
    }
    .table th, .table td {
        color: #333; /* Color adjustment for table text */
    }
</style>
</head>
<body>

<div class="container">
    <h1 class="my-4">Swiggy Registration Status</h1>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Confirm Password</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
            swiggyservices ss = new swiggyservices(swiggydbconnections.getconnection());
            List<swiggy> l = ss.getall();
            for(swiggy s : l) {
            %>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getName()%></td>
                <td><%=s.getEmail()%></td>
                <td><%=s.getPassword()%></td>
                <td><%=s.getConfirmpassword()%></td>
                <td>
                    <button class="btn btn-warning btn-sm">Update</button>
                    <a href="delete?id=<%=s.getId()%>" class="btn btn-danger btn-sm">DeleteById</a>
                    <a href="delete1?email=<%=s.getEmail()%>" class="btn btn-danger btn-sm">DeleteByEmail</a>
                </td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
