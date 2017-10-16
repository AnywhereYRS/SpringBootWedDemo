/**
 * Created by YRS on 2017/10/13.
 */
function checkLogin() {
    var username = $("#username").val();
    var password = $("#password").val();
    var param = {
        "username" : username,
        "password" : password
    }

    $.ajax({
        url : "/user/login",
        type : "POST",
        contentType : "application/json",
        dataType : "json",
        data : JSON.stringify(param),
        async : true,
        success : function(data) {
            if (data) {
                alert("恭喜你 " + username + " 登录成功");
                location.href = "/user/show";
            } else {
                alert("用户名或密码错误!");
            }
        }
    });

}

function checkRegist() {
    var username = $("#username").val();
    var password = $("#password").val();
    var email = $("#email").val();
    var param = {
        "username" : username,
        "password" : password,
        "email" : email
    }
    console.log(param);

    $.ajax({
        url : "/user/regist",
        type : "POST",
        contentType : "application/json",
        dataType : "json",
        data : JSON.stringify(param),
        async : true,
        success : function(data) {
            if (data) {
                alert("恭喜你 " + username + " 注册成功");
                location.href = "/user/toLoginForm";
            } else {
                alert("用户名存在:注册失败!");
            }
        }
    });
}