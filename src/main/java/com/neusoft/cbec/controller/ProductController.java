package com.neusoft.cbec.controller;

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

}
