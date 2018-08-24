/**
 * 
 */
$(document).ready(function(){
	$("from#orderitemLoginFrom").validate({
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
	$("from#orderitemLoginFrom").ajaxForm(function(loginResult){
		if(loginReuslt.status=='Y'){
			window.location.href="index.html";
			
		}else{
			BootstrapDialog.show({
				title:"订单登陆提示",
			    message:"<h4>"+loginReult.message+"</h4>",
			    buttons:[{
			    	lable:"关闭",
			        action:function(dialog){
			        	dialog.close();
			        	
			        }
			    }]
			})
		}
	});
	
});