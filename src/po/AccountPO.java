package po;

import java.io.Serializable;

import vo.AccountVO;

public class AccountPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1234278313697247619L;
	
	private String id;
	private String name;
	private double money;
    
	public AccountPO(String id,String name,double money){
		this.id = id;
		this.name = name;
		this.money = money;
	}
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public double getMoney(){
		return money;
	}
	
	public boolean setMoney(double money){
		this.money = money;
		return true;
	}
	public AccountVO getAccountVO(){
		AccountVO vo = new AccountVO(id,name,money);
		return vo;		
	}

	public  void update(AccountVO vo){
		this.id = vo.getId();
		this.name = vo.getName();
		this.money = vo.getMoney();
	}
}
