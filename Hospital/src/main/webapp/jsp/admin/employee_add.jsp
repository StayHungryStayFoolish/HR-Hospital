<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<%@page import="com.hospital_hr.entity.*" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>医院 - 添加员工</title>
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
                    <h5>添加员工</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal" id="commentForm" action="<%=path %>/employee/add.do" method="post">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">工号</label>
                            <div class="col-sm-7">
                                <% Integer employeeNumber = (Integer) request.getAttribute("employeeNumber"); %>
                                <input type="text" class="form-control" name="employeeNumber"
                                       value="<%=employeeNumber %>" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">姓名</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="" name="name" minlength="2"
                                       required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">密码</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" placeholder="" id="password" name="password"
                                       minlength="4" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">确认密码</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" placeholder="" name="password2"
                                       equalTo="#password" minlength="4" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别</label>
                            <div class="col-sm-7">
                                <div class="radio i-checks">
                                    <label>
                                        <input type="radio" value="男" name="gender" checked="checked"> <i></i>男</label>
                                    <i style="margin-left: 25px"></i>
                                    <label>
                                        <input type="radio" value="女" name="gender"> <i></i>女</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">出生日期</label>
                            <div class="col-sm-7">
                                <input type="date" class="form-control" size="1" name="date">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">联系方式</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="" name="telephone">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">邮箱</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="" name="email" email="ture">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">籍贯</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="" name="address">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学历</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="" name="education">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">部门</label>
                            <div class="col-sm-7">
                                <select class="form-control m-b" name="departmentNumber" size="1" required>
                                    <option value="">--请选择部门--</option>
                                    <%
                                        List<Department> dList = (List<Department>) request.getAttribute("dList");
                                        for (Department department : dList) {

                                    %>
                                    <option value="<%=department.getDepartmentNumber() %>">
                                        <%=department.getName() %>
                                    </option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">职称</label>
                            <div class="col-sm-7">
                                <select class="form-control m-b" name="positionNumber" size="1" required>
                                    <option value="">--请选择职称--</option>
                                    <%
                                        List<Position> pList = (List<Position>) request.getAttribute("pList");
                                        for(Position position : pList){

                                    %>
                                    <option value="<%=position.getPositionNumber() %>">
                                        <%=position.getName() %>
                                    </option>
                                    <%
                                        }
                                    %>
                                </select>
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
