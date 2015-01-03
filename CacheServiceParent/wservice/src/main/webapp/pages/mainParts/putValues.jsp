<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.unsa.pmf.ws.common.data.Field"%>
<%@page import="com.unsa.pmf.ws.common.config.Configurations"%>
<%@page import="com.unsa.pmf.ws.service.cache.impl.CacheServiceImpl"%>
<%@page import="com.unsa.pmf.ws.common.session.Session"%>
<div>
	<%
	    Session sessionFromServer = null;
		String message = null;
		boolean parameter = false;
		try {
		    String sessionName = request.getParameter("sessionName");
		    String sessionId = request.getParameter("sessionId");
		    String key = request.getParameter("key");
		    String value = request.getParameter("value");
		    parameter = (sessionName == null || sessionName.isEmpty());
		    parameter = (parameter || sessionId == null || sessionId.isEmpty());
		    if (parameter) {
		    	message = "Please, put session, key and value";
		    } else {
				CacheServiceImpl service = new CacheServiceImpl();
				sessionFromServer = new Session();
				sessionFromServer.setSessionId(sessionId);
				sessionFromServer.setSessionName(sessionName);
				Field field = new Field();
				field.setKey(key);
				field.setValue(value);
				List<Field> fields = new ArrayList<Field>();
				fields.add(field);
				sessionFromServer = service.putValues(sessionFromServer, fields);
			    message = "Data added successfully.";
		    }
		} catch (Exception e) {
			message = e.getMessage();
		}
	%>
		<form action="index.jsp?action=putValues" method="post">
			<div ng-app="" ng-init="sessionId=''; sessionName=''" >
				<fieldset class="field">
					<legend> Session from server</legend>
					<div class="row">
						<label>Session ID: </label> 
						<input type="text" name="sessionId" ng-model="sessionId"></input>
					</div>
					<div class="row">
						<label>Service name: </label> 
						<input type="text" name="sessionName" ng-model="sessionName"></input>
					</div>
				</fieldset>
				<fieldset class="field">
					<legend> Values for cache</legend>
					<div class="row">
						<label>Key: </label> 
						<input type="text" name="key" ng-model="key"></input>
					</div>
					<div class="row">
						<label>Value: </label> 
						<input type="text" name="value" ng-model="value"></input>
					</div>
				</fieldset>
			</div>
			<div class="row">
				<input type="submit" value="Put values" id="submit" class="shadow border"></input>
			</div>
		</form>
	<br>	
	<%
		if (message != null) {%>
			<fieldset class="field">
				<legend>Message:</legend>
				<div class="row">
					<label><%= message %></label> 
				</div>
			</fieldset>
	<%
		}
	%>
</div>