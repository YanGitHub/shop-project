<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="nav navbar-nav">

    <c:if test="${isManager == 1}">
        <li><a href="/orderFood">点餐</a></li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">会员管理 <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="/vipType">会员类别</a></li>
                <li><a href="/vipInfo">会员信息</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">桌台管理 <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="/deskType">桌台类别</a></li>
                <li><a href="/deskInfo">桌台信息</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">菜单管理 <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="/menuType">菜单类别</a></li>
                <li><a href="/menuInfo">菜单信息</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">销售管理 <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="/bill">销售单</a></li>
                <li><a href="/order">销售统计</a></li>
            </ul>
        </li>
    </c:if>
    <c:if test="${isManager == 2}">
        <li><a href="/orderFood">点餐</a></li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">会员管理 <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="/vipType">会员类别</a></li>
                <li><a href="/vipInfo">会员信息</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">菜单管理 <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="/menuType">菜单类别</a></li>
                <li><a href="/menuInfo">菜单信息</a></li>
            </ul>
        </li>
    </c:if>
</ul>

<ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">公司信息 <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#" onclick="update()">修改</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">关于 <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#" onclick="loginOut()">退出</a></li>
            <li><a href="#" onclick="showVersion()">版本</a></li>
        </ul>
    </li>
</ul>

<div id="updateModal" class="modal fade bs-example-modal-sm" tabindex="1" role="dialog">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h5 class="modal-title">公司信息</h5>
            </div>
            <div class="modal-body">
                <table>
                    <input id="id" hidden="hidden">
                    <tr>
                        <th class="tb-lab">公司名称</th>
                        <td>
                            <input class="easyui-textbox" id="name" name="name" style="width:168px;height:24px">
                        </td>
                    </tr>
                    <tr>
                        <th class="tb-lab">地址</th>
                        <td>
                            <input class="easyui-textbox" id="address" name="address" style="width:168px;height:24px">
                        </td>
                    </tr>
                    <tr>
                        <th class="tb-lab">电话</th>
                        <td>
                            <input class="easyui-textbox" id="mobile" name="mobile" style="width:168px;height:24px">
                        </td>
                    </tr>
                    <tr>
                        <th class="tb-lab">税号</th>
                        <td>
                            <input class="easyui-textbox" id="dutyParagraph" name="dutyParagraph" style="width:168px;height:24px">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="updateSure()">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<script>
    function loginOut() {
        window.location.href = "/login";
    }
    function showVersion() {
        alertLittle("饭店管理系统,目前版本为：1.0");
    }
    function update() {
        $.post("/company/get", null, function (data) {
            $("#id").val(data.id);
            $("#name").textbox('setValue', data.name);
            $("#address").textbox('setValue', data.address);
            $("#mobile").textbox('setValue', data.mobile);
            $("#dutyParagraph").textbox('setValue', data.dutyParagraph);
        });
        $("#updateModal").modal({backdrop: false});
    }
    function updateSure() {
        var id = $("#id").val();
        var name = $("#name").textbox('getValue');
        var address = $("#address").textbox('getValue');
        var mobile = $("#mobile").textbox('getValue');
        var dutyParagraph = $("#dutyParagraph").textbox('getValue');
        $.post("/company/update", {id:id,name:name,address:address,mobile:mobile,dutyParagraph:dutyParagraph}, function (data) {
            if (data.status) {
                alertLittle(data.msg);
                $("#updateModal").modal('hide');
            } else {
                alertLittle(data.msg);
            }
        });
    }
</script>