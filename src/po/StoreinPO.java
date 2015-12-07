package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import systemenum.DocumentState;
import vo.StoreinCheckResultVO;
import vo.StoreinCreateVO;
import vo.StoreinQueryVO;


/**
 * ����һ����ⵥ����Ϣ
 * 
 * @author lc
 * @version 1.3
 *
 */
public class StoreinPO implements Serializable{
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 9100315138503885498L;

	
	public StoreinPO(String id,List<String> orderId, Date inDate, String destination,
			List<Integer> areaNum, List<Integer> rowNum,
			List<Integer> frameNum, List<Integer> item) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.date = inDate;
		this.destination = destination;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.documentState = DocumentState.PENDING;
	}


	private String id;
	private DocumentState documentState;
	private List<String> orderId;
	private Date date;
	private String destination; 
	private List<Integer> areaNum;
	private List<Integer> rowNum;
	private List<Integer> frameNum;
	private List<Integer> item;
	private String organization;  //1.�������ĸ����Ĵ洢����Ӧ��λ�ã��ֶβ��ң�2.��Ӧ����ⵥ�ĳ�����
	
	
		
	public StoreinPO(String id, List<String> orderId,
			Date date, String destination, List<Integer> areaNum,
			List<Integer> rowNum, List<Integer> frameNum, List<Integer> item,
			String organization) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.date = date;
		this.destination = destination;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.organization = organization;
	}


	public String getOrganization(){
		return organization;
	}
	
	
	public DocumentState getDocumentState() {
		return documentState;
	}

	public void setDocumentState(DocumentState documentState) {
		this.documentState = documentState;
	}
	
	public String getStoreinId() {
		return id;
	}
	
	public List<String> getOrderId() {
		return orderId;
	}
	
	public Date getInDate() {
		return date;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public List<Integer> getAreaNum() {
		return areaNum;
	}
	
	public List<Integer> getRowNum() {
		return rowNum;
	}
	
	public List<Integer> getFrameNum() {
		return frameNum;
	}
	
	public List<Integer> getItem() {
		return item;
	}
	
	/**
	 * ��ȡ����ⵥ�еĶ���
	 * 
	 * @return ����һ��{@code List<StoreinCheckResultVO>}
	 */
	public List<StoreinCheckResultVO> getStoreinCheckResultVOs(){
		List<StoreinCheckResultVO> storeinCheckResultVOs = new ArrayList<StoreinCheckResultVO>();
		for (int i = 0; i < orderId.size(); i++) {
			StoreinCheckResultVO vo = new StoreinCheckResultVO(orderId.get(i), areaNum.get(i), 
					rowNum.get(i), frameNum.get(i), item.get(i));
			storeinCheckResultVOs.add(vo);
		}
		return storeinCheckResultVOs;	
	}
	
	/**
	 * ��ȡ�޸ĺ����ⵥ����
	 * 
	 * @param vo {@code StoreinCreateVO}
	 * @return ����һ��{@code StoreinPO}
	 */
	public StoreinPO updateModifyInfo(StoreinCreateVO vo) {
		
		return this;
	}

	
	public StoreinQueryVO getStoreinQueryVOs() {
		return new StoreinQueryVO(orderId, areaNum, rowNum, frameNum, item, date, destination);
	}
	
	/**
	 * ��ȡ������������Ϣ
	 * 
	 * @return ����һ��{@code StoreinCreateVO}
	 */
	public StoreinCreateVO getStoreinCreateVO() {
		return new StoreinCreateVO(id, orderId, date, destination, areaNum, rowNum, frameNum, item, organization);
	}
}
