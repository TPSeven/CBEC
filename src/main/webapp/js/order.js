/**
 * 
 */



$(document).ready(function(){

	$("ul#order li a").on("click",function(event){
		var herf=$(this).attr("href");

		$("div#maincontent").load(herf);
		event.preventDefault();
	});


});