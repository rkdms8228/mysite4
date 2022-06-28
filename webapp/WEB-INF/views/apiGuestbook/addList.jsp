<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css -->
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">

<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js">

</script>

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
				<h2>방명록</h2>
				<ul>
					<li>일반방명록</li>
					<li>ajax방명록</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">
				
				<div id="content-head" class="clearfix">
					<h3>일반방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">일반방명록</li>
						</ul>
					</div>
				</div>
				<!-- //content-head -->

				<div id="guestbook">
					<form action="/mysite4/guestbook/add" method="get">
						<table id="guestAdd">
							<colgroup>
								<col style="width: 70px;">
								<col>
								<col style="width: 70px;">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<th><label class="form-text" for="input-uname">이름</label></th>
									<td><input id="input-uname" type="text" name="name"></td>
									<th><label class="form-text" for="input-pass">패스워드</label></th>
									<td><input id="input-pass"type="password" name="password"></td>
								</tr>
								<tr>
									<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
								</tr>
								<tr class="button-area">
									<td colspan="4" class="text-center"><button type="submit">등록</button></td>
								</tr>
							</tbody>
							
						</table>
						<!-- //guestWrite -->	
					</form>	
					
					<!-- guestRead -->
					<div id="ListArea">
						
					</div>
					<!-- //guestRead -->
					
				</div>
				<!-- //guestbook -->
			
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
		
		<!-- 준비가 끝나면 -->
		$(document).ready(function() {
			
			console.log("jquery로 요청");
			
			$.ajax({
				
				url : "${pageContext.request.contextPath }/api/guestbook/list",
				type : "post",
				//contentType : "application/json",
				//data : {name: "홍길동"},
				
				dataType : "json",
				success : function(guestList){
					
					/*성공시 처리해야 될 코드 작성*/
					console.log(guestList);
					//console.log(guestList[0].name);
					
					//화면에 data + html 그리기
					for(var i=0; i<guestList.length; i++) {
						
						render(guestList[i]); //vo --> 화면에 그리는 작업
						
					}
					
				},
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
				
			});
			
		});
		
		function render(guestVo) {
			
			console.log("render");
			//var name = guestVo.name;
			
			var str = "" ;
			str += "<c:forEach items='${guestList}' var='guestVo'>" ;
			str += "	<table class='guestRead'>" ;
			str += "		<colgroup>" ;
			str += "			<col style='width: 10%;'>" ;
			str += "			<col style='width: 40%;'>" ;
			str += "			<col style='width: 40%;'>" ;
			str += "			<col style='width: 10%;'>" ;
			str += "		</colgroup>" ;
			str += "		<tr>" ;
			str += "			<td>[ ${guestVo.no}번 ]</td>" ;
			str += "			<td> 이름: ${guestVo.name} </td>" ;
			str += "			<td>[ 등록날짜: ${guestVo.regDate} ]</td>" ;
			str += "			<td><a href='/mysite4/guestbook/deleteForm/${guestVo.no}'>[삭제]</a></td>" ;
			str += "		</tr>" ;
			str += "		<tr>" ;
			str += "			<td colspan='4'>" ;
			str += "			${guestVo.no} 번째 방명록 내용<br>" ;
			str += "			${guestVo.content}" ;
			str += "			</td>" ;
			str += "		</tr>" ;
			str += "	</table>" ;
			str += "</c:forEach>" ;
			
			
			//$("#ListArea").append(name+ "<br>");
			
		}
		
	</script>

</html>