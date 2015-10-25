package vo;

import java.util.Date;

public class OrderSignVO {
	
	private long id;
	private String signName;
	private Date signData;
	
	public OrderSignVO(long id, String signName, Date signData) {
		super();
		this.id = id;
		this.signName = signName;
		this.signData = signData;
	}

	public long getId() {
		return id;
	}

	public String getSignName() {
		return signName;
	}

	public Date getSignData() {
		return signData;
	}
	
	

}
