/**
 * 
 */



$(document).ready(function(){

	$("ul#admin-content li a").on("click",function(event){
		var herf=$(this).attr("href");
		$("div#maincontent").load(herf);
		event.preventDefault();
		
	});
	
 
});