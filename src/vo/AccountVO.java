package vo;

public class AccountVO {

	private long id;
	private double money;
    
	public AccountVO(long id,double money){
		this.id=id;
		this.money=money;
	}
	
	public long getId(){
		return id;
	}
	
	public double getMoney(){
		return money;
	}
}
