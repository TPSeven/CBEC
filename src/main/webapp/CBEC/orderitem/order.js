/**
 * 
 */


$(document).ready(function(){
 $.getJSON("../orderitem/getListByAll.mvc",function(orderitemList){
	alert(orderitemList) ;
	 
 });
 
alert("ok");

});
