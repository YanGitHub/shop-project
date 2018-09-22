<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>饭店管理系统</title>
    <%@include file="common/head.jsp"%>
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
            <%@include file="common/nav.jsp"%>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<div class="container" style="margin-top: 60px;">
    <ol class="breadcrumb" style="margin-bottom: 10px">
        <li><a href="#">点餐</a></li>
    </ol>

    <div class="row">
        <div class="col-lg-12">
            <c:forEach var="item" items="${deskInfoList}">
                <div class="col-lg-3">
                    <div class="thumbnail">
                        <div class="caption">
                            <h3>${item.name} <code>${item.code}</code> </h3>
                            <p>
                                状态：<code>${item.deskStatus.status}</code>
                                类型：<code>${item.deskType.type}</code> <br/>
                                可容纳人数：<code>${item.deskType.num}</code>
                                人数：<code>${item.deskStatus.personNum}</code><br/>
                                会员名称：${item.deskStatus.vipName}
                                时间：${item.deskStatus.time}
                                电话：${item.deskStatus.tel}
                                备注：${item.deskStatus.note}
                            </p>
                            <p>
                                <a href="#" onclick="selectedMenu()" class="btn btn-primary" role="button">点餐</a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<script>
    function selectedMenu() {
        
    }
</script>
</body>
</html>