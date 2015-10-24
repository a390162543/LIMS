package po;

public class AccountPO {
	
	private long id;
	private double money;
    
	public AccountPO(long id,double money){
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
