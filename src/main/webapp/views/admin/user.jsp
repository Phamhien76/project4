<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <a href="<%=request.getContextPath()%>/userController/getData" class="active">
                <i class='bx bx-grid-alt'></i>
                <span class="links_name">Dashboard</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/categoriesController/findAll?page=1&sortBy=id&sortDir=ASC">
                <i  class='bx bx-coin-stack'></i>
                <span class="links_name">Categories</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/productController/findAll?page=1&sortBy=id&sortDir=ASC">
                <i  class='bx bx-box'></i>
                <span class="links_name">Products</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/billController/findAll?page=1&sortBy=id&sortDir=ASC">
                <i  class='bx bx-list-ul'></i>
                <span class="links_name">Bill list</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/userController/findAll?page=1&sortBy=id&sortDir=ASC">
                <i  class='bx bx-user'></i>
                <span class="links_name">User</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/views/login.jsp">
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
            <span class="dashboard">User</span>
        </div>
        <div class="sidebar-button">
            <i  class='bx bx-user'></i>
            <span class="dashboard"><%=session.getAttribute("name")%></span>
        </div>
    </nav>


    <div class="home-content">

        <nav class="nav">
            <div class="create">

            </div>
            <div class="search-box">
                <form action="<%=request.getContextPath()%>/userController/searchSortUser" method="post">
                    <input type="text" name="email"  placeholder="Email...">
                    <button >Search</button>
                </form>
            </div>
            <div class="sort">
                <form action="<%=request.getContextPath()%>/userController/findAllSort" method="post" >
                    <label for="sortBy">Order:</label>
                    <select id="sortBy" name="sortBy">
                        <option value="name">User Name</option>
                        <option value="created">Created</option>
                    </select>
                    <select id="sortDir" name="sortDir">
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
                <th>User Id</th>
                <th>User Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Created</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody id="listStudent">
            <c:forEach items="${listUser}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.created}</td>
                    <td>${user.status?"Active":"Inactive"}</td>
                    <td>
                        <a class="btn btn-warning btn-xs" href="<%=request.getContextPath()%>/userController/updateStatus?userId=${user.id}">Block</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
       <div class="page">
            <a class="btn btn-warning btn-xs" href="<%=request.getContextPath()%>/userController/findAll?page=1&sortBy=id&sortDir=ASC" >Back</a>
           <c:forEach items="${listPage}" var="page">
               <a href="<%=request.getContextPath()%>/userController/findAll?page=${page}&sortBy=id&sortDir=ASC">${page}</a>
           </c:forEach>
       </div>

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
