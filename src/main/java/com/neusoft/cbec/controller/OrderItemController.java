package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
  @RequestMapping("/add")
  public String  add(OrderItemModel em)throws Exception{
	  orderitemService.add(em);
	  return "ok";
  }
  @RequestMapping("/getListByAll")
  public List<OrderItemModel> getListByAll()throws Exception{
		List<OrderItemModel> list = orderitemService.getListByAll();
		return list;
  }
} 
