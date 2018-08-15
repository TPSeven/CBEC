/**
 * 
 */


$(document).ready(function(){
var o_id=0;  //选择的订单编号
	
	
	//请求取得部门别表的REST API
   function showOrderitemList(){

	   $("div#OrderitemMainContent").load("orderitem/list.html",function(){
		   
	
		$.getJSON("orderitem/getListByAll.mvc",function(orderitemList){
			
			  var lines="";
			 for(var i=0;i<orderitemList.length;i++)
				{
				lines=lines+"<tr data-id='"+orderitemList[i].order_id+"'><td>"+orderitemList[i].order_id+"</td><td>"+orderitemList[i].pro_id+"</td><td>"+orderitemList[i].pro_id_count+"</td><td>"+
				orderitemList[i].man_id+"</td><td>"+orderitemList[i].seller_id+"</td><td>"+orderitemList[i].state+"</td><tr>"	
				}orderlisttable
			 $("table#orderlisttable tbody").html(lines);
				//点解TR事件处理
				$("table#orderlisttable tbody tr").on("click",function(){
					o_id=$(this).attr("data-id");
					$("table#orderlisttable tbody tr").css("background-color","#FFFFFF")
					$(this).css("background-color","#EEEE");
					
				});
		});
	
		 });   
		}
	   
   

// 点击增加按钮事件处理
 $("a#orderlistAddLink").on("click",function(){ 
	 $("div#OrderitemMainContent").load("orderitem/add.html",function(){
	$("button#OrderItemAddButton").on("click",function(){
      var order_id=$("input[name='order_id']").val();
      var pro_id=$("input[name='pro_id']").val();
      var pro_id_count=$("input[name='pro_id_count']").val();
      var man_id=$("input[name='man_id']").val();
      var seller_id=$("input[name='seller_id']").val();   
      var state=$("input[name='state']").val();
     //请求REST API
      $.post("orderitem/add.mvc",{order_id:order_id,pro_id:pro_id,pro_id_count:pro_id_count,man_id:man_id,seller_id:seller_id,state:state},function(resultdata){
    
    	  if(resultdata=="ok"){
    		  alert("增加订单成功");
    		  
    	  }else{
    		  alert("增加订单失败");
    	  }
    	  showOrderitemList();
      });
	});
	$("button#OrderItemCancelButton").on("click",function(){
	
		showOrderitemList();
	 }); 		 
 });
});
 //点击修改按钮事件处理
 $("a#orderlistModifyLink").on("click",function(){
	 if(o_id==0){
		 alert("请选择要修改的订单");
		 
	 }else{
		 
		 $("div#OrderitemMainContent").load("orderitem/modify.html",function(){
			 //取得选择的订单信息
			
			 $.getJSON("orderitem/getOrderById.mvc",{id:o_id},function(resultData){
				$("input[name='pro_id']").val(resultData.pro_id);
				$("input[name='pro_id_count']").val(resultData.pro_id_count);
				$("input[name='man_id']").val(resultData.man_id);
				$("input[name='seller_id']").val(resultData.seller_id);
				$("input[name='state']").val(resultData.state);
			 });
			 
				$("button#OrderItemModifyButton").on("click",function(){
					
					var pro_id = $("input[name='pro_id']").val();
					var pro_id_count = $("input[name='pro_id_count']").val();
					var man_id = $("input[name='man_id']").val();
					var seller_id = $("input[name='seller_id']").val();
					var state = $("input[name='state']").val();
					

					//发送修改请求
					$.post("orderitem/modify.mvc",{order_id:o_id,pro_id:pro_id,pro_id_count:pro_id_count,man_id:man_id,seller_id:seller_id,state:state},function(resultData){
						if(resultData=="ok"){
							alert("修改订单成功");
							showOrderitemList();
						}else{
							alert("修改订单失败");
						}
					});
				});
					$("button#OrderItemCancelButton").on("click",function(){
					
						showOrderitemList();
					 });  
			 
		 });
	 }
 });
 //点击删除按钮事件处理
 $("a#orderlistDeleteLink").on("click",function(){
	 if(o_id==0){
		 alert("请选择删除的订单");
		 
	 }else{
		 var confirmResult=confirm("确认要删除选择的订单吗?");
		if(confirmResult){
		    $.post("orderitem/delete.mvc",{order_id:o_id},function(resultdata){
	    	    
		    	  if(resultdata=="ok"){
		    		  alert("删除订单成功");
		    		  
		    	  }else{
		    		  alert("删除订单失败");
		    	  }
		    			    	  showOrderitemList();
		
		    });
	 }
	 }
	 });
//点击查看事件处理
 $("a#orderlistViewLink").on("click",function(){
	 if(o_id==0){
		 alert("请选择查看的订单");
		 
	 }else{
		 
		 $("div#OrderitemMainContent").load("orderitem/view.html",function(){
	    		 $.getJSON("orderitem/getOrderById.mvc",{id:o_id},function(resultData){
	 				$("span#order_id").html(resultData.order_id);
	 				$("span#pro_id").html(resultData.pro_id);
	 				$("span#pro_id_count").html(resultData.pro_id_count);
	 				$("span#man_id").html(resultData.man_id);
	 				$("span#seller_id").html(resultData.seller_id);
	 				$("span#state").html(resultData.state);
	 			 });  
	    	
	    			$("button#OrderItemCancelButton").on("click",function(){
						
						showOrderitemList();
					 });
	      });
	 }
	 });
 
 
 
	showOrderitemList();
});
