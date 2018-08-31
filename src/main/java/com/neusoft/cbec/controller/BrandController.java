package com.neusoft.cbec.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.BrandModel;
import com.neusoft.cbec.result.ControllerResult;
import com.neusoft.cbec.result.GridResult;

import com.nuesoft.cbec.service.IBrandService;

/*
 * 品牌商控制器类
 * 马家豪
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

	private IBrandService brandService = null;
	
	@Autowired
	public void setBrandService(IBrandService brandService) {
		this.brandService = brandService;
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ControllerResult add(BrandModel brandmodel) throws Exception{
		brandService.add(brandmodel);
		ControllerResult result = new ControllerResult();
		result.setStatus("ok");
		result.setMessage("增加员工成功!");
		
		return result;
	}
	
	@RequestMapping(value = "/listbyall/nomanu",method = RequestMethod.GET) 
	public List<BrandModel> toListByAll() throws Exception{
		
		List<BrandModel> list = brandService.getListByAll();
		return list;	
	}
	
	@RequestMapping(value = "/listbyall/wtihmanu",method = RequestMethod.GET) 
	public List<BrandModel> toListWithManuByAl() throws Exception{
		
		List<BrandModel> list = brandService.getListWithManuByAll();
		return list;	
	}
	
	@RequestMapping(value = "/modify",method = RequestMethod.POST)
	public ControllerResult modify(BrandModel brandmodel)throws Exception{
		brandService.modify(brandmodel);
		ControllerResult result = new ControllerResult();
		result.setStatus("ok");
		result.setMessage("修改员工成功!");
		return result;
	}
	
	@RequestMapping(value = "/getbrandid" ,method = {RequestMethod.POST ,RequestMethod.GET})
	public BrandModel getbrandid(@RequestParam(required=true)int id) throws Exception{
		return brandService.getById(id);
	}		
    
	@RequestMapping(value="/delete",method= {RequestMethod.POST})
	public String delete(BrandModel brandmodel) throws Exception{
		brandService.delete(brandmodel);
		return "ok";
	}
	//根据制造商号取得品牌商列表
	//检索条件取得员工列表有分页
		/*@RequestMapping(value="/list/manu/page",method = {RequestMethod.POST ,RequestMethod.GET})
		public GridResult<BrandModel> getByConditionWithPage(@RequestParam(required = false,defaultValue = "0")int manuid,
				@RequestParam(required=false,defaultValue="10" )int rows,
				@RequestParam(required=false,defaultValue="1")int page) throws Exception{
			    System.out.println(manuid);

			     
			     GridResult<BrandModel>  result = new GridResult<BrandModel>();
			     result.setRecords(brandService.getCountByCondition(manuid));
			     int pageCount=brandService.getPageCountByCondition(manuid, rows);
			     if(page>pageCount) {
			    	 page=pageCount;
			    	 
			     }
			     if(page<1) {
			    	 page=1;
			     }
			     result.setPage(page);
			     result.setTotal(pageCount);
			     result.setRows(brandService.getListByConditionWithPage(manuid, rows, page));
			     return result;
		      	 
		}*/
	//检索条件取得品牌商列表有分页
	@RequestMapping(value="/list/condition/page",method = {RequestMethod.POST ,RequestMethod.GET})
	public GridResult<BrandModel> getByConditionWithPage(@RequestParam(required = false,defaultValue = "0")int manuid,
			/*@RequestParam(required = false,defaultValue = "") String man_name,*/
			@RequestParam(required = false,defaultValue = "") String name,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, 
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
			@RequestParam(required=false,defaultValue="10" )int rows,
			@RequestParam(required=false,defaultValue="1")int page) throws Exception{
		    System.out.println(manuid);

		     if(name!=null&&name.trim().length()>0) {
		    	 name="%"+name+"%";
		     }
		     
		     GridResult<BrandModel>  result = new GridResult<BrandModel>();
		     result.setRecords(brandService.getCountByCondition(manuid, name, startDate, endDate));
		     int pageCount=brandService.getPageCountByCondition(manuid, name, startDate, endDate, rows);
		     if(page>pageCount) {
		    	 page=pageCount;
		    	 
		     }
		     if(page<1) {
		    	 page=1;
		     }
		     result.setPage(page);
		     result.setTotal(pageCount);
		     result.setRows(brandService.getListByConditionWithPage(manuid, name, startDate, endDate, rows, page));
		     return result;
	      	 
	}
	//检索条件取得员工列表无分页
	@RequestMapping(value="/list/condition",method = {RequestMethod.POST ,RequestMethod.GET})
	public List<BrandModel> getByCondition(@RequestParam(required = false,defaultValue = "0")int manuid,
			@RequestParam(required = false,defaultValue = "") String name,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, 
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate
			) throws Exception{
		     if(name!=null&&name.trim().length()>0) {
		    	 name="%"+name+"%";
		     }
		     return brandService.getListByCondition(manuid, name, startDate, endDate);
		
	}
	//取得品牌商是否可用于新员工，返回TURE，表示不存在，可以使用；false表示品牌商已经存在，不能使用
	//用于JQuery Validate remote 的验证规则
	@RequestMapping(value="/checkIDCanBeUsed",method=RequestMethod.GET)
	public boolean checkIDCanBeUsed(String brand_name) throws Exception{
		List<BrandModel> list = brandService.getListByAll();
		for(BrandModel brandname : list) {
			if(brandname.getBrand_name()!=null&&brandname.getBrand_name().equals(brand_name)) {
				return false;
			}
		}
		return true;                   
		
	}
	
	
			
	
	

	
}
