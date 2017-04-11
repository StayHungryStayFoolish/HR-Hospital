<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.hospital_hr.entity.*" %>
<%@ page import="com.hospital_hr.uitl.MyTimeUtil" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>医院 - 查看员工请假信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="<%=path %>/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.css" rel="stylesheet">
    <link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>查看员工请假信息</h5>
                </div>
                <div class="ibox-content">
                    <% Leave leave = (Leave) request.getAttribute("leave");%>
                    <form method="post" class="form-horizontal" action="">
                        <div class="form-group">
                            <div class="col-md-2"></div>
                            <div class="col-md-5">
                                <label class="col-sm-8 control-label">工号：</label>
                                <p class="form-control-static"><%=leave.getEmployeeNumber() %></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2"></div>
                            <div class="col-md-5">
                                <label class="col-sm-8 control-label">姓名：</label>
                                <p class="form-control-static"><%=leave.getEmployee().getName() %></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2"></div>
                            <div class="col-md-5">
                                <label class="col-sm-8 control-label">起始时间：</label>
                                <%
                                    String starttime = MyTimeUtil.dateFormat(leave.getStartTime());
                                    String endtime = MyTimeUtil.dateFormat(leave.getStartTime());
                                %>
                                <p class="form-control-static"><%=starttime %></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2"></div>
                            <div class="col-md-5">
                                <label class="col-sm-8 control-label">结束时间：</label>
                                <p class="form-control-static"><%=endtime %></p>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
