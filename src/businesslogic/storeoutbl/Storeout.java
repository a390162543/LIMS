package businesslogic.storeoutbl;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.StoreoutPO;
import systemenum.DocumentState;
import systemenum.Position;
import systemenum.StorageState;
import dataservice.DataService;
import dataservice.StoreoutDataService;
import vo.LoadVO;
import vo.LogVO;
import vo.StorageLocationVO;
import vo.StoreinCheckVo;
import vo.StoreinOrderVO;
import vo.StoreoutCreateVO;
import vo.StoreoutQueryVO;
import vo.OutOrderCheckResultVO;
import vo.TransferVO;
import businesslogic.idbl.IdManager;
import businesslogic.loadbl.Load;
import businesslogic.logbl.Log;
import businesslogic.orderbl.Order;
import businesslogic.storagebl.Storage;
import businesslogic.storagebl.StorageHelper;
import businesslogic.transferbl.Transfer;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdblService;
import businesslogicservice.StoreoutblService;


/**
 * 
 * @author lc
 *
 */
public class Storeout implements StoreoutblService{

	@Override
	public boolean createStoreoutPO(StoreoutCreateVO vo) {
		StoreoutDataService storeoutDataService = DataService.getStoreoutDataService();
		
		StoreoutPO po = vo.getStoreoutPO();
		po.setDocumentState(DocumentState.PENDING);
		try {
			storeoutDataService.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String operation = "创建了出库单"+"("+vo.getId()+")";
		Log log = new Log();
		log.createLogPO(operation);
		return true;
	}

	@Override
	public boolean modifyStoreout(StoreoutCreateVO vo) {
		StoreoutDataService storeoutDataService = DataService.getStoreoutDataService();
	
		StoreoutPO storeoutPO = vo.getStoreoutPO();
		StoreoutPO updatePO = storeoutPO.updateModifyInfo(vo);
		updatePO.setDocumentState(DocumentState.PASS);
		try {
			storeoutDataService.insert(updatePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> orderIdList = updatePO.getOrderId();
		Order order = new Order();
		StorageHelper helper = new StorageHelper();
		for (int i = 0; i < orderIdList.size(); i++) {
			StoreinOrderVO storeinOrderVO = order.getStorageOrderVO(orderIdList
					.get(i));
			StorageLocationVO storageLocationVO = new StorageLocationVO(LoginController.getOrganizationId(),
					storeinOrderVO.getAreaNum(), storeinOrderVO.getRowNum(),
					storeinOrderVO.getFrameNum(), storeinOrderVO.getItem(),
					StorageState.ISAVAILABLE);
			helper.changeLocationState(storageLocationVO);
			order.setStoreoutState(orderIdList.get(i));
		}

		return false;
	}

	
	@Override
	public boolean execute(StoreoutCreateVO vo) {
		StoreoutDataService storeoutDataService = DataService.getStoreoutDataService();
		
		StoreoutPO storeoutPO = null;
		try {
			storeoutPO = storeoutDataService.find(vo.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		storeoutPO.setDocumentState(DocumentState.PASS);
		try {
			storeoutDataService.update(storeoutPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StorageHelper helper = new StorageHelper();
		Order order = new Order();
		List<String> orderIdList = storeoutPO.getOrderId();

		for (int i = 0; i < orderIdList.size(); i++) {
			StoreinOrderVO storeinOrderVO = order.getStorageOrderVO(orderIdList
					.get(i));
			StorageLocationVO storageLocationVO = new StorageLocationVO(LoginController.getOrganizationId(),
					storeinOrderVO.getAreaNum(), storeinOrderVO.getRowNum(),
					storeinOrderVO.getFrameNum(), storeinOrderVO.getItem(),
					StorageState.ISAVAILABLE);
			helper.changeLocationState(storageLocationVO);
			order.setStoreoutState(orderIdList.get(i));
		}

		return true;
	}

	/**
	 * 库存盘点时，该方法提供满足条件的出库的货物
	 * 
	 * @param vo {@code StoreoutCheckVo}
	 * @return 成功则返回一个{@code List<OutOrderCheckResultVO>}，失败则返回{@code null}
	 */
	public List<OutOrderCheckResultVO> storeoutCheck(StoreinCheckVo vo) {
		StoreoutDataService storeoutDataService = DataService.getStoreoutDataService();
		String field = vo.getFiled();
		Date value = vo.getFromDate();
		Date toDate = vo.getToDate();
		List<OutOrderCheckResultVO> outCheckResultVOs = new ArrayList<OutOrderCheckResultVO>();
		List<StoreoutPO> storeoutPOs = null;

		try {
			storeoutPOs = storeoutDataService.finds(field, value);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (StoreoutPO po : storeoutPOs) {
			if (po.getDate().compareTo(toDate) <= 0) {
				for (int i = 0; i < po.getOrderId().size(); i++) {
					Order order = new Order();
					OutOrderCheckResultVO checkResultVO = order.findStoreout(po
							.getOrderId().get(i));
					checkResultVO.setDate(po.getDate());
					checkResultVO.setDestination(po.getDestination());
					outCheckResultVOs.add(checkResultVO);
				}

			}
		}

		return outCheckResultVOs;	
	}
	
	
	/**
	 * 库存查看时，该方法提供符合条件的出库单相应的信息
	 * 
	 * @param field {@code String}
	 * @param value {@code Object}
	 * @return 成功则返回一个{@code List<StoreoutQueryVO>}，失败则返回{@code null}
	 */
	public List<StoreoutQueryVO> getStoreoutQueryVOs(String field, Object value) {
		StoreoutDataService storeoutDataService = DataService.getStoreoutDataService();
		List<StoreoutQueryVO> storeoutQueryVOs = new ArrayList<StoreoutQueryVO>();
		List<StoreoutPO> storeoutPOs = null;

		try {
			storeoutPOs = storeoutDataService.finds(field, value);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (StoreoutPO po : storeoutPOs) {
			storeoutQueryVOs.add(po.getStoreoutQueryVO());
		}
		return storeoutQueryVOs;

	}
	
	/**
	 * 获取待审批的出库单
	 * 
	 * @return 成功则返回一个{@code List<StoreoutCreateVO>},失败则返回{@code null}
	 */
	public List<StoreoutCreateVO> getPendingStoreoutCreateVO () {
		StoreoutDataService storeoutDataService = DataService.getStoreoutDataService();
		List<StoreoutCreateVO> storeoutPendingVOs = new ArrayList<StoreoutCreateVO>();
		List<StoreoutPO> pendingStoreoutPOs = null;

		try {
			pendingStoreoutPOs = storeoutDataService.finds("documentState",
					DocumentState.PENDING);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (StoreoutPO po : pendingStoreoutPOs) {
			storeoutPendingVOs.add(po.getStoreoutCreateVO());
		}
		return storeoutPendingVOs;
	}

	
	
	@Override
	public boolean changeLocationState(String orderId) {
		Order order = new Order();
		StoreinOrderVO storeinOrderVO = order.getStorageOrderVO(orderId);
		order.storeoutOrderState(orderId);
		StorageLocationVO vo = new StorageLocationVO(LoginController.getOrganizationId(),storeinOrderVO.getAreaNum(), storeinOrderVO.getRowNum(), 
				storeinOrderVO.getFrameNum(), storeinOrderVO.getItem(), StorageState.ISSTORINGOUT);
		StorageHelper helper = new StorageHelper();
		helper.changeLocationState(vo);
		Storage storage = new Storage();
		storage.reduceNowCapacity(vo.getStorageId());
		return true;
	}

	
	@Override
	public boolean restoreLcationState(String orderId) {
		Order order = new Order();
		StoreinOrderVO storeinOrderVO = order.getStorageOrderVO(orderId);
		order.restoreOrderState(orderId);
		StorageLocationVO vo = new StorageLocationVO(LoginController.getOrganizationId(),storeinOrderVO.getAreaNum(), storeinOrderVO.getRowNum(), 
				storeinOrderVO.getFrameNum(), storeinOrderVO.getItem(), StorageState.ISSTORED);
		StorageHelper helper = new StorageHelper();
		helper.changeLocationState(vo);
		return true;
	}

	@Override
	public IdblService getIdblService() {
		StoreoutDataService storeoutDataService = DataService.getStoreoutDataService();
		return new IdManager(storeoutDataService, 6);
	}

	@Override
	public List<String> getTransferVO(String transferId) {
		Transfer transfer = new Transfer();
		List<String> orders = new ArrayList<String>();
		TransferVO transferVO = transfer.find(transferId);
		orders = transferVO.getOrderId();
		return orders;
	}

	@Override
	public List<String> getLoadVO(String loadId) {
		Load load = new Load();
		List<String> orders = new ArrayList<String>();
		LoadVO loadVO = load.getLoadVO(loadId);
		orders = loadVO.getOrderId();
		return orders;
	}
	
	 
}
