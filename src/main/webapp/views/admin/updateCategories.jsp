<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024/01/03
  Time: 16:39
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
            <span class="dashboard">Categories</span>
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
        <form action="<%=request.getContextPath()%>/categoriesController/update" method="post" >
            <label for="id">Catalog Name</label>
            <input type="text" id="id" name="id" value="${updateCategories.id}"><br>
            <label for="name">Catalog Name</label>
            <input type="text" id="name" name="name" value="${updateCategories.name}"><br>
            <label for="description">Description</label>
            <input type="text" id="description" name="description" value="${updateCategories.description}"><br>
            <label for="active">Status</label>
            <input type="radio" name="status" value="true" ${updateCategories.status?"checked":""}  id="active"><label for="active">Active</label>
            <input type="radio" name="status" value="false" ${updateCategories.status?"":"checked"} id="inactive"><label for="inactive">Inactive</label><br>
            <input type="submit" value="Create"/>

        </form>

    </div>
</section>
</body>
</html>

