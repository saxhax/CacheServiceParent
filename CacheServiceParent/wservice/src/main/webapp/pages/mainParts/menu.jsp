<script type="text/javascript">
	function startIframe(id) {
		var width = window.innerWidth;
		width = (width - 500)/2;
		document.getElementById(id + "2").style.left = width;
		openIframe(id);
	}
</script>
<div id="menu" class="shadow border radius minWidth">
	<div id="createServiceMenu" onclick='goTo("index.jsp?action=createService")'>Home</div>
	<div id="getSessionMenu" onclick='goTo("index.jsp?action=getSession")'>Service</div>
	<div id="howToMenu" onclick='goTo("index.jsp?action=howTo")'>How to</div>
	<div id="infoMenu" onclick='goTo("index.jsp?action=info")'>Info</div>
	<div onclick='goTo("../")'>Logout</div>
	<div id="turnOff" onclick='startIframe("iframe")'></div>
</div>
<div id="iframe" onclick='closeIframe("iframe")'>
	<iframe id="iframe2" src="mainParts/iframe.jsp">
	</iframe>
</div>