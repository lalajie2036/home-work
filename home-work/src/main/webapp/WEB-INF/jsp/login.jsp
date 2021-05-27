<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书管理信息系统登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modules/layer/default/layer.css">
    <script src="${pageContext.request.contextPath}/js/layui.js"></script>
</head>
<body>

<div class="login-main">
    <header class="layui-elip">图书借阅管理信息系统</header>
    <form class="layui-form" action="${pageContext.request.contextPath}/library/list.action" method="post" id="form">
        <div class="layui-input-inline">
            <input type="text" name="name" required lay-verify="required" placeholder="学号" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <select name="access" id="access" lay-verify="required">
                <option value="">请选择权限</option>
                <option value="0" >管理员</option>
                <option value="1" >用户</option>
            </select>
        </div>

        <div class="layui-input-inline login-btn">
            <button lay-submit lay-filter="login" class="layui-btn">登录</button>
        </div>
        <hr/>
        <p><a href="${pageContext.request.contextPath}/toRegister" class="fl">立即注册</a><a href="javascript:;" onclick="forgetpsw();" class="fr">忘记密码？</a></p>
    </form>
</div>



<script type="text/javascript">
    <%--console.log(${pageContext.request.contextPath});--%>

    layui.use(['form','layer','jquery'], function () {

        // 操作对象
        var form = layui.form;
        var $ = layui.jquery;


        //登录跳转判断
        form.on('submit(login)',function (data) {
            $.ajax({
                url:'${pageContext.request.contextPath}/doLogin',
                data:$('#form').serialize(),
                type:'post',
                success:function (data) {
                    if (data.status == '0'){
                        location.href = "${pageContext.request.contextPath}/library/index";
                    }else if (data.status == '1') {
                        location.href = "${pageContext.request.contextPath}/library/frontIndex";
                    }else if (data.status == '2'){
                            layer.msg(data.message);
                    }else{
                        //服务器异常
                        layer.msg(data.message);
                    }
                }
            })
            return false;
        })
    });
    function forgetpsw(){
        layer.msg('联系管理员到图书馆进行重置');
    }

    (function e() {
        debugger;
    })();
</script>
</body>
</html>
