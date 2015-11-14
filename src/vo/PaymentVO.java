package vo;

import java.util.Date;

import systemenum.Entry;

public class PaymentVO {
	private long id;
	private Date date;
	private double money ;
	private String name;
	private long accountId;
	private Entry entry ;
	private long payeeAccountId;
	private String remarks;
	
	public PaymentVO(long id,Date date,double money,String name,long accountId,Entry entry,String remarks,long payeeAccountId){
		this.id=id;
		this.date=date;
		this.money=money;
		this.name=name;
		this.accountId=accountId;
		this.entry=entry;
		this.remarks=remarks;
		this.payeeAccountId=payeeAccountId;
	}
	
	public long getId(){
		return id;
	}
	
	public Date getDate(){
		return date;
	}
	
	public double getMoney(){
		return money;
	}
	
	public String getName(){
		return name;
	}

	public long getAccountId(){
		return accountId;
	}
	
	public Entry getEntry(){
		return entry;
	}
		
	public long getPayeeAccountId(){
		return payeeAccountId;
	}
	
	public String getRemarks(){
		return remarks;
	}
	


}
