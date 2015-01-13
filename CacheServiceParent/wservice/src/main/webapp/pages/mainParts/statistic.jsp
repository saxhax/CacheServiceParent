<%@page import="java.util.Date"%>
<%@page import="com.unsa.pmf.ws.common.data.Row"%>
<%@page import="com.unsa.pmf.ws.common.data.Data"%>
<%@page import="com.unsa.pmf.ws.common.filter.Condition"%>
<%@page import="com.unsa.pmf.ws.common.filter.Filter"%>
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
		List<String> insert = new ArrayList<String>();
		List<String> pull = new ArrayList<String>();
		insert.add("Started at " + new Date());
		try {
		    String sessionName = request.getParameter("sessionName");
		    String sessionId = request.getParameter("sessionId");
		    int limit;
		    try {
		    	limit = Integer.parseInt(request.getParameter("limit"));
		    } catch (Exception e) {
		    	limit = 1000000;
		    }
		    parameter = (sessionName == null || sessionName.isEmpty());
		    parameter = (parameter || sessionId == null || sessionId.isEmpty());
		    if (parameter) {
		    	message = "Please, put session, key, value and number of rows for insert";
		    } else {
				CacheServiceImpl service = new CacheServiceImpl();
				sessionFromServer = new Session();
				sessionFromServer.setSessionId(sessionId);
				sessionFromServer.setSessionName(sessionName);
				
				for (int i = 1; i <= limit; i++) {
					List<Field> values = new ArrayList<Field>();
					for (int j = 0; j < 15; j++) {
						Field field = new Field();
						field.setKey(j + "key" + i);
						field.setValue(j + "value" + i);
						values.add(field);
					}
					service.putValues(sessionFromServer, values);
					if (i % (limit/10) == 0) {
						insert.add(i + ". rows inserted at " + new Date());
					}
				}
				insert.add((limit+1) + ". ros inserted at " + new Date());
				insert.add("Finished<br><br>");
				pull.add("Start test with cache at " + new Date() + "");
				Filter filter = new Filter();
				Condition condition = new Condition();
				condition.setLimit(limit);
				condition.setUseCache(true);
				filter.setCondition(condition);
				Field field = new Field();
				field.setKey("7key" + (limit/2));
				field.setValue("7value" + (limit/2));
				List<Field> fields = new ArrayList<Field>();
				fields.add(field);
				filter.setFindFields(fields);
				Date start = new Date();
				service.getValues(sessionFromServer, filter);
				pull.add("Finished at " + new Date() + " with duration of: " + (new Date().getTime()  - start.getTime()) + "ms.<br><br>");
				pull.add("Start test without cache at " + new Date() + "");
				condition.setUseCache(false);
				start = new Date();
				service.getValues(sessionFromServer, filter);
				pull.add("Finished at " + new Date() + " with duration of: " + (new Date().getTime()  - start.getTime()) + "ms.<br><br>");
		    }
		} catch (Exception e) {
			message = e.getMessage();
		}
		if (!parameter) {
		%>
			<div>
				<h2>Statistic</h2>
				<fieldset class="field shadow half">
					<legend>Insert</legend>
					<%
						for (String date : insert) {
					%>
						<label><%=date %><br></label> 
					<% 
						}
					%>
				</fieldset>
				<fieldset class="field shadow half">
					<legend>Pull data</legend>
					<%
						for (String date : pull) {
					%>
						<label><%=date %><br></label> 
					<% 
						}
					%>
				</fieldset>
			</div>
		<br>	
		<%
		} else {
		%>
			<form action="index.jsp?action=statistic" method="post">
				<div>
					<h2>Create statistic test</h2>
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
						<div class="row">
							<label>Number of rows: </label> 
							<input type="text" name="limit"></input>
						</div>
					</fieldset>
				</div>
				<div class="row">
					<input type="submit" value="Generate test" id="submit" class="shadow border"></input>
				</div>
			</form>
		<%
		}
		if (message != null) {
		%>
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