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
		boolean ajsFilter = false;
		Data data = null;
		try {
		    String sessionName = request.getParameter("sessionName");
		    String sessionId = request.getParameter("sessionId");
		    String key = request.getParameter("key");
		    String value = request.getParameter("value");
		    int limit;
		    try {
		    	limit = Integer.parseInt(request.getParameter("limit"));
		    } catch (Exception e) {
		    	limit = 10;
		    }
		    try {
		    	ajsFilter = request.getParameterMap().containsKey("ajsFilter");
		    } catch (Exception e) {
		    	ajsFilter = false;
		    }
		    parameter = (sessionName == null || sessionName.isEmpty());
		    parameter = (parameter || sessionId == null || sessionId.isEmpty());
		    if (parameter) {
		    	message = "Please, put session, key and value";
		    } else {
				CacheServiceImpl service = new CacheServiceImpl();
				sessionFromServer = new Session();
				sessionFromServer.setSessionId(sessionId);
				sessionFromServer.setSessionName(sessionName);
				Filter filter = new Filter();
				Condition condition = new Condition();
				condition.setLimit(limit);
				filter.setCondition(condition);
				Field field = new Field();
				field.setKey(key);
				field.setValue(value);
				List<Field> fields = new ArrayList<Field>();
				fields.add(field);
				filter.setFindFields(fields);
				data = service.getValues(sessionFromServer, filter);
		    }
		} catch (Exception e) {
			message = e.getMessage();
		}
		if (data == null) {
		%>
			<form action="index.jsp?action=getValues" method="post">
				<div>
					<h2>Get values for specific filter and session</h2>
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
					<fieldset class="field shadow">
						<legend> Filter values</legend>
						<div class="row">
							<label>Key: </label> 
							<input type="text" name="key"></input>
						</div>
						<div class="row">
							<label>Value: </label> 
							<input type="text" name="value"></input>
						</div>
						<div class="row">
							<label>Limit rows: </label> 
							<input type="text" name="limit"></input>
						</div>
						<div class="row">
							<label>Enable filtering: </label> 
							<input style="float: none; width: 120px" type="checkbox" name="ajsFilter" checked></input>
						</div>
					</fieldset>
				</div>
				<div class="row">
					<input type="submit" value="Get values" id="submit" class="shadow border"></input>
				</div>
			</form>
		<br>	
		<%
		} else {
		%>
			<h2>Data from cache service</h2>
		<%
		if (ajsFilter) {
		%>
			<script>
				array = new Array();
				<%
					int i = 0;
					for (int row = 0; row < data.getFoundRows().size(); row++) {
						List<Field> fields = data.getFoundRows().get(row).getFields();
						for (int field = 0; field < fields.size(); field++) {
							%>
							array[<%=i %>] = { key : '<%=fields.get(field).getKey() %>', value : '<%=fields.get(field).getValue() %>', row : '<%=row + 1 %>', field : '<%=field + 1 %>' };
							<%
							i++;
						}
					}
				%>
			</script>
			<div ng-app="getValuesFilterModule">
				<div ng-controller="getValuesController as ctrl">
					<div style="padding-left: 20px;">
						<lable>Filter: </lable>
						<input ng-init="value=''" ng-model="value" />
					</div>
					<div ng-repeat="entry in ctrl.filteredArray(value)">
						<fieldset class="field shadow half">
							<legend>Row: {{entry.row}}, Field: {{entry.field}}</legend>
							<div class="row">
								<label>K: </label> 
								<input type="text" name="key" value="{{entry.key}}" readonly></input>
							</div>
							<div class="row">
								<label>V: </label> 
								<input type="text" name="key" value="{{entry.value}}" readonly></input>
							</div>
						</fieldset>
					</div>
				</div>
			</div>
			<br><br>
		<%
		} else {
			int rowCount = 1;
			for (Row row : data.getFoundRows()) {
			%>
				<fieldset class="shadow getValues"><legend>Row: <%=rowCount %></legend>
					  <span style="padding-left: 280px;"><strong>K</strong>ey/<strong>V</strong>alue fields</span><%
					int fieldCount = 1;
					for (Field field : row.getFields()) {
					%>
						<div>
							<fieldset class="field shadow half">
							    <legend><%=fieldCount %></legend>
								<div class="row">
									<label>K: </label> 
									<input type="text" name="key" value="<%=field.getKey() %>" readonly></input>
								</div>
								<div class="row">
									<label>V: </label> 
									<input type="text" name="key" value="<%=field.getValue() %>" readonly></input>
								</div>
							</fieldset>
						</div>
					<%
					fieldCount++;
					}
					rowCount++;
					%></fieldset><%
				}
			}
		}
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