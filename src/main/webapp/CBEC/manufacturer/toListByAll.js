/**
 *  品牌商信息管理JS
 *  author：温万龙
 */

$(document).ready(function(){
	$.getJSON("http://localhost:8080/cbec/manufacturer/toListByAll.mvc",function(manufacturerList){
		var lines="";
		for(var i=0;i<manufacturerList.length;++i){
			lines=lines+"<tr>"+
				"<td>"+manufacturerList[i].name+"</td>"+
				"<td>"+manufacturerList[i].address+"</td>"+
				"<td>"+manufacturerList[i].scope+"</td>"+
				"<td>"+manufacturerList[i].desc+"</td>"+
				"<td></td>"+
				"</tr>";
        $("table#manufacturerListTable tbody").html(lines);
		}
	});
});