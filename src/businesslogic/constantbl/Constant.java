package businesslogic.constantbl;


import java.rmi.RemoteException;

import vo.ConstantVO;
import dataservice.ConstantDataService;
import dataservice.DataService;
import businesslogicservice.ConstantblService;

 
/**
 * {@code Constant}�Ǽ۸�ҵ���߼���ʵ���࣬�ṩ�����йؼ۸��ҵ���߼�����
 * @author ������
 * @version 1.6
 * @see dataservice.ConstantDataService
 */
public class Constant implements ConstantblService{
	
	private ConstantDataService constansDataService;
	public Constant() {
		// TODO Auto-generated constructor stub
		constansDataService = DataService .getConstantDataService();
	}
	@Override
	public boolean modifyPrice(ConstantVO vo) {
		// TODO Auto-generated method stub
		  try { 
	        	 
				constansDataService.insert(vo.getConsstantPO());				 
					 	
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
	}

	@Override
	public ConstantVO getPrice() {
		double price = 0.0;
		// TODO Auto-generated method stub
		  try { 
	        	 
	        	if(constansDataService.getConstantPO() != null)
	        		price = constansDataService.getConstantPO().getPrice();
				 		
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return new ConstantVO(price);
	}
	
	public boolean modifyPriceLog(Constant vo){
		
		return false;
		
	}
	 
}
