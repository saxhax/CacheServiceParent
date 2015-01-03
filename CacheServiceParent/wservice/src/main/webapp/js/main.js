function goTo(link) {
	window.open(link, '_self', false);
}

function goToWithPromot(link) {
	var count = 0;
	while (count <= 0) {
		try {
			var element = document.getElementById("count");
			count = element.options[element.selectedIndex].value;
			if (count == NaN) {
				count = 2;
			}
		} catch (error) {
			//do nothing
		}
	}
	window.open(link + "&count=" + count, '_self', false);
}

function addBorderToLastRightSide(id) {
	document.getElementById(id).setAttribute("class", "border blackShadow bg radius");
}

function openIframe(iframe) {
	var element = document.getElementById(iframe);
	element.style.visibility = "visible";
}


function closeIframe(iframe) {
	var element = document.getElementById(iframe);
	element.style.visibility = "hidden";
}