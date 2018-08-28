package com.neusoft.cbec.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.ProductModel;
import com.neusoft.cbec.result.ControllerResult;
import com.neusoft.cbec.result.GridResult;
import com.nuesoft.cbec.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	private IProductService productService = null;
	@Autowired
	public void setProdudtService(IProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ControllerResult add(ProductModel product) throws Exception {
		
		productService.add(product);
		
		ControllerResult result=new ControllerResult();
		result.setStatus("OK");
		result.setMessage("增加员工成功!");
		
		return result;
		
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(ProductModel product) throws Exception {
		
		productService.modify(product);
		return "ok";
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(ProductModel product) throws Exception {
		
		productService.delete(product);
		return "ok";
		
	}
	 
	@RequestMapping(value="/list/all",method=RequestMethod.GET)
	public List<ProductModel> getListByAll() throws Exception{
		return productService.getListByAll();
	}
	//无种类
	@RequestMapping(value="/list/all/withoutkinds",method=RequestMethod.GET)
	public List<ProductModel> getListWithoutKindsByAll() throws Exception{
		return productService.getListWithoutKindsByAll();
	}
	//有种类
	@RequestMapping(value="/list/all/withkinds",method=RequestMethod.GET)
	public List<ProductModel> getListWithKindsByAll() throws Exception{
		return productService.getListWithKindsByAll();
	}
	
	@RequestMapping(value="/get/id",method=RequestMethod.GET)
	public ProductModel getById(String productId) throws Exception{
		return productService.getById(productId);
	}
		
		
	@RequestMapping(value="/list/condition",method=RequestMethod.POST)
	public List<ProductModel> getListByCondition(@RequestParam(required=false,defaultValue="0") int kindsId, 
			@RequestParam(required=false,defaultValue="0") int sprice,
			@RequestParam(required=false,defaultValue="0") int eprice,
			@RequestParam(required=false,defaultValue="0") int brand,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, 
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
			@RequestParam(required=false,defaultValue="") String name,
			@RequestParam(required=false,defaultValue="") String proState) throws Exception {
		if(name!=null&&name.trim().length()>0) {
			name="%"+name+"%";
			
		}
		return productService.getListByCondition(kindsId, sprice, eprice, brand, startDate, endDate, name, proState);
	}	
	
	@RequestMapping(value="/list/condition/page",method=RequestMethod.POST)
	public GridResult<ProductModel> getListByConditionWithPage(@RequestParam(required=false,defaultValue="0") int kindsId, 
			@RequestParam(required=false,defaultValue="0") int startPrice,
			@RequestParam(required=false,defaultValue="0") int endPrice,
			@RequestParam(required=false,defaultValue="0") int brand,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, 
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
			@RequestParam(required=false,defaultValue="") String name,
			@RequestParam(required=false,defaultValue="") String proState,
			@RequestParam(required=false,defaultValue="3") int rows,
			@RequestParam(required=false,defaultValue="1") int page) throws Exception {
		if(name!=null&&name.trim().length()>0) {
			name="%"+name+"%";
			
		}
		System.out.println(kindsId);
		GridResult<ProductModel>  result=new GridResult<ProductModel>();
		
		result.setRecords(productService.getCountByCondition(kindsId, startPrice, endPrice, brand, startDate, endDate, name, proState));
		int pageCount=productService.getPageCountByCondition(kindsId, startPrice, endPrice, brand, startDate, endDate, name, proState, rows);
		if(page>pageCount) {
			page=pageCount;
		}
		if(page<1) {
			page=1;
		}
		result.setPage(page);
		result.setTotal(pageCount);
		result.setRows(productService.getListByConditionWithPage(kindsId, startPrice, endPrice, brand, startDate, endDate, name, proState, rows, page));
		
		return result;
	}
	
	//检查商品id是否是否可用于新员工，返回true表示不存在，可以使用 返回fales表示ID已存在，不能使用
	//用于jQuery validate remote的验证规则
/*	@RequestMapping(value="checkIDCanBeUsed")
	public boolean checkIDCanBeUsed(String pro_id) throws Exception{
		boolean result=true;
		if(productService.getById(pro_id)!=null) {
			return false;
		}
		
		return result;
		
	}*/
}


