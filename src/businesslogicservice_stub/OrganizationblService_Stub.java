 package businesslogicservice_stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.OrderPO;
import po.OrganizationPO;
import systemenum.DeliveryWay;
import systemenum.WrapWay;
import vo.OrganizationVO;
import businesslogicservice.OrderblService;
import businesslogicservice.OrganizationblService;

public class OrganizationblService_Stub implements OrganizationblService {
    long id;
	String name;
	String city;
	public OrganizationblService_Stub(long i, String n, String c) {
		id = i;
		name = n;
		city = c;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	
	public OrganizationPO CreatOrganizationPO(OrganizationVO vo) {
		// TODO Auto-generated method stub
		return new OrganizationPO(id, name, city);
	}

	@Override
	public boolean deleteOrganizationPO(OrganizationVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean queryTruckPO(OrganizationVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

	 
	@Override
	public List<OrganizationVO> getOrganizationPO() {
		// TODO Auto-generated method stub
		List<OrganizationVO> organizationvo = new ArrayList<OrganizationVO>();
		organizationvo.add(new OrganizationVO(id,name,city));
		return organizationvo;
	}

	 
	 
}
