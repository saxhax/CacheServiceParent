<%@page import="com.unsa.pmf.ws.service.cache.statistic.Statistic"%>
<%@page import="com.unsa.pmf.ws.service.cache.statistic.StatisticParameter"%>
<%@page import="com.unsa.pmf.ws.service.cache.statistic.StatisticResponse"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<div>
	<%
		String message = null;
		boolean parameter = false;
		List<String> insert = new ArrayList<String>();
		List<String> pull = new ArrayList<String>();
		try {
		    String sessionName = request.getParameter("sessionName");
		    String sessionId = request.getParameter("sessionId");
		    parameter = (sessionName == null || sessionName.isEmpty());
		    parameter = (parameter || sessionId == null || sessionId.isEmpty());
		    if (parameter) {
		    	message = "Please, put session, key, value and number of rows for insert";
		    } else {
		    	StatisticParameter statisticParameter = new StatisticParameter();
		    	statisticParameter.parseSession(sessionId, sessionName);
		    	statisticParameter.parseLimitRow(request.getParameter("limitRow"));
		    	statisticParameter.parseLimitField(request.getParameter("limitField"));
		    	statisticParameter.parseDiffKeys(request.getParameter("keys"));
		    	statisticParameter.parseDiffValues(request.getParameter("values"));
		    	StatisticResponse statisticResponse = new Statistic().createStatistic(statisticParameter);
		    	message = statisticResponse.getMessage();
		    	insert = statisticResponse.getInsert();
		    	pull = statisticResponse.getPull();
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
							<input type="number" name="limitRow"></input>
						</div>
						<div class="row">
							<label>Number of fields: </label> 
							<input type="number" name="limitField"></input>
						</div>
						<div class="row">
							<label>Different keys: </label> 
							<input type="number" name="keys"></input>
						</div>
						<div class="row">
							<label>Different values: </label> 
							<input type="number" name="values"></input>
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