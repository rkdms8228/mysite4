<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet"
	type="text/css"
>
<link href="${pageContext.request.contextPath}/assets/css/gallery.css" rel="stylesheet"
	type="text/css"
>


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
			<!-- 게시판 aside -->
			<c:import url="/WEB-INF/views/include/galleryAside.jsp"></c:import>
			<!-- //게시판 aside -->

			<div id="content">

				<div id="content-head">
					<h3>첨부파일연습</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>갤러리</li>
							<li class="last">첨부파일연습</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="file">
					<form action="${pageContext.request.contextPath}/fileupload/upload" method="post" enctype="multipart/form-data">
						<table>
							<colgroup>
								<col style="width: 600px;">
								<col style="width: 220px;">
							</colgroup>
							<tr>
								<td class="text-left">
									<input type="file" name="file">
								</td>
								<td class="text-right">
									<button type="submit">파일업로드</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<!-- //file -->


			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->


		<!-- 푸터 -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //푸터 -->
	</div>
	<!-- //wrap -->

</body>

</html>


