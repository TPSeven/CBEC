package com.neusoft.cbec.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.ManufacturerModel;
import com.neusoft.cbec.model.OrderItemModel;
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
  public String  add(OrderItemModel em)throws Exception{
	  orderitemService.add(em);
	  return "ok";
  }
	@RequestMapping(value="/modify",method= {RequestMethod.POST})
	public String modify(OrderItemModel em) throws Exception{
		  orderitemService.modify(em);
		return "ok";
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
  
  @RequestMapping(value="listbycondition")
	public List<OrderItemModel> getListByCondition(@RequestParam(required=false,defaultValue="0") int order_id, @RequestParam(required=false,defaultValue="0") int man_id, @RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")  Date endDate,@RequestParam(required=false,defaultValue="") String man_name) throws Exception {
	if(man_name!=null&&man_name.trim().length()>0){
		man_name="%"+man_name+"%";
	}
		return orderitemService.getListByCondition(order_id, man_id, startDate, endDate,man_name);
	}

  @RequestMapping(value="listbyconditionwithpage")
	public List<OrderItemModel> getListByConditionWithPage(int order_id, int man_id, Date startDate, Date endDate,String man_name, int rows,
			int page)
			throws Exception {
	
		return orderitemService.getListByConditionWithPage(order_id, man_id, endDate, startDate, man_name,rows*(page-1)+1,rows*page);
	}
  
} 
