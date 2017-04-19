<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.hospital_hr.entity.*" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>医院 - 安排加班</title>
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
                    <h5>安排加班</h5>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="commentForm" action="<%=path %>/overtime/add.do">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">部门</label>
                            <div class="col-sm-7">
                                <select class="form-control m-b" id="department" name="departmentNumber" size="1"
                                        required>
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
                            <label class="col-sm-3 control-label">员工</label>
                            <div class="col-sm-7">
                                <select class="form-control m-b" id="employee" name="employeeNumber" size="1" required>
                                    <option value="">--请选择员工--</option>
                                    <%
                                        List<Employee> eList = (List<Employee>) request.getAttribute("eList");
                                        for (Employee employee : eList) {

                                    %>
                                    <option value="<%=employee.getEmployeeNumber() %>">
                                        <%=employee.getName() %>
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
