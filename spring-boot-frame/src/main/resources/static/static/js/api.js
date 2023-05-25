function askVerifyCode(){
    get('http://localhost:8080/api/auth/verify-code',{
        mail: $("#input-mail").val()
    },function (data){
        if (data.code === 200){
            alert(data.reason)
        }else {
            alert(data.reason)
        }
    })
}

function register(){
    post('http://localhost:8080/api/auth/register',{
        username: $("#username").val(),
        password: $("#password").val(),
        mail: $("#input-mail").val(),
        verify: $("#verify-code").val()
    },function (data){
        console.log(data)
        if (data.code === 200){
            window.location = "login.html"
        }else {
            alert(data.reason)
        }
    })
}

function login(){
    post('http://localhost:8080/api/auth/login',{
        username: $("#username").val(),
        password: $("#password").val()
    },function (data){
        if (data.code === 200){
            window.location = "index.html"
        }else {
            alert(data.reason)
        }
    })
}

function logout(){
    get('http://localhost:8080/api/auth/logout',{},function (data){
        if(data.code === 200){
            window.location = "login.html"
        }
    })
}

function initUserInfo(){
    get('http://localhost:8080/api/user/info',{},function (data){
        if (data.code === 200){
            $("#profile-name").text(data.data.username)
        }else {
            window.location = "login.html"
        }
    })
}

function get(url, data ,success){
    $.ajax({
        type: "get",
        url: url,
        async: true,
        data: data,
        dataType: 'json',
        xhrFields: {
            withCredentials: true
        },
        success: success
    });
}

function post(url, data, success){
    $.ajax({
        type: "post",
        url: url,
        async: true,
        data: data,
        dataType: 'json',
        xhrFields: {
            withCredentials: true
        },
        success: success
    });
}