/**
 * 系统的转管理JS
 * 作者：帅
 */


$(document).ready(function(){
	//页面的操作代码区
	$("ul#side-menu li ul li a").on("click",function(event){
		var href=$(this).attr("href");
		$("div#maincontent").load(href);
		event.preventDefault();
	})
});