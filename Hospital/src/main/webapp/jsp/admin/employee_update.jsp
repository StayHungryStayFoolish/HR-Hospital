<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.hospital_hr.entity.*" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>医院 - 修改在职员工信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="<%=path %>/css/plugins/dataTables/dataTables.bootstrap.css"
          rel="stylesheet">
    <link href="<%=path %>/css/animate.css" rel="stylesheet">
    <link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>修改在职员工信息</h5>
                </div>
                <div class="ibox-content">
                    <% Employee employee = (Employee)request.getAttribute("employee"); %>
                    <form method="post" class="form-horizontal" id="commentForm" action="<%=path %>/employee/<%=employee.getId() %>/update.do">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">工号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="employeeNumber" value="<%=employee.getEmployeeNumber() %>" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">姓名</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="name" value="<%=employee.getName() %>" minlength="2" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">密码</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" name="password" value="<%=employee.getPassword() %>" minlength="4" required>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=path %>/js/plugins/jeditable/jquery.jeditable.js"></script>

<!-- Data Tables -->
<script src="<%=path %>/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="<%=path %>/js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- 自定义js -->
<script src="<%=path %>/js/content.js?v=1.0.0"></script>

<!-- 表单验证 -->
<script src="<%=path %>/js/plugins/validate/jquery.validate.min.js"></script>
<script src="<%=path %>/js/plugins/validate/messages_zh.min.js"></script>

<!-- layer javascript -->
<script src="js/plugins/layer/layer.min.js"></script>
<script>
    $().ready(function() {
        $("#commentForm").validate();
    });
    $.validator.setDefaults({
        submitHandler: function() {
            parent.layer.msg('修改成功！',{icon: 1});
            form.submit();
        }
    });
</script>

</body>
</html>
