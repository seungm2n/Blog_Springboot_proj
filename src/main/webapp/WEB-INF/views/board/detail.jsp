<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 헤더 시작 -->
<%@ include file="../layout/header.jsp" %>
<!-- 헤더 끝 -->

<div class="container">

    <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
    <c:if test="${board.user.id == principal.user.id}">
        <a class="btn btn-warning" href="/board/${board.id}/updateForm">수정</a>
        <button id="btn-delete" class="btn btn-danger" href="#">삭제</button>
    </c:if>
    <br/><br/>
    <div ustify-content-end>
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

    <div class="card">
        <form>
            <input type="hidden" id="boardId" value="${board.id}"/>
            <input type="hidden" id="userId" value="${principal.user.id}"/>
            <div class="card-body">
                <textarea id="reply-content" class="form-control" row="1"></textarea>
            </div>
            <div class="card-footer">
                <button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
            </div>
        </form>
    </div>
    <br/>
    <div class="card">
        <div class="card-header">
            <strong>Comment</strong>
        </div>
        <ul id="reply-box" class="list-group">
            <c:forEach var="reply" items="${board.replys}">
                <li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
                    <div>${reply.content}</div>
                    <div class="d-flex">
                        <div class="font-italic">작성자 : ${reply.user.username} &nbsp;</div>
                        <c:if test="${reply.user.id == principal.user.id}">
                            <button class="badge">수정</button>
                            &nbsp;
                            <button onclick="index.replyDelete(${board.id},${reply.id})" class="badge">삭제</button>
                        </c:if>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<script src="/js/board.js"></script>
<!-- 푸터 시작 -->
<%@ include file="../layout/footer.jsp" %>
<!-- 푸터 끝 -->