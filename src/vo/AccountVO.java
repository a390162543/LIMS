package vo;

import po.AccountPO;
/**
 * {@code AccountVO}是账户界面与业务逻辑层之间传递的值对象，
 * 记录了账户的所有信息
 * @author 刘德宽
 * @version 1.6
 */
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
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setMoney(double money){
		this.money = money;
	}
    /**
     * 获取一个{@code AccountVO}对应的{@code AccountPO}对象
     * @return {@code AccountPO}对象
     */
	public AccountPO getAccountPO(){
		AccountPO po = new AccountPO(id ,name,money);
		return po;	
	}

}
