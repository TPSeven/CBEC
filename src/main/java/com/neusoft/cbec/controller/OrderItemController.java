package com.neusoft.cbec.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.ManufacturerModel;
import com.neusoft.cbec.model.OrderItemModel;
import com.neusoft.cbec.result.ControllerResult;
import com.neusoft.cbec.result.GridResult;
import com.nuesoft.cbec.service.IOrderItemService;

@RestController 
@RequestMapping("/orderitem")
public class OrderItemController {
  private IOrderItemService orderitemService=null;
@Autowired
public void setOrderitemService(IOrderItemService orderitemService) {
	this.orderitemService = orderitemService;
}
  @RequestMapping(value="/add")
  public ControllerResult  add(OrderItemModel em)throws Exception{
	  orderitemService.add(em);
	  ControllerResult result =new ControllerResult();
	  result.setMessage("添加成功");
	  return result;
  }
	@RequestMapping(value="/modify",method= {RequestMethod.POST})
	public ControllerResult modify(OrderItemModel em) throws Exception{
		  orderitemService.modify(em);
		  ControllerResult result =new ControllerResult();
		  result.setMessage("修改成功");
		  return result;
	}
	@RequestMapping(value="/delete",method= {RequestMethod.POST})
	public String delete(OrderItemModel em) throws Exception{
		  orderitemService.delete(em);
		return "ok";
	}
	
  //取得订单列表 ，无关联制造商
  @RequestMapping(value="/getListByAll",method=RequestMethod.GET)
  public List<OrderItemModel> getListByAll()throws Exception{
		List<OrderItemModel> list = orderitemService.getListByAll();
		return list;
  }
  
  //取得订单列表，取得制造商
  @RequestMapping(value="/getListWithManByAll",method=RequestMethod.GET)
  public List<OrderItemModel> getListWithManByAll()throws Exception{
		List<OrderItemModel> list = orderitemService.getListWithManByAll();
		return list;
  }
  
  @RequestMapping(value="/getOrderById",method= {RequestMethod.POST,RequestMethod.GET})
	public OrderItemModel getOrderById(@RequestParam(required=true)int id) throws Exception{
		return orderitemService.getOrderItemById(id);
	}
  
  @RequestMapping(value="/listbycondition")
	public List<OrderItemModel> getListByCondition(
			@RequestParam(required=false,defaultValue="0") int order_id, 
			@RequestParam(required=false,defaultValue="0") int man_id,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")  Date endDate,
			@RequestParam(required=false,defaultValue="") String man_name,
			@RequestParam(required=false,defaultValue="") String state) throws Exception {
	if(man_name!=null&&man_name.trim().length()>0){
		man_name="%"+man_name+"%";
	}
		return orderitemService.getListByCondition(order_id, man_id, startDate, endDate,man_name,state);
	}

  @RequestMapping(value="/listbyconditionwithpage")
	public GridResult<OrderItemModel> getListByConditionWithPage(
			@RequestParam(required=false,defaultValue="0")int order_id,
			@RequestParam(required=false,defaultValue="0")int man_id,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date startDate, 
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,
			@RequestParam(required=false,defaultValue="") String man_name,
			@RequestParam(required=false,defaultValue="") String state,
			@RequestParam(required=false,defaultValue="10")int rows,
			@RequestParam(required=false,defaultValue="1")int page)
			throws Exception {
	  
	  if(man_name!=null&&man_name.trim().length()>0){
			man_name="%"+man_name+"%";
		}
		GridResult<OrderItemModel>  result=new GridResult<OrderItemModel>();
		
		result.setRecords(orderitemService.getCountByCondition(order_id, man_id, startDate, endDate,man_name ,state));

		int pageCount=orderitemService.getPageByConditionWithPage(order_id, man_id, startDate, endDate, man_name,state, rows);
		if(page>pageCount) {
			page=pageCount;
		}
		if(page<1) {
			page=1;
		}
		result.setPage(page);
		result.setTotal(pageCount);
		System.out.println(page);
		System.out.println("111");		
		System.out.println(pageCount);
		result.setRows(orderitemService.getListByConditionWithPage(order_id, man_id, startDate, endDate,man_name,state,rows,page));
		System.out.println("111");
		return result;
	}
/*  @RequestMapping(value="listbyconditionwithpage")
  public List<OrderItemModel> getListByConditionWithPage(
			@RequestParam(required=false,defaultValue="0")int order_id,
			@RequestParam(required=false,defaultValue="0")int man_id,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date startDate, 
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,
			@RequestParam(required=false,defaultValue="") String man_name,
			@RequestParam(required=false,defaultValue="10")int rows,
			@RequestParam(required=false,defaultValue="1")int page)
			throws Exception {
	  if(man_name!=null&&man_name.trim().length()>0){
			man_name="%"+man_name+"%";
		}
		return orderitemService.getListByConditionWithPage(order_id, man_id, startDate, endDate,man_name,rows,page);
}*/
  
