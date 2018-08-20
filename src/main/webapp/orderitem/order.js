/**
 * 
 */


$(document).ready(function(){
	var o_id=0;
	var order_id=0;
	var man_id=0;
	var man_name="";
	var state="";
	var startDate=null;
	var endDate=null;
	
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
	
//取得订单更改事件
	
function getParamAndReloadGrid(){
	 var datas={order_id:order_id,man_name:man_name,man_id:man_id,state:state};
	 if (startDate!=null){
		 datas.startDate=startDate;
	 }
	 if(endDate!=null){
		 datas.endDate=endDate;
	 }
	 $("table#orderitemGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
	
}

//取得订单编号更改事件
$("input#order_id").on("change",function(){
	order_id1=$("input#order_id").val();
	
   getParamAndReloadGrid();

});
//取得姓名更改事件
     $("input#man_name").on("change",function(){
	    man_name=$("input#man_name").val();
	    getParamAndReloadGrid();
	 
});

   //起始日期更改事件处理
 	$("input#startDate").on("change",function(){
 		startDate=$("input#startDate").val();
 		getParamAndReloadGrid();
 	});
 	//截止日期更改事件处理
 	$("input#endDate").on("change",function(){
 		endDate=$("input#endDate").val();
 		getParamAndReloadGrid();
 	});
 	//制造商编号事件处理
     $("input#man_id").on("change",function(){
    	 man_id=$("input#man_id").val();
    	
    	 getParamAndReloadGrid();
 	  
 	 
 });
     //订单状态的选择更改事件处理
     $("input[type='radio'][name='state']").on("change",function(){
    	state=$(this).val();
    	
    	  getParamAndReloadGrid();
    	 //state=$("input[type='radio'][name='state']:checked").val();
     //  alert(state);
     
     });

});
