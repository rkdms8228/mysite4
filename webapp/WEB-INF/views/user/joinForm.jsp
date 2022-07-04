<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/mysite4/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/mysite4/assets/css/user.css" rel="stylesheet" type="text/css">

<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"></script>

</head>

<body>
	<div id="wrap">

		<!-- header -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->

		<!-- nav -->
		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>
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
					<div id="joinForm">
						<form id="join-form" action="/mysite4/user/join" method="get">
	
							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label> 
								<input type="text" id="input-uid" name="id" value="" placeholder="아이디를 입력하세요">
								<button type="button" id="idCheck">중복체크</button>
							</div>
	
							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">패스워드</label> 
								<input type="text" id="input-pass" name="password" value="" placeholder="비밀번호를 입력하세요"	>
							</div>
	
							<!-- 이메일 -->
							<div class="form-group">
								<label class="form-text" for="input-name">이름</label> 
								<input type="text" id="input-name" name="name" value="" placeholder="이름을 입력하세요">
							</div>
	
							<!-- //나이 -->
							<div class="form-group">
								<span class="form-text">성별</span> 
								
								<label for="rdo-male">남</label> 
								<input type="radio" id="rdo-male" name="gender" value="male" > 
								
								<label for="rdo-female">여</label> 
								<input type="radio" id="rdo-female" name="gender" value="female" > 
	
							</div>
	
							<!-- 약관동의 -->
							<div class="form-group">
								<span class="form-text">약관동의</span> 
								
								<input type="checkbox" id="chk-agree" value="" name="">
								<label for="chk-agree">서비스 약관에 동의합니다.</label> 
							</div>
							
							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="submit" id="btn-submit">회원가입</button>
							</div>
							
						</form>
					</div>
					<!-- //joinForm -->
				</div>
				<!-- //user -->
			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->
		
		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

	<script type="text/javascript">
	
		//아이디 중복 무조건 체크 (아이디 중복일 때 = 0 , 중복이 아닐 때 = 1 )
		var idcheck = 0;
		
		//idCheck 버튼을 클릭했을 때 
		$("#join-form").on("submit", function() {
		    
			var joinId =  $("#input-uid").val();
			var joinPw =  $("#input-pass").val();
			
			//원래의 submit기능을 못하게 하는 장치(다른 html기능 포함)
			//event.preventDefault();
			
			if (joinId == "" || joinId == null) {		    
			    alert("아이디를 입력해 주세요.");
			    return false;
			}
			if (joinPw == "" || joinPw == null) {		    
			    alert("패스워드를 체크해 주세요.");
			    return false;
			}
			
			//약관동의
			var agree = $("#chk-agree").is(":checked");
			if(agree == false) {
				alert("약관에 동의해 주세요.");
			    return false;
			}
			
		});
		
		$("#idCheck").on("click", function() {
			
			var id = $("[name=id]").val();
			
			var userVo = {
				id : id
			};
			
			$.ajax({
				 
				//보낼 때
				url : "${pageContext.request.contextPath}/api/user/join",
				type : "post",
				//contentType: "application/json",
				data: userVo,
				 
				//받을 때
				//dataType : "json",
				success : function(result) {
					
					if (id == null || id == "") {
					    
					    alert("아이디를 입력해 주세요.");

					}else if (result == "fail") {
						 alert("이미 존재하는 아이디 입니다. 다른 아이디를 입력해 주세요.");
					}else {
						
					    alert("사용 가능한 아이디입니다.");
					    
					    //아이디가 중복되지 않으면  idcheck = 1 
					    idcheck = 1;
					    
					}
				       
				},
				 error : function(error) { 
				     alert("error : " + error);
				}
			     
			});
			
		});
	
	</script>

</html>