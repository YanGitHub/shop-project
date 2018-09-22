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
        <li><a href="#">销售单</a></li>
    </ol>

    <div class="row" style="margin-top: 10px">
        <div class="col-lg-12">
            <table id="grid"></table>
        </div>
    </div>
    <div class="row" style="margin-top: 10px">
        <div class="col-lg-12">
            <table id="gridMx"></table>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $('#grid').datagrid({
            rownumbers: true,
            striped: true,
            url: '/bill/getList',
            height: 250,
            singleSelect: true,
            onClickRow: showMx,
            pagination: true,
            pageSize: 10,
            columns: [
                [
                    {field: 'id', title: '', hidden: true},
                    {field: 'billNo', title: '开台单号', width: 80},
                    {field: 'vipCode', title: '会员编码', align: 'center', width: 100},
                    {field: 'personNum', title: '人数', align: 'center', width: 80},
                    {field: 'time', title: '时间', align: 'center', width: 150},
                    {field: 'vipName', title: '会员', align: 'center', width: 80},
                    {field: 'note', title: '备注', align: 'center', width: 80}
                ]
            ]
        });

        $('#gridMx').datagrid({
            rownumbers: true,
            striped: true,
            height: 250,
            singleSelect: true,
            pagination: true,
            url: '/billMenu/getList',
            queryParams: {billNo: -99},
            pageSize: 10,
            columns: [
                [
                    {field: 'id', title: '', hidden: true},
                    {field: 'menuCode', title: '菜单编号', width: 80},
                    {field: 'menuTypeCode', title: '类别', align: 'center', width: 100},
                    {field: 'time', title: '时间', align: 'center', width: 150},
                    {field: 'num', title: '数量', align: 'center', width: 150},
                    {field: 'isSettled', title: '是否结账', align: 'center', width: 80,formatter: caozuo},
                    {field: 'note', title: '备注', align: 'center', width: 150}
                ]
            ]
        });
    });

    function caozuo(v, r, i) {
        var str="已结";
        if(v==0){
            str="未结"
        }
        return str;
    }

    function showMx(rowIndex, rowData) {
        $('#gridMx').datagrid('reload', {
            billNo: rowData.billNo
        });
    }

</script>
</body>
</html>