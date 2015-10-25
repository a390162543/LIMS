package dataservice_driver;

import java.rmi.RemoteException;

import po.OrganizationPO;
import dataservice.OrganizationDataService;

public class OrganizationDataService_Driver {
	public void drive(OrganizationDataService organizationdataservice){
		OrganizationPO po = new OrganizationPO(new Long("025001"), 
				"�Ͼ�����ϼ����ת����","�Ͼ�");
		try {
			organizationdataservice.delete(po);
			organizationdataservice.find(new Long("025001"));
			organizationdataservice.finds("City", "�Ͼ�");
			organizationdataservice.getAll();
			organizationdataservice.insert(po);
			organizationdataservice.update(po);
			organizationdataservice.finish();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
