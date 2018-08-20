/**
 * JQuery Validate CBEC项目 用户定制的验证规则
 */
//用户名称验证
$.validator.addMethod("rangelenghtForCBEC",function(value,element,params){
	var min = params[0];
	var max = params[1];
	var result = false;
	if(value!=null&&value.length>=min&&value.length<=max){
		result = true;
	}
	return this.optional(element) || result;
},"用户名称长度不符合要求！");

//密码验证
$.validator.addMethod("checkpassword",function(value,element){
	return this.optional(element) || /^[\w]{6,8}$/.test(value);
},"密码的格式为6-8位，只能是字母、数字和下划线");

//电话号码验证
$.validator.addMethod("mobile",function(value,element){
	return this.optional(element) || /^[1][3,4,5,7,8][0-9]{9}$/.test(value);
	//当element为空时this.optional(element)=true，用于在该控件为非必填项目时可以通过验证，及条件可以不填但是不能填错格式。
},"手机号码不合法");