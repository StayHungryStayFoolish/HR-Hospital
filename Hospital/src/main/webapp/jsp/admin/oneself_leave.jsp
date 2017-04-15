<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.hospital_hr.entity.*" %>
<%@ page import="com.hospital_hr.uitl.MyTimeUtil" %>
<%@ page import="com.baomidou.mybatisplus.plugins.Page" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>医院 - 员工请假列表</title>
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
                    <h5>请假列表</h5>
                </div>
                <div class="ibox-content">
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>姓名</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>天数</th>
                            <th>类型</th>
                            <th>请假原因</th>
                            <th>审批状态</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            Page<Leave> pageInfo = (Page<Leave>) request.getAttribute("page");
                            if (null != pageInfo && null != pageInfo.getRecords() && pageInfo.getRecords().size() > 0) {
                                List<Leave> list = pageInfo.getRecords();
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
                            <td><%=leave.getType() %>
                            </td>
                            <td><%=leave.getReason() %>
                            </td>
                            <td><%=leave.getStatus() %>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                        </tbody>
                    </table>
                    <div>
                        <span style="float: left; padding: 5px">
								当前&nbsp;<span
                                style="color: red;"><%=pageInfo.getCurrent() %></span>&nbsp;/&nbsp;<b><%=pageInfo.getPages() %></b>&nbsp;页&nbsp;&nbsp;
								总共&nbsp;<b><%=pageInfo.getTotal() %></b>&nbsp;条
                        </span>
                        <nav aria-label="Page navigation" style="margin: 0 auto; width: 200px">
                            <ul class="pagination" style="margin: 0;">
                                <li>
                                    <a href="<%=path %>/leave/oneself.do?page=<%=pageInfo.getCurrent()-1>1?pageInfo.getCurrent()-1:1 %>"
                                       aria-label="Previous"> <span aria-hidden="true">前一页</span>
                                    </a>
                                </li>
                                <%
                                    for (int i = 1; i <= pageInfo.getPages(); i++) {
                                %>
                                <li><a href="<%=path %>/leave/oneself.do?page=<%=i%>"><%=i %>
                                </a>
                                </li>
                                <%
                                    }
                                %>
                                <li>
                                    <a href="<%=path %>/leave/oneself.do?page=<%=pageInfo.getCurrent()+1<pageInfo.getPages()?pageInfo.getCurrent()+1:pageInfo.getPages() %>"
                                       aria-label="Next"> <span aria-hidden="true">后一页</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
