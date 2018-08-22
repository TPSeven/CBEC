/**
 *  用户信息主页管理JS
 *  author：温万龙
 */

$(document).ready(function(){
	var userId = 0; 
	var userSex = null;
	var userName = null;
	var userPhone = null;
	var startDate = null;
	var endDate = null;
	var lowerAge = null;
	var upperAge = null;
	var roleIds = null;
	
	//加载用户列表
	function showManufacturerList(){
		$("div#user-content").load("user/list.html",function(){
			
			//获取JSON数据 显示员工列表表格
			$("table#userGrid").jqGrid({
				url: 'user/list/role/byCondition/page.mvc',
	         	mtype: "GET",
			 	styleUI : 'Bootstrap',
	         	datatype: "json",
	         	colModel: [
	        		{ label: '名称', name: 'name',width: 60 },
	            	{ label: '密码', name: 'password', width: 60 },
		            { label: '性别', name: 'sex', width: 30 },
		            { label: '年龄', name: 'age', width: 30 },
		            { label:'生日', name: 'birthday', width: 60 },
		            { label: '邮箱', name: 'email', width: 80 },
		            { label: '电话', name: 'phone', width: 80 },
		        ],
	        	autowidth:true,
			 	viewrecords: true,
	         	width: "100%",
			 	height: 350,
	         	rowNum: 15,
	         	rowList:[1,3,5,7],
	         	multiselect:false,
	        	onSelectRow:function(id){
	        		userId = id;
//	        		alert(userId);
         		},
	         	pager: "#userGridPager",
			});
		});
	}
	
	//设置请求参数，载入Grid数据，刷新Grid
	function setParamAndReloadGrid(){
		var datas = {userName:userName,userSex:userSex,userPhone:userPhone,lowerAge:lowerAge,upperAge:upperAge};
		
		if(startDate!=null){
			datas.startDate=startDate;
		}
		if(endDate!=null){
			datas.endDate=endDate;
		}
		
		if(roleIds!=null){
			datas.roleIds=roleIds;
		}
		//清空postData
	    var postData = $("table#userGrid").jqGrid("getGridParam","postData");
        $.each(postData, function (k, v) {
            delete postData[k];
        });                    
		$("table#userGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
		
		//强制清空postData
//		$("table#userGrid").jqGrid("setGridParam",{postData:null}).trigger("reloadGrid");
		
	}
	
	
	showManufacturerList();
	
	//===加载检索条件菜单===
	//取得角色列表，生成角色复选框	
	$.getJSON("role/list.mvc",function(roleList){
		$.each(roleList,function(index,rl){
			$("div#roleCheckboxArea").append("<label class='radio-inline'>"+"<input type='checkbox' name='roles' value='"+rl.id+"'>"+rl.name);
		});
		
		//角色复选框点击事件处理
		$("input[type='checkbox'][name='roles']").on("click",function(){
			//创建保存选中角色编号的数组
			roleIds=new Array();
			//取得选中的角色
			$("input[type='checkbox'][name='roles']:checked").each(function(index,role){
				//通过$(this) 或 $(role)取得选中的复选框
				roleIds.push($(role).val());
			});
			setParamAndReloadGrid();
		});
		
	});
	
	
	//===检索条件菜单事件处理===
	//名称检索
	$("input#userName").on("change",function(){
		userName = $("input#userName").val();
		setParamAndReloadGrid();
	});
	
	//电话检索
	$("input#userPhone").on("change",function(){
		userPhone = $("input#userPhone").val();
		setParamAndReloadGrid();
	});
	
	//起始日期更改事件处理
	$("input#startBirDate").on("change",function(){
		startDate=$("input#startBirDate").val();
		setParamAndReloadGrid();
	});
	
	//截止日期更改事件处理
	$("input#endBirDate").on("change",function(){
		endDate=$("input#endBirDate").val();
		setParamAndReloadGrid();
	});
	
	//最小年龄更改事件处理
	$("input#lowerAge").on("change",function(){
		lowerAge=$("input#lowerAge").val();
		setParamAndReloadGrid();
	});
	
	//最大年龄更改事件处理
	$("input#upperAge").on("change",function(){
		upperAge=$("input#upperAge").val();
		setParamAndReloadGrid();
	});
	
	//性别检索
	$("input[type='radio'][name='userSex']").on("change",function(){
		userSex=$(this).val();
		setParamAndReloadGrid();
	});
	
	//===增删改查按钮事件处理===
	//增加
	$("a#addUserLink").on("click",function(){
		$("div#userDialog").load("user/add.html",function(){
			//取得角色列表，填充复选框
			$.getJSON("role/list.mvc",function(roleList){
				$.each(roleList,function(index,rl){
					$("div#addRoleCheckboxArea").append("<label class='radio-inline'>"+"<input type='checkbox' name='addRoles' value='"+rl.id+"'>"+rl.name);
				});
			});
			
			//验证--使用JQueryValidate对员工进行数据验证
			$("form#addUserForm").validate({
				rules:{
					name:{
						required:true,
						remote:"user/checkNameCanBeUsed.mvc",
						rangelenghtForCBEC:[4,15]
					},
					password:{
						required:true,
						checkpassword:true
					},
					repassword:{
						equalTo:"input[name='password']",
					},
					age:{
						digits:true,
					 	range:[18,60]
					},
					birthday:{
						required:true
					},
					phone:{
						mobile:true
					},
					email:{
						required:true,
						remote:{
							url:"user/checkEmailCanBeUsed.mvc",
							type:"POST",
							data:{
								userEmail:function(){
									return $("input[name='email']").val();
								}
							}
						},
					 	email:true
					},
					joinDate:{
						required:true
					},
					portrait:{
						accept:"image/*"
					}
				},
				messages:{
					name:{
						required:"账号不能为空",
						remote:"用户名称已经被注册",
						rangelenghtForCBEC:"账号长度为4~15位"
					},
					password:{
						required:"密码账号不能为空",
						rangelength:"密码长度为6~8位"
					},
					repassword:{
						equalTo:"两次密码不一致",
					},
					age:{
						digits:"年龄必须为整数",
					 	range:"年龄范围为18~60"
					},
					birthday:{
						required:"生日不能为空"
					},
					email:{
						required:"邮箱不能为空",
						remote:"该邮箱已经被注册",
						email:"邮件名称不合法"
					},
					joinDate:{
						required:"注册日期为空"
					},
					portrait:{
						accept:"文件类型必须为图片"
					}
				}
			});
			
			//拦截表单提交导致的页面跳转
			$("form#addUserForm").ajaxForm(function(result){
				alert(result.message);
				//重新获得检索参数，刷新Grid，显示
				setParamAndReloadGrid();
				$("div#userDialog").dialog("close");
			});
			
			//取消按钮点击事件处理
			$("a#userCancelLink").on("click",function(){
				$("div#userDialog").dialog("close");
			});
		});
		
		$("div#userDialog").dialog({
			title:"添加新用户",
			width:500,
			height:600
		});
	});
	
	
	
	//修改
	$("a#modifyUserLink").on("click",function(){
		if(userId==0){
//			alert("请选择一个用户！");
			BootstrapDialog.show({
				title:"用户操作提示",
				message:"<h5>请选择一个用户</h5>",
				buttons:[{
					label:'关闭',
					action:function(dialog){
						dialog.close();
					}
				}]
			});
		}else{
			
			
			//修改页面-跳转
			$("div#userDialog").load("user/modify.html",function(){
				//取得角色列表，生成复选框
				$.getJSON("role/list.mvc",function(roleList){
					$.each(roleList,function(index,rl){
						$("div#modifyRoleCheckboxArea").append("<label class='radio-inline'>"+"<input type='checkbox' name='modifyRoles' value='"+rl.id+"'>"+rl.name);
					});
					//回显数据
					$.getJSON("user/get.mvc",{id:userId},function(resuletData){
						$("input[name='id']").val(userId);
						$("input[name='name']").val(resuletData.name);
						$("input[name='sex']").val(resuletData.sex);
						$("input[name='password']").val(resuletData.password);
						$("input[name='repassword']").val(resuletData.password);
						$("input[name='age']").val(resuletData.age);
						$("input[name='birthday']").val(resuletData.birthday);
						$("input[name='phone']").val(resuletData.phone);
						$("input[name='email']").val(resuletData.email);
						$("input[name='joinDate']").val(resuletData.joinDate);
						if(resuletData.roles!=null&&resuletData.roles.length>0){
							$.each(resuletData.roles,function(index,role){
								$("input[type='checkbox'][name='modifyRoles'][value='"+role.id+"']").attr("checked","checked");
							});
						}
						$("textarea[name='desc']").val(resuletData.desc);
					});
				});
				
				
				//验证--使用JQueryValidate对员工修改数据验证
				$("form#modifyUserForm").validate({
					rules:{
						name:{
							required:true,
							remote:"user/checkNameCanBeUsed.mvc",
							rangelenghtForCBEC:[4,15]
						},
						password:{
							required:true,
							checkpassword:true
						},
						repassword:{
							equalTo:"input[name='password']",
						},
						age:{
							digits:true,
						 	range:[18,60]
						},
						birthday:{
							required:true
						},
						phone:{
							mobile:true
						},
						email:{
							required:true,
							remote:{
								url:"user/checkEmailCanBeUsed.mvc",
								type:"POST",
								data:{
									userEmail:function(){
										return $("input[name='email']").val();
									}
								}
							},
						 	email:true
						},
						joinDate:{
							required:true
						}
					},
					messages:{
						name:{
							required:"账号不能为空",
							remote:"用户名称已经被注册或无修改",
							rangelenghtForCBEC:"账号长度为4~15位"
						},
						password:{
							required:"密码账号不能为空",
							rangelength:"密码长度为6~8位"
						},
						repassword:{
							equalTo:"两次密码不一致",
						},
						age:{
							digits:"年龄必须为整数",
						 	range:"年龄范围为18~60"
						},
						birthday:{
							required:"生日不能为空"
						},
						email:{
							required:"邮箱不能为空",
							remote:"该邮箱已经被注册或无修改",
							email:"邮件名称不合法"
						},
						joinDate:{
							required:"注册日期为空"
						}
					}
				});
				
				//拦截表单提交导致的页面跳转
				$("form#modifyUserForm").ajaxForm(function(result){
					alert(result.message);
					//重新获得检索参数，刷新Grid，显示
					setParamAndReloadGrid();
					$("div#userDialog").dialog("close");
				});
				
				//取消按钮点击事件处理
				$("a#modifyCancelLink").on("click",function(){
					$("div#userDialog").dialog("close");
				});
				
			});			
			
			
			$("div#userDialog").dialog({
				title:"添加新用户",
				width:500,
				height:600
			});
		}
		
	});
	
	//删除
	$("a#deleteUserLink").on("click",function(){
		alert("3");
	});
	
	//查看
	$("a#viewUserLink").on("click",function(){
		alert("4");
	});
	
/*	取得角色列表，填充角色下拉框 
	$.getJSON("role/list.mvc",function(roleList){
		$.each(roleList,function(index,rl){
			$("select#roleSelection").append("<option value='"+rl.id+"'>"+rl.name+"</option>");
		});
	});
	//角色下拉框更改事件处理
	$("select#roleSelection").on("change",function(){
		roleId = $("select#roleSelection").val();
		alert(roleId);
		setParamAndReloadGrid();
	});*/
	
});
