<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<%@page import="com.hospital_hr.entity.*" %>
<%@page import="com.baomidou.mybatisplus.plugins.Page" %>
<%@page import="com.hospital_hr.uitl.MyTimeUtil" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>医院 - 在职员工列表</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="<%=path %>/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.css" rel="stylesheet">
    <link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<%=path %>/dist/sweetalert.css">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>在职员工列表</h5>
                </div>
                <div class="ibox-heading">
                    <div style="margin-bottom: 8px">
                        <a href="<%=path %>/employee/toAdd.do" class="btn btn-success">添加员工</a>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTable-example">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>工号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>电话</th>
                            <th>部门名称</th>
                            <th>职称</th>
                            <th>入职时间</th>
                            <th>管理</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            Page<Employee> pageInfo = (Page<Employee>) request.getAttribute("page");
                            if (null != pageInfo && null != pageInfo.getRecords() && pageInfo.getRecords().size() > 0) {
                                List<Employee> list = pageInfo.getRecords();
                                int index = 1;
                                for (Employee employee : list) {
                        %>
                        <tr class="gradeA">
                            <td><%=index++ %></td>

                        </tr>
                        </tbody>
                    </table>
                    <div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
