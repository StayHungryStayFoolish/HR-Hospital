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
    <title>医院 - 修改离休员工信息</title>
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
                    <h5>修改离休员工信息</h5>
                </div>
                <div class="ibox-content">
                    <% History history = (History) request.getAttribute("history"); %>
                    <form method="post" class="form-horizontal" id="commentForm"
                          action="<%=path %>/history/<%=history.getId() %>/updateRetire.do">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">工号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="employeeNumber"
                                       value="<%=history.getEmployeeNumber() %>" readonly="readonly">
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
<script>
    $().ready(function () {
        $("#commentForm").validate();
    });
    $.validator.setDefaults({
        submitHandler: function () {
            parent.layer.msg('修改成功！', {
                icon: 1
            });
            form.submit();
        }
    });
</script>

</body>
</html>
