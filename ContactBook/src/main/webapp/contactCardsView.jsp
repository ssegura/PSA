<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1>Contact Book</h1>

	<p>${message}</p>


	<c:forEach items="${requestScope.contacts}" var="entry">

		<div class="card">
			<img id="avatar" src="./images/img_avatar.png" alt="Avatar">
			<div class="card_container">
				<h4>
					<b><c:out value="${entry.value.name}" /></b>
				</h4>
				<p><c:out value="${entry.value.telephone}" /></p>
				
				<a href="contactupdate?id=${entry.value.id}"><img src="./images/edit.png" width="30px"></a> <a
				href="contactdelete?id=${entry.value.id}"><img src="./images/delete.png" width="30px"></a>
					
			</div>
		</div>
	</c:forEach>
	
	<div id="bottom_links">
		<a href="contactEditView.jsp" class="button">New contact</a>
	</div>
	
<!-- footer -->
<%@include file="includes/footer.jsp"%>