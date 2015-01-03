<div id="createService">
	<%
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("createService")) {%>
			<jsp:include page="createService.jsp" /><%
		} else if (action.equalsIgnoreCase("getSession")) {%>
		<jsp:include page="getSession.jsp" /><%
	}
	%>
</div>