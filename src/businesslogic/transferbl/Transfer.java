package businesslogic.transferbl;

import java.net.MalformedURLException;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import dataservice.OrderDataService;
import dataservice.TransferDataService; 
import po.OrderPO;
import po.TransferPO;
import systemenum.DocumentState; 
import businesslogicservice.TransferblService; 
import vo.GoodsVO;
import vo.TransferVO;

public class Transfer implements TransferblService{
	private GoodsList goodsList;
	private TransferDataService transferDataService ;
	
	public Transfer(){
		goodsList = new GoodsList();
		try { 
        	 transferDataService = (TransferDataService) Naming.lookup
        			("rmi://localhost/TransferData");
		 
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addGoods(GoodsVO vo){
		goodsList.add(vo);
	}
	
	public void deleteGoods(GoodsVO vo){
		goodsList.delete(vo);
	}
	
	public double getCost(String location1, String location2){
		
		return 0;
	}

	@Override
	public boolean createTransferPO(TransferVO vo) {
		// TODO Auto-generated method stub
		try {         
			transferDataService.insert(vo.getTransferPO());		 	
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean modifyTransferPO(TransferVO vo) {
		// TODO Auto-generated method stub
		try {         	 
			 	transferDataService.update(vo.getTransferPO());			 
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<TransferVO> getTransferVO() {
		// TODO Auto-generated method stub
		List<TransferVO> vos =  new ArrayList<TransferVO>();
		 try {
			  List<TransferPO> pos= transferDataService.getAll();
			 for(TransferPO po : pos)
				 vos.add(po.getTransferVO());      
	         
	        } catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vos;
	}

	@Override
	public boolean execute(TransferVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GoodsVO getGoodsVO(String id) {
		// TODO Auto-generated method stub	
		try {
			OrderDataService orderDataService = (OrderDataService)Naming.lookup("rmi://localhost/OrderData");
			if(orderDataService.find(id) == null)
				return null;
			else{
				OrderPO po = orderDataService.find(id);
				GoodsVO vo = po.getGoodsVO();
				return vo;
			}
			
			 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		return null;
	}
	
	public List<TransferVO> getPendingTransferVO(){
		List<TransferVO> vos =  new ArrayList<TransferVO>();
		 try {
			 TransferDataService tds = (TransferDataService) Naming.lookup
	        			("rmi://localhost/TransferData");
			 List<TransferPO> pos= tds.finds("documentState", DocumentState.PENDING);
			 for(TransferPO po : pos){
				 vos.add(po.getTransferVO());
			 }
	           
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (NotBoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		return vos;
		
	}
	
}
