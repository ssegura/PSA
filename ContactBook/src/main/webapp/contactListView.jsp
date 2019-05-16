<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1>Contact Book</h1>

	<div class="container">
	
		<p>${message}</p>
				
		<table id="agenda">
			<tr>
				<th>Name</th>
				<th>Phone number</th>
				<th>Actions</th>
			</tr>

			<c:forEach items="${requestScope.contacts}" var="entry">
				<tr>
					<td><c:out value="${entry.value.name}" /></td>
					<td><c:out value="${entry.value.telephone}" /></td>
					<td><a href="contactupdate?id=${entry.value.id}"><img src="./images/edit.png" width="30px"></a> 
						<a href="contactdelete?id=${entry.value.id}"><img src="./images/delete.png" width="30px"></a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="bottom_links">
			<a href="contactEditView.jsp" class="button">New contact</a>
		</div>
	</div>

	<!-- footer -->
	<%@include file="includes/footer.jsp"%>