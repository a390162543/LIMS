package po;

import java.io.Serializable;

import vo.AccountVO;
/**
 * {@code AccountPO}���˻�ҵ���߼��������ݲ�֮�䴫�ݵĳ־û�����
 * ��¼���˻���������Ϣ
 * @author ���¿�
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
     * ��ȡ��{@code AccountPO}��Ӧ��{@code AccountVO}����
     * @return {@code AccountVO}����
     */
	public AccountVO getAccountVO(){
		AccountVO vo = new AccountVO(id,name,money);
		return vo;		
	}

    /**
     * ��һ��{@code AccountVO}�������{@code AccountPO}����Ϣ
     * @param vo {@code AccountVO}����
     */
	public  void update(AccountVO vo){
		this.id = vo.getId();
		this.name = vo.getName();
		this.money = vo.getMoney();
	}
}
