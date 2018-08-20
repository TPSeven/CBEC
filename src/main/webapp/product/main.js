/**
 * 商品管理主管理JS
 */
//页面载入成功事件
$(document).ready(function(){
	alert("PRO OK");
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
        rowNum: 15,
        pager: "#productGridPager"
    });
});
