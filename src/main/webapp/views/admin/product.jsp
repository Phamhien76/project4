<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024/01/03
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboad</title>
    <link href="<%=request.getContextPath()%>/resources/css/dashboard.css" rel="stylesheet"/>

    <!-- Boxicons CDN Link -->
    <link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet"/>
</head>
<body>

<div class="sidebar">
    <div class="logo-details">
        <i class='bx bxl-c-plus-plus'></i>
        <span class="logo_name">Nhahien</span>
    </div>
    <ul class="nav-links">
        <li>
            <a href="<%=request.getContextPath()%>/dashboardController/findAll" class="active">
                <i class='bx bx-grid-alt'></i>
                <span class="links_name">Dashboard</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/categoriesController/findAll">
                <i  class='bx bx-coin-stack'></i>
                <span class="links_name">Categories</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/productController/findAll">
                <i  class='bx bx-box'></i>
                <span class="links_name">Products</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/billController/findAll">
                <i  class='bx bx-list-ul'></i>
                <span class="links_name">Bill list</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/userController/findAll">
                <i  class='bx bx-user'></i>
                <span class="links_name">User</span>
            </a>
        </li>
        <li>
            <a href="">
                <i  class='bx bx-log-out'></i>
                <span class="links_name">Log out</span>
            </a>
        </li>
    </ul>
</div>
<section class="home-section">
    <nav>
        <div class="sidebar-button">
            <i class='bx bx-menu sidebarBtn'></i>
            <span class="dashboard">Product</span>
        </div>
        <div class="search-box">
            <input type="text" placeholder="Search...">
            <i class='bx bx-search' ></i>
        </div>
        <div class="profile-details">
            <!--<img src="images/profile.jpg" alt="">-->
            <span class="admin_name">Sort</span>
            <i class='bx bx-chevron-down' ></i>
        </div>
    </nav>


    <div class="home-content">
        <a href="<%=request.getContextPath()%>/views/admin/newProduct.jsp">Create</a>
        <table border="1">
            <thead>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Title</th>
                <th>Description</th>
                <th>Product Images</th>
                <th>Product Unit</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listProduct}" var="pro">
                <tr>
                    <td>${pro.id}</td>
                    <td>${pro.name}</td>
                    <td>${pro.price}</td>
                    <td>${pro.title}</td>
                    <td>${pro.description}</td>
                    <td><img src="${pro.avatarImage}" alt="${pro.name}" height="50" width="50"/></td>
                    <td>
                        <c:forEach items="${pro.listImages}" var="image">
                            <img src="${image.imageLink}" alt="${pro.name}" height="50" width="50"/>

                        </c:forEach>
                    </td>
                    <td>${pro.unit}</td>
                    <td>${pro.status?"Active":"Inactive"}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/productController/initUpdate?catalogId=${pro.id}">Update</a>
                        <a href="<%=request.getContextPath()%>/productController/delete?catalogId=${pro.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>

    </div>
</section>
</body>
</html>