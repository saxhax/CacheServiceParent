<%@page import="com.unsa.pmf.ws.common.config.Configurations"%>
<%@page import="com.unsa.pmf.ws.service.cache.impl.CacheServiceImpl"%>
<%@page import="com.unsa.pmf.ws.common.session.Session"%>
<div>
	<%
	    Session sessionFromServer = null;
		String errorMessage = null;
		boolean parameter = false;
		try {
		    String sessionName = request.getParameter("name");
		    parameter = (sessionName == null || sessionName.isEmpty());
		    if (parameter) {
		    	errorMessage = "Please, put name and create service";
		    } else {
				CacheServiceImpl service = new CacheServiceImpl();
				Configurations configurations = new Configurations();
				configurations.setName(sessionName);
				sessionFromServer = service.createCacheService(configurations);
		    }
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
	%>
	
	<fieldset>
		<legend>Create service</legend>
		<form action="index.jsp?action=createService" method="post">
			<h2>Cache service, name is enough for new service</h2>
			<div class="row">
				<label>Name: </label> 
				<input type="text" name="name"></input>
			</div>
			<div class="row">
				<input type="submit" value="Create service" id="submit" class="shadow border"></input>
			</div>
		</form>
	</fieldset>
	<br>
	<%
		if (sessionFromServer != null) {%>
			<div ng-app="" ng-init="sessionId='<%= sessionFromServer.getSessionId() %>'; sessionName='<%= sessionFromServer.getSessionName() %>'" >
				<fieldset class="session">
					<legend>Session from server</legend>
					<div class="row">
						<label>Session ID: </label> 
						<input type="text" name="sessionId" ng-model="sessionId" readonly></input>
					</div>
					<div class="row">
						<label>Service name: </label> 
						<input type="text" name="sessionName" ng-model="sessionName" readonly></input>
					</div>
				</fieldset>
			</div>
	<%
		}
		if (errorMessage != null) {%>
			<fieldset class="session">
				<legend>Session:</legend>
				<div class="row">
					<label><%= errorMessage %></label> 
				</div>
			</fieldset>
	<%
		}
	%>
</div>