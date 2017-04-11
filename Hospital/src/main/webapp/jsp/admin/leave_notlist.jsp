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
    <title>医院 - 员工未批准请假列表</title>
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
                    <h5>未批准请假列表</h5>
                </div>
                <div class="ibox-content">
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>姓名</th>
                            <th>开始日期</th>
                            <th>结束日期</th>
                            <th>天数</th>
                            <th>审批状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Leave> list = (List<Leave>) request.getAttribute("list");
                            int index = 1;
                            for (Leave leave : list) {
                        %>
                        <tr class="gradeA">
                            <td><%=index++ %>
                            </td>
                            <td><%=leave.getEmployee().getName() %>
                            </td>
                            <%
                                String startTime = MyTimeUtil.dateFormat(leave.getStartTime());
                                String endTime = MyTimeUtil.dateFormat(leave.getStartTime());
                            %>
                            <td><%=startTime %>
                            </td>
                            <td><%=endTime %>
                            </td>
                            <td><%=leave.getDays() %>
                            </td>
                            <td><%=leave.getStatus() %>
                            </td>
                            <td><a href="<%=path %>/leave/<%=leave.getId() %>/detail.do" class="btn btn-info">查看</a>&nbsp;&nbsp;
                                <a href="<%=path %>/leave/<%=leave.getId() %>/update.do" class="btn btn-primary">批准</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