  //检查订单编号是可用于新订单，  返回true 表示不存在，可用，false表示已经存在，不可用
  @RequestMapping(value="/checkIDCanBeUsed",method=RequestMethod.POST) 
  public boolean checkIDCanBeUsed(int  order_id) throws Exception{
	    boolean  result=true;
	    if(orderitemService.getOrderItemById(order_id)!=null) {
	    	result=false;
	    }
	    return result;
	    }
  @RequestMapping(value="/validate",method=RequestMethod.POST) 
 public   ControllerResult validate(int order_id,int man_id,HttpSession session)throws Exception{
	 ControllerResult result =new ControllerResult();

	 if(orderitemService.validate(order_id, man_id)) {
      OrderItemModel em=orderitemService.getOrderItemById(order_id);
      session.setAttribute("orderitemInfo", em);
		result.setStatus("Y");
		result.setMessage("订单验证通过");
	 }else
	 {	 
		 result.setStatus("N");
			result.setMessage ("订单验证失败");
	 }
	   return result;
 }
  //检查订单是否登陆
  @RequestMapping(value="/checklogin",method=RequestMethod.GET) 
 public   ControllerResult checklogin(HttpSession session)throws Exception{
	 ControllerResult result =new ControllerResult();

	 if(session.getAttribute("orderitemInfo")!=null) {
		 System.out.println("ok3");
		result.setStatus("Y");
		result.setMessage("订单验证通过");
	 }else
	 {	 System.out.println("ok4");
		 result.setStatus("N");
			result.setMessage ("订单验证失败");
	 }
	   return result;
 }
  //取得已经登陆的订单信息
  @RequestMapping(value="/getOrderitemInfoFromSession",method=RequestMethod.GET) 
  public OrderItemModel getOrderitemInfoFromSession(HttpSession session)throws Exception{
	     return (OrderItemModel)session.getAttribute("orderitemInfo");
  }
  
  @RequestMapping(value="/orderitemlogout",method=RequestMethod.GET) 
  public ControllerResult OrderitemLogout(HttpSession session)throws Exception{

   session.invalidate();  //销毁session对象
	  ControllerResult result =new ControllerResult();

	
			result.setStatus("Y");
			result.setMessage("订单注销成功");
	
		   return result;
  }
  @RequestMapping(value="/listbyman")
	public List<OrderItemModel> getOrderitemByMan(
			@RequestParam(required=false,defaultValue="0")int order_id,
			@RequestParam(required=false,defaultValue="0")int man_id,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date startDate, 
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,
			@RequestParam(required=false,defaultValue="") String state)
			throws Exception {
	
		return orderitemService.getOrderitemByMan(order_id,man_id,startDate,endDate,state);
	}
  
    @RequestMapping(value="/listbymanwithpage")
	public GridResult<OrderItemModel> getOrderitemByManWithPage(
	@RequestParam(required=false,defaultValue="0")int order_id,
	@RequestParam(required=false,defaultValue="0")int man_id,
	@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date startDate, 
	@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,
	@RequestParam(required=false,defaultValue="") String state,
	@RequestParam(required=false,defaultValue="10")int rows,
	@RequestParam(required=false,defaultValue="1")int page)
			throws Exception {
		GridResult<OrderItemModel>  result=new GridResult<OrderItemModel>();
		result.setRecords(orderitemService.getCountByMan(order_id,man_id,startDate,endDate,state));

		int pageCount=orderitemService.getPageByManWithPage(order_id,man_id,startDate,endDate,state, rows);
		if(page>pageCount) {
			page=pageCount;
		}
		if(page<1) {
			page=1;
		}
		result.setPage(page);
		result.setTotal(pageCount);
		result.setRows(orderitemService.getOrderitemByManWithPage(order_id,man_id,startDate, endDate, state,rows,page));
		
		return result;
	}
}
  