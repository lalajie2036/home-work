<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>在借图书</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="./layui/css/layui.css"
		  media="all">
	<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
	<style>
		.wrap-div {
			display: -webkit-box;
			-webkit-box-orient: vertical;
			-webkit-line-clamp: 3;
			overflow: hidden;
			float: left;
			width: 100%;
			word-break: break-all;
			text-overflow: ellipsis;
		}
	</style>
</head>
<body>

<div class="layui-nav-item demoTable"
	 style="display: flex;justify-content: flex-end;">
	<input type="text" class="layui-input"
		   style="padding: 0;display: inline;width: 300px;"
		   placeholder="请输入搜索信息..."/>
	<button class="layui-btn" data-type="getCheckLength"
			style="margin-left: 20px;">搜索
	</button>
</div>

<div class="layui-form" id="content">
	<table class="layui-table" style="table-layout:fixed">
		<colgroup>
			<col width="150">
			<col width="150">
			<col width="150">
			<col>
			<col width="180">
		</colgroup>
		<thead>
		<tr>
			<th>书名</th>
			<th>作者</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="borrowBooks" items="${sessionScope.books}" varStatus="status">

			<tr>

				<td>${borrowBooks.name}</td>
				<td>${borrowBooks.author}</td>
				<td class="wrap-td">
					<div class="wrap-div">${borrowBooks.description}</div>
				</td>
				<td>
					<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
					<a class="layui-btn layui-btn-xs" lay-event="edit">归还</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<div id="page" style="display: flex;justify-content: center;"  ></div>
