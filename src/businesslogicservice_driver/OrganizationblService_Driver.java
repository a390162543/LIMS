package businesslogicservice_driver;

import businesslogicservice.OrganizationblService;
import vo.OrganizationVO;
 

public class OrganizationblService_Driver {
	public void drive(OrganizationblService organizationblservice){
		OrganizationVO vo = new OrganizationVO(new Long("0250"), "�Ͼ�����ϼ����ת����",
				"�Ͼ�");
		
		organizationblservice .CreatOrganizationPO(vo);
		organizationblservice.deleteOrganizationPO(vo);
		organizationblservice.queryTruckPO(vo);
		organizationblservice.getOrganizationVO();
				
	}
}
