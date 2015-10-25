package vo;

import java.util.Date;
import java.util.List;

public class TransferVO {
	private long id;
	private Date loadDate;
	private  long flightNumbe;
	private  String depart;
	private  String destination;
	private  long containerId;
	private  String loadMan;
	private  List<Long> orderId;
	private double expenses;
	  
	public TransferVO(long id, Date loadDate, long flightNumbe, String depart,
			String destination, long containerId, String loadMan,
			List<Long> orderId, double expenses) {
		super();
		this.id = id;
		this.loadDate = loadDate;
		this.flightNumbe = flightNumbe;
		this.depart = depart;
		this.destination = destination;
		this.containerId = containerId;
		this.loadMan = loadMan;
		this.orderId = orderId;
		this.expenses = expenses;
	}
	  
	  

}
