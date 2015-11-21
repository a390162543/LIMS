package vo;

import java.util.Date;

public class StoreinCheckVo {
	
	String filed;
	Date fromDate;
	Date toDate;
	
	public StoreinCheckVo(String filed, Date fromDate, Date toDate) {
		super();
		this.filed = filed;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public String getFiled() {
		return filed;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public Date getToDate() {
		return toDate;
	}
	
}
