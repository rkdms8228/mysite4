<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/mysite4/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/mysite4/assets/css/user.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<div id="header" class="clearfix">
			<h1>
				<a href="/mysite4/main">MySite</a>
			</h1>

			<c:choose>
				<c:when test="${empty authUser}">
					<ul>
						<li><a href="/mysite4/user/loginForm" class="btn_s">로그인</a></li>
						<li><a href="/mysite4/user/joinForm" class="btn_s">회원가입</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul>
						<li>${sessionScope.authUser.name} 님 안녕하세요 ﻿คʕ•ﻌ•ʔค</li>
						<li><a href="/mysite4/user/logout" class="btn_s">로그아웃</a></li>
						<li><a href="/mysite4/user/modifyForm" class="btn_s">회원정보수정</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
			
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
			<div id="aside">
				<h2>회원</h2>
				<ul>
					<li>회원정보</li>
					<li>로그인</li>
					<li>회원가입</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">
			
				<div id="content-head">
					<h3>회원가입</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>회원</li>
							<li class="last">회원가입</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
	
				<div id="user">
					<div id="joinOK">
					
						<p class="text-large bold">
							회원가입을 축하합니다.<br>
							<br>
							<a href="" >[로그인하기]</a>
						</p>
							
					</div>
					<!-- //joinOK -->
				</div>
				<!-- //user -->
			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->


		<div id="footer">
			Copyright ⓒ 2022 김가은 ʕ•ᴥ•ʔ. All right reserved
		</div>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>