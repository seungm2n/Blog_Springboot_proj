<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="/blog">SYM</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/user/login">로그인</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/join">회원가입</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="https://seungm2n.github.io/">GitBlog</a>
            </li>
        </ul>
    </div>
</nav>
<br>

<div class="container">
    <div class="card m-2">
        <div class="card-body">
            <h4 class="card-title">제목 적는 부분</h4>
            <p class="card-text">내용 적는 부분</p>
            <a href="#" class="btn btn-primary">상세보기</a>
        </div>
    </div>

    <div class="card m-2">
        <div class="card-body">
            <h4 class="card-title">제목 적는 부분</h4>
            <p class="card-text">내용 적는 부분</p>
            <a href="#" class="btn btn-primary">상세보기</a>
        </div>
    </div>

    <div class="card m-2">
        <div class="card-body">
            <h4 class="card-title">제목 적는 부분</h4>
            <p class="card-text">내용 적는 부분</p>
            <a href="#" class="btn btn-primary">상세보기</a>
        </div>
    </div>
</div>

<!-- 푸터 시작 -->
<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Create by Seungm2n2</p>
    <p>📞 010-1212-2323</p>
    <p>🏴 서울특별시 금천구 XX동</p>
</div>
</body>
</html>


