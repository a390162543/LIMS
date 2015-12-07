package vo;


import java.util.Date;
import po.OrderPO;


/**
 * ��VO������������ʱ����Ϣ
 * 
 * @author lc
 * @version 1.3
 *
 */
public class OrderSignVO {
	
	private String id;
	private String signName;
	private Date signData;
	
	public OrderSignVO(String id, String signName, Date signData) {
		super();
		this.id = id;
		this.signName = signName;
		this.signData = signData;
	}

	public String getId() {
		return id;
	}

	public String getSignName() {
		return signName;
	}

	public Date getSignData() {
		return signData;
	}
	
	/**
	 * ��ȡ��Ӧ��OrderPO
	 * @return ����һ��{@code OrderPO}
	 */
	public OrderPO getOrderPO(){
		
		OrderPO po = null;
		
		return po;
	}

}
