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
            <span class="dashboard">Categories</span>
        </div>
    </nav>



    <form action="<%=request.getContextPath()%>/categoriesController/update" method="post"  >
        <div class="modal-body">
            <div class="mb-3 row">
                <label for="id" class="col-sm-3 col-form-label" placeholder="Nhập vào mã danh mục">Catalog Id</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="id" name="id" value="${updateCategories.id}"/>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="name" class="col-sm-3 col-form-label" placeholder="Nhập vào tên sản phẩm">Catalog name</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="name" name="name" value="${updateCategories.name}"/>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="description" class="col-sm-3 col-form-label" placeholder="Nhập vào mô tả">Description</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="description" name="description" value="${updateCategories.description}" />
                </div>
            </div>
            <div class="mb-3 row">
                <label for="active" class="col-sm-3 col-form-label">Status</label>
                <div class="col-sm-9">
                    <input type="radio" name="status" id="active" value="true" ${updateCategories.status?"checked":""} /><label for="active">Active</label>
                    <input type="radio" name="status" id="inactive" value="false" ${updateCategories.status?"":"checked"} /><label for="inactive">Inactive</label>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary" id="btnCreateStudent" >Save</button>
                <a href=<%=request.getContextPath()%>/categoriesController/findAll"  class="btn btn-secondary" >Cancel</a>
            </div>
        </div>
    </form>


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

