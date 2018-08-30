
/*品牌管理*/
$(document).ready(function () {
	         var brandId = 0; 
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
	    		//检查是否输入了生日截止日
	    		if(endDate!=null){
	    			datas.endDate=endDate;
	    		}
	    		
	    		//清除postData累积的参数
	    		var postData = $('table#BrandGrid').jqGrid("getGridParam", "postData");
	    		$.each(postData, function (k, v) {
	                delete postData[k];
	            }); 
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
	      //起始日期更改事件处理
	      $("input#StartDate").on("change",function(){
	  		startDate=$("input#StartDate").val();
	  		getParamAndReloadGrid();
	  	  });
	  	  //截止日期更改事件处理
	  	  $("input#EndDate").on("change",function(){
	  		  endDate=$("input#EndDate").val();
	  		  getParamAndReloadGrid();
	  	  });
	      //增加事件
	      $("a#BrandAddLink").on("click",function(){
	    	  $("div#BrandDialog").load("brand/addbrand.html",function(){
	    		  //取得制造商列表，填充制造商下拉框
	    		  $.getJSON("manufacturer/toListByAll.mvc",function(manuList){
	  	        	$.each(manuList,function(index,manu){
	  	        		$("select[name='manufacturer.id']").append("<option value = '"+manu.id+"'>"+manu.name+"</option>");
	  	        		/*$("select#ManufacturerSelection").append("<option value = '"+manu.name+"'></option>");*/
	  	        	});
	  	        });
	    		//使用JQuery validate对员工进行数据验证
	    		  $("form#BrandAddForm").validate({
	    			  rules:{
	    				  brand_name:{
	    					  required:true,
	    					  rangelength:[2,5],
	    		              remote:"brand/checkIDCanBeUsed.mvc"
	    				  },
	    				  brand_desc:{
	    					  required:true,
	    					  rangelength:[2,20]
	    					  
	    				  },
	    				  brand_time:{
	    					  required:true
	    				  }
	    				  
	    			  },
	    			  messages:{
	    				  brand_name:{
	    					  required:"品牌商不能为空",
	    					  rangelength:"品牌商名字必须为2到5个字符",
	    					  remote:"此品牌商名称已存在"
	    				  },
	    				  brand_desc:{
	    					  required:"品牌商描述不能为空",
	    					  rangelength:"品牌商描述必须在2到20个字符"
	    					  
	    				  },
	    				  brand_time:{
	    					  required:"品牌商注册时间不能为空"
	    				  }
	    				  
	    			  }
	    		  
	    		  });
	    		  
	    		  //拦截增加的表单提交
	    		  $("form#BrandAddForm").ajaxForm(function(result){
	    			 
	    			  alert(result.message);
	    			  getParamAndReloadGrid();//重新载入员工列表，并刷新Grid显示
	    			  $("div#BrandDialog").dialog("close");//关闭弹出的DiaGrid
    			  
	    		  });
	    		  //定义取消链接点击事件处理
	    		  $("a#BrandAddCancelLink").on("click",function(){
	    			  $("div#BrandDialog").dialog("close");//关闭弹出Dialog
	    		  });
	    		  
	    		 
	    		  
	    		  
	    	  });
	    	  $("div#BrandDialog").dialog({
	    		  title:"增加新品牌商",
	    		  width:900,
	    		  height:350
	    	  });
	      });
	      //修改按钮事件
	      $("a#BrandModifyLink").on("click",function(){
	    	  if(brandId==0){
	    		  BootstrapDialog.show({
	    			  title:"员工操作提醒",
	    			  message:"<h4>请选择要修改的员工</h4>",
	    			  buttons:[{
	    				  label:'关闭',
	    				  action: function(dialog){
	    					  dialog.close();
	    				  }
	    			  }]
	    		  });
	    	  }
	    	  else{
	    		  $("div#BrandDialog").load("brand/modifybrand.html",function(){
	    			  //取得制造商列表，填充制造商下拉框
		    		  $.getJSON("manufacturer/toListByAll.mvc",function(manuList){
		  	        	$.each(manuList,function(index,manu){
		  	        		$("select[name='manufacturer.id']").append("<option value = '"+manu.id+"'>"+manu.name+"</option>");
		  	        	});
		  	        });
		    		  $.getJSON("brand/getbrandid.mvc",{id:brandId},function(br){
		    			  $("input[name='brand_id']").val(br.brand_id);
		    			  $("input[name='brand_name']").val(br.brand_name);
		    			  $("input[name='brand_desc']").val(br.brand_desc);
		    			  $("input[name='brand_time']").val(br.brand_time);
		    			  //选中品牌商的制造商（下拉框）
		    			  $("select[name='manufacturer.id']").val(br.manufacturer.id);
		    		  });
		    		//使用JQuery validate对员工进行数据验证
		    		  $("form#BrandModifyForm").validate({
		    			  rules:{
		    				  brand_name:{
		    					  required:true,
		    					  rangelength:[2,5],
		    		            //  remote:"brand/checkIDCanBeUsed.mvc"
		    				  },
		    				  brand_desc:{
		    					  required:true,
		    					  rangelength:[2,20]
		    					  
		    				  },
		    				  brand_time:{
		    					  required:true
		    				  }
		    				  
		    			  },
		    			  messages:{
		    				  brand_name:{
		    					  required:"品牌商不能为空",
		    					  rangelength:"品牌商名字必须为2到5个字符",
		    				//	  remote:"此品牌商名称已存在"
		    				  },
		    				  brand_desc:{
		    					  required:"品牌商描述不能为空",
		    					  rangelength:"品牌商描述必须在2到20个字符"
		    					  
		    				  },
		    				  brand_time:{
		    					  required:"品牌商注册时间不能为空"
		    				  }
		    				  
		    			  }
		    		  
		    		  });
		    		//拦截增加的表单提交
		    		  $("form#BrandModifyForm").ajaxForm(function(result){
		    		
		    			  alert(result.message);
		    			  getParamAndReloadGrid();//重新载入员工列表，并刷新Grid显示
		    			  
		    			  $("div#BrandDialog").dialog("close");//关闭弹出的DiaGrid
	    			  
		    		  });
		    		  //定义取消链接点击事件处理
		    		  $("a#BrandModifyCancelLink").on("click",function(){
		    			  $("div#BrandDialog").dialog("close");//关闭弹出Dialog
		    		  });

	    			  
	    			  
	    		  });
	    		//弹出修改页面
					$("div#BrandDialog").dialog({
						title:"修改品牌商",
						width:900,
						height:550
					});
	    	  }
	      });
	      //删除按钮-绑定响应事件
	      $("a#BrandDeleteLink").on("click",function(){
	    	  if(brandId==0){
	    		  alert("请选择要删除的品牌商");
	    	  }else{
	    		  var conf = confirm("确定要删除吗？");
	    		  if(conf){
	    			  $.post("brand/delete.mvc",{brand_id:brandId},function(resultData){
	    				  if(resultData=="ok"){
	    					  alert("删除品牌商成功");
	    					  getParamAndReloadGrid();	    					  
	    				  }else{
	    					  alert("删除品牌商失败");
	    				  }
	    			  });
	    		  }
	    	  }
	      });
	      //查看单个品牌商信息
	      $("a#BrandViewLink").on("click",function(){
	    	  
	    	  if(brandId==0){
	    		  alert("请选择要查看的品牌商");
	    	  }else{
	    		  $("div#BrandDialog").load("brand/view.html",function(){
	    			  $.getJSON("brand/getbrandid.mvc",{id:brandId},function(brdata){
	    				  $("span#brandId").html(brdata.brand_id);
	    				  $("span#brandName").html(brdata.brand_name);
	    				  $("span#brandManufacturerId").html(brdata.manufacturer.id);
	    				  $("span#brandManufacturerName").html(brdata.manufacturer.name);
	    				  $("span#brandDesc").html(brdata.brand_desc);
	    				  $("span#brandTime").html(brdata.brand_time);
	    				  
	    			  });
	    			//定义取消链接点击事件处理
			    		$("a#BrandViewCancelLink").on("click",function(){
			    			$("div#BrandDialog").dialog("close");//关闭弹出Dialog
			    		});
	    		  });
	    			$("div#BrandDialog").dialog({
	    				title:"查看单个品牌商信息",
	    				width:900,
	    				height:550
	    			});
	    	  }
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
                	
                }
                
            });
        });