
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Modify Page</h1>

${listDTO}

${dto}
<form class="modForm" action="/board/modify/${dto.bno}" method="post">
    <input type="hidden" name="page" value="${listDTO.page}">
    <input type="hidden" name="size" value="${listDTO.size}">
    <input type="hidden" name="type" value="${listDTO.type}">
    <input type="hidden" name="keyword" value="${listDTO.keyword}">

    <div>
        <div>
            <input type="text" name="bno" value="<c:out value="${dto.bno}"/>"readonly>
        </div>
        <div>
            <input type="text" name="title" value="<c:out value="${dto.title}"/> ">
        </div>
        <div>
            <textarea type="text" name="content"><c:out value="${dto.content}"/></textarea>
        </div>
    </div>

</form>


<div>
    <button class="listBtn">리스트</button>
    <button class="modPostBtn">수정</button>
    <button class="delPostBtn">삭제</button>
</div>

<form class="actionForm" action="/board/remove/${bno}" method="post">
</form>

<script>

    const bno = ${dto.bno}
        const actionForm = document.querySelector(".actionForm")


    document.querySelector(".listBtn").addEventListener("click",(e)=>{
        self.location = `/board/list${listDTO.link}`
    },false)

    document.querySelector(".delPostBtn").addEventListener("click",(e)=>{
        actionForm.setAttribute("action", `/board/remove/${bno}`)
        actionForm.submit()
    },false)

    document.querySelector(".modPostBtn").addEventListener("click",(e)=>{

        document.querySelector(".modForm").submit();
    },false)


</script>
</body>
</html>
