<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>留言板</title>
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="layui-form" id="content">
    <table class="layui-table" style="table-layout:fixed">
        <colgroup>
            <col width="150">
            <col width="250">
            <col width="200">
            <col>
            <col width="200">
        </colgroup>
        <thead>
        <tr>
            <th>用户名</th>
            <th>留言内容</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="message" items="${sessionScope.messages}" varStatus="status">

            <tr>

                <td>${message.cardId}</td>
                <td>${message.detail}</td>
                <td class="wrap-td">
                    <div class="wrap-div">${message.publicDate}</div>
                </td>
                <td>
                    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="update">修改</a>
                    <a class="layui-btn layui-btn-xs" lay-event="del">删除</a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div id="page" style="display: flex;justify-content: center;"  ></div>

<script src="/layui/layui.js" charset="UTF-8"></script>
<script src = "K/layui/lay/modules/jquery.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
    layui.use(['laypage', 'layer'], function () {

            var laypage = layui.laypage
                , layer = layui.layer;
            var $ = layui.$;

            var count = 0, page = 1, limit = 5;

            $(document).ready(function () {
                //进入页面先加载数据
                getContent(1, limit);
                //得到数量count后，渲染表格

                laypage.render({
                    elem: 'page',
                    count: count,
                    curr: page,
                    limits: [5, 10, 15, 20],
                    limit: limit,
                    theme: '#1E9FFF',
                    layout: ['count', 'prev', 'page', 'next', 'limit'],
                    jump: function (obj, first) {
                        if (!first) {
                            getContent(obj.curr, obj.limit);
                            //更新当前页码和当前每页显示条数
                            page = obj.curr;
                            limit = obj.limit;
                        }
                    }
                });
            });

            function getContent(page, size) {
                $.ajax({
                    type: 'POST',
                    url: "/search/message",
                    async: false, //开启同步请求，为了保证先得到count再渲染表格
                    data: JSON.stringify({
                        pageNum: page,
                        pageSize: size
                    }),
                    contentType: "application/json;charset=UTF-8",
                    success: function (data) {
                        $('#content').load(location.href + " #content");
                        //count从Servlet中得到
                        count = data;
                    }
                });
            }
        }
    );
</script>

</body>
</html>