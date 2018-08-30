/*
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
	$.getJSON("login/checkLogin.mvc",function(result){
		if(result.status=="N"){
			window.location.href="login/main.html";
		}else{
			//取得登陆用户的信息
			$.getJSON("login/getLoginUser.mvc",function(userModel){
				userInfo = userModel;
				$("a#loginUserName").html("<i class='fa fa-comment fa-fw'></i>"+"您好,"+userInfo.name);
				
				//取得用户的授权模块以及功能 --避免异步取不到id
				$.getJSON("user/get/grandModlesAndFunctions.mvc",{id:userInfo.id},function(modules){
					if(modules!=null){
						var mlist = "";
						//遍历模块
						$.each(modules,function(index,module){
							mlist += "<li><a href='#'><i class='fa fa-wrench fa-fw'></i>"+module.name+"<span class='fa arrow'></span></a>";
								//子功能的判断与遍历
								if(module.functions!=null){
									mlist += "<ul class='nav nav-second-level' >";
									$.each(module.functions,function(index,fun){
										mlist += "<li><a href='"+fun.url+"'>"+fun.name+"</a></li>"
									});
									mlist += "</ul>";
								}
							mlist += "</li>";
						});
						$("ul#side-menu").append(mlist);
						$('ul#side-menu').metisMenu();//收缩菜单
					}
					
					//菜单点击响应事件-页面内跳转
					$("ul#side-menu li ul li a").on("click",function(event){
						var href = $(this).attr("href");
						
						//载入href指定页面到主页的maincontent区域
						$("div#maincontent").load(href);
						//阻止默认跳转
						event.preventDefault();
					});
				});
				
				
			});
			
			
			
		}
	});
	
	//加载home主页
	$("div#maincontent").load("home/main.html");
	
	//主页链接点击响应事件
	$("ul#side-menu li a[href='indexWwl.html']").on("click",function(event){
		$("div#maincontent").load("home/main.html");
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
					$.getJSON("login/userLogout.mvc",function(){
						location.href="login/main.html";
					});
				}
			}]
		});
	});
	
});


