<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*     { box-sizing:border-box;  }
	
	.sign-upForm { width:600px; margin:0 auto; }

	.sign-upForm input {
       
       border:1px solid grey;
       border-radius:5px;
       width: 50%;
       padding: 10px;
       margin:5px;
       
    }
    
	div  {
            text-align: center;
       }
    
    td { width:200px; }
    
    #container { width:100% }
    
    #form1 { width:100%; }

   
    input[name="signup"]:hover { background-color:#1E90FF; }
    input[name="signup"]:active { background-color:#4169E1; }
	input[name="signup"] { background-color:#87CEFA; border:0px; }
    
    input:focus { border-color:#0000CD; outline:none;}
    
    hr          { width:400px; margin-bottom:70px; }
    


</style>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
    window.onload = function() {
        //id에 길이가 1이상이고
        //비활성화 되어 있다면
        //id체크로직을 한번 돌린다

        $('#username').on('change', function() {
        const username = document.getElementById('username').value.length;
        if(username >= 1) {
            idCheck(document.getElementById('username').value)
        }
        })



} // window.onload end
	
    function idCheck(username) {
        //아이디체크 ajax 해보자 아장자ㅏ!
        $.ajax({
            url: "/getUser?username=" + username, // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
            method: "GET",   // HTTP 요청 메소드(GET, POST 등)
        })
        // HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
        .done(function(e) {
            if(e==0){
            console.log("OK")
            }else{
            console.log("NOK")
            }
        })
        // HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
        .fail(function(xhr, status, errorThrown) {

        })
        //
        .always(function(xhr, status) {
            $("#text").html("요청이 완료되었습니다!");
        });

    }
	


</script>
</head>
<body>
	<div class="sign-upForm">
	<h2>회원가입</h2>
	<hr />
		<form action="/signup/register" method="POST" id="form1">
		  <table id="container">
		  	<tr>
                <td>
                    <input type="text" name="username" id="username" placeholder="아이디" maxlength="20"><br>
                    <span id="unameCheck"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="password" name="userpassword" placeholder="비밀번호" maxlength="20"><br>
                    <span id="pwCheck"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="password" name="repasswd" placeholder="비밀번호 확인" maxlength="20"><br>
                    <span id="re_pwCheck"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="text" name="usernickname" placeholder="닉네임" maxlength="15"><br>
                    <span id="unicknameCheck"></span>
                </td>
            </tr>
            <tr>
                <td><span id="checkError"></span></td>
            </tr>
            <tr>
                <td><input type="submit" name="signup" value="가입하기"/></td>
            </tr>
		  </table>
		</form>

	</div>
</body>
</html>