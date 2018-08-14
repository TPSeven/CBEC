/**
 * 商品管理主JS程序
 */
//页面载入成功事件
$(document).ready(function(){
	//请求取得部门列表的REST API
	$.getJSON("product/list/all.mvc",function(productList){
		var lines="";
		for(var i=0;i<productList.length;i++){
	lines=lines+"<tr><td>"+productList[i].pro_id+"</td>" +
					"<td>"+productList[i].pro_name+"</td>" +
					"<td>"+productList[i].pro_price+"</td>" +
					"<td>"+productList[i].pro_weight+"</td>" +
					"<td>"+productList[i].pro_count+"</td>" +
					"<td>"+productList[i].pro_kinds_id+"</td>" +
					"<td>"+productList[i].pro_state_id+"</td>" +
					"<td>"+productList[i].brand_id+"</td>" +
					"<td>"+productList[i].pro_photos_id+"</td>" +
					"<td>"+productList[i].pro_desc+"</td></tr>"
					
		}
		$("table#productListTable tbody").html(lines);
	});
	//点击增加按钮事件处理
	$("a#ProductAddLink").on("click",function(){
		$("div#ProductMainContent").load("product/add.html");
	});
	
	
	
});