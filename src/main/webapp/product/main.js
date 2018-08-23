/**
 * 商品管理主管理JS
 */
//页面载入成功事件
$(document).ready(function(){
	var productId = null;
	var kindsId = 0;
	var proName = null;
	var proState="";
	var startDate=null;
	var endDate=null;
	alert("PRO OK");
	//填充下拉框
	$.getJSON("kinds/list/all.mvc",function(kindsList){
		//var options="<option value='0'>所有</option>"
		$.each(kindsList,function(index,kd){
			$("select#KindsSelection").append("<option value='"+kd.pro_kinds_id+"'>"+kd.pro_kinds_name+"</option>");
		});
	});
	
	//商品状态选框
	
	//事件更改
	function getParamAndReloadGrid(){
		 var datas={kindsId:kindsId,name:proName,proState:proState};
		 if (startDate!=null){
			 datas.startDate=startDate;
		 }
		 if(endDate!=null){
			 datas.endDate=endDate;
		 }
		 $("table#productGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
		
	}
	
	//品种下拉框更改事件
	$("select#KindsSelection").on("change",function(){
		kindsId=$("select#KindsSelection").val();
		getParamAndReloadGrid();
	});
	
	//状态选项更改事件
    $("input[type='radio'][name='state']").on("change",function(){
    	proState=$(this).val();
    	alert(proState);
  	  	getParamAndReloadGrid();
    
    });
	
	//名称框更改事件
	$("input#productName").on("change",function(){
		proName=$("input#productName").val();
		alert(proName);
		getParamAndReloadGrid();
	});
	

	
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
            { label: '商品状态', name: 'pro_state', width: 120 },
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
    //增加事件按钮点击事件处理
    $("a#ProductAddLink").on("click",function(){
    	$("div#ProductDialog").load("product/add.html",function(productList){
    	   //取得种类表填充下拉框
    		$.getJSON("kinds/list/all.mvc",function(kindsList){
    			//var options="<option value='0'>所有</option>"
    			$.each(kindsList,function(index,kd){
    				
    				$("select[name='kinds.pro_kinds_id']").append("<option value='"+kd.pro_kinds_id+"'>"+kd.pro_kinds_name+"</option>");
    			});
    		});
    		//取得品牌表生成品牌复选框
    		
    	});
    	$("div#ProductDialog").dialog({
    	  	title:"增加商品",
        	width:900,
        	hight:350	
    	});
  
    });
});
