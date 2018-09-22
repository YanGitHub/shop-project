<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<head>
    <title>会员信息</title>
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
        <li><a href="#">菜单管理</a></li>
        <li><a href="#">菜单信息</a></li>
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

<div id="createModal" class="modal fade bs-example-modal-lg" tabindex="1" role="dialog">
    <div class="modal-dialog modal-lg" style="width: 500px;height: 200px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h5 class="modal-title">菜单信息</h5>
            </div>
            <div class="modal-body">
                <table>
                    <input id="id" hidden="hidden">
                    <tr>
                        <th class="tb-lab">菜单编号</th>
                        <td>
                            <input class="easyui-textbox" id="code" name="code" style="width:168px;height:24px">
                        </td>
                        <th class="tb-lab">菜单名称</th>
                        <td>
                            <input class="easyui-textbox" id="name" name="name" style="width:168px;height:24px">
                        </td>
                    </tr>
                    <tr>
                        <th class="tb-lab">价格</th>
                        <td>
                            <input class="easyui-textbox" id="realPrice" name="realPrice" style="width:168px;height:24px">
                        </td>
                        <th class="tb-lab">单位</th>
                        <td>
                            <input class="easyui-textbox" id="unit" name="unit" style="width:168px;height:24px">
                        </td>
                    </tr>
                    <tr>
                        <th class="tb-lab">原价</th>
                        <td>
                            <input class="easyui-textbox" id="untPrice" name="untPrice" style="width:168px;height:24px">
                        </td>
                        <th class="tb-lab">菜单类型</th>
                        <td>
                            <input id="typeId" class="easyui-combobox" name="typeId"
                                   style="width: 168px;height: 24px"
                                   data-options="valueField:'id',textField:'name',url:'/menuType/combobox',value:null"/>
                        </td>
                    </tr>
                    <tr>
                        <th class="tb-lab">积分基数</th>
                        <td>
                            <input class="easyui-textbox" id="pointBase" name="pointBase" style="width:168px;height:24px">
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
        url: '/menuInfo/getList',
        height: 450,
        singleSelect: true,
        pagination: true,
        pageSize: 10,
        columns: [
            [
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

    function create() {
        $("#id").val("");
        $("#code").textbox('setValue',"");
        $("#name").textbox('setValue',"");
        $("#realPrice").textbox('setValue',"");
        $("#unit").textbox('setValue',"");
        $("#untPrice").textbox('setValue',"");
        $("#pointBase").textbox('setValue',"");
        $("#typeId").combobox('setValue',"");
        $("#btnName").html("新增");
        $("#createModal").modal({backdrop: false});
    }
    function createNew() {
        var code=$("#code").textbox('getValue');
        var name=$("#name").textbox('getValue');
        var realPrice=$("#realPrice").textbox('getValue');
        var unit=$("#unit").textbox('getValue');
        var untPrice=$("#untPrice").textbox('getValue');
        var pointBase=$("#pointBase").textbox('getValue');
        var typeId=$("#typeId").combobox('getValue');
        if(code=="" || code ==null){
            alertLittle("请输入菜单编号");
            return;
        }
        if(name=="" || name ==null){
            alertLittle("请输入菜单名称");
            return;
        }
        if(typeId=="" || typeId ==null){
            alertLittle("请选择会员类型");
            return;
        }
        var id=$("#id").val();
        var  url="/menuInfo/create";
        if(id!="" && id!=null){
            url="/menuInfo/update";
        }
        $.post(url,{code:code,name:name,realPrice:realPrice,unit:unit,untPrice:untPrice,pointBase:pointBase,typeId:typeId,id:id},function (data) {
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
        $("#code").textbox('setValue',item.code);
        $("#name").textbox('setValue',item.name);
        $("#realPrice").textbox('setValue',item.realPrice);
        $("#unit").textbox('setValue',item.unit);
        $("#untPrice").textbox('setValue',item.untPrice);
        $("#pointBase").textbox('setValue',item.pointBase);
        $("#typeId").combobox('setValue',item.typeId);
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
        $.post('/menuInfo/delete',{id:item.id},function (data) {
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
