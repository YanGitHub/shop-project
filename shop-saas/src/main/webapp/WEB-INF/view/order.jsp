<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>饭店管理系统</title>
    <%@include file="common/head.jsp" %>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">饭店管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <%@include file="common/nav.jsp" %>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<div class="container" style="margin-top: 60px;">
    <ol class="breadcrumb" style="margin-bottom: 10px">
        <li><a href="#">销售管理</a></li>
        <li><a href="#">销售统计</a></li>
    </ol>

    <div class="row" style="margin-top: 10px">
        <div class="col-lg-12">
            <table id="grid"></table>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $('#grid').datagrid({
            rownumbers: true,
            striped: true,
            url: '/order/getList',
            height: 500,
            singleSelect: true,
            pagination: true,
            pageSize: 10,
            columns: [
                [
                    {field: 'id', title: '', hidden: true},
                    {field: 'time', title: '时间', width: 150},
                    {field: 'receivable', title: '应收', align: 'center', width: 100},
                    {field: 'actualReceipt', title: '实收', align: 'center', width: 80}
                ]
            ]
        });
    });



</script>
</body>
</html>