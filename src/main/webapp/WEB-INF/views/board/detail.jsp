<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 헤더 시작 -->
<%@ include file="../layout/header.jsp" %>
<!-- 헤더 끝 -->

<div class="container">
    <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
    <c:if test="${board.user.id == principal.user.id}">
        <button id="btn-update" class="btn btn-warning" href="#">수정</button>
        <button id="btn-delete" class="btn btn-danger" href="#">삭제</button>
    </c:if>
    <br/><br/>
    <div>
        글 번 호 : <span id="id"><i>${board.id}</i></span><br/>
        작 성 자 : <span><i>${board.user.username}</i></span><br/>
        작 성 일 : <span><i>${board.createDate}</i></span><br/>
        조 회 수 : <span><i>${board.count}</i></span>
    </div>
    <div>
        <h1>${board.title}</h1>
    </div>
    <hr/>
    <div>
        <div> ${board.content} </div>
    </div>
    <hr/>

</div>

<script src="/js/board.js"></script>
<!-- 푸터 시작 -->
<%@ include file="../layout/footer.jsp" %>
<!-- 푸터 끝 -->