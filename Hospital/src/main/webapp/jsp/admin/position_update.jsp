<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.hospital_hr.entity.*" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>医院 - 修改职称信息</title>
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
                    <h5>修改职称信息</h5>
                </div>
                <div class="ibox-content">
                    <% Position position = (Position)request.getAttribute("position"); %>
                    <form method="post" class="form-horizontal" id="commentForm" action="<%=path %>/position/<%=position.getId() %>/update.do">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">职称号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="positionNumber" value="<%=position.getPositionNumber() %>" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">名称</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="" name="name" value="<%=position.getName() %>" required>
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
