/**
 * 商品管理主管理JS
 */
//页面载入成功事件
$(document).ready(function(){
	var productId = null;
	alert("PRO OK");
	//填充下拉框
	$.getJSON("kinds/list/all.mvc",function(kindsList){
		var options="<option value='0'>所有</option>"
		$.each(kindsList,function(index,kd){
			$("select#KindsSelection").append("<option value='"+kd.pro_kinds_id+"'>"+kd.pro_kinds_name+"</option>");
		});
	});
	
	//商品品牌复选框
	
	
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
            { label: '商品状态', name: 'pro_state_id', width: 120 },
            { label: '商品品牌', name: 'brand_id', width: 120 },
            { label: '商品图片', name: 'pro_photos_id', width: 120 },
            { label: '商品简介', name: 'pro_desc', width: 120 }
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
});
