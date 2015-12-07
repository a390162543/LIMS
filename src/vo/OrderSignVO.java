package vo;


import java.util.Date;
import po.OrderPO;


/**
 * 该VO包含订单创建时的信息
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
	 * 获取相应的OrderPO
	 * @return 返回一个{@code OrderPO}
	 */
	public OrderPO getOrderPO(){
		
		OrderPO po = null;
		
		return po;
	}

}
