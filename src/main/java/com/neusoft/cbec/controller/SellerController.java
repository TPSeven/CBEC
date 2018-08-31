package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.SellerModel;
import com.neusoft.cbec.result.ControllerResult;
import com.nuesoft.cbec.service.ISellerService;
@RestController 
@RequestMapping("/seller")
public class SellerController {
      private ISellerService  sellerservice=null;
    @Autowired
	public void setSellerservice(ISellerService sellerservice) {
		this.sellerservice = sellerservice;
	}
    @RequestMapping(value="/add")
    public ControllerResult  add(SellerModel se)throws Exception{
    	sellerservice.add(se);
  	  ControllerResult result =new ControllerResult();
  	  result.setMessage("添加成功");
  	  return result;
    }
    @RequestMapping(value="/modify",method= {RequestMethod.POST})
	public String modify(SellerModel se) throws Exception{
    	sellerservice.modify(se);
		return "ok";
	}
	@RequestMapping(value="/delete",method= {RequestMethod.POST})
	public String delete(SellerModel se) throws Exception{
		sellerservice.delete(se);
		return "ok";
	}
	
  //取得订单列表 ，无关联制造商
  @RequestMapping(value="/getListByAll",method=RequestMethod.GET)
  public List<SellerModel> getListByAll()throws Exception{
		List<SellerModel> list = sellerservice.getListByAll();
		return list;
  }
	
	
}
