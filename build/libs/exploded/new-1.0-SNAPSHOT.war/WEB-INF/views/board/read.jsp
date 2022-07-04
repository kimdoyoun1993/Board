<%--
  Created by IntelliJ IDEA.
  User: tnsdu
  Date: 2022-07-04
  Time: 오후 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Read Page</h1>
${listDTO}

${dto}
<div>
    <button class="listBtn">리스트</button>
    <button class="modBtn">수정/삭제</button>
</div>
<script>

    const bno =${dto.bno}

    document.querySelector(".listBtn").addEventListener("click",(e)=>{
        self.location = `/board/list/${listDTO.link}`
    },false)
    document.querySelector(".modBtn").addEventListener("click",(e)=>{
        self.location = `/board/modify/${bno}/${listDTO.link}`
    },false)

</script>
</body>
</html>
