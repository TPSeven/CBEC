/**
 *  系统的主管理JS-加入用户登陆模块
 *  author：温万龙
 */
$.ajaxSetup({
	traditional:true,
	cache:false
});

$(document).ready(function(){
	var userInfo = null;
	//检测是否存在用户会话
	$.getJSON("user/checkLogin.mvc",function(result){
		if(result.status=="N"){
			window.location.href="loginWwl.html";
		}else{
			//取得登陆用户的信息
			$.getJSON("user/getLoginUser.mvc",function(userModel){
				userInfo = userModel;
				$("a#loginUserName").html("<i class='fa fa-comment fa-fw'></i>"+"您好,"+userInfo.name);
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
	$("a#userLoginoutLink").on("click",function(){
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
					$.getJSON("user/userLogout.mvc",function(){
						location.href="loginWwl.html";
					});
				}
			}]
		});
	});
	
});


