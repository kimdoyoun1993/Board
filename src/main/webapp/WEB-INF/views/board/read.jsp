<%--
  Created by IntelliJ IDEA.
  User: tnsdu
  Date: 2022-07-04
  Time: 오후 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<textarea><c:out value="${dto.content}"/></textarea>

<div>
    <button class="listBtn">리스트</button>
    <button class="modBtn">수정/삭제</button>
</div>

<div>
    <div>
        <input type="text" name="replyText" value="샘플 댓글">
    </div>
    <div>
        <input type="text" name="replyer" value="testUser">
    </div>
    <div>
        <button class="addReplyBtn">댓글 추가</button>
    </div>
</div>

<div>
    <ul class="replyUL">

    </ul>
</div>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src ="/resources/js/reply.js"></script>
<script>

    const bno = ${dto.bno}
    const replyUL = document.querySelector(".replyUL")
    const replyCount = ${dto.replyCount}

    function getServerList() {
        replyService.getList({bno}, (replyArr) => {
            const liArr = replyArr.map(reply => `<li> \${reply.rno} \${reply.replyText}</li>`)

            replyUL.innerHTML = liArr.join(" ")
        })
    }

    function addServerReply() {

        replyService.addReply(
            {bno: bno,
                replyText: document.querySelector("input[name = 'replyText']").value,
                replyer: document.querySelector("input[name = 'replyer']").value},
            () => {
                getServerList()
            }
        )
    }
    qsAddEvent(".addReplyBtn","click" , addServerReply)

</script>
</body>
</html>
