<div id="createService">
	<%
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("createService")) {%>
			<jsp:include page="createService.jsp" /><%
		} else if (action.equalsIgnoreCase("getSession")) {%>
			<jsp:include page="getSession.jsp" /><%
		} else if (action.equalsIgnoreCase("putValues")) {%>
			<jsp:include page="putValues.jsp" /><%
		} else if (action.equalsIgnoreCase("closeSession")) {%>
			<jsp:include page="closeSession.jsp" /><%
		} else if (action.equalsIgnoreCase("getValues")) {%>
			<jsp:include page="getValues.jsp" /><%
		}  else if (action.equalsIgnoreCase("howTo")) {%>
			<jsp:include page="howTo.jsp" /><%
		} else {%>
			<jsp:include page="error.jsp" /><%
		}
	%>
</div>