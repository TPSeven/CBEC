
/*品牌管理*/
$(document).ready(function () {
	         var brandId = null; 
	         var man_id = 0;
	         var startDate = null;
	         var endDate = null;
	         var brandName = "";
	         //取得请求参数，并重新载入Grid数据并刷新
	         function getParamAndReloadGrid(){
	        	var datas = {manuid:man_id,name:brandName};
	        	//检查是否输入了生日起始日期
	        	if(startDate!=null){
	    			datas.startDate=startDate;
	    		}
	    		
	    		//检查是否输入了生日截止日期
	    		if(endDate!=null){
	    			datas.endDate=endDate;
	    		}
	    		
	    		//清除postData累积的参数
	    		/*var postData = $('table#BrandGrid').jqGrid("getGridParam", "postData");
	    		$.each(postData, function (k, v) {
	                delete postData[k];
	            });*/ 
	        	$("table#BrandGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
	         };
	         
	         
	         
	         //取得制造商列表，填充制造商下拉框
	        $.getJSON("manufacturer/toListByAll.mvc",function(manuList){
	        	$.each(manuList,function(index,manu){
	        		$("select#ManufacturerSelection").append("<option value = '"+manu.id+"'>"+manu.name+"</option>");
	        		/*$("select#ManufacturerSelection").append("<option value = '"+manu.name+"'></option>");*/
	        	});
	        });
	         //制造商下拉框更改事件
	       $("select#ManufacturerSelection").on("change",function(){
	    	   man_id=$("select#ManufacturerSelection").val();
	    	   
	    	   getParamAndReloadGrid();
	       });
	       
	      //品牌商名字更改事件
	      $("input#brandName").on("change",function(){
	    	  brandName = $("input#brandName").val();
	    	  getParamAndReloadGrid();
	    	  
	      });
			//显示品牌商列表
            $("table#BrandGrid").jqGrid({
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
                pager: "#BrandGridPager",
                //不让多选
                multiselect:false,
                onSelectRow:function(brand_id){
                	brandId = brand_id;
                	alert(brandId);
                }
                
            });
        });