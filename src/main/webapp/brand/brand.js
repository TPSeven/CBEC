
/*品牌管理*/


$(document).ready(function(){
	var brandId = 0;

	//请求取得部门列表的REST API
	function showBrandList(){
		
		$("div#BrandMainContext").load("brand/listbrand.html",function(){//先载入链表
		
			//载入数据
			$.getJSON("brand/listbyall.mvc",function(brandList){
				
				var lines = "";
				for(var i=0;i<brandList.length;i++){
					lines=lines+
					"<tr data-id ='"+brandList[i].brand_id+"'><td>"+brandList[i].brand_name+
					"</td><td>"+brandList[i].man_id+
					"</td><td>"+brandList[i].brand_desc+
					"</td></tr>";
					$("table#brandListTable tbody").html(lines);
					//点击TR事件处理
					$("table#brandListTable tbody tr").on('click',function(){
						brandId = $(this).attr("data-id");
						
						$("table#brandListTable tbody tr").css("background-color","#FFFFFF")
						//选中的行变颜色
						$(this).css("background-color","#EEEE");
						alert(brandId);
						
					});
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
	//修改按钮处理事件
	$("a#BrandModifyLink").on('click',function(){
		if(brandId == 0 ){
			alert("请选择要修改的部门")
		}
		else{
			$("div#BrandMainContext").load("brand/modifybrand.html",function(){
				
				//取得选择的部门的信息
				$.getJSON("brand/getbrandid.mvc",{id:brandId},function(resultData){
					alert(resultData);
					var brand_name = $("input[name = 'brand_name']").val(resultData.brand_name);
					var man_id = $("input[name = 'man_id']").val(resultData.man_id);
					var brand_desc = $("input[name = 'brand_desc']").val(resultData.brand_desc);
					
				});
				//点击修改按钮
				
				$("button#BrandModifyButton").on("click",function(){
					//取得修改的值
					var brand_name = $("input[name = 'brand_name']").val();
					var man_id = $("input[name = 'man_id']").val();
					var brand_desc = $("input[name = 'brand_desc']").val();
					//请求REST API
					$.post("brand/modify.mvc",{brand_id:brandId,brand_name:brand_name,man_id:man_id,brand_desc:brand_desc},function(resultData){
						
						if(resultData=="ok"){
							alert("修改部门成功");
						}
						else{
							alert("修改部门失败");
						}
						showBrandList();
					});
					
				});
				//点击返回按钮事件处理
				$("button#BrandCancleButton").on("click",function(){
					showBrandList();
				});
				
				
			});
		}
	});
	
	/*$("a#BrandModifyLink").on("click",function(){
		if(departmentNo==0){
			alert("请选择要修改的部门");
		}
		else{
			$("div#DepartmentMainContent").load("department/modify.html",function(){
				//取得选择的部门的信息
				$.getJSON("department/get.mvc",{no:departmentNo},function(resultData){
					$("input[name='code']").val(resultData.code);
					$("input[name='name']").val(resultData.name);
				});
				//点击修改提交按钮处理
				$("button#DepartmentModifyButton").on("click",function(){
					//取得输入的CODE和name值
					var code=$("input[name='code']").val();
					var name=$("input[name='name']").val();
					//请求REST API
					$.post("department/modify.mvc",{no:departmentNo,code:code,name:name},function(resultData){
						if(resultData=="ok"){
							alert("修改部门成功");
						}
						else{
							alert("修改部门失败");
						}
						
						showDepartmentList();
					});
				});
				//点击返回按钮事件处理	
				$("button#DepartmentCancelButton").on("click",function(){
					showDepartmentList();
				});
				
				
			});
		}
	});*/
});