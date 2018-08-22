package com.neusoft.cbec.model;

import org.apache.ibatis.type.Alias;

/**
 * @author Wwl 温万龙
 * 钱包model类
 */
@Alias("Wallet")
public class WalletModel {
	private int id = 0 ; //钱包主键
	private double balance = 0.0 ; //余额
	private int bankcards = 0; //银行卡，应该关联一个银行卡信息表
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getBankcards() {
		return bankcards;
	}
	public void setBankcards(int bankcards) {
		this.bankcards = bankcards;
	}
	
}
