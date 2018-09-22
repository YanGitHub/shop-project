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
        <li><a href="#">桌台管理</a></li>
        <li><a href="#">桌台类别</a></li>
    </ol>

    <div class="row">
        <div class="col-lg-12">
            <div class="btn-group">
                <button class="btn btn-info" onclick="create()">新增</button>
                <button class="btn btn-info" onclick="update()">修改</button>
                <button class="btn btn-info" onclick="deleteDate()">删除</button>
            </div>
        </div>
    </div>

    <div class="row" style="margin-top: 10px">
        <div class="col-lg-12">
            <table id="grid"></table>
        </div>
    </div>
</div>

<div id="createModal" class="modal fade bs-example-modal-sm" tabindex="1" role="dialog">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h5 class="modal-title">桌台类型</h5>
            </div>
            <div class="modal-body">
                <table>
                    <input id="id" hidden="hidden">
                    <tr>
                        <th class="tb-lab">桌台类别</th>
                        <td>
                            <input class="easyui-textbox" id="type" name="type" style="width:168px;height:24px">
                        </td>
                    </tr>
                    <tr>
                        <th class="tb-lab">容纳人数</th>
                        <td>
                            <input class="easyui-textbox" id="num" name="num" style="width:168px;height:24px">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="createNew()" id="btnName"></button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<div id="deleteModal" class="modal fade bs-example-modal-sm" tabindex="1" role="dialog">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h5 class="modal-title">提示</h5>
            </div>
            <div class="modal-body">
                <span> 是否删除 ?</span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="deleteDateSure()">删除</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<script type="text/javascript">
    $('#grid').datagrid({
        rownumbers: true,
        striped: true,
        url: '/deskType/getList',
        height: 450,
        singleSelect: true,
        pagination: true,
        pageSize: 10,
        columns: [
            [
                {field: 'id', title: '', hidden: true},
                {field: 'type', title: '桌台类别', width: 80},
                {field: 'num', title: '容纳人数', align: 'center', width: 100}
            ]
        ]
    });

    function create() {
        $("#id").val("");
        $("#type").textbox('setValue',"");
        $("#num").textbox('setValue',"");
        $("#btnName").html("新增");
        $("#createModal").modal({backdrop: false});
    }
    function createNew() {
        var type=$("#type").textbox('getValue');
        var num=$("#num").textbox('getValue');
        if(type=="" || type ==null){
            alertLittle("请输入桌台类型");
        }
        if(num=="" || num ==null){
            alertLittle("请输入容纳人数");
        }
        var id=$("#id").val();
        var  url="/deskType/create";
        if(id!="" && id!=null){
            url="/deskType/update";
        }
        $.post(url,{type:type,num:num,id:id},function (data) {
            if (data.status) {
                alertLittle(data.msg);
                $('#grid').datagrid('reload');
                $("#createModal").modal('hide');
            } else {
                alertLittle(data.msg);
            }
        });
    }
    function update() {
        var item = $('#grid').datagrid('getSelected');
        if (!item) {
            alertLittle("请选择数据");
            return;
        }
        $("#id").val(item.id);
        $("#type").textbox('setValue',item.type);
        $("#num").textbox('setValue',item.num);
        $("#btnName").html("修改");
        $("#createModal").modal({backdrop: false});
    }
    function deleteDate(){
        var item = $('#grid').datagrid('getSelected');
        if (!item) {
            alertLittle("请选择数据");
            return;
        }
        $("#deleteModal").modal({backdrop: false});
    }
    function deleteDateSure() {
        var item = $('#grid').datagrid('getSelected');
        $.post('/deskType/delete',{id:item.id},function (data) {
            if (data.status) {
                alertLittle(data.msg);
                $("#deleteModal").modal('hide');
                $('#grid').datagrid('reload');
            } else {
                alertLittle(data.msg);
            }
        });
    }
</script>
</body>
</html>