let index = {
    init: function () {
        //let _this = this
        $("#btn-save").on("click", () => { //function() {}, () ⇒ {} // this를 바인딩하기 위해서 사용
            this.save(); // _this
        });
    },
    save: function() {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }
        //ajax 호출시 default 비동기 호출
        //ajax 통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert 요청
        $.ajax({
            //회원가입 수행 요청
            type: "POST",
            url: "/api/users",
            data: JSON.stringify(data), //http body data
            contentType: "application/json; charset=utf-8", //body data type, MIME
            dataType: "json" //요청을 서버로 해서 응답이 왔을 때 기본적으로 모든것이 문자열(생긴것이 json 이라면) => javascript 오브젝트로 변경
        }).done(function(response) {
            alert("회원가입이 완료되었습니다.");
            location.href="/";
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
}

index.init();