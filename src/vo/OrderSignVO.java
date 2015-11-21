package vo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import dataservice.OrderDataService;
import po.OrderPO;

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
	
	public OrderPO getOrderPO(){
		
		OrderPO po = null;
		
		return po;
	}

}
