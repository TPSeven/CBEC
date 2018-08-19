/**
 * 
 */


$(document).ready(function(){
	var o_id=null;
//取得订单列表	
	
	
	
	
	
	
	//显示订单列表表格
    $("table#orderitemGrid").jqGrid({
        url: 'orderitem/listbyconditionwithpage.mvc',
        mtype: "GET",
		styleUI : 'Bootstrap',
        datatype: "json",
        colModel: [
            { label: '订单编号', name: 'order_id', key: true, width: 75 },
            { label: '产品编号', name: 'pro_id', width: 150 },
            { label: '产品数量', name: 'pro_id_count', width: 150 },
            { label: '制造商编号', name: 'man_id', width: 150 },
            { label:'借卖方编号', name: 'seller_id', width: 150 },
            { label:'订单状态', name: 'state', width: 150 },
            { label:'订单日期', name: 'order_date', width: 150 } 
        ],
        autowidth:true,
		viewrecords: true,
        height: 400,
        rowNum: 10,
        rowList:[2,10,15,20],
        pager: "#orderitemGridPager",
        	  jsonReader : {
                  root: "rows",  //指定数据列表
                  page: "page",
                  total: "total",
                  records: "records",
                  repeatitems: true,
                  id: "id"
              },
              multiselect:false,
              onSelectRow:function(id){
             	o_id=id;
             	 alert(o_id);
              }
              
    });
});
