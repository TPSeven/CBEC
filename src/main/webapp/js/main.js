/**
 *  系统的主管理JS
 *  author：温万龙
 */
$(document).ready(function(){
	//菜单链接点击事件
	$("ul#manufacturer-content li a,ul#admin-content li a").on("click",function(event){
		var href = $(this).attr("href");
		
		//载入href指定页面到主页的maincontent区域
		$("div#maincontent").load(href);
		//阻止默认跳转
		event.preventDefault();
	});
	
});

jQuery.ajaxSettings.traditional = true; 
