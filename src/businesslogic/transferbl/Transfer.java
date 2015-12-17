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
 * {@code Transfer}����ת��ҵ���߼���ʵ���࣬�ṩ�����й���ת����ҵ���߼�����
 * @author ������
 *
 */
public class Transfer implements TransferblService{
	/**
	 * {@code Transfer}�����ݲ����ú��߼�������
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
		case "����":
			rate = 20; break;
		case "��·":
			rate = 0.2; break;
		case "����":
			rate = 2; break;
		default:
			break;
		}
		// weight ��λΪkg
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
	 * ��ת����ִ�з���
	 *@param vo, TransferVO
	 *@return �ɹ�ִ�з���true�� ���򷵻�false
	 */
	public boolean execute(TransferVO vo) {
		// TODO Auto-generated method stub
		//����������Ϣ
		Order order = new Order();
		
		String depart = vo.getDepart();
		String distination = vo.getDestination();
		String info = "������ " + vo.getDestination() + "��";
		for(String s : vo.getOrderId()){
			OrderDeliverInfoVO infoVO = new OrderDeliverInfoVO(s, depart, distination, info);
			order.modifyDeliverInfo(infoVO);
		}
		//������ת������״̬
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
     * ��ȡ���д�������{@code TransferVO}
     * @return {@code Transfer}���б����û�з���������{@code TransferVO}�����߲�ѯ
     * ʧ�ܣ��򷵻�һ�����б�
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
