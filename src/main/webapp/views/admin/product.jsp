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
    <link href="<%=request.getContextPath()%>/resources/css/product.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

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

        <div class="profile-details">
            <i  class='bx bx-user'></i>
            <span class="admin_name">User</span>

        </div>
    </nav>



    <div class="home-content">

        <nav class="nav">
            <div class="create">
                <a href="<%=request.getContextPath()%>/productController/initCreate">Create</a>
            </div>
            <div class="search-box">
                <input type="text" placeholder="Search...">
                <i class='bx bx-search' ></i>
            </div>
            <div class="sort">
                <form action="<%=request.getContextPath()%>/productController/findAllSort" method="post" >
                    <label for="orderDir">Order:</label>
                    <select id="orderDir" name="orderDir">
                        <option value="id">Product Id</option>
                        <option value="name">Product Name</option>
                        <option value="price">Price</option>
                        <option value="create">Create</option>
                    </select>
                    <select id="orderBy" name="orderBy">
                        <option value="ASC">ASC</option>
                        <option value="DESC">DESC</option>
                    </select><br>
                    <input type="submit" value="Search">
                </form>
            </div>
        </nav>

        <table class="table table-bordered" id="table">
            <thead>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Title</th>
                <th>Description</th>
                <th>Avatar</th>
                <th>Other Images</th>
                <th>Unit</th>
                <th>Catalog Id</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody id="listStudent">
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
                    <td>${pro.catalog.name}</td>
                    <td>${pro.status?"Active":"Inactive"}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/productController/initUpdate?catalogId=${pro.id}">Update</a>
                        <a href="<%=request.getContextPath()%>/productController/delete?catalogId=${pro.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        </table>?
        <c:forEach items="${listPage}" var="page">
            <a href="/productController/findAll?page=${page}&&sortBy=id&&sortDir=ASC">${page}</a>
        </c:forEach>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"></script>
</body>
</html>
