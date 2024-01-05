<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024/01/01
  Time: 22:02
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
            <span class="dashboard">Dashboard</span>
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
        <div class="bill">
            <div class="oder">Đơn Hàng</div>
            <div class="overview-boxes">
                <div class="box">
                    <div class="right-side">
                        <div class="box-topic">Đã hủy</div>
                        <div class="number">40,876</div>
                    </div>
                    <i class='bx bx-cart-alt cart zero'></i>
                </div>
                <div class="box">
                    <div class="right-side">
                        <div class="box-topic">Đang chờ</div>
                        <div class="number">40,876</div>
                    </div>
                    <i class='bx bx-cart-alt cart'></i>
                </div>
                <div class="box">
                    <div class="right-side">
                        <div class="box-topic">Đã duyệt</div>
                        <div class="number">38,876</div>
                    </div>
                    <i class='bx bxs-cart-add cart two' ></i>
                </div>
                <div class="box">
                    <div class="right-side">
                        <div class="box-topic">Đang giao</div>
                        <div class="number">$12,876</div>
                    </div>
                    <i class='bx bx-cart cart three' ></i>
                </div>
                <div class="box">
                    <div class="right-side">
                        <div class="box-topic">Đã nhận hàng</div>
                        <div class="number">11,086</div>
                    </div>
                    <i class='bx bxs-cart-download cart four' ></i>
                </div>
            </div>
        </div>



        <div class="sales-boxes">
            <div class="recent-sales box">
                <div class="sales-details">
                    <ul class="details">
                        <li class="topic">Tài Khoản</li>
                        <li><a href="#">Hoạt động</a></li>
                        <li><a href="#">Không hoạt động</a></li>
                        <li class="topic">Sản Phẩm</li>
                        <li><a href="#">Hoạt động</a></li>
                        <li><a href="#">Không hoạt động</a></li>
                    </ul>
                    <ul class="details">
                        <li class="topic">Tổng</li>
                        <li><a href="#">$204.98</a></li>
                        <li><a href="#">$24.55</a></li>
                        <li class="topic">Tổng </li>
                        <li><a href="#">$25.88</a></li>
                        <li><a href="#">$170.66</a></li>
                    </ul>
                </div>

            </div>
            <div class="top-sales box">
                <div class="title">Doanh Thu</div>
                <ul class="top-sales-details">
                    <li>
                        <a href="#">
                            <!--<img src="images/sunglasses.jpg" alt="">-->
                            <span class="product">Theo ngày</span>
                        </a>
                        <span class="price">$1107</span>
                    </li>
                    <li>
                        <a href="#">
                            <!--<img src="images/jeans.jpg" alt="">-->
                            <span class="product">Theo Tháng </span>
                        </a>
                        <span class="price">$1567</span>
                    </li>
                    <li>
                        <a href="#">
                            <!-- <img src="images/nike.jpg" alt="">-->
                            <span class="product">Theo Năm</span>
                        </a>
                        <span class="price">$1234</span>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</section>
</body>
</html>
