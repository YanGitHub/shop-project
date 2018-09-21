<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <%@include file="common/head.jsp"%>
    <style>
        body {
            padding-top: 50px;
        }

        .carousel {
            height: 400px;
            background-color: #000;
            margin-bottom: 60px;
        }

        .carousel .item {
            height: 400px;
            background-color: #000;
        }

        .carousel img {
            width: 100%;
        }
    </style>
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
            <a class="navbar-brand" href="#">欢迎使用饭店管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>


<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="/static/img/bg1.jpg" alt="...">
            <div class="carousel-caption">
                ...
            </div>
        </div>
        <div class="item">
            <img src="/static/img/bg2.jpg" alt="...">
            <div class="carousel-caption">
                ...
            </div>
        </div>
        <div class="item">
            <img src="/static/img/bg3.jpg" alt="...">
            <div class="carousel-caption">
                ...
            </div>
        </div>
    </div>
</div>

<div class="row" style="margin-left: 0;margin-right: 0">
    <div class="col-sm-3"></div>
    <div class="col-sm-3">
        <div class="input-group">
            <span class="input-group-addon" style="width: 90px">用户名</span>
            <input type="text" id="name" class="form-control" placeholder="Username" value="" onkeypress="login()"
                   aria-describedby="basic-addon1">
        </div>
    </div>
    <div class="col-sm-3">
        <div class="input-group">
            <span class="input-group-addon" style="width: 90px">密码</span>
            <input type="password" id="password" class="form-control" onkeypress="login()" value="" placeholder="password"
                   aria-describedby="basic-addon1">
        </div>
    </div>
    <div class="col-sm-3">
        <div class="btn-group">
            <button class="btn btn-info" onclick="loginBtn()">登录</button>
        </div>
    </div>
</div>


<script type="text/javascript">
    function login() {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e.keyCode == 13) {
            loginBtn();
        }
    }

    function loginBtn(){
        var name = $('#name').val().trim();
        var password = $('#password').val().trim();
        $.post('/verifyLogin', {userName: name, password: password}, function (data) {
            if (data.status) {
                window.location.href = "/index";
            } else {
                alertLittle(data.msg);
            }
        });
    }

</script>
</body>
</html>