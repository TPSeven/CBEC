/**
 *  角色管理JS
 *  author：温万龙
 */

$(document).ready(function(){
	var roleId = 0;
	alert("1");
	//显示角色列表
	$("table#roleGrid").jqGrid({
		url:"role/list.mvc",
		mtype:"GET",
		styleUI : 'Bootstrap',
     	datatype: "json",
     	colModel: [
    		{ label: '角色ID', name: 'id', width: 100 },
        	{ label: '角色名称', name: 'name', width: 100 },
        ],
        autowidth:true,
	 	viewrecords: true,
     	width: "100%",
	 	height: 350,
     	rowNum: 10,
     	rowList:[1,3,5,7],
         	multiselect:false,
        	onSelectRow:function(id){
        		userId = id;
	        	alert(userId);
     		},
     	pager: "#roleGridPager",
	});
	
	 $('table#roleGrid').navGrid('#roleGridPager',
		{	edit: true, 
	    	add: true, 
	    	del: true, 
	    	refresh: true, 
	    	view: true, 
	    	position: "left", 
	    	cloneToTop: false 
		},
	    // options for the Edit Dialog
	    {
	        editCaption: "编辑角色",
	        recreateForm: true,
			checkOnUpdate : true,
			checkOnSubmit : true,
	        closeAfterEdit: true,
	        errorTextFormat: function (data) {
	            return 'Error: ' + data.responseText
	        }
	    },
	    // options for the Add Dialog
	    {
	        closeAfterAdd: true,
	        recreateForm: true,
	        errorTextFormat: function (data) {
	            return 'Error: ' + data.responseText
	        }
	    },
	    // options for the Delete Dailog
	    {
	        errorTextFormat: function (data) {
	            return 'Error: ' + data.responseText
	        }
	    },
		{ multipleSearch: true,
		showQuery: true} // search options - define multiple search
		);
	
});
