<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="nav navbar-nav">
    <li><a href="/orderFood">点餐</a></li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">会员管理 <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="/vipType">会员类别</a></li>
            <li><a href="#">会员信息</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">桌台管理 <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#">桌台类别</a></li>
            <li><a href="#">桌台信息</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">菜单管理 <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#">菜单类别</a></li>
            <li><a href="#">菜单信息</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">销售管理 <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#">销售单</a></li>
            <li><a href="#">销售统计</a></li>
        </ul>
    </li>
</ul>

<ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">关于 <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#" onclick="loginOut()">退出</a></li>
            <li><a href="#" onclick="showVersion()">版本</a></li>
        </ul>
    </li>
</ul>

<script>
    function loginOut() {
        window.location.href = "/login";
    }
    function showVersion() {
        alertLittle("饭店管理系统,目前版本为：1.0");
    }
</script>