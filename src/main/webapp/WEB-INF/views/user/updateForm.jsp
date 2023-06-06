<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 헤더 시작 -->
<%@include file="../layout/header.jsp"%>
<!-- 헤더 끝 -->

<div class="container">
    <form>
        <input type="hidden" id="id" value="${principal.user.id}" />
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter username" id="username" readonly>
        </div>
        <div class="form-group">
            <label for="password">Password: </label>
            <input type="password" value="${principal.user.password}" class="form-control" placeholder="Enter password" id="password">
        </div>
        <div class="form-group">
            <label for="email">Email address:</label>
            <input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email">
        </div>

    </form>
    <button id="btn-update" class="btn btn-primary">수정완료</button>
</div>

<script src="/js/user.js"></script>
<!-- 푸터 시작 -->
<%@ include file="../layout/footer.jsp"%>
<!-- 푸터 끝 -->