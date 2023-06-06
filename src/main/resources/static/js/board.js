let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
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

    }
}

index.init();