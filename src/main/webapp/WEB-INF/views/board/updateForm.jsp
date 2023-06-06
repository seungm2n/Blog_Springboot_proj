<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 헤더 시작 -->
<%@ include file="../layout/header.jsp"%>
<!-- 헤더 끝 -->

<div class="container">
    <input type="hidden" id="id" value="${board.id}" />
    <form>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Enter title" id="title" value="${board.title}">
        </div>

        <div class="form-group">
            <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
        </div>
    </form>
    <button id="btn-update" class="btn btn-primary">수정완료</button>
</div>

<script>
    $('.summernote').summernote({
        placeholder: '내용을 입력해주세요.',
        tabsize: 2,
        height: 300
    });
</script>
<script src="/js/board.js"></script>
<!-- 푸터 시작 -->
<%@ include file="../layout/footer.jsp"%>
<!-- 푸터 끝 -->