package po;

import java.io.Serializable;
import java.util.Date;

import systemenum.DocumentState;
import systemenum.Entry;
import vo.PaymentVO;
/**
 * {@code PaymentPO}是付款单业务逻辑层与数据层之间传递的持久化对象，
 * 记录了付款单的所有信息
 * @author 刘德宽
 * @see systemenum.DocumentState
 */
public class PaymentPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7585418107787136611L;
	private String id;
	private Date date;
	private double money ;
	private String name;
	private String accountId;
	private String payeeAccountId;
	private Entry entry ;
	private String remarks;
	
	private DocumentState documentState;
	
	public PaymentPO(String id,Date date,double money,String name,String accountId,String payeeAccountId,Entry entry,String remarks){
		this.id=id;
		this.date=date;
		this.money=money;
		this.name=name;
		this.accountId=accountId;
		this.payeeAccountId=payeeAccountId;
		this.entry=entry;
		this.remarks=remarks;
		this.documentState=DocumentState.PENDING;
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
	
	public String getRemarks(){
		return remarks;
	}

	public String getPayeeAccountId(){
		return payeeAccountId;
	}
	public DocumentState getDocumentState() {
		return documentState;
	}

	public void setDocumentState(DocumentState documentState) {
		this.documentState = documentState;
	}

    /**
     * 获取该{@code PaymentPO}对应的{@code PaymentVO}对象
     * @return {@code PaymentVO}对象
     */
	public PaymentVO getPaymentVO(){
		PaymentVO vo = new PaymentVO(id, date , money , name , accountId , payeeAccountId , entry , remarks );
		return vo;
	}

    /**
     * 用一个{@code PaymentVO}对象更新{@code PaymentPO}的信息
     * @param vo {@code PaymentVO}对象
     */
	public void update(PaymentVO vo){
		this.id = vo.getId();
		this.date = vo.getDate();
		this.money = vo.getMoney();
		this.name = vo.getName();
		this.payeeAccountId = vo.getPayeeAccountId();
		this.accountId = vo.getAccountId();
		this.entry = vo.getEntry();
		this.remarks = vo.getRemarks();
	}
}
