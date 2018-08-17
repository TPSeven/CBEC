/**
 *  用户信息主页管理JS
 *  author：温万龙
 */

$(document).ready(function(){
	var userId = 0; 
	function showManufacturerList(){
		
		$("div#user-content").load("user/list.html",function(){
			
			//获取JSON数据 显示员工列表表格
			$("table#userGrid").jqGrid({
				url: 'user/getListWithRoleByConditionWithPage.mvc',
	         	mtype: "GET",
			 	styleUI : 'Bootstrap',
	         	datatype: "json",
	         	colModel: [
//	         		{ label: 'id', name: 'id', key: true, width: 60 },
	        		{ label: '账户', name: 'name',width: 60 },
	            	{ label: '密码', name: 'password', width: 60 },
		            { label: '性别', name: 'sex', width: 30 },
		            { label: '年龄', name: 'age', width: 30 },
		            { label:'生日', name: 'birthday', width: 60 },
		            { label: '邮箱', name: 'email', width: 80 },
		            { label: '电话', name: 'phone', width: 80 },
		            { label: '角色', name: 'role.name', width: 80 }
		        ],
	        	autowidth:true,
			 	viewrecords: true,
	         	width: "100%",
			 	height: 350,
	         	rowNum: 15,
	         	rowList:[1,3,5,7],
	         	multiselect:false,
	        	onSelectRow:function(id){
	        		userId = id;
	        		alert(userId);
         		},
	         	pager: "#userGridPager",
			});
		});
	}
	
	showManufacturerList();
	
});
