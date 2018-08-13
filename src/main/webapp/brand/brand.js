
/*品牌管理*/


$(document).ready(function(){

	//请求取得部门列表的REST API
	function showBrandList(){
		
		$("div#BrandMainContext").load("brand/listbrand.html",function(){//先载入链表
		
			//载入数据
			$.getJSON("brand/listbyall.mvc",function(brandList){
				
				var lines = "";
				for(var i=0;i<brandList.length;i++){
					lines=lines+
					"<tr><td>"+brandList[i].brand_name+
					"</td><td>"+brandList[i].man_id+
					"</td><td>"+brandList[i].brand_desc+
					"</td></tr>";
					$("table#brandListTable tbody").html(lines);
//		          alert (lines);                          
				}
			});
		});
	}
	showBrandList();
	//增加按钮事件处理
	$("a#BrandAddLink").on("click",function(){
		$("div#BrandMainContext").load("brand/addbrand.html",function(event){//把定位BrandMainContext以下的页面替换
			$("button#BrandAddButton").on("click",function(){
				
				var brand_name = $("input[name = 'brand_name']").val();
				var man_id = $("input[name = 'man_id']").val();
				var brand_desc = $("input[name = 'brand_desc']").val();
				
				//请求REST API
				$.post("brand/add.mvc",{brand_name:brand_name,man_id:man_id,brand_desc:brand_desc},function(resultData){
					
					if(resultData=="ok"){
						alert("增加员工成功");
					}
					else{
						alert("增加员工失败");
					}
					showBrandList();
				});
				
			});
			$("button#BrandCancleButton").on("click",function(){
				showBrandList();
			});
		});
		
	});
});