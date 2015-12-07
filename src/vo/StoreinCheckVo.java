package vo;

import java.util.Date;


/**
 * 入库单查询时传递的VO，用于查询符合条件的VO
 * @author lc
 * @version 1.3
 *
 */
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
