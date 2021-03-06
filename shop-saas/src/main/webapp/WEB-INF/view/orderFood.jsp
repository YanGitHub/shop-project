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
                                状态：<code>${item.deskStatus.status}</code><br/>
                                类型：<code>${item.deskType.type}</code> <br/>
                                可容纳人数：<code>${item.deskType.num}</code><br/>
                                人数：<code>${item.deskStatus.personNum}</code><br/>
                                会员名称：${item.deskStatus.vipName}<br/>
                                时间：${item.deskStatus.time}<br/>
                                电话：${item.deskStatus.tel}<br/>
                                备注：${item.deskStatus.note}<br/>
                            </p>
                            <p>
                                <a href="#" onclick="selectedMenu('${item.deskStatus.status}',${item.id})" class="btn btn-primary" role="button">点餐</a>
                                <a href="#" onclick="settled('${item.deskStatus.status}',${item.id})" class="btn btn-default" role="button">结算</a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>


<div id="menuModal" class="modal fade bs-example-modal-lg" tabindex="1" role="dialog">
    <div class="modal-dialog modal-lg" style="width: 600px;height: 200px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h5 class="modal-title">菜单信息</h5>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-2">会员</div>
                    <div class="col-lg-4">
                        <input id="vip" class="easyui-combobox" name="vip"
                               data-options="valueField:'id',textField:'name',url:'/vipInfo/getAll',value:null"/>
                    </div>
                    <div class="col-lg-2">备注</div>
                    <div class="col-lg-4">
                        <input id="note" class="easyui-textbox" name="note"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-2">人数</div>
                    <div class="col-lg-4">
                        <input id="num" class="easyui-textbox" name="num"/>
                    </div>
                </div>
                <table id="menuGrid"></table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="configBtn()">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<div id="settledModal" class="modal fade bs-example-modal-lg" tabindex="1" role="dialog">
    <div class="modal-dialog modal-lg" style="width: 600px;height: 200px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h5 class="modal-title">结算</h5>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-2">应收</div>
                    <div class="col-lg-4">
                        <input id="amt" class="easyui-textbox" readonly="readonly" name="amt"/>
                    </div>
                    <div class="col-lg-2">实收</div>
                    <div class="col-lg-4">
                        <input id="amount" class="easyui-textbox" name="amount"/>
                    </div>
                </div>
                <table id="gridMx"></table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="doSettled()">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<script>
    var deskInfoId = 0;
    function loadMenuGrid() {
        $('#menuGrid').datagrid({
            rownumbers: true,
            striped: true,
            url: '/menuInfo/getList',
            height: 400,
            singleSelect: false,
            pagination: true,
            pageSize: 10,
            columns: [
                [
                    {field: 'ck', checkbox:true},
                    {field: 'id', title: '', hidden: true},
                    {field: 'code', title: '菜单编号', width: 80},
                    {field: 'name', title: '菜单名称', align: 'center', width: 100},
                    {field: 'realPrice', title: '价格', align: 'center', width: 80},
                    {field: 'unit', title: '单位', align: 'center', width: 80},
                    {field: 'untPrice', title: '原价', align: 'center', width: 80},
                    {field: 'pointBase', title: '积分基数', align: 'center', width: 80},
                    {field: 'typeName', title: '类别', align: 'center', width: 80}
                ]
            ]
        });
    }

    function doSettled() {
        var amount =$("#amount").textbox('getValue');
        var amt =$("#amt").textbox('getValue');
        if (amount ==  null || amount == ''){
            alertLittle("请输入结算金额");
            return;
        }
        var item = $("#gridMx").datagrid('getRows');
        var billNo = item[0].billNo;
        $.post('/orderFood/settled',{deskInfoId:deskInfoId,amount:amount,amt:amt,billNo:billNo},function (data) {
            if (data.status){
                alertLittle("结算成功");
                window.location.href = "/orderFood";
            }else {
                alertLittle("结算失败");
            }
        })
    }

    function settled(status,deskId) {
        deskInfoId = deskId;
        if (status == "无人用餐"){
            alertLittle("无人用餐，无法完成结算");
            return;
        }else {
            $("#settledModal").modal({backdrop:false});
            loadMenuList();
        }
    }

    function selectedMenu(status,deskId) {
        if (status == "正在用餐"){
            alertLittle("正在用餐，请换其它桌");
            return;
        }else {
            $("#menuModal").modal({backdrop:false});
            loadMenuGrid();
            deskInfoId = deskId;
        }
    }

    function configBtn() {
        var item = $("#menuGrid").datagrid('getChecked');
        if (item.length == 0){
            alertLittle("请选择菜品");
            return;
        }
        var vipId = $("#vip").combobox('getValue');
        var note = $("#note").textbox('getValue');
        var num = $("#num").textbox('getValue');

        if (num == null || num == ""){
            alertLittle("请输入人数");
            return;
        }
        $.post('/orderFood/submit',{deskInfoId:deskInfoId,vipId:vipId,note:note,item:JSON.stringify(item),
                                    num:num},function (data) {
           if (data.status){
               alertLittle("成功");
               window.location.href = "/orderFood";
           }else {
               alertLittle("失败");
           }
        });
    }

    function loadMenuList() {
        $('#gridMx').datagrid({
            rownumbers: true,
            striped: true,
            height: 250,
            singleSelect: true,
            pagination: false,
            url: '/billMenu/getListByDeskId?deskInfoId=' + deskInfoId,
            onLoadSuccess: function (row, data) {
                caclulateAmt();
            },
            columns: [
                [
                    {field: 'id', title: '', hidden: true},
                    {field: 'menuCode', title: '菜单编号', width: 80},
                    {field: 'menuTypeCode', title: '类别', align: 'center', width: 100},
                    {field: 'time', title: '时间', align: 'center', width: 150},
                    {field: 'num', title: '数量', align: 'center', width: 150},
                    {field: 'price', title: '价格', align: 'center', width: 150},
                    {field: 'isSettled', title: '是否结账', align: 'center', width: 80},
                    {field: 'note', title: '备注', align: 'center', width: 150}
                ]
            ]
        });
    }
    function caclulateAmt() {
        var item = $("#gridMx").datagrid('getRows');
        var sum = 0.0;
        for (var i = 0;i < item.length;i++){
            sum += parseFloat(item[i].price);
        }
        $("#amt").textbox('setValue',sum);
    }
</script>
</body>
</html>