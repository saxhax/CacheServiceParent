<html>
	<%
    	boolean contain = false;
		boolean error = false;
		String action = "";
		try {
		    action = request.getParameter("action");
		    if (action == null || action.isEmpty()) {
		    	error = true;
		    } else {
			    String actions[] = {"createService", "getSession", "putValues", "closeSession"};
			    for (String validAction : actions) {
			    	if (validAction.equalsIgnoreCase(action)) {
			    		contain = true;
			    		break;
			    	}
			    }
		    }
		} catch (Exception e) {
			error = true;
		}
	    error = error || !contain;
		if (!error) {%>
			<jsp:include page="mainParts/head.jsp" />	
			<body  class="background">
				<jsp:include page="mainParts/header.jsp" />
				<jsp:include page="mainParts/menu.jsp" />
				<jsp:include page="mainParts/main.jsp?action=<%=action%>" />
				<jsp:include page="mainParts/footer.jsp" />
			</body><% 
		} else if (error){
			String site = new String("../index.jsp");
		    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		    response.setHeader("Location", site); 
		}
	%>
</html>
