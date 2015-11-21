package vo;

import po.AccountPO;

public class AccountVO {

	private String id;
	private String name;
	private double money;
    
	public AccountVO(String id, String name,double money){
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
	public AccountPO getAccountPO(){
		AccountPO po = new AccountPO(id ,name,money);
		return po;	
	}

}
