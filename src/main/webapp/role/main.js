/**
 *  角色管理JS
 *  author：温万龙
 */

$(document).ready(function(){
	var roleId = 0;
	//首页链接事件绑定
	$("a#home").on("click",function(){
		//加载home主页
		$("div#maincontent").load("home/main.html");
	});
	
	//显示角色列表
	$("table#roleGrid").jqGrid({
		url:"role/list.mvc",
		mtype:"GET",
		styleUI : 'Bootstrap',
     	datatype: "json",
     	colModel: [
    		{ label: '角色ID', name: 'id', width: 100 },
        	{ label: '角色名称', name: 'name', width: 100 },
        ],
        autowidth:true,
	 	viewrecords: true,
     	width: "100%",
	 	height: 350,
     	rowNum: 10,
     	rowList:[1,3,5,7],
         	multiselect:false,
        	onSelectRow:function(id){
        		roleId = id;
     		},
     	pager: "#roleGridPager",
	});
	
	//刷新角色列表
	function reloadRoleGrid(){
//		$("table#userGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
		$("table#roleGrid").jqGrid().trigger("reloadGrid");
	}
	
	
	//添加按钮响应事件
	$("a#addRoleLink").on("click",function(){
		$("div#roleDialog").load("role/add.html",function(){
			//表单验证
			$("form#addRoleForm").validate({
				rules:{
					id:{
						required:true,
						digits:true,
						min:1,
						remote:"role/checkRoleId.mvc"
					},
					name:{
						required:true,
						rangelength:[3,10]
					}
				},
				messages:{
					id:{
						required:"请填写角色ID",
						digits:"请填写整数",
						min:"不能填写0",
						remote:"该角色ID已经存在"
					},
					name:{
						required:"请填写角色名称",
						rangelength:"角色名称长度为3~10"
					}
				}
			});
			
			//表单截取
			$("form#addRoleForm").ajaxForm(function(result){
				BootstrapDialog.show({
					title:"角色操作提示",
					message:result.message,
					buttons:[{
						label:'关闭',
						action:function(dialog){
							dialog.close();
						}
					}]
				});
				$("div#roleDialog").dialog("close");
				//刷新角色列表
				reloadRoleGrid();
			});
			
			//取消按钮-关闭窗口
			$("a#roleCancelLink").on("click",function(){
				$("div#roleDialog").dialog("close");
			});
		});

		//窗口设置
		$("div#roleDialog").dialog({
				title:"添加新角色",
				width:500,
				height:300
		});
	});
	
	//修改按钮响应事件
	$("a#modifyRoleLink").on("click",function(){
		if(roleId==0){
			BootstrapDialog.show({
				title:"角色操作提示",
				message:"请选择一个角色",
				buttons:[{
					label:"关闭",
					action:function(dialog){
						dialog.close();
					}
				}]
			});
		}else{
			$("div#roleDialog").load("role/modify.html",function(){
				//角色相关数据回显
				$.getJSON("role/get/byId.mvc",{id:roleId},function(result){
					$("input[name='id']").val(result.id);
					$("input[name='id']").attr("disabled","disabled");
					$("input[name='name']").val(result.name);
				});
				
				//数据校验
				$("form#modifyRoleForm").validate({
					rules:{
						name:{
							required:true,
							rangelength:[3,10]
						}
					},
					messages:{
						name:{
							required:"请填写角色名称",
							rangelength:"角色名称长度为3~10"
						}
					}
				});
				
				//表单截取
				$("form#modifyRoleForm").ajaxForm(function(result){
					BootstrapDialog.show({
						title:"角色操作提示",
						message:result.message,
						buttons:[{ 
							label:"关闭",
							action:function(dialog){
								dialog.close();
							}
						}]
					});
					$("div#roleDialog").dialog("close");
					//刷新角色列表
					reloadRoleGrid();
				});
				
				//取消按钮-关闭窗口
				$("a#roleCancelLink").on("click",function(){
					$("div#roleDialog").dialog("close");
				});
				
			});
			
			$("div#roleDialog").dialog({
				title:"修改角色",
				width:500,
				height:300
			});
		}
	});
	
	//删除按钮响应事件
	$("a#deleteRoleLink").on("click",function(){
		if(roleId==0){
			BootstrapDialog.show({
				title:"角色操作提示",
				message:"请选择一个角色",
				buttons:[{
					label:"关闭",
					action:function(dialog){
						dialog.close();
					}
				}]
			});
		}else{
			BootstrapDialog.show({
				title:"角色操作提示",
				message:"确定要删除吗？",
				buttons:[{
					label:"关闭",
					action:function(dialog){
						dialog.close();
					}
				},{
					label:"确定",
					action:function(dialog){
						$.post("role/delete.mvc",{id:roleId},function(deleteResult){
							BootstrapDialog.show({
								title:"删除操作提示",
								message:deleteResult.message,
								buttons:[{
									label:"关闭",
									action:function(dialog){
										dialog.close();
									}
								}]
							});
							//刷新角色列表
							if(deleteResult.status=="T") reloadRoleGrid();
						});
						dialog.close();	
					}
				}]
			});

		}
	});
	
});
