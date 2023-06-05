<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 헤더 시작 -->
<%@include file="../layout/header.jsp"%>
<!-- 헤더 끝 -->

<div class="container">
    <form action="/action_page.php">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" class="form-control" placeholder="Enter username" id="username">
        </div>
        <div class="form-group">
            <label for="email">Email address:</label>
            <input type="email" class="form-control" placeholder="Enter email" id="email">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>
<%--        <div class="form-group form-check">--%>
<%--            <label class="form-check-label">--%>
<%--                <input class="form-check-input" type="checkbox"> Remember me--%>
<%--            </label>--%>
<%--        </div>--%>
        <button type="submit" class="btn btn-primary">회원가입</button>
    </form>
</div>

<!-- 푸터 시작 -->
<%@ include file="../layout/footer.jsp"%>
<!-- 푸터 끝 -->