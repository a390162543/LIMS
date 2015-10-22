package po;

public class AccountPO {
	
	private long id;
	private long name;
	private double money;
    
	public AccountPO(long id,long name,double money){
		this.id=id;
		this.name=name;
		this.money=money;
	}
	
	public long getId(){
		return id;
	}
	
	public long getName(){
		return name;
	}
	
	public double getMoney(){
		return money;
	}
	
}
