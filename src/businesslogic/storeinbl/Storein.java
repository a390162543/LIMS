package businesslogic.storeinbl;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import po.StoreinPO;
import systemenum.DocumentState;
import systemenum.Position;
import systemenum.StorageState;
import dataservice.DataService;
import dataservice.StoreinDataService;
import vo.LogVO;
import vo.StorageLocationVO;
import vo.StoreinCheckVo;
import vo.StoreinCreateVO;
import vo.StoreinOrderVO;
import vo.StoreinQueryVO;
import vo.InOrderCheckResultVO;
import businesslogic.idbl.IdManager;
import businesslogic.logbl.Log;
import businesslogic.orderbl.Order;
import businesslogic.storagebl.Storage;
import businesslogic.storagebl.StorageHelper;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdblService;
import businesslogicservice.StoreinblService;



/**
 * 实现StoreinblService，提供界面需要调用的方法以及和其他模块交互的方法
 * 
 * @author lc
 * @version 1.4
 *
 */
public class Storein implements StoreinblService{

	@Override
	public boolean createStoreinPO(StoreinCreateVO vo) {
		StoreinDataService storeinDataService = DataService.getStoreinDataService();
		
		StoreinPO storeinPO = vo.getStoreinPO();
		storeinPO.setDocumentState(DocumentState.PENDING);
		try {
			storeinDataService.insert(storeinPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String operation = "创建了入库单"+"("+vo.getId()+")";
		LogVO logVO = new LogVO(operation, LoginController.getEmployeeId(), LoginController.getEmployeeName(), Position.STORAGEMANAGER);
		Log log = new Log();
		log.createLogPO(logVO);
		return true;
	}

	@Override
	public boolean modifyStorein(StoreinCreateVO vo) {
		StoreinDataService storeinDataService = DataService.getStoreinDataService();
		
		StoreinPO storeinPO = vo.getStoreinPO();
		StoreinPO updatePO = storeinPO.updateModifyInfo(vo);
		updatePO.setDocumentState(DocumentState.PASS);
		try {
			storeinDataService.insert(updatePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> orderId = updatePO.getOrderId();
		List<Integer> areaNum = updatePO.getAreaNum();
		List<Integer> rowNum = updatePO.getRowNum();
		List<Integer> frameNum = updatePO.getFrameNum();
		List<Integer> item = updatePO.getItem();
		Order order = new Order();
		StorageHelper helper = new StorageHelper();
		for (int i = 0; i < areaNum.size(); i++) {
			StoreinOrderVO storeinOrderVO = new StoreinOrderVO(orderId.get(i),
					areaNum.get(i), rowNum.get(i), frameNum.get(i), item.get(i));
			order.setStorageState(storeinOrderVO);
		}
		for (int i = 0; i < areaNum.size(); i++) {
			StorageLocationVO storageLocationVO = new StorageLocationVO(LoginController.getOrganizationId(),
					areaNum.get(i), rowNum.get(i), frameNum.get(i),
					item.get(i), StorageState.ISSTORED);
			helper.changeLocationState(storageLocationVO);
		}
		
		return true;
	}

	
	@Override
	public boolean execute(StoreinCreateVO vo) {
		StoreinDataService storeinDataService = DataService.getStoreinDataService();
		
		StoreinPO storeinPO = null;
		try {
			storeinPO = storeinDataService.find(vo.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		storeinPO.setDocumentState(DocumentState.PASS);
		try {
			storeinDataService.update(storeinPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> orderId = storeinPO.getOrderId();
		List<Integer> areaNum = storeinPO.getAreaNum();
		List<Integer> rowNum = storeinPO.getRowNum();
		List<Integer> frameNum = storeinPO.getFrameNum();
		List<Integer> item = storeinPO.getItem();
		Order order = new Order();
		StorageHelper helper = new StorageHelper();
		for (int i = 0; i < areaNum.size(); i++) {
			StoreinOrderVO storeinOrderVO = new StoreinOrderVO(orderId.get(i),
					areaNum.get(i), rowNum.get(i), frameNum.get(i), item.get(i));
			order.setStorageState(storeinOrderVO);
		}
		for (int i = 0; i < areaNum.size(); i++) {
			StorageLocationVO storageLocationVO = new StorageLocationVO(LoginController.getOrganizationId(),
					areaNum.get(i), rowNum.get(i), frameNum.get(i),
					item.get(i), StorageState.ISSTORED);
			helper.changeLocationState(storageLocationVO);
		}

		return true;
	}

	/**
	 * 库存盘点时，该方法提供满足条件的入库的货物
	 * 
	 * @param vo {@code StoreinCheckVo}
	 * @return 成功则返回一个{@code List<InOrderCheckResultVO>}，失败则返回{@code null}
	 */
	public List<InOrderCheckResultVO> storeinCheck(StoreinCheckVo vo) {
		StoreinDataService storeinDataService = DataService.getStoreinDataService();
		String field = vo.getFiled();
		Date value = vo.getFromDate();
		Date toDate = vo.getToDate();
		List<InOrderCheckResultVO> inCheckResultVOs = new ArrayList<InOrderCheckResultVO>();
		List<StoreinPO> storeinPOs = null;

		try {
			storeinPOs = storeinDataService.finds(field, value);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (StoreinPO po : storeinPOs) {
			if (po.getInDate().compareTo(toDate) <= 0) {
				for (int i = 0; i < po.getOrderId().size(); i++) {
					Order order = new Order();
					InOrderCheckResultVO checkResultVO = order.findStorein(po
							.getOrderId().get(i));
					checkResultVO.setDate(po.getInDate());
					checkResultVO.setDestination(po.getDestination());
					inCheckResultVOs.add(checkResultVO);
				}
			}
		}
		return inCheckResultVOs;
	}
	
	/**
	 * 库存查看时，该方法提供符合条件的入库单相应的信息
	 * 
	 * @param field {@code String}
	 * @param value {@code Object}
	 * @return 成功则返回一个{@code List<StoreinQueryVO>}，失败则返回{@code null}
	 */
	public List<StoreinQueryVO> storeinQuery(String field, Object value){
		StoreinDataService storeinDataService = DataService.getStoreinDataService();
		List<StoreinQueryVO> storeinQueryVOs = new ArrayList<StoreinQueryVO>();
		List<StoreinPO> storeinPOs = null;

		try {
			storeinPOs = storeinDataService.finds(field, value);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (StoreinPO po : storeinPOs) {
			storeinQueryVOs.add(po.getStoreinQueryVOs());
		}
		return storeinQueryVOs;
	}
	
	/**
	 * 获取待审批的入库单
	 * 
	 * @return 成功则返回一个{@code List<StoreinCreateVO>},失败则返回{@code null}
	 */
	public List<StoreinCreateVO> getStoreinPendingVOs() {	
		StoreinDataService storeinDataService = DataService.getStoreinDataService();
		List<StoreinCreateVO> storeinPendingVOs = new ArrayList<StoreinCreateVO>();
		List<StoreinPO> pendingStoreinPOs = null;

		try {
			pendingStoreinPOs = storeinDataService.finds("documentState",
					DocumentState.PENDING);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (StoreinPO po : pendingStoreinPOs) {
			storeinPendingVOs.add(po.getStoreinCreateVO());
		}
		return storeinPendingVOs;
	}

	
	@Override
	public boolean changeLocationState(StorageLocationVO vo) {
		StorageHelper helper = new StorageHelper();
		helper.changeLocationState(vo);
		Order order = new Order();
		order.storeinOrderState(vo.getOrderId());
		Storage storage = new Storage();
		storage.addNowCapacity(vo.getStorageId());
		return true;
	}

	@Override
	public boolean restoreLocationState(StorageLocationVO vo) {
		StorageHelper helper = new StorageHelper();
		helper.changeLocationState(vo);
		Order order = new Order();
		order.restoreOrderState(vo.getOrderId());
		return true;
	}
	
	/**
	 * 期初建账时入库单的执行
	 * 
	 * @param vos {@code List<StoreinCreateVO>}
	 * @return 成功则返回{@code true}，失败则返回{@code false}
	 */
	public boolean primeInfoExecute (List<StoreinCreateVO> vos){
		StoreinDataService storeinDataService = DataService.getStoreinDataService();

		for (StoreinCreateVO storeinCreateVO : vos) {
			StoreinPO po = storeinCreateVO.getStoreinPO();
			try {
				storeinDataService.insert(po);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}

	
	@Override
	public IdblService getIdblService() {
		
		StoreinDataService storeinDataService = DataService.getStoreinDataService();
		return new IdManager(storeinDataService, 6);
	}

	
}
