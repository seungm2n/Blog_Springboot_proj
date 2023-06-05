let index = {
    init: function () {
        // function(){}, ()=>{} this를 바인딩하기 위함.
        $("#btn-save").on("click", () => {
            this.save();
        });
    },

    save: function () {
        // alert("user의 회원가입 save함수 호출");
        let data ={
            username : $("#username").val(),
            password : $("#password").val(),
            email : $("#email").val()
        };
        // console.log(data);
        $.ajax({
            // 회원가입 요청
            type : "POST",
            url : "/auth/joinProc",
            data : JSON.stringify(data),    // http body 데이터
            contentType : "application/json; charset=utf-8",    // body 데이터가 어떤 타입?
            dataType : "json"   // 요청을 서버로해서 응답이 왔을 때, 기본적으로 모든 것이 문자열 (JSON 이라면) => javascript오브젝트로 변경
        }).done(function(resp){
            // 성공 시
            alert("회원가입이 완료되었습니다.");
            // console.log(resp);
            location.href="/";
        }).fail(function(error){
            // 실패 시
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경 -> insert 요청

    }
}

index.init();