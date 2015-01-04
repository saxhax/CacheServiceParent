<div>
	<ul>
		<li class="border shadow bg radius" id="createServiceRight" onclick='goTo("index.jsp?action=createService")'>Create service</li>
		<li class="border shadow bg radius" id="getSessionRight" onclick='goTo("index.jsp?action=getSession")'>Get session for service</li>
		<li class="border shadow bg radius" id="putValuesRight" onclick='goToWithPromot("index.jsp?action=putValues")'>Put values</li>
		<li class="border shadow bg radius" id="getValuesRight" onclick='goTo("index.jsp?action=getValues")'>Get values</li>
		<li class="border shadow bg radius" id="closeSessionRight" onclick='goTo("index.jsp?action=closeSession")'>Close session</li>
		<li class="border shadow bg radius" id="statisticRight" onclick='goTo("index.jsp?action=statistic")'>Statistic</li>
		<li class="border shadow bg radius" onclick='goTo("../")'>Logout</li>
	</ul>
	<select id="count" onclick="">
		<% for (int i = 1; i <= 20; i++) {
				if (i == 3)
					%><option value="3" selected="selected">3</option><%
				else 
				%>
					<option value="<%=i %>"><%=i %></option>
				<%
			} 
		%>
	</select>
	<script>
	addBorderToLastRightSide("<%=request.getParameter("action") %>");
	</script>
</div>