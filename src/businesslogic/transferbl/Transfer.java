package businesslogic.transferbl;

 
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import dataservice.DataService;
import dataservice.TransferDataService; 
import po.TransferPO;
import systemenum.DocumentState; 
import businesslogic.idbl.IdManager;
import businesslogic.orderbl.Order;
import businesslogic.organizationbl.Organization;
import businesslogicservice.IdblService;
import businesslogicservice.TransferblService; 
import vo.GoodsVO;
import vo.OrderDeliverInfoVO;
import vo.TransferVO;

/**
 * {@code Transfer}是中转单业务逻辑的实现类，提供所有有关中转单的业务逻辑服务
 * @author 刘航伸
 *
 */
public class Transfer implements TransferblService{
	/**
	 * {@code Transfer}的数据层引用和逻辑层引用
	 */
	private GoodsList goodsList;
	private TransferDataService transferDataService ;
	
	public Transfer(){
		goodsList = new GoodsList();
		transferDataService = DataService.getTransferDataService();
	}
	
	public boolean addGoods(GoodsVO vo){
		goodsList.add(vo);
		return true;
	}
	
	public boolean  deleteGoods(GoodsVO vo){
		goodsList.delete(vo);
		return true;
	}
	
	public double getCost(String location1, String location2,String way){
		Organization organization = new Organization();
		double distance = organization.getDistanceByOrganizatioName(location1, location2);
		double weight = goodsList.getWeight();
		double cost = 0.0;
		double rate = 0.0;
		switch (way) {
		case "航空":
			rate = 20; break;
		case "铁路":
			rate = 0.2; break;
		case "汽运":
			rate = 2; break;
		default:
			break;
		}
		// weight 单位为kg
		cost = weight * rate * distance / 1000;
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
	/**
	 * 中转单的执行方法
	 *@param vo, TransferVO
	 *@return 成功执行返回true， 否则返回false
	 */
	public boolean execute(TransferVO vo) {
		// TODO Auto-generated method stub
		//更改物流信息
		Order order = new Order();
		
		String depart = vo.getDepart();
		String distination = vo.getDestination();
		String info = "正发往 " + vo.getDestination() + "中";
		for(String s : vo.getOrderId()){
			OrderDeliverInfoVO infoVO = new OrderDeliverInfoVO(s, depart, distination, info);
			order.modifyDeliverInfo(infoVO);
		}
		//更改中转单单据状态
		try {
			TransferPO po = vo.getTransferPO();
			po.setDocumentState(DocumentState.PASS);
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
	 
    /**
     * 获取所有待审批的{@code TransferVO}
     * @return {@code Transfer}的列表，如果没有符合条件的{@code TransferVO}，或者查询
     * 失败，则返回一个空列表
     */
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

	@Override
	public IdblService getIdblService(){
		// TODO Auto-generated method stub
	 return new IdManager(transferDataService, 7, true);
	}
	
    public TransferVO getTransferVO(String id){
        try {
            TransferPO po = transferDataService.find(id);
            if(po != null)
                return po.getTransferVO();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
	
}
