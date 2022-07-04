<%--
  Created by IntelliJ IDEA.
  User: tnsdu
  Date: 2022-06-29
  Time: 오후 5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Register page</h1>
<form action="/board/register" method="post">
    <input type="text" name="title">
    <script> // 뒤로가기 막기
    history.pushState(null,null,location.href);
    {
        history.go(1)
    }
    </script>

    <button>CLICK</button>
</body>
</html>
