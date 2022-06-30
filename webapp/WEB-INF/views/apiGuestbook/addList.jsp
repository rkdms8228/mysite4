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
<link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">

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
					<!-- <form action="${pageContext.request.contextPath}/guestbook/add" method="get"> -->
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
						
					<!-- </form> -->
					
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
	
	<!-- ////////////////////////////////////////////////////////////////// -->
	<!-- 삭제 모달창 -->
	<div id="delModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">비밀번호를 입력하세요.</h4>
				</div>
				<div class="modal-body">
				
				PASSWORD <input type="text" name="password" value=""> <br><br>
				<input type="hidden" name="no" value="">	
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="btnModalDel" type="button" class="btn btn-danger">삭제</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- ////////////////////////////////////////////////////////////////// -->

</body>

	<script type="text/javascript">
		
		/* 준비가 끝났을 때 */
		$(document).ready(function() {
			
			console.log("jquery로 요청 data만 받는 요청");
			
			//리스트 요청 + 그리기
			fetchList();
			
		});
		
		//저장 버튼을 클릭했을 때2
		$("#btnSubmit").on("click", function() {
			
			console.log("저장 버튼 클릭");
			
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
			
			console.log(guestVo);
			
			$.ajax({
				
				//보낼 때
				url : "${pageContext.request.contextPath}/api/guestbook/add2",
				type : "post",
				contentType : "application/json",
				data : JSON.stringify(guestVo),	//js객체를 JSON 문자열로 변경
				
				//받을 때
				dataType : "json",
				success : function(result){
					
					//성공시 처리해야 될 코드 작성
					
				},
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
				
			});
			
		)};
		
	/*
		//저장 버튼을 클릭했을 때
		$("#btnSubmit").on("click", function() {
			
			console.log("저장 버튼 클릭");
			
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
				// url : "${pageContext.request.contextPath }/api/guestbook/add?name="+name+"&password="+password+"&content="+content,
				url : "${pageContext.request.contextPath}/api/guestbook/add",
				type : "post",
				//contentType : "application/json",
				data : guestVo, //파라미터 정리됨
				
				//받을 때
				dataType : "json",
				success : function(gvo){
					
					//성공시 처리해야 될 코드 작성
					console.log(gvo);
					
					//1개데이터 리스트 추가(그리기)하기
					render(gvo, "up");
					
					//입력폼 초기화
					$("[name=name]").val("");
					$("[name=password]").val("");
					$("[name=content]").val("");
					
				},
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
				
			});
			
		});
	*/
		
		/* 삭제 버튼을 클릭했을 때 */
		$("#ListArea").on("click", ".btnDel", function() {
			
			console.log("리스트 삭제 버튼 클릭");
			
			var $this = $(this);	
			var no = $this.data("no");
			//console.log(no);
			
			//모달창에 form값 입력
			//$("[name=password]").val("");
			$("#delModal [name=password]").val("");
			$("[name=no]").val(no);
			
			//모달창 띄우기
			$("#delModal").modal("show");
			
		});
		
		/* 모달창 삭제 버튼을 클릭했을 때 */
		$("#btnModalDel").on("click", function() {
			
			console.log("모달창 삭제 버튼 클릭");
			
			//데이터 모으기
			var password = $("#delModal [name=password]").val();
			var no = $("[name=no]").val();
			
			var guestVo = {};
			guestVo.password = password;
			guestVo.no = no;
			
			console.log(guestVo);
			
			//서버로 데이터 전송
			$.ajax({
				
				//보낼 때
				url : "${pageContext.request.contextPath}/api/guestbook/delete",
				type : "post",
				//contentType : "application/json",
				data : guestVo,
				
				//받을 때
				dataType : "json",
				success : function(result){
					
					/* 성공시 처리해야 될 코드 작성 */
					console.log(result);
						
					if(result == "success") { //성공이면 제거하기
						
						$("#T"+no).remove();
						
						//모달창 닫기
						$("#delModal").modal("hide");
						
					}else { //실패하면
						alert("비밀번호가 틀렸습니다.");
					}
					
				},
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
				
			});
			
			//성공이면 리스트에서 제거하기
			
			//모달창 닫기
			
		});
		
		/* 리스트 요청 */
		function fetchList(){
			
			$.ajax({
				
				url : "${pageContext.request.contextPath}/api/guestbook/list",		
				type : "post",
				//contentType : "application/json",
				//data : {name: "홍길동"},
				
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
			str += '<table id="T'+guestVo.no+'" class="guestRead">' ;
			str += '   <colgroup>' ;
			str += '      <col style="width: 10%;">' ;
			str += '      <col style="width: 40%;">' ;
			str += '      <col style="width: 40%;">' ;
			str += '      <col style="width: 10%;">' ;
			str += '   </colgroup>' ;
			str += '   <tr>' ;
			str += '      <td>'+guestVo.no+'</td>' ;
			str += '      <td>'+guestVo.name+'</td>' ;
			str += '      <td>'+guestVo.regDate+'</td>' ;
			str += '       <td><button class="btnDel" type="button" data-no="'+guestVo.no+'">[삭제]</button></td>' ;
			str += '   </tr>' ;
			str += '   <tr>' ;
			str += '      <td colspan=4 class="text-left">'+guestVo.content+'</td>' ;
			str += '   </tr>' ;
			str += '</table>' ;

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