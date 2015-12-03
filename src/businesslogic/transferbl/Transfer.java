package businesslogic.transferbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import dataservice.TransferDataService; 
import po.TransferPO;
import systemenum.DocumentState; 
import businesslogic.orderbl.Order;
import businesslogic.organizationbl.Organization;
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
	
	public double getCost(String location1, String location2,String way){
		Organization organization = new Organization();
		double distance = organization.getDistanceByOrganizatioName(location1, location2);
		double weight = goodsList.getWeight();
		double cost = 0.0;
		double rate = 0.0;
		switch (way) {
		case "º½¿Õ":
			rate = 20; break;
		case "ÌúÂ·":
			rate = 0.2; break;
		case "ÆûÔË":
			rate = 2; break;
		default:
			break;
		}
		cost = weight * rate * distance;
		return cost;
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
		TransferPO po = vo.getTransferPO();
		po.setDocumentState(DocumentState.PASS);
		try {
			transferDataService.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public GoodsVO getGoodsVO(String id) {
		// TODO Auto-generated method stub	
		 Order order = new Order();
		 GoodsVO vo = order.getGoodsVO(id);				 
		 return vo;
			 		 
	}
	
	public List<TransferVO> getPendingTransferVO(){
		List<TransferVO> vos =  new ArrayList<TransferVO>();
		 try {
			 List<TransferPO> pos= transferDataService.finds("documentState", DocumentState.PENDING);
			 for(TransferPO po : pos){
				 vos.add(po.getTransferVO());
			 }        
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }  
		return vos;
		
	}
	
	public TransferVO find(String id){
		try {
			TransferVO vo = transferDataService.find(id).getTransferVO();
			return vo;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
