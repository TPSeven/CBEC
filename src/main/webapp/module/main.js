/**
 *  系统模块管理JS
 *  author：温万龙
 */

$(document).ready(function(){
	var moduleNo = 0;
	//首页链接事件绑定
	$("a#home").on("click",function(){
		//加载home主页
		$("div#maincontent").load("home/main.html");
	});
	
	//显示模块列表
	$("table#moduleGrid").jqGrid({
		url:"module/list.mvc",
		mtype:"GET",
		styleUI : 'Bootstrap',
     	datatype: "json",
     	colModel: [
    		{ label: '模块编号', name: 'no', width: 100 },
        	{ label: '模块名称', name: 'name', width: 100 },
        ],
        autowidth:true,
	 	viewrecords: true,
     	width: "100%",
	 	height: 350,
     	rowNum: 10,
     	rowList:[1,3,5,7],
         	multiselect:false,
        	onSelectRow:function(no){
        		moduleNo = no;
     		},
     	pager: "#moduleGridPager",
	});
	
	//刷新模块列表
	function reloadModuleGrid(){
		$("table#moduleGrid").jqGrid().trigger("reloadGrid");
	}
	
	
	//添加按钮响应事件
	$("a#addModuleLink").on("click",function(){
		$("div#moduleDialog").load("module/add.html",function(){
			//表单验证
			$("form#addModuleForm").validate({
				rules:{
					no:{
						required:true,
						digits:true,
						min:1,
						remote:"module/checkModuleNo.mvc"
					},
					name:{
						required:true,
						rangelength:[3,10]
					}
				},
				messages:{
					no:{
						required:"请填写模块编号",
						digits:"请填写整数",
						min:"不能填写0",
						remote:"该模块编号已经存在"
					},
					name:{
						required:"请填写模块名称",
						rangelength:"模块名称长度为3~10"
					}
				}
			});
			
			//表单截取
			$("form#addModuleForm").ajaxForm(function(result){
				BootstrapDialog.show({
					title:"模块操作提示",
					message:result.message,
					buttons:[{
						label:'关闭',
						action:function(dialog){
							dialog.close();
						}
					}]
				});
				$("div#moduleDialog").dialog("close");
				if(result.status=="T"){
					//刷新模块列表
					reloadModuleGrid();
				}
				
			});
			
			//取消按钮-关闭窗口
			$("a#moduleCancelLink").on("click",function(){
				$("div#moduleDialog").dialog("close");
			});
		});

		//窗口设置
		$("div#moduleDialog").dialog({
				title:"添加新模块",
				width:500,
				height:300
		});
	});
	
	//修改按钮响应事件
	$("a#modifyModuleLink").on("click",function(){
		if(moduleNo==0){
			BootstrapDialog.show({
				title:"模块操作提示",
				message:"请选择一个模块",
				buttons:[{
					label:"关闭",
					action:function(dialog){
						dialog.close();
					}
				}]
			});
		}else{
			$("div#moduleDialog").load("module/modify.html",function(){
				//模块相关数据回显
				$.getJSON("module/get/byNo.mvc",{no:moduleNo},function(result){
					$("input[name='no']").val(result.no);
					$("input[name='no']").attr("readonly","readonly");
					$("input[name='name']").val(result.name);
				});
				
				//数据校验
				$("form#modifyModuleForm").validate({
					rules:{
						name:{
							required:true,
							rangelength:[3,10]
						}
					},
					messages:{
						name:{
							required:"请填写模块名称",
							rangelength:"模块名称长度为3~10"
						}
					}
				});
				
				//表单截取
				$("form#modifyModuleForm").ajaxForm(function(result){
					BootstrapDialog.show({
						title:"模块操作提示",
						message:result.message,
						buttons:[{ 
							label:"关闭",
							action:function(dialog){
								dialog.close();
							}
						}]
					});
					$("div#moduleDialog").dialog("close");
					if(result.status=="T"){
						//刷新模块列表
						reloadModuleGrid();
					}
				});
				
				//取消按钮-关闭窗口
				$("a#moduleCancelLink").on("click",function(){
					$("div#moduleDialog").dialog("close");
				});
				
			});
			
			$("div#moduleDialog").dialog({
				title:"修改模块",
				width:500,
				height:300
			});
		}
	});
	
	//删除按钮响应事件
	$("a#deleteModuleLink").on("click",function(){
		if(moduleNo==0){
			BootstrapDialog.show({
				title:"模块操作提示",
				message:"请选择一个模块",
				buttons:[{
					label:"关闭",
					action:function(dialog){
						dialog.close();
					}
				}]
			});
		}else{
			BootstrapDialog.show({
				title:"模块操作提示",
				message:"确定要删除吗？",
				buttons:[{
					label:"关闭",
					action:function(dialog){
						dialog.close();
					}
				},{
					label:"确定",
					action:function(dialog){
						$.post("module/delete.mvc",{no:moduleNo},function(deleteResult){
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
							//刷新模块列表
							if(deleteResult.status=="T") reloadModuleGrid();
						});
						dialog.close();	
					}
				}]
			});

		}
	});
	
});
