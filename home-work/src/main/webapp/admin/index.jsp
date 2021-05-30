<%@ page import="cn.edu.niit.javabean.Admin" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>系统管理员</title>
	<!-- layui -->
	<link rel="stylesheet" href="/layui/css/layui.css">
	<script src="/layui/layui.js"></script>
</head>
<body class="layui-layout-body">

<%
  Admin user = (Admin) request.getSession().getAttribute("admin");
%>

<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo" style="font-size: 25px">图书馆管理端</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          <%=user.getUsername()%>
        </a>
        <dl class="layui-nav-child">
          <dd id="updatePassword"><a href="javascript:;">修改密码</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="./logOut">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="./readerIndex.jsp" target="content">用户管理</a>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="./booklist.jsp"  target="content">图书管理</a>
        </li>
        <li class="layui-nav-item">
          <a href="./messageBoard.jsp" target="content">留言管理</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <iframe src="welcome.jsp" name="content" height="100%" width="100%" frameborder="0" scrolling="no"></iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    ©  图书管理系统
  </div>
</div>

<script>
//JavaScript代码区域
layui.use(['element', 'jquery', 'layer'], function(){
  $ = layui.jquery;
  var element = layui.element
  $ = layui.jquery;
  var form = layui.form
  ,layer = layui.layer;

  $("#updatePassword").click(function(){
	  layer.open({
	    title: '修改密码',
	    type: 2,
	    area: ['300px', '300px'],
	    maxmin: true,
  	  	shadeClose: true,
  	  	content: 'updatePassword.jsp'
	  })
  })
});
</script>
</body>
</html>