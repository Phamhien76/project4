<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <span class="dashboard">Dashboard</span>
        </div>

        <div class="sidebar-button">
            <i  class='bx bx-user'></i>
            <span class="dashboard"><%=session.getAttribute("name")%></span>
        </div>
    </nav>

    <div class="home-content">
        <div class="bill">
            <div class="oder">Đơn Hàng</div>
            <div class="overview-boxes">
                <div class="box">
                    <div class="right-side">
                        <div class="box-topic">Đã hủy</div>
                        <div class="number">${cancel0}</div>
                    </div>
                    <i class='bx bx-cart-alt cart zero'></i>
                </div>
                <div class="box">
                    <div class="right-side">
                        <div class="box-topic">Đang chờ</div>
                        <div class="number">${waiting1}</div>
                    </div>
                    <i class='bx bx-cart-alt cart'></i>
                </div>
                <div class="box">
                    <div class="right-side">
                        <div class="box-topic">Đã duyệt</div>
                        <div class="number">${approved2}</div>
                    </div>
                    <i class='bx bxs-cart-add cart two' ></i>
                </div>
                <div class="box">
                    <div class="right-side">
                        <div class="box-topic">Đang giao</div>
                        <div class="number">${delivering3}</div>
                    </div>
                    <i class='bx bx-cart cart three' ></i>
                </div>
                <div class="box">
                    <div class="right-side">
                        <div class="box-topic">Đã nhận hàng</div>
                        <div class="number">${received4}</div>
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
                        <li><a href="#">${userActive}</a></li>
                        <li><a href="#">${userInactive} </a></li>
                        <li class="topic">Tổng </li>
                        <li><a href="#">${productActive}</a></li>
                        <li><a href="#">${productInactive}</a></li>
                    </ul>
                </div>

            </div>
            <div class="top-sales box">
                <div class="title">Doanh Thu</div>
                <ul class="top-sales-details">
                    <li>
                        <form action="<%=request.getContextPath()%>/userController/total">
                            <label for="day">Theo ngày</label>
                            <select name="day" id="day">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                <option value="17">17</option>
                                <option value="18">18</option>
                                <option value="19">19</option>
                                <option value="20">20</option>
                                <option value="21">21</option>
                                <option value="22">22</option>
                                <option value="23">23</option>
                                <option value="24">24</option>
                                <option value="25">25</option>
                                <option value="26">26</option>
                                <option value="27">27</option>
                                <option value="28">28</option>
                                <option value="29">29</option>
                                <option value="30">30</option>
                                <option value="31">31</option>
                            </select>
                            <input type="submit" value="Xem">
                        </form>
                        <div class="price">
                              ${totalDay}
                        </div>
                    </li>
                    <li>
                        <form action="<%=request.getContextPath()%>/userController/totalMonth">
                            <label for="month">Theo Tháng</label>
                            <select name="month" id="month">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>

                            </select>
                            <input type="submit" value="Xem">
                        </form>
                        <div class="price">
                            ${totalMonth}
                        </div>
                    </li>
                    <li>
                        <form action="<%=request.getContextPath()%>/userController/totalYear">
                            <label for="year">Theo Năm</label>
                            <select name="year" id="year">
                                <option value="2023">2023</option>
                                <option value="2024">2024</option>
                            </select>
                            <input type="submit" value="Xem">
                        </form>
                        <div class="price">
                                ${totalYear}
                        </div>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</section>
</body>
</html>