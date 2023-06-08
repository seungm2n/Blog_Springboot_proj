let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteById();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
        $("#btn-reply-save").on("click", () => {
            this.replySave();
        });

    },

    save: function () {
        let data ={
            title : $("#title").val(),
            content : $("#content").val()
        };

        $.ajax({
            type : "POST",
            url : "/api/board",
            data : JSON.stringify(data),
            contentType : "application/json; charset=utf-8",
            dataType : "json"
        }).done(function(resp){
            // 성공 시
            alert("글이 게시되었습니다.");
            // console.log(resp);
            location.href="/";
        }).fail(function(error){
            // 실패 시
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경 -> insert 요청

    },

    deleteById: function () {
        let id = $("#id").text();

        $.ajax({
            type : "DELETE",
            url : "/api/board/" + id,
            dataType : "json"
        }).done(function(resp){
            // 성공 시
            alert("게시글이 삭제되었습니다.");
            // console.log(resp);
            location.href="/";
        }).fail(function(error){
            // 실패 시
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경 -> insert 요청

    },

    update: function () {
        let id = $("#id").val();

        let data ={
            title : $("#title").val(),
            content : $("#content").val()
        };

        $.ajax({
            type : "PUT",
            url : "/api/board/" + id,
            data : JSON.stringify(data),
            contentType : "application/json; charset=utf-8",
            dataType : "json"
        }).done(function(resp){
            // 성공 시
            alert("게시글이 수정되었습니다.");
            // console.log(resp);
            location.href="/";
        }).fail(function(error){
            // 실패 시
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경 -> insert 요청

    },
    replySave: function () {
        let data ={
            boardId : $("#boardId").val(),
            userId : $("#userId").val(),
            content : $("#reply-content").val()
        };

        console.log(data);

        $.ajax({
            type : "POST",
            url : `/api/board/${data.boardId}/reply`,
            data : JSON.stringify(data),
            contentType : "application/json; charset=utf-8",
            dataType : "json"
        }).done(function(resp){
            // 성공 시
            alert("댓글 작성이 완료되었습니다.");
            // console.log(resp);
            location.href=`/board/${data.boardId}`;
        }).fail(function(error){
            // 실패 시
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경 -> insert 요청

    },
    replyDelete: function (boardId, replyId) {

        $.ajax({
            type : "DELETE",
            url : `/api/board/${boardId}/reply/${replyId}`,
            dataType : "json"
        }).done(function(resp){
            // 성공 시
            alert("댓글 삭제가 완료되었습니다.");
            location.href=`/board/${boardId}`;
        }).fail(function(error){
            // 실패 시
            alert(JSON.stringify(error));
        });

    }
}

index.init();