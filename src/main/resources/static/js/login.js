function checkpost(){

    if(document.forms[5].name.value=="用户名"&&document.forms[5].pw.value==" 密码"){

        window.location="跳转的地址";

    }else{

        alert("用户名或密码不正确！")

        return false;

    }

}