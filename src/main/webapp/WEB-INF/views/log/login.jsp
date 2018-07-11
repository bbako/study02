<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="/resources/">
    <title>Login</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body style="background: center center fixed;">
<div class="col-md-6">
    <div class="page-form">
        <div class="panel panel-blue">
            <div class="panel-body pan">
                <form action="/log/loginPost" method="post" class="form-horizontal">
                <div class="form-body pal">
                    <div class="form-group">
                        <div class="col-md-12 text-center">
                            <h1>
                                L O G I N</h1>
                            <br />
                        </div>
                    </div>
                    <div class="form-group">

                        <div class="col-md-12">
                            <div class="input-icon right">
                                <i class="fa fa-user"></i>
                                <input id="inputName" type="text" placeholder="아이디를 입력하세요" class="form-control" name="mid" /></div>
                        </div>
                    </div>
                    <div class="form-group">

                        <div class="col-md-12">
                            <div class="input-icon right">
                                <i class="fa fa-lock"></i>
                                <input id="inputPassword" type="password"  placeholder="비밀번호를 입력하세요" class="form-control" name="mpw" /></div>
                        </div>
                    </div>
                    <div class="form-group mbn">
                        <div class="col-lg-12" align="right">
                            <div class="form-group mbn">
                                <div class="col-lg-3">
                                    &nbsp;
                                </div>
                                <div class="col-lg-9">
                                     <div >
                                	<label>
                                	<input type="checkbox" name="useCookie"> Remember Me
                                	</label>
                                </div>
                                    <button type="submit" class="btn btn-default">로그인</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
    
 <script  src="https://code.jquery.com/jquery-3.2.1.min.js"
  			integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
    
 <script>
 
	$(document).ready(function(e) { 
		
		var result = '${sregimsg}';
		if (result == "success") {
			history.pushState(null, null);
			alert("회원가입이 왼료 되었습니다. 로그인 하세요.");
			window.onpopstate = function(e) {
				history.go(1);
			};
		}
		
		var result2 = '${logoutmsg}';
		if (result2 == "success") {
			history.pushState(null, null);
			alert("로그아웃 되었습니다. 다시 로그인 하세요.");
			window.onpopstate = function(e) {
				history.go(1);
			};
		}
		
		var result3 = '${sendId}';
		if (result3 == "success") {
			history.pushState(null, null);
			alert("메일이 발송 되었습니다. 확인 후 로그인 하세요.");
			window.onpopstate = function(e) {
				history.go(1);
			};
		}
		var result3 = '${sendPw}';
		if (result3 == "success") {
			history.pushState(null, null);
			alert("메일이 발송 되었습니다. 확인 후 로그인 하세요.");
			window.onpopstate = function(e) {
				history.go(1);
			};
		}
		
		
	});
	
</script>
</body>
</html>
