package com.neusoft.cbec.result;

/**
 * @author Wwl
 * Contoller层调用，返回结果
 */
public class ControllerResult {
	private String status=null; //状态： 正常 OK, 异常:ERROR
	private String message=null; //消息信息: 异常，异常message, 没有异常自己定义。
	private Exception exception=null;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	
}
