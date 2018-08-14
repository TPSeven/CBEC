/**
 * 商品管理主JS程序
 */
//页面载入成功事件
$(document).ready(function(){
	var productId=0;//选择的商品编号
	
	
	//请求取得部门列表的REST API
	function showProductList(){
		$("div#ProductMainContent").load("product/list.html",function(){
			$.getJSON("product/list/all.mvc",function(productList){
				var lines="";
				for(var i=0;i<productList.length;i++){
			lines=lines+"<tr data-id='"+productList[i].pro_id+"'><td>"+productList[i].pro_id+"</td>" +
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
				//点击TR事件处理
				$("table#productListTable tbody tr").on("click",function(){
					productId=$(this).attr("data-id");
					//alert(productId);
					//8-14 0:22
					$("table#productListTable tbody tr").css("background-color","#FFFFFF");
					$(this).css("background-color","#EEEE");
				});
			});

			
		});

		
	}

	//点击增加按钮事件处理
	$("a#ProductAddLink").on("click",function(){
		$("div#ProductMainContent").load("product/add.html",function(){
			$("button#ProductAddButton").on("click",function(){
				//取得输入的名称
				var pro_name=$("input[name='pro_name']").val();
				var pro_price=$("input[name='pro_price']").val();
				var pro_weight=$("input[name='pro_weight']").val();
				var pro_count=$("input[name='pro_count']").val();
				var pro_kinds_id=$("input[name='pro_kinds_id']").val();
				var pro_state_id=$("input[name='pro_state_id']").val();
				var brand_id=$("input[name='brand_id']").val();
				var pro_photos_id=$("input[name='pro_photos_id']").val();
				var pro_desc=$("input[name='pro_desc']").val();
				//请求REST API
				$.post("product/add.mvc",{pro_name:name,pro_price:pro_price,pro_weight:pro_weight,pro_count:pro_count,pro_kinds_id:pro_kinds_id,pro_state_id:pro_state_id,brand_id:brand_id,pro_photos_id:pro_photos_id,pro_desc:pro_desc}, function(resultDate){
					if(resultDate=="ok"){
						alert("增加员工成功！");
					}
					else{
						alert("增加员工失败！");
					}
					showProductList();
				});
				//pro_price:pro_price,pro_weight:pro_weight,pro_count:pro_count,pro_kinds_id:pro_kinds_id,pro_state_id:pro_state_id,brand_id:brand_id,pro_photos_id:pro_photos_id,pro_desc:pro_desc}
				//alert("提交按钮点击...");
				//event.preventDefault();
			});
			//点击返回按钮事件处理
			$("button#ProductCancelButton").on("click",function(){
				showProductList();
			});
			
		});
	});
	//点击修改按钮事件处理
	$("a#ProductModifyLink").on("click",function(){
		if(productId==0){
			alert("请选择要修改的商品");
			
		}
		else{
			$("div#ProductMainContent").load("product/modify.html",function(){
			//取得选择的部门信息
				$.getJSON("product/get/id.mvc",{productId:productId},function(resultData){
					$("input[name='pro_name']").val(resultData.pro_name);
					$("input[name='pro_price']").val(resultData.pro_price);
					$("input[name='pro_weight']").val(resultData.pro_weight);
					$("input[name='pro_count']").val(resultData.pro_count);
					$("input[name='pro_kinds_id']").val(resultData.pro_kinds_id);
					$("input[name='pro_state_id']").val(resultData.pro_state_id);
					$("input[name='brand_id']").val(resultData.brand_id);
					$("input[name='pro_photos_id']").val(resultData.pro_photos_id);
					$("input[name='pro_desc']").val(resultData.pro_desc);
				});
			});
			//取得输入的值
			//8-14 1:34
			
		}
	});
	
	
	//点击删除按钮事件处理
	
	
	
	//点击查看按钮事件处理
	
	
	
	//初始载入部门列表显示页面并取得部门列表
	showProductList();
	
	
});





