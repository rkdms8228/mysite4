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
					<form action="${pageContext.request.contextPath}/guestbook/add" method="get">
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
									<td colspan="4" class="text-center"><button type="submit" id="btnSubmit">등록</button></td>
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
			
			console.log("jquery로 요청 data만 받는 요청");
			
			//리스트 요청 + 그리기
			fetchList();
			
		});
		
		//저장 버튼을 클릭했을 때
		$("#btnSubmit").on("click", function() {
			console.log("저장 버튼 클릭");
		});
		

			
		//데이터 수집
		var name = $("[name=name]").val();
		var password = $("[name=password]").val();
		var content = $("[name=content]").val();
		
		//데이터 객체로 묶기
		var guestVo = {
				name: name
				, password: password
				, content: content
		};
		
		$.ajax({
			
			//보낼 때
			/* url : "${pageContext.request.contextPath }/api/guestbook/add?name="+name+"&password="+password+"&content="+content,	 */
			url : "${pageContext.request.contextPath}/api/guestbook/add",
			type : "post",
			//contentType : "application/json",
			data : guestVo, //파라미터 정리됨
			
			//받을 때
			dataType : "json",
			success : function(gvo){
				
				//성공시 처리해야 될 코드 작성
				console.log(gvo);
				
				/* 1개데이터 리스트 추가(그리기)하기 */
				render(gvo, "up");
				
				/* 입력폼 초기화 */
				$("[name=name]").val("");
				$("[name=password]").val("");
				$("[name=content]").val("");
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
			
		});
		
		/* 리스트 요청 */
		function fetchList(){
			
			$.ajax({
				
				url : "${pageContext.request.contextPath}/api/guestbook/list",		
				type : "post",
				//contentType : "application/json",
				//data : {name: ”홍길동"},
				
				dataType : "json",
				success : function(guestbookList){
					//화면 data + html 그린다
					for(var i=0; i<guestbookList.length; i++){
						render(guestbookList[i], "down");  //vo --> 화면에 그린다.
					}
				},
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
			});
			
		}
		
		/* 리스트 그리기 1개씩*/
		function render(guestVo, opt) {
			
			console.log("render");
			//var name = guestVo.name;
			
			var str = '' ;
			str += '<table class="guestRead">';
			str += '   <colgroup>';
			str += '      <col style="width: 10%;">';
			str += '      <col style="width: 40%;">';
			str += '      <col style="width: 40%;">';
			str += '      <col style="width: 10%;">';
			str += '   </colgroup>';
			str += '   <tr>';
			str += '      <td>'+guestVo.no+'</td>';
			str += '      <td>'+guestVo.name+'</td>';
			str += '      <td>'+guestVo.regDate+'</td>';
			str += '       <td><a href="">[삭제]</a></td>';
			str += '   </tr>';
			str += '   <tr>';
			str += '      <td colspan=4 class="text-left">'+guestVo.content+'</td>';
			str += '   </tr>';
			str += '</table>';

			if(opt == "down") {
				$("#ListArea").append(str);
			}else if(opt == "up") {
				$("#ListArea").prepend(str);
			}else {
				console.log("opt오류");
			}
			
			
		}
		
	</script>

</html>