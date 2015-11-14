package po;

import java.util.Date;

import systemenum.DocumentState;
import systemenum.Entry;

public class PaymentPO {
	
	private long id;
	private Date date;
	private double money ;
	private String name;
	private long accountId;
	private Entry entry ;
	private String remarks;
	private long payeeAccountId;
	private DocumentState documentState;
	
	public PaymentPO(long id,Date date,double money,String name,long accountId,Entry entry,String remarks,long payeeAccountId){
		this.id=id;
		this.date=date;
		this.money=money;
		this.name=name;
		this.accountId=accountId;
		this.entry=entry;
		this.remarks=remarks;
		this.payeeAccountId=payeeAccountId;
		this.documentState=DocumentState.PENDING;
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
	
	public String getRemarks(){
		return remarks;
	}

	public long getPayeeAccountId(){
		return payeeAccountId;
	}
	public DocumentState getDocumentState() {
		return documentState;
	}

	public void setDocumentState(DocumentState documentState) {
		this.documentState = documentState;
	}

}
