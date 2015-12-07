package vo;

import systemenum.GoodsState;
import systemenum.ShipForm;


/**
 * 该VO用于装车单更新是传递信息
 * @author lc
 * @version 1.3
 *
 */
public class OrderQueryVO {
	
	 private String id;
	 private GoodsState state;
	 private String deliverInfo;
	 private String nowLocation;
	 private String nextLocation;
	 private ShipForm shipForm;
	 
	 public OrderQueryVO(String id, GoodsState state, String deliverInfo,
			String nowLocation, String nextLocation) {
		super();
		this.id = id;
		this.state = state;
		this.deliverInfo = deliverInfo;
		this.nowLocation = nowLocation;
		this.nextLocation = nextLocation;
	}

	 
	 
	public OrderQueryVO(String id, GoodsState state, String deliverInfo,
			String nowLocation, String nextLocation, ShipForm shipForm) {
		super();
		this.id = id;
		this.state = state;
		this.deliverInfo = deliverInfo;
		this.nowLocation = nowLocation;
		this.nextLocation = nextLocation;
		this.shipForm = shipForm;
	}



	public String getId() {
		return id;
	}

	public GoodsState getState() {
		return state;
	}

	public String getDeliverInfo() {
		return deliverInfo;
	}

	public String getNowLocation() {
		return nowLocation;
	}

	public String getNextLocation() {
		return nextLocation;
	}



	public ShipForm getShipForm() {
		return shipForm;
	}
	 
	 
	 

}
