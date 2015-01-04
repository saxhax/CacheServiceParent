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
		int numberOfFields = 0;
		try {
		    String sessionName = request.getParameter("sessionName");
		    String sessionId = request.getParameter("sessionId");
		    numberOfFields = Integer.parseInt(request.getParameter("count"));
		    if (numberOfFields <= 0 || numberOfFields > 100) {
		    	numberOfFields = 3;
		    }
		   
		    parameter = (sessionName == null || sessionName.isEmpty());
		    parameter = (parameter || sessionId == null || sessionId.isEmpty());
		    if (parameter) {
		    	message = "Please, put session, keys and values";
		    } else {
				CacheServiceImpl service = new CacheServiceImpl();
				sessionFromServer = new Session();
				sessionFromServer.setSessionId(sessionId);
				sessionFromServer.setSessionName(sessionName);
				
				List<Field> fields = new ArrayList<Field>();
				for (int i = 0; i < numberOfFields; i++) {
				  	Field field = new Field();
					field.setKey(request.getParameter("key" + i));
					field.setValue(request.getParameter("value" + i));
					fields.add(field);
				}
				sessionFromServer = service.putValues(sessionFromServer, fields);
			    message = "Data added successfully.";
		    }
		} catch (Exception e) {
			message = e.getMessage();
		}
	%>
		<form action="index.jsp?action=putValues&count=<%=numberOfFields %>" method="post">
			<div>
				<h2>Put session and values</h2>
				<fieldset class="field shadow">
					<legend> Session from server</legend>
					<div class="row">
						<label>Session ID: </label> 
						<input type="text" name="sessionId"></input>
					</div>
					<div class="row">
						<label>Service name: </label> 
						<input type="text" name="sessionName"></input>
					</div>
				</fieldset>
				<span style="padding:10px 0px 5px 280px;"><strong>K</strong>ey/<strong>V</strong>alue fields</span>
				<fieldset class="shadow getValues">
				<% 
				for (int i = 0; i < numberOfFields; i++) {
				%>
					<fieldset class="field shadow half">
						<legend> Values for cache number: <%=(i+1) %></legend>
						<div class="row">
							<label>K: </label> 
							<input type="text" name="key<%=i %>"></input>
						</div>
						<div class="row">
							<label>V: </label> 
							<input type="text" name="value<%=i %>"></input>
						</div>
					</fieldset>
				<% 
				}
				%>
				</fieldset>
			</div>
			<div class="row">
				<input type="submit" value="Put values" id="submit" class="shadow border"></input>
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