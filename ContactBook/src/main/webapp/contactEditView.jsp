<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1>Contact Book</h1>

	
	<% String controller = "contactnew"; %>
	
	<c:if test="${not empty contact}">
    	<% controller = "contactupdate"; %>
	</c:if>
	
	<div class="container">
		<form action="<%= controller %>" method="post">
	
			<label for="name">Name: </label> 
			<input id="name" name="name" type="text" required="required" value="${contact.name}">
			
			<label for="phone">Phone: </label> 
			<input id="phone" name="phone" type="text" pattern="\d{9}" required="required" value="${contact.telephone}">
			
			<c:if test="${not empty contact}">
				<input name="id" type="hidden" value="${contact.id}">
			</c:if>
	
			<div class="bottom_links">
				<button type="submit" class="button">Submit</button>
				<button type="button" onClick="javascript:window.location.href='contactlist'" class="button">Cancel</button>
			</div>
	
		</form>
	</div>

	<!-- footer -->
	<%@include file="includes/footer.jsp"%>