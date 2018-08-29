
$.ajaxSetup({
	traditional:true,
	cache:false
});

$(document).ready(function(){

	var orderitemInfo = null;
	//检测是否存在用户会话
	$.getJSON("orderitem/checklogin.mvc",function(result){
		if(result.status=="N"){
			window.location.href="loginzhm.html";
		}else{
			alert("ok");
			//取得登陆订单的信息
			$.getJSON("orderitem/getOrderitemInfoFromSession.mvc",function(orderitemdata){
				orderitemInfo = orderitemdata;
				
				$("span#loginorderitemid").html("<i class='fa fa-comment fa-fw'></i>"+"您好,"+orderitemInfo.order_id);
			});
		}
	});
	
	//菜单链接点击事件
	$("ul#manufacturer-content li a,ul#admin-content li a").on("click",function(event){
		var href = $(this).attr("href");
		
		//载入href指定页面到主页的maincontent区域
		$("div#maincontent").load(href);
		//阻止默认跳转
		event.preventDefault();
	});
	
	//用户登出
	$("a#orderitemlogoutlink").on("click",function(){
		
		BootstrapDialog.show({
			title:"提示",
			message:"确定要退出登陆吗？",
			buttons:[{
				label:"关闭",
				action:function(dialog){
					dialog.close();
				}
			},{
				label:"确定",
				action:function(){
					$.getJSON("orderitem/orderitemlogout.mvc",function(){
						location.href="loginzhm.html";
					});
				}
			}]
		});
	});
	
});


