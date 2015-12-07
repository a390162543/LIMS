package vo;

import java.util.Date;



/**
 * ����ѯʱ���ص�VO
 * �ڳ�����Ҳʹ�ø�VO
 * 
 * @author lc
 * @version 1.5
 *
 */
public class StoreinCheckResultVO {
	
	
	//���������ڳ����˵�VO
	private String orderId;
	private Integer areaNum;
	private Integer rowNum;
	private Integer frameNum;
	private Integer item;
	private Date date; //�������
	private String desination;  //Ŀ�ĵ�
	
	public StoreinCheckResultVO(String orderId, Integer areaNum, Integer rowNum,
			Integer frameNum, Integer item) {
		super();
		this.orderId = orderId;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
	}
	
	

	public StoreinCheckResultVO(String orderId, Integer areaNum,
			Integer rowNum, Integer frameNum, Integer item, Date date,
			String desination) {
		super();
		this.orderId = orderId;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.date = date;
		this.desination = desination;
	}



	public String getOrderId() {
		return orderId;
	}

	public Integer getAreaNum() {
		return areaNum;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public Integer getFrameNum() {
		return frameNum;
	}

	public Integer getItem() {
		return item;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getDesination() {
		return desination;
	}



	public void setDesination(String desination) {
		this.desination = desination;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public void setAreaNum(Integer areaNum) {
		this.areaNum = areaNum;
	}



	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}



	public void setFrameNum(Integer frameNum) {
		this.frameNum = frameNum;
	}



	public void setItem(Integer item) {
		this.item = item;
	}
	
	

	

}
