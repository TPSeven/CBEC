/*
 * 登陆页面
 * author：Wwl 温万龙
 * */

$(document).ready(function(){
	//用户登陆输入信息验证
	$("form#userLoginForm").validate({
		rules:{
			email:{
				required:true
			},
			password:{
				required:true
			}
		},
		message:{
			email:{
				required:"请填入你的登陆邮箱"
			},
			password:{
				required:"请填入你的密码"
			}
		}
	});
	
	//拦截请求
	$("form#userLoginForm").ajaxForm(function(result){
		if(result.status=="N"){
			BootstrapDialog.show({
				title:"登陆提示",
				message:"邮箱或密码错误",
				buttons:[{
					label:"关闭",
					action:function(dialog){
						dialog.close();
					}
				}]
			});
		}else{
			//跳转到首页
			window.location.href="indexWwl.html";
		}
	});
});
