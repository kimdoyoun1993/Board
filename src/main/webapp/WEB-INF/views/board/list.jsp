<%--
  Created by IntelliJ IDEA.
  User: tnsdu
  Date: 2022-06-29
  Time: 오후 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${listDTO}</h1>
</hr>
<h3>${listDTO.link}</h3>

<div class="searchDiv">

    <select class="type">
        <option value="">----</option>
        <option value="t" ${listDTO.type =="t"?"selected":""}>제목</option>
        <option value="tc" ${listDTO.type =="tc"?"selected":""}>제목내용</option>
        <option value="tcw" ${listDTO.type =="tcw"?"selected":""}>제목내용작성자</option>
    </select>
    <input type="text" name="keyword"  value="${listDTO.keyword}">
    <button class="searchBtn">Search</button>
</div>

<ul class="dtoList">
    <c:forEach items="${dtoList}" var="board">
        <li>
            <span>${board.bno}</span>
            <span><a href ='/board/read/${board.bno}' class="dtoLink"><c:out value = "${board.title}"/></a></span>

        </li>

    </c:forEach>
</ul>

${pageMaker}
<style>
    .pagination{
        display: flex;
    }
    .pagination .page-item {
        margin: 0.3em;
        list-style: none;
    }
</style>

<ul class="pagination">
    <li class="page-item">
        <a class="page-link" href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
        </a>
    </li>

    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
        <li class="page-item"><a class="page-link" href="${num}">${num}</a> </li>
    </c:forEach>

    <li class="page-item">
        <a class="page-link" href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
        </a>
    </li>
</ul>

<form class="actionForm" action="/board/list" method="get">

    <input type="hidden" name="page" value="${listDTO.page}">
    <input type="hidden" name="size" value="${listDTO.size}">
    <input type="hidden" name="type" value="${listDTO.type == null? '':listDTO.type}">
    <input type="hidden" name="keyword" value="${listDTO.keyword == null? '':listDTO.keyword}">

</form>

<script>

    const linkDiv = document.querySelector(".pagination")
    const actionForm = document.querySelector(".actionForm")

    document.querySelector(".dtoList").addEventListener("click",(e)=>{

        e.preventDefault()
        e.stopPropagation()

        const target = e.target
        if(target.getAttribute("class").indexOf("dtoLink")<0){
            return
        }
        const url = target.getAttribute("href")
        actionForm.setAttribute("action",url)
        actionForm.submit()
    },false)

   linkDiv.addEventListener("click",(e) => {
       e.stopPropagation()
       e.preventDefault()

       const target = e.target

       if(target.getAttribute("class") !== 'page-link'){
           return
       }
       const pageNum = target.getAttribute("href")
       actionForm.querySelector("input[name='page']").value = pageNum
       actionForm.submit()
   },false)

    document.querySelector(".searchBtn").addEventListener("click",(e) => {
        const type =document.querySelector('.searchDiv .type').value
        const keyword =document.querySelector(".searchDiv input[name='keyword']").value

        console.log(type , keyword)

        actionForm.querySelector("input[name ='page']").value = 1
        actionForm.querySelector("input[name ='type']").value = type
        actionForm.querySelector("input[name ='keyword']").value = keyword
        actionForm.submit()

    },false)

    const result = '${result}'
    console.log(result)

    if(result !== ''){
        alert("처리되었습니다.")
    }
</script>
</body>
</html>
