package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.WalletModel;
import com.nuesoft.cbec.service.IWalletService;

/**
 * @author Wwl 温万龙
 * 钱包 控制层
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {
	private IWalletService walletService = null;

	@Autowired
	public void setWalletService(IWalletService walletService) {
		this.walletService = walletService;
	}
	
	@RequestMapping("/list")
	public List<WalletModel> getListByAll() throws Exception{
		return walletService.getListByAll();
	}
	
	@RequestMapping(value="/get/byId",method= {RequestMethod.GET})
	public WalletModel getWalletById(@RequestParam(required=true)int id) throws Exception{
		return walletService.getWalletById(id);
	}
}
