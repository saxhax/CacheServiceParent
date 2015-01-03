<%@page import="java.util.List"%>
<%@page import="com.unsa.pmf.ws.service.cache.impl.CacheServiceImpl"%>
<%@page import="com.unsa.pmf.ws.common.session.Session"%>
<div>
	<%
		String message = null;
		boolean parameter = false;
		try {
		    String sessionName = request.getParameter("sessionName");
		    String sessionId = request.getParameter("sessionId");
		    parameter = (sessionName == null || sessionName.isEmpty());
		    parameter = (parameter || sessionId == null || sessionId.isEmpty());
		    if (parameter) {
		    	message = "Please, put session and close";
		    } else {
				CacheServiceImpl service = new CacheServiceImpl();
				Session sessionFromServer = new Session();
				sessionFromServer.setSessionId(sessionId);
				sessionFromServer.setSessionName(sessionName);
				service.closeSession(sessionFromServer);
			    message = "Session closed successfully.";
		    }
		} catch (Exception e) {
			message = e.getMessage();
		}
	%>
		<form action="index.jsp?action=closeSession" method="post">
			<div ng-app="" ng-init="sessionId=''; sessionName=''" >
				<h2>Close session</h2>
				<fieldset class="field shadow">
					<legend>Close session</legend>
					<div class="row">
						<label>Session ID: </label> 
						<input type="text" name="sessionId" ng-model="sessionId"></input>
					</div>
					<div class="row">
						<label>Service name: </label> 
						<input type="text" name="sessionName" ng-model="sessionName"></input>
					</div>
				</fieldset>
			</div>
			<div class="row">
				<input type="submit" value="Close session" id="submit" class="shadow border"></input>
			</div>
		</form>
	<br>	
	<%
		if (message != null) {%>
			<fieldset class="field shadow">
				<legend>Message:</legend>
				<div class="row">
					<label><%= message %></label> 
				</div>
			</fieldset>
	<%
		}
	%>
</div>