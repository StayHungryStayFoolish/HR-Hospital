<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.hospital_hr.entity.Employee" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>医院人事管理系统 - 主页</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <style>
        #line-chart {
            height: 300px;
            width: 800px;
            margin: 0px auto;
            margin-top: 1em;
        }
    </style>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="<%=path%>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path%>/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path%>/css/animate.css" rel="stylesheet">
    <link href="<%=path%>/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow: hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close">
            <i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<span class="clear">
									<span class="block m-t-xs" style="font-size: 20px;">
										<i class="fa fa-heartbeat"></i>
										<strong class="font-bold">&nbsp;医院</strong>
									</span>
								</span>
                        </a>
                    </div>
                    <div class="logo-element">HR</div>
                </li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">个人</span>
                </li>
                <li><a class="J_menuItem" href="<%=path %>/employee/welcome.do">
                    <i class="fa fa-home"></i>
                    <span class="nav-label">主页</span>
                </a>
                </li>
                <% Employee employee = (Employee) session.getAttribute("logged"); %>
                <li><a href="graph_metrics.html">
                    <i class="fa fa fa-newspaper-o"></i>
                    <span class="nav-label">个人信息</span>
                    <span class="fa arrow"></span>
                </a>
                </li>



            </ul>
        </div>
    </nav>

</div>
</body>
</html>
