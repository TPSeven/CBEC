package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.ProductModel;
import com.nuesoft.cbec.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	private IProductService productService = null;
	@Autowired
	public void setProdudtService(IProductService productService) {
		this.productService = productService;
	}
	@RequestMapping("/add")
	public String add(ProductModel product) throws Exception {
		
		productService.add(product);
		return "ok";
		
	}
	
	@RequestMapping("/modify")
	public String modify(ProductModel product) throws Exception {
		
		productService.modify(product);
		return "ok";
		
	}
	
	@RequestMapping("/delete")
	public String delete(ProductModel product) throws Exception {
		
		productService.delete(product);
		return "ok";
		
	}
	@RequestMapping("/list/all")
	public List<ProductModel> getListByAll() throws Exception{
		return productService.getListByAll();
	}

}
