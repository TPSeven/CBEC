/**
 * 
 */


$(document).ready(function(){
   function showOrderitemList(){
	   $("div#OrderitemMainContent").load("orderitem/list.html",function(){
		   
	
		$.getJSON("orderitem/getListByAll.mvc",function(orderitemList){
			
			  var lines="";
			 for(var i=0;i<orderitemList.length;i++)
				{
				lines=lines+"<tr><td>"+orderitemList[i].order_id+"</td><td>"+orderitemList[i].pro_id+"</td><td>"+orderitemList[i].pro_id_count+"</td><td>"+
				orderitemList[i].man_id+"</td><td>"+orderitemList[i].seller_id+"</td><td>"+orderitemList[i].state+"</td><tr>"	
				}
			 $("table#orderlisttable tbody").html(lines);
		});
		 });   
		}
	   
   

// 点击增加按钮事件处理
 $("a#orderlistAddLink").on("click",function(){
	 
	 $("div#OrderitemMainContent").load("orderitem/add.html",function(){
		 
	$("button#OrderItemAddButton").on("click",function(){
      var order_id=$("input[name='order_id']").val();
      var pro_id=$("input[name='pro_id']").val();
      var pro_id_count=$("input[name='pro_id-count']").val();
      var man_id=$("input[name='man_id']").val();
      var seller_id=$("input[name='seller_id']").val();   
      var state=$("input[name='state']").val();
     //请求REST API
      $.post("orderitem/add.mvc",{order_id,pro_id,pro_id_count,man_id,seller_id,state},function(resultdata){
    
    	  if(resultdata="ok"){
    		  alert("增加员工成功");
    		  
    	  }else{
    		  alert("增加员工失败");
    	  }
    	  showOrderitemList();
      });
	});
	$("button#OrderItemCancelButton").on("click",function(){
	
		showOrderitemList();
	 }); 		 
 });
});
	showOrderitemList();
});
