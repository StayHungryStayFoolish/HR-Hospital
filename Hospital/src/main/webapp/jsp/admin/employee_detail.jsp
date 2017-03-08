<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.hospital_hr.entity.*" %>
<%@page import="com.hospital_hr.uitl.MyTimeUtil" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>医院 - 查看员工信息</title>
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
                    <h5>查看员工信息</h5>
                </div>
                <div class="ibox-content">
                    <% Employee employee = (Employee) request.getAttribute("employee");%>
                    <form method="post" class="form-horizontal" action="">
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <div class="col-md-4">
                                <lable class="col-sm-8 control-label">工号：</lable>
                                <p class="form-control-static"><%=employee.getEmployeeNumber() %>
                                </p>
                            </div>
                            <div class="col-md-4">
                                <lable class="col-sm-5 control-label">姓名：</lable>
                                <p class="form-control-static"><%=employee.getName()%>
                                </p>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <div class="col-md-4">
                                <label class="col-sm-8 control-label">性别：</label>
                                <p class="form-control-static"><%=employee.getGender() %>
                                </p>
                            </div>
                            <div class="col-md-4">
                                <label class="col-sm-5 control-label">出生日期：</label>
                                <% String birthday = MyTimeUtil.dateFormat(employee.getBirthday()); %>
                                <p class="form-control-static"><%=birthday %>
                                </p>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <div class="col-md-4">
                                <label class="col-sm-8 control-label">电话：</label>
                                <p class="form-control-static"><%=employee.getTelephone() %>
                                </p>
                            </div>
                            <div class="col-md-4">
                                <label class="col-sm-5 control-label">邮箱：</label>
                                <p class="form-control-static"><%=employee.getEmail() %>
                                </p>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <div class="col-md-4">
                                <label class="col-sm-8 control-label">籍贯：</label>
                                <p class="form-control-static"><%=employee.getAddress() %>
                                </p>
                            </div>
                            <div class="col-md-4">
                                <label class="col-sm-5 control-label">学历：</label>
                                <p class="form-control-static"><%=employee.getEducation() %>
                                </p>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <div class="col-md-4">
                                <label class="col-sm-8 control-label">部门：</label>
                                <p class="form-control-static"><%=employee.getDepartment().getName() %>
                                </p>
                            </div>
                            <div class="col-md-4">
                                <label class="col-sm-5 control-label">职称：</label>
                                <p class="form-control-static"><%=employee.getPosition().getName() %>
                                </p>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <div class="col-md-4">
                                <label class="col-sm-8 control-label">入职时间：</label>
                                <% String inTime = MyTimeUtil.dateFormat(employee.getInTime()); %>
                                <p class="form-control-static"><%=inTime %>
                                </p>
                            </div>
                            <div class="col-md-4">
                                <label class="col-sm-5 control-label">备注：</label>
                                <p class="form-control-static"><%=employee.getNotes() %>
                                </p>
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
