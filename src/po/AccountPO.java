package po;

import java.io.Serializable;

import vo.AccountVO;
/**
 * {@code AccountPO}是账户业务逻辑层与数据层之间传递的持久化对象，
 * 记录了账户的所有信息
 * @author 刘德宽
 *
 */
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
    /**
     * 获取该{@code AccountPO}对应的{@code AccountVO}对象
     * @return {@code AccountVO}对象
     */
	public AccountVO getAccountVO(){
		AccountVO vo = new AccountVO(id,name,money);
		return vo;		
	}

    /**
     * 用一个{@code AccountVO}对象更新{@code AccountPO}的信息
     * @param vo {@code AccountVO}对象
     */
	public  void update(AccountVO vo){
		this.id = vo.getId();
		this.name = vo.getName();
		this.money = vo.getMoney();
	}
}
