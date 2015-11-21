package businesslogicservice_stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import systemenum.ShipForm;
import vo.StorageCheckVO;
import vo.StorageQueryResultVO;
import vo.StorageSetAreaVO;
import vo.StoreinCheckVo;
import vo.StoreinCreateVO;
import vo.StoreoutCreateVO;
import vo.InOrderCheckResultVO;
import vo.OutOrderCheckResultVO;
import businesslogicservice.StorageblService;

public class StorageblService_Stub implements StorageblService {
	
	Date storeOrderDate;	
	String storageCheckId;
	String nextLocation;
	String destination;
	int storeAreaNum;
	int storeRowNum;
	int storeFrameNum;
	int storeItem;
	StorageCheckVO vo;
	
	
	double alarm;
	
	String storeinId;
	List<String> storeinOrderId;
	Date storeinDate;
	 
	List<Integer> areaNum;
	List<Integer> rowNum;
	List<Integer> frameNum;
	List<Integer> item;
	
	String storeoutId;
	List<String> storeoutOrderId;
	Date storeoutDate;
	String storeoutdestination;
	ShipForm shipForm;
	String transferId;
	
	
	
	public StorageblService_Stub(String storageCheckId,StorageCheckVO vo,
			 double alarm, String storeinId,
			List<String> storeinOrderId, Date storeinDate, List<Integer> areaNum,
			List<Integer> rowNum, List<Integer> frameNum, List<Integer> item,
			String storeoutId, List<String> storeoutOrderId, Date storeoutDate,
			String storeoutdestination, ShipForm shipForm,
			String transferId,String nextLocation,Date storeOrderDate,int storeAreaNum,
			int storeRowNum,int storeFrameNum,int storeItem) {
		super();
		this.storageCheckId = storageCheckId;
		this.vo = vo;
		this.alarm = alarm;
		this.storeinId = storeinId;
		this.storeinOrderId = storeinOrderId;
		this.storeinDate = storeinDate;
		
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.storeoutId = storeoutId;
		this.storeoutOrderId = storeoutOrderId;
		this.storeoutDate = storeoutDate;
		this.storeoutdestination = storeoutdestination;
		this.shipForm = shipForm;
		this.transferId = transferId;
		this.nextLocation = nextLocation;
		this.storeOrderDate = storeOrderDate;
		this.storeAreaNum = storeAreaNum;
		this.storeFrameNum = storeFrameNum;
		this.storeRowNum = storeRowNum;
		this.storeItem = storeItem;
	}

	
	
	@Override
	public boolean setArea(StorageSetAreaVO vo) {
		return true;
	}

	@Override
	public List<StorageCheckVO> storeCheck(Date date) {
		List<StorageCheckVO> storageCheckVOs = new ArrayList<StorageCheckVO>();
		storageCheckVOs.add(new StorageCheckVO(storageCheckId, storeOrderDate, nextLocation, storeAreaNum, storeRowNum, storeFrameNum, storeItem));
		return storageCheckVOs;
	}

	@Override
	public boolean isExceeded() {
		return false;
	}

	@Override
	public boolean gainExcel() {
		return true;
	}

	@Override
	public boolean setAlarm(double alarm) {
		return true;
	}

	@Override
	public List<StoreoutCreateVO> storeoutQuery(Date fromDate, Date toDate) {
		List<StoreoutCreateVO> storeoutCreateVOs = new ArrayList<StoreoutCreateVO>();
		storeoutCreateVOs.add(new StoreoutCreateVO(storeoutId, storeoutOrderId, storeoutDate, storeoutdestination, shipForm, transferId));
		return storeoutCreateVOs;
	}

	@Override
	public List<StoreinCreateVO> storeinQuery(Date fromDate, Date toDate) {
		List<StoreinCreateVO> storeinCreateVOs = new ArrayList<StoreinCreateVO>();
		storeinCreateVOs.add(new StoreinCreateVO(storeinId, storeinOrderId, storeinDate, destination ,areaNum, rowNum, frameNum, item));
		return storeinCreateVOs;
	}



	@Override
	public int getTotalStorein(List<StoreinCreateVO> storeinList) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int getTotalStoreout(List<StoreoutCreateVO> storeoutList) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public StorageSetAreaVO getStorageData(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<OutOrderCheckResultVO> storeoutCheck(StoreinCheckVo vo) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<InOrderCheckResultVO> storeinCheck(StoreinCheckVo vo) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<StorageQueryResultVO> storageQuery(String field, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
