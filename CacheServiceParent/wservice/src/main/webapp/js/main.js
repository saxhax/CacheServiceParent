var array = new Array();
var rows = new Array();

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
	try {
		document.getElementById(id + "Right").setAttribute("class", "border blackShadow bg radius");
		} catch (error){}
	try {
		document.getElementById(id + "Menu").style.background="#888";
		} catch (error){}
	
}

function openIframe(iframe) {
	var element = document.getElementById(iframe);
	element.style.visibility = "visible";
}


function closeIframe(iframe) {
	var element = document.getElementById(iframe);
	element.style.visibility = "hidden";
}

angular.module('getValuesFilterModule', []).
  controller('getValuesController', ['filterFilter', function(filterFilter) {
    this.filteredArray = function(value, row) {
    	return filterFilter(array[row], value);
    };
    this.rows = function() {
        return rows;
      };
  }]);