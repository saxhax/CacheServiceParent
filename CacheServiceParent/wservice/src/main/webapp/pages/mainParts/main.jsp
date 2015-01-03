<div id="main" class="minWidth">
	<%
		String action = request.getParameter("action");
	%>
	<div id="mainleft" class="shadow border radius bg">
		<jsp:include page="mainLeft.jsp?action=<%=action%>" />
	</div>
	<div id="mainRight" class="shadow border radius bg">
		<jsp:include page="mainRight.jsp" />
	</div>
</div>