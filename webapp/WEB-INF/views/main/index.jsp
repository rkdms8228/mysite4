<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/mysite4/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/mysite4/assets/css/main.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<div id="header" class="clearfix">
			<h1>
				<a href="/mysite4/main">MySite</a>
			</h1>

			<!-- 
			<ul>
				<li>황일영 님 안녕하세요^^</li>
				<li><a href="" class="btn_s">로그아웃</a></li>
				<li><a href="" class="btn_s">회원정보수정</a></li>
			</ul>
			-->	
			<ul>
				<li><a href="/mysite4/loginForm" class="btn_s">로그인</a></li>
				<li><a href="" class="btn_s">회원가입</a></li>
			</ul>
			
		</div>
		<!-- //header -->

		<div id="nav">
			<ul class="clearfix">
				<li><a href="">입사지원서</a></li>
				<li><a href="">게시판</a></li>
				<li><a href="">갤러리</a></li>
				<li><a href="">방명록</a></li>
			</ul>
		</div>
		<!-- //nav -->

		
		<div id="container" class="clearfix">
			<!-- aside 없음 -->
			<div id="full-content">
			
				<!-- content-head 없음 -->
				<div id="index"> 
				
					<img id="profile-img" src="/mysite4/assets/image/profile.jpg">
					
					<div id="greetings">
						<p class="text-xlarge">
							<span class="bold">안녕하세요!!<br>
							김가은의 MySite՞•ᴥ•՞에 오신 것을 환영합니다.<br>
							<br>
							이 사이트는 웹 프로그램밍 실습 과제 예제 사이트입니다.<br>
							</span>
							<br>
							사이트 소개, 회원가입, 방명록, 게시판으로 구성되어 있으며<br>
							jsp & serlvet(모델4) 방식으로 제작되었습니다.<br>
							<br>
							자바 수업 + 데이터베이스 수업 + 웹프로그래밍 수업<br>
							배운 거 있는 거 없는 거 다 합쳐서 만들어 놓은 사이트입니다.<br>
							<br>
							(자유롭게 꾸며 보세요!!)<br>
							<br><br>
							<a class="" href="">[방명록에 글 남기기]</a>
						</p>	
					</div>
					<!-- //greetings -->
					
					<div class="clear"></div>
					
				</div>
				<!-- //index -->
				
			</div>
			<!-- //full-content -->
			

		</div>
		<!-- //container -->
		
		
		<div id="footer">
			Copyright ⓒ 2022 김가은 ʕ•ᴥ•ʔ. All right reserved
		</div>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>