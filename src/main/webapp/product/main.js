/**
 * 商品管理主管理JS
 */
//页面载入成功事件
$(document).ready(function(){
	var brandId =0;
	var productId = null;
	var kindsId = 0;
	var proName = null;
	var proState="";
	var startDate=null;
	var endDate=null;
	
	//填充下拉框
	$.getJSON("kinds/list/all.mvc",function(kindsList){
		//var options="<option value='0'>所有</option>"
		$.each(kindsList,function(index,kd){
			$("select#KindsSelection").append("<option value='"+kd.pro_kinds_id+"'>"+kd.pro_kinds_name+"</option>");
		});
	});
	
	//商品状态选框
	
	//事件更改
	function getParamAndReloadGrid(){
		 var datas={brandId:brandId,kindsId:kindsId,name:proName,proState:proState};
		 if (startDate!=null){
			 datas.startDate=startDate;
		 }
		 if(endDate!=null){
			 datas.endDate=endDate;
		 }
		 $("table#productGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
		
	}
	
	//品种下拉框更改事件
	$("select#KindsSelection").on("change",function(){
		kindsId=$("select#KindsSelection").val();
		getParamAndReloadGrid();
	});
	
	//状态选项更改事件
    $("input[type='radio'][name='pro_state']").on("change",function(){
    	proState=$(this).val();
  	  	getParamAndReloadGrid();
    
    });
	
	//名称框更改事件
	$("input#productName").on("change",function(){
		proName=$("input#productName").val();
		getParamAndReloadGrid();
	});
	

	
	//显示员工列表表格
    $("table#productGrid").jqGrid({
        url: 'product/list/condition/page.mvc',
        mtype: "POST",
		styleUI : 'Bootstrap',
        datatype: "json",
        colModel: [
            { label: '商品编号', name: 'pro_id', key: true, width: 120 },
            { label: '商品名称', name: 'pro_name', width: 120 },
            { label: '商品价格', name: 'pro_price', width: 120 },
            { label: '商品重量', name: 'pro_weight', width: 120 },
            { label: '商品数量', name: 'pro_count', width: 120 },
            { label: '商品种类', name: 'kinds.pro_kinds_name', width: 120 },
            { label: '商品状态', name: 'pro_state', width: 120 },
            { label: '商品品牌', name: 'brand.brand_name', width: 120 },
            { label: '商品图片', name: 'pro_photos_id', width: 120 },
            { label: '商品简介', name: 'pro_desc', width: 120 },
            { label: '更新日期', name: 'up_date', width: 120 }
        ],
        autowidth:true,
		viewrecords: true,
		width:"100%",
        height: 350,
        rowNum: 10,
        rowList:[2,5,10],
        pager: "#productGridPager",
        jsonReader : {
        	root:"rows",
        	page:"page",
        	total:"total",
        	records:"records",
        	repeatitems:true,
        	id:"pro_id"
        },
        multiselect:false,
        onSelectRow:function(id){
        	productId=id;
        	alert(productId);
        }
    });
    //增加事件按钮点击事件处理
    $("a#ProductAddLink").on("click",function(){
    	$("div#ProductDialog").load("product/add.html",function(productList){
    	   //取得种类表填充下拉框
    		$.getJSON("kinds/list/all.mvc",function(kindsList){
    			//var options="<option value='0'>所有</option>"
    			$.each(kindsList,function(index,kd){
    				
    				$("select[name='kinds.pro_kinds_id']").append("<option value='"+kd.pro_kinds_id+"'>"+kd.pro_kinds_name+"</option>");
    			});
    		});
    		//取得品牌表生成品牌复选框
    		$.getJSON("product/list/all/withoutkinds.mvc",function(productList){
				$.each(productList,function(index,pd){
					$("div#BrandCheckboxArea").append("<label class='checkbox-inline'><input type='checkbox' name='brand_id' value='"+pd.brand_id+"'>"+rm.name+"</label>");
				});	
    		});
    		//使用jQuery validate对商品进行数据验证
			$("form#ProductAddForm").validate({
				rules:{
					/*pro_id:{
						required:true,
						remote:{
							url:"product/checkIDCanBeUsed.mvc",
							type:"POST",
							data:{
								productId:function(){
									return $("input[name='pro_id']");
								}
							}
						}
					
					
					},*/
					
					pro_name:{
						required:true	
					},
					
					pro_price:{
						required:true,
						number:true

					},
					pro_weight:{
						required:true,
						number:true,
					},
					pro_count:{
						required:true,
						digits:true
					},
					up_date:{
						required:true
					},
					pro_desc:{
						required:true
					}
				
					
				},
				messages:{
					pro_name:{
						required:"商品名称为空"
					},
					
					pro_price:{
						required:"商品价格为空",
						number:"价格必须为数值"

					},
					pro_weight:{
						required:"商品重量为空",
						number:"重量必须为数值"
					},
					pro_count:{
						required:"商品数量为空",
						digits:"数量必须为整数"
					},
					up_date:{
						required:"商品日期为空",
					},
					pro_desc:{
						required:"商品简介为空",
					}
					
				}
			});
    		
    		
    		
    		//拦截增加表单提交
    		$("form#ProductAddForm").ajaxForm(function(result){
    			alert(result.message);
    			getParamAndReloadGrid(); //重新载入商品列表，并刷新Grid显示。
    			$("div#ProductDialog").dialog("close"); //关闭弹出Dialog
    			
    		});
    		//定义取消连接点击事件处理
    		$("a#ProductAddCancelLink").on("click",function(){
    			$("div#ProductDialog").dialog("close"); //关闭弹出Dialog
    		});
    		
    	});

		
    	$("div#ProductDialog").dialog({
    	  	title:"增加商品",
        	width:500,
        	hight:1000
    	});
  
    });
    
    //修改商品按钮点击事件处理
    $("a#ProductModifyLink").on("click",function(){
    	if(productId==null){
    		BootstrapDialog.show({
    			title:"商品操作提示",
    			message:"<h4>请选择要修改的商品</h4>",
    			buttons:[{
    				label:'关闭',
    				action:function(dialog){
    					dialog.close();
    				}
    			}]
    		})
    	}
    	else{
        	$("div#ProductDialog").load("product/modify.html",function(productList){
         	   //取得种类表填充下拉框
         		$.getJSON("kinds/list/all.mvc",function(kindsList){
         			//var options="<option value='0'>所有</option>"
         			$.each(kindsList,function(index,kd){
         				
         				$("select[name='kinds.pro_kinds_id']").append("<option value='"+kd.pro_kinds_id+"'>"+kd.pro_kinds_name+"</option>");
         			});
         		});
     			//取得商品的信息，填充员工修改表单元素
				$.getJSON("product/get/id/withkindsandbrand.mvc",{productId:productId},function(pd){
					$("input[name='pro_id']").val(pd.pro_id);
					$("input[name='pro_name']").val(pd.pro_name);
					$("input[name='pro_price']").val(pd.pro_price);
					$("input[name='pro_weight']").val(pd.pro_weight);
					$("input[name='pro_count']").val(pd.pro_count);
					$("input[name='pro_state'][value='"+pd.pro_state+"']").attr("checked","checked");
					$("input[name='brand.brand_id']").val(pd.brand.brand_id);
					$("input[name='pro_photos_id']").val(pd.pro_photos_id);
					$("input[name='pro_desc']").val(pd.pro_desc);
					$("input[name='up_date']").val(pd.up_date);
					//选中种类的商品
					$("select[name='kinds.pro_kinds_id']").val(pd.kinds.pro_kinds_id);
					//biao
				});
     		
         		//使用jQuery validate对商品进行数据验证
     			$("form#ProductModifyForm").validate({
     				rules:{
//     					pro_id:{
//     						required:true,
//     						remote:"product/checkIDCanBeUsed.mvc"
//     					},
     					
     					pro_name:{
     						required:true	
     					},
     					
     					pro_price:{
     						required:true,
     						number:true

     					},
     					pro_weight:{
     						required:true,
     						number:true,
     					},
     					pro_count:{
     						required:true,
     						digits:true
     					},
     					up_date:{
     						required:true
     					},
     					pro_desc:{
     						required:true
     					}
     				
     					
     				},
     				messages:{
     					pro_name:{
     						required:"商品名称为空"
     					},
     					
     					pro_price:{
     						required:"商品价格为空",
     						number:"价格必须为数值"

     					},
     					pro_weight:{
     						required:"商品重量为空",
     						number:"重量必须为数值"
     					},
     					pro_count:{
     						required:"商品数量为空",
     						digits:"数量必须为整数"
     					},
     					up_date:{
     						required:"商品日期为空",
     					},
     					pro_desc:{
     						required:"商品简介为空",
     					}
     					
     				}
     			});
         		
     			$("div#ProductDialog").dialog({
     	    	  	title:"修改商品",
     	        	width:500,
     	        	hight:1000
     	    	});
         		
         		
         		//拦截增加表单提交
         		$("form#ProductModifyForm").ajaxForm(function(result){
         			alert(result.message);
         			getParamAndReloadGrid(); //重新载入商品列表，并刷新Grid显示。
         			$("div#ProductDialog").dialog("close"); //关闭弹出Dialog
         			
         		});
         		//定义取消连接点击事件处理
         		$("a#ProductModifyCancelLink").on("click",function(){
         			$("div#ProductDialog").dialog("close"); //关闭弹出Dialog
         		});
         		
         	});
    		
    	}	
    });
    
	//删除订单按钮事件处理
    $("a#ProductDeleteLink").on("click",function(){

    		if(productId == null){
    			BootstrapDialog.show({
        			title:"订单操作提示",
        		    message:"<h4>请选择要删除的订单</h4>",
        				buttons:[{
        				label:'关闭'	,
        				action:function(dialog){
        					dialog.close();
        			      	 }	
                 		  }
        				] 
        		});  
    			
    		}else{ 
    			
    			BootstrapDialog.confirm('确认要删除此订单吗?', function(confirmResult){
    			
        			if(confirmResult){
        			    $.post("product/delete.mvc",{pro_id:productId},function(result){
	        			  if(result=="ok"){
	        				   alert("删除订单成功");
	        			  }
	        			  else{
	        				  alert("删除订单失败");
	        			  }
        			    });
    			    } 
        			getParamAndReloadGrid();
    			});
    		}	
    });
 // 
    //查看商品事件处理
    $("a#ProductViewLink").on("click",function(){
        
		if(productId==0){
			alert("请选择要查看的订单!");
			
		}
		else{
			
			$("div#ProductDialog").load("product/view.html",function(){
				$("div#ProductDialog").dialog({
            		title:"查看订单",
            	width:900,
            	heigth:650   
            	});
		    	 $.getJSON("product/get/id/withkindsandbrand.mvc",{productId:productId},function(resultData){
		    		    $("span#productId").html(resultData.pro_id);
		    		    $("span#productName").html(resultData.pro_name);
		 				$("span#productPrice").html(resultData.pro_price);
		 				$("span#productWeight").html(resultData.pro_weight);
		 				$("span#productCount").html(resultData.pro_count);
		 				$("span#productKinds").html(resultData.kinds.pro_kinds_name);
		 				$("span#productState").html(resultData.pro_state); 
		 				$("span#productBrand").html(resultData.brand.brand_name); 
		 				$("span#productPhotos").html(resultData.pro_photos_id); 
		 				$("span#productDesc").html(resultData.pro_desc); 
		 				$("span#productUpdate").html(resultData.up_date); 
		    	 });
		    	   $("button#ProductCancelButton").on("click",function(){
		    			$("div#ProductDialog").dialog("close"); //关闭弹出Dialog
		    		
		    	   });
    		});
		 } 		
    });
});
