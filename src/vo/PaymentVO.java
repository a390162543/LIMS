package vo;

import java.util.Date;

import po.PaymentPO;
import systemenum.Entry;

public class PaymentVO {
	private String id;
	private Date date;
	private double money ;
	private String name;
	private String accountId;
	private String payeeAccountId;
	private Entry entry ;	
	private String remarks;
	
	public PaymentVO(String id,Date date,double money,String name,String accountId,String payeeAccountId,Entry entry,String remarks){
		this.id=id;
		this.date=date;
		this.money=money;
		this.name=name;
		this.accountId=accountId;
		this.payeeAccountId=payeeAccountId;
		this.entry=entry;
		this.remarks=remarks;		
	}
	
	public String getId(){
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

	public String getAccountId(){
		return accountId;
	}
	
	public Entry getEntry(){
		return entry;
	}
		
	public String getPayeeAccountId(){
		return payeeAccountId;
	}
	
	public String getRemarks(){
		return remarks;
	}
	
	public PaymentPO getPaymentPO(){
		PaymentPO po = new PaymentPO(id, date , money , name , accountId , payeeAccountId , entry , remarks );
		return po;
	}

}
