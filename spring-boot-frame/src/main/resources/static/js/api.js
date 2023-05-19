function askVerifyCode(){
    $.get('/api/auth/verify-code',{
        mail: $("#input-mail").val()
    },function (data){
        alert(data.reason)
    })
}