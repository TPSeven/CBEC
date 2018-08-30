/**
 * 
 */
jQuery.ajaxSettings.traditional=true;
$.ajaxSetup({
	traditional:false,
	cache:false //close AJAX cache
  });

$(document).ready(function(){
	var o_id=0;
	var order_id=0;
	var man_id=0;
	var man_name="";
	var state="";
	var startDate=null;
	var endDate=null;
	
	//显示订单列表表格
    $("table#orderitemGrid").jqGrid({
        url: 'orderitem/listbyconditionwithpage.mvc',
        mtype: "GET",
		styleUI : 'Bootstrap',
        datatype: "json",
        colModel: [
            { label: '订单编号', name: 'order_id', key: true, width: 75 },
            { label: '产品编号', name: 'pro_id', width: 150 },
            { label: '产品数量', name: 'pro_id_count', width: 150 },
            { label: '制造商编号', name:'manufacture.id', width: 150 },
         // { label:'制造商名', name: 'manufacture.man_name', width: 150 },
            { label:'借卖方编号', name: 'seller_id', width: 150 },
            { label:'订单状态', name: 'state', width: 150 },
            { label:'订单日期', name: 'order_date', width: 150 }
        ],
        autowidth:true,
		viewrecords: true,
        height: 400,
        rowNum: 10,
        rowList:[2,10,15,20],
        pager: "#orderitemGridPager",
        	  jsonReader : {
                  root: "rows",  //指定数据列表
                  page: "page",
                  total: "total",
                  records: "records",
                  repeatitems: true,
                  id: "id"
              },
              multiselect:false,
              onSelectRow:function(id){
             	o_id=id;
             	
              }
              
    });
	
//取得订单更改事件
	
function getParamAndReloadGrid(){
	 var datas={order_id:order_id,man_name:man_name,man_id:man_id,state:state};
	 if (startDate!=null){
		 datas.startDate=startDate;
	 }
	 if(endDate!=null){
		 datas.endDate=endDate;
	 }
	 //清除累积的参数
	 var postData = $('table#orderitemGrid').jqGrid("getGridParam","postData");
	 $.each(postData, function(k,v){
		 delete postData[k];
	 })
	 //设置新的参数
	 $("table#orderitemGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
	
}

//取得订单编号更改事件
$("input#order_id").on("change",function(){
	order_id=$("input#order_id").val();
	  getParamAndReloadGrid();
   
});
//取得姓名更改事件
     $("input#man_name").on("change",function(){
	    man_name=$("input#man_name").val();
	    getParamAndReloadGrid();
	 
});

   //起始日期更改事件处理
 	$("input#startDate").on("change",function(){
 		startDate=$("input#startDate").val();
 		getParamAndReloadGrid();
 	});
 	//截止日期更改事件处理
 	$("input#endDate").on("change",function(){
 		endDate=$("input#endDate").val();
 		getParamAndReloadGrid();
 	});
 	//制造商编号事件处理
     $("input#man_id").on("change",function(){
    	 man_id=$("input#man_id").val();
    	
    	 getParamAndReloadGrid();
 	  
 	 
 });
     //订单状态的选择更改事件处理
     $("input[type='radio'][name='state']").on("change",function(){
    	state=$(this).val();
    	
    	  getParamAndReloadGrid();
    	 //state=$("input[type='radio'][name='state']:checked").val();
     //  alert(state);
     
     });
  
     //增加订单按钮点击事件处理
     $("a#orderlistAddLink").on("click",function(){
    	
    	  
    	$("div#OrderItemDialog").load("orderitem/add.html", function(){
     	//嵌入增加页面
    		$("div#OrderItemDialog").dialog({
     		title:"增加新订单",
    	width:900,
    	heigth:650   
    	});
      //使用JQuery validate对订单进行数据验证
    		
    		$("form#addorderitemForm").validate({
    			rules:{
    			order_id:{
        				required:true,
        				//rangelength:[1,10],
        				rangelengthforOA:[1,10],
    		            remote:{
    		            	url:"orderitem/checkIDCanBeUsed.mvc",
    		                type:"POST",
    		                data:{
    		                        order_id:function(){
    		                		return  $("input[name='order_id']").val();
    		                	 }
    		                }
    		            }
    		    },
    			pro_id:{
    				required:true,
    				rangelength:[1,5]
    			},
    			pro_id_count:{
    				required:true,
    				digits:true,
    				range:[50,10000]
    			},
    			man_id:{
    				required:true,
    				rangelength:[1,5]
    			},
    			order_date:{
    				required:true
    			},
    			seller_id:{
    				required:true,
    				rangelength:[1,5]
    			},
    			state:{
    				required:true
    			}
    			},
    			messaeges:{
    				order_id:{
        				required:"订单编号为空",
        			//	rangelength:"订单编号要在1到10为长度",
        				remote:"订单编号已经存在"
        			},
    				pro_id:{
        				required:"产品编号为空",
        				rangelength:"产品编号要在1到5为长度"
        			},
        			pro_id_count:{
        				required:"产品数量为空",
        				digits:"产品数量必须是整数",
        			    range:"产品数量要在50到10000"
        			},
        			man_id:{
        				required:"制造商编号为空",
        				rangelength:"制造商编号要在1到5为长度"
        			},
        			order_date:{
        				required:"生日为空"
        			},
        			seller_id:{
        				required:"借卖方编号为空",
        				rangelength:"借卖方编号要在1到5为长度"
        			},
        			state:{
        				required:"订单状态为空"
        			}
    			}
    		});
    		
    		
    	//拦截订单增加表单提交
		$("form#addorderitemForm").ajaxForm(function(result){
			alert(result.message);
	
			getParamAndReloadGrid(); //重新载入订单列表，并刷新Grid显示。
	
			$("div#OrderItemDialog").dialog("close"); //关闭弹出Dialog
		
		});
		//定义取消连接点击事件处理
		$("a#OrderItemCancelButton").on("click",function(){
			$("div#OrderItemDialog").dialog("close"); //关闭弹出Dialog
		
		});
    	});
     });
   //修改订单按钮点击事件处理
    $("a#orderlistModifyLink").on("click",function(){
    	$("div#OrderItemDialog").load("orderitem/modify.html",function(){
    	
    		if(o_id==0){
    		BootstrapDialog.show({
    			title:"订单操作提示",
    		    message:"<h4>请选择要修改的订单</h4>",
    				buttons:[{
    				label:'关闭'	,
    				action:function(dialog){
    					dialog.close();
    			      	 }	
             		  }
    				] 
    		});  		
    		}
    		else
    			{
    			//嵌入修改页面
        		$("div#OrderItemDialog").dialog({
            		title:"修改订单",
            	width:900,
            	heigth:650   
            	});
    			 $.getJSON("orderitem/getOrderById.mvc",{id:o_id},function(resultData){
 					    $("input[name='order_id']").val(resultData.order_id);
    					$("input[name='pro_id']").val(resultData.pro_id);
    					$("input[name='pro_id_count']").val(resultData.pro_id_count);
    					$("input[name='manufacture.id']").val(resultData.manufacture.id);
    					//$("input[name='manufacture.man_name']").val(resultData.man_name);
    					$("input[name='seller_id']").val(resultData.seller_id);
    					$("input[name='state']").val(resultData.state);
    					$("input[name='order_date']").val(resultData.order_date);
    				 });
    			}
    		$("form#modifyorderitemForm").validate({
    			rules:{
    			pro_id:{
    				required:true,
    				rangelength:[1,5]
    			},
    			pro_id_count:{
    				required:true,
    				digits:true,
    				range:[50,10000]
    			},
    			man_id:{
    				required:true,
    				rangelength:[1,5]
    			},
    			man_name:{
    				required:true
    			},
    			order_date:{
    				required:true
    			},
    			seller_id:{
    				required:true,
    				rangelength:[1,5]
    			},
    			state:{
    				required:true
    			}
    			},
    			messaeges:{
    				pro_id:{
        				required:"产品编号为空",
        				rangelength:"产品编号要在1到5为长度"
        			},
        			pro_id_count:{
        				required:"产品数量为空",
        				digits:"产品数量必须是整数",
        			    range:"产品数量要在50到10000"
        			},
        			man_id:{
        				required:"制造商编号为空",
        				rangelength:"制造商编号要在1到5为长度"
        			},
        			man_name:{
        				required:"制造商编号为空"
        			},
        			order_date:{
        				required:"生日为空"
        			},
        			seller_id:{
        				required:"借卖方编号为空",
        				rangelength:"借卖方编号要在1到5为长度"
        			},
        			state:{
        				required:"订单状态为空"
        			}
    			}
    		});
    	
    		$("form#modifyorderitemForm").ajaxForm(function(result){
    			alert(result.message);
    			
    			  getParamAndReloadGrid(); //重新载入订单列表，并刷新Grid显示。
    		
    			$("div#OrderItemDialog").dialog("close"); //关闭弹出Dialog
    		
    		});
    		//定义取消连接点击事件处理
    		$("a#OrderItemCancelButton").on("click",function(){
    			$("div#OrderItemDialog").dialog("close"); //关闭弹出Dialog
    		
    		});
    	});
    	
     });
    //删除订单按钮事件处理
    $("a#orderlistDeleteLink").on("click",function(){
    
    		if(o_id==0){
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
    			    $.post("orderitem/delete.mvc",{order_id:o_id},function(result){
    			  if(result=="ok"){
    				
    				   alert("删除订单成功");
    			  }else{
    				  alert("删除订单失败");
    			  }
    			});
    			    } 
    			getParamAndReloadGrid(); 
    			});
    			}
 			
    });
    //查看订单俺就事件处理
    $("a#orderlistViewLink").on("click",function(){
        
		if(o_id==0){
			alert("请选择要查看的订单!");
			
		}else{ 
		
			$("div#OrderItemDialog").load("orderitem/view.html",function(){
				$("div#OrderItemDialog").dialog({
            		title:"查看订单",
            	width:900,
            	heigth:650   
            	});
		
			    	 $.getJSON("orderitem/getOrderById.mvc",{id:o_id},function(resultData){
			    		    $("span#order_id").html(resultData.order_id);
			    		    $("span#order_date").html(resultData.order_date);
			 				$("span#pro_id").html(resultData.pro_id);
			 				$("span#pro_id_count").html(resultData.pro_id_count);
			 				$("span#man_id").html(resultData.manufacture.id);
			 			//	$("span#man_name").html(resultData.manufacture.man_name);
			 				$("span#seller_id").html(resultData.seller_id);
			 				$("span#state").html(resultData.state);
			 			 
			    	 });
			    	   $("button#OrderItemCancelButton").on("click",function(){
			    			$("div#OrderItemDialog").dialog("close"); //关闭弹出Dialog
			    		
			    });
	    		});
			    } 
	
			

			
});
});
