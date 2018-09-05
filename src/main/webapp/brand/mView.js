/**
 *  制造商信息主页管理JS
 *  author：马家豪
 */

$(document).ready(function(){	
	
	 function getParamAndReloadGrid(){
		var man_id = 2;
     	var datas = {manuid:man_id};
     	alert(datas.manuid);
     	$("table#ManuGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
      };
      
    /*//制造商更改事件
      $("select#ManufacturerSelection").on("change",function(){
   	   man_id=$("select#ManufacturerSelection").val();
   	   
   	   getParamAndReloadGrid();
      });*/
     
	//显示品牌商列表
    $("table#ManuGrid").jqGrid({
    	
    	//指定数据来源
        url: 'brand/list/condition/page.mvc',
        mtype: "GET",
		styleUI : 'Bootstrap',
        datatype: "json",
        colModel: [
            { label: '品牌商ID', name: 'brand_id', key: true, width: 150 },
            { label: '品牌商名字', name: 'brand_name', width: 150},
            { label: '制造商ID', name: 'manufacturer.id', width: 150 },
            { label: '制造商名字', name: 'manufacturer.name', width: 150 },
            { label: '品牌商描述', name: 'brand_desc', width: 150 },
            { label:'品牌商注册时间', name: 'brand_time', width: 150 }
        ],
        //自动宽度
        /*autowidth:ture,*/
        //是否显示记录
		viewrecords: true,
		height: 400,
		/*autowidth:ture,*/
		width: "%100",
		//一行显示多少个
		rowNum: 10,
        rowList:[2,10,15,20],
        pager: "#ManuGridPager",
      
    });});
