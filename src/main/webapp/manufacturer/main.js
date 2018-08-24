/**
 *  品牌商信息主页管理JS
 *  author：温万龙
 */

$(document).ready(function(){
	var manufacturerId = 0;
	
	function showManufacturerList(){
		
		$("div#manufacturer-content").load("manufacturer/list.html",function(){
			//按钮响应事件添加
			addLinkClick();
			modifyLinkClick();
			deleteLinkClick();
			viewLinkClick();
			
			//获取JSON数据
			$.getJSON("manufacturer/toListByAll.mvc",function(manufacturerList){
				var lines="";
				for(var i=0;i<manufacturerList.length;++i){
					lines=lines+"<tr data-id='"+manufacturerList[i].id+"'>"+
						"<td>"+manufacturerList[i].no+"</td>"+
						"<td>"+manufacturerList[i].name+"</td>"+
						"<td>"+manufacturerList[i].phone+"</td>"+
						"<td>"+manufacturerList[i].address+"</td>"+
						"<td>"+manufacturerList[i].mdesc+"</td>"+
						"</tr>";
		        	$("div#manufacturer-content table tbody").html(lines);
		        	
		        	//点击行信息响应事件
		        	$("div#manufacturer-content table tbody tr").on("click",function(){
		        		manufacturerId = $(this).attr("data-id");
		        		$("div#manufacturer-content table tbody tr").css('background-color','#FFFFFF');
		        		$(this).css('background-color','#F5F5F5');
		        	});
				}
			});
		});
		
		
	}
	
	showManufacturerList();
	
	//添加按钮-绑定响应事件
	function addLinkClick(){
		$("a#addManufacturerLink").on("click",function(){
			
			//主页添加按钮响应-跳转
			$("div#manufacturer-content").load("manufacturer/add.html",function(event){
				
				//添加页面，添加按钮响应
				$("button#addManufacturerBut").on("click",function(){
					var no = $("input[name='no']").val();
					var name = $("input[name='name']").val();
					var address = $("input[name='address']").val();
					var phone = $("input[name='phone']").val();
					var mdesc = $("textarea[name='mdesc']").val();
					var log = $("input[name='log']").val();
					//发送请求，添加员工
					$.post("manufacturer/add.mvc",{no:no,name:name,address:address,phone:phone,mdesc:mdesc,log:log},function(resultData){
						if(resultData=="ok"){
							alert("添加品牌商成功");
							showManufacturerList();
						}else{
							alert("添加品牌商失败");
						}
					});
					
				});
				
				//返回按钮响应
				$("button#backManufacturerBut").on("click",function(){
					showManufacturerList();
				});
			});
			
			
		});
	}

	//修改按钮-绑定响应事件
	function modifyLinkClick(){
		$("a#modifyManufacturerLink").on("click",function(){
			if(manufacturerId==0){
				BootstrapDialog.show({
	    			title:"品牌商操作提示",
	    		    message:"<h4>请选择要修改的品牌商</h4>",
	    				buttons:[{
	    				label:'关闭'	,
	    				action:function(dialog){
	    					dialog.close();
	    			      	 }	
	             		  }
	    				] 
	    		});  	
			}else{
				//修改页面-跳转
				$("div#manufacturer-content").load("manufacturer/modify.html",function(){
					
					//回显数据
					$.getJSON("manufacturer/getManuById.mvc",{id:manufacturerId},function(resuletData){
						$("input[name='no']").val(resuletData.no);
						$("input[name='name']").val(resuletData.name);
						$("input[name='address']").val(resuletData.address);
						$("input[name='phone']").val(resuletData.phone);
						$("textarea[name='mdesc']").val(resuletData.mdesc);
						$("input[name='log']").val(resuletData.log);
					});
					
					//修改按钮响应事件
					$("button#modifyManufacturerBut").on("click",function(){
						
						var no = $("input[name='no']").val();
						var name = $("input[name='name']").val();
						var address = $("input[name='address']").val();
						var phone = $("input[name='phone']").val();
						var mdesc = $("textarea[name='mdesc']").val();
						var log = $("input[name='log']").val();

						//发送修改请求
						$.post("manufacturer/modify.mvc",{id:manufacturerId,no:no,name:name,address:address,phone:phone,mdesc:mdesc,log:log},function(resultData){
							if(resultData=="ok"){
								alert("修改品牌商成功");
								showManufacturerList();
							}else{
								alert("修改品牌商失败");
							}
						});
					});
					
					//返回按钮响应
					$("button#backManufacturerBut").on("click",function(){
						showManufacturerList();
					});
				});
			}
		});
	}
	
	//删除按钮-绑定响应事件
	function deleteLinkClick(){
		$("a#deleteManufacturerLink").on("click",function(){
			if(manufacturerId==0){
				BootstrapDialog.show({
	    			title:"品牌商操作提示",
	    		    message:"<h4>请选择要删除的品牌商</h4>",
	    				buttons:[{
	    				label:'关闭'	,
	    				action:function(dialog){
	    					dialog.close();
	    			      	 }	
	             		  }
	    				] 
	    		});  
				
				}else{ 
					alert(manufacturerId);
				
				//检查选择的品牌商是否可以被删除
				$.getJSON("manufacturer/checkcandelete.mvc",{man_id:manufacturerId},function(checkResult){
				
					if(checkResult.status=='N'){
						BootstrapDialog.show({
			    			title:"品牌商操作提示",
			    		    message:"<h5>"+checkResult.message+"</h5>",
			    				buttons:[{
			    				label:'关闭'	,
			    				action:function(dialog){
			    					dialog.close();
			    			      	 }	
			             		  }
			    				] 
			    		});
					}else{
						//可以删除
						BootstrapDialog.confirm('确认要删除此品牌商吗?', function(result){
		
						if(result){
							$.post("manufacturer/delete.mvc",{id:manufacturerId},function(resultData){
								if(resultData=="ok"){
									alert("删除品牌商成功");
									showManufacturerList();
								}else{
									alert("删除品牌商失败");
								}
								showManufacturerList();
							});
						}
						});
					}
				});
				
		
			
			}
		});
	}
	
	//查看按钮-绑定响应事件
	function viewLinkClick(){
		//查看按钮响应
		$("a#viewManufacturerLink").on("click",function(){
			if(manufacturerId==0){
				alert("请选择要查看的品牌商");
			}else{
				$("div#manufacturer-content").load("manufacturer/view.html",function(){
					//显示数据
					$.getJSON("manufacturer/getManuById.mvc",{id:manufacturerId},function(resuletData){
						$("a#viewNo").text("品牌商编号："+resuletData.no);
						$("a#viewName").text("品牌商名称："+resuletData.name);
						$("a#viewPhone").text("品牌商电话："+resuletData.phone);
						$("a#viewAddress").text("品牌商地址："+resuletData.address);
						$("textarea[name='mdesc']").val(resuletData.mdesc);
					});
					
					//显示信息页面，返回按钮响应
					$("button#backManufacturerBut").on("click",function(){
						showManufacturerList();
					});
				});
			}	
		});
		
		
	}
});
