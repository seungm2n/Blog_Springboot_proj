<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 헤더 시작 -->
<%@include file="../layout/header.jsp"%>
<!-- 헤더 끝 -->

<div class="container">
    <form>
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" class="form-control" placeholder="Enter username" id="username">
        </div>
<%--        <div class="form-group">--%>
<%--            <label for="email">Email address:</label>--%>
<%--            <input type="email" class="form-control" placeholder="Enter email" id="email">--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>
                <div class="form-group form-check">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox"> Remember me
                    </label>
                </div>
    </form>
    <button id="btn-login" class="btn btn-primary">로그인</button>
</div>

<script src="/blog/js/user.js"></script>
<!-- 푸터 시작 -->
<%@ include file="../layout/footer.jsp"%>
<!-- 푸터 끝 -->