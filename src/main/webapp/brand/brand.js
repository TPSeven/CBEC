
/*品牌管理*/


$(document).ready(function(){
	/*alert("2");*/
	//请求取得部门列表的REST API
	$.getJSON("brand/listbyall.mvc",function(brandList){
		var lines = "";
		for(var i=0;i<brandList.length;i++){
			lines=lines+
			"<tr><td>"+brandList[i].brand_name+
			"</td><td>"+brandList[i].man_id+
			"</td><td>"+brandList[i].brand_desc+
			"</td></tr>";
			$("table#brandListTable tbody").html(lines);
//          alert (lines);                          
		}
	});
	alert("查看成功");
});