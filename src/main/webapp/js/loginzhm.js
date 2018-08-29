/**
 * 
 */
$(document).ready(function(){
	$("form#orderitemLoginFrom").validate({
		rules:{
			order_id:{
				required:true
			},
	        man_id:{
	        	  required:true
	        }
	      
		},
		message:{
			    order_id:{
			    	required:"账号为空"
			    },
			    man_id:{
			    	 required:"密码为空"
			    }
		}
	});
	$("form#orderitemLoginFrom").ajaxForm(function(loginResult){
	
		if(loginResult.status=='Y'){
			
			window.location.href="indexzhm.html";
			
		}else{
		
			BootstrapDialog.show({
			
				title:"订单登陆提示",
				message:"<h4>"+loginResult.message+"</h4>",
			    buttons:[{
			    	lable:"关闭",
			        action:function(dialog){
			        	dialog.close();
			        	
			        }
			    }]
			});
		}
	});
	
});