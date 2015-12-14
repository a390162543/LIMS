package businesslogic.primeinfobl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.PrimeInfoPO;
import dataservice.DataService;
import dataservice.PrimeInfoDataService;
import vo.AccountVO;
import vo.EmployeeVO;
import vo.OrderCreateVO;
import vo.OrganizationVO;
import vo.PrimeInfoVO;
import vo.StoreinCreateVO;
import vo.TruckVO;
import businesslogic.accountbl.Account;
import businesslogic.employeebl.Employee;
import businesslogic.logbl.Log;
import businesslogic.orderbl.Order;
import businesslogic.organizationbl.Organization;
import businesslogic.storeinbl.Storein;
import businesslogic.truckbl.Truck;
import businesslogicservice.PrimeInfoblService;

/**
 * {@code PrimeInfo}是期初建账的业务逻辑的实现类，提供所有有关期初建账的业务逻辑服务
 * @author 刘德宽
 * @version 1.6
 * @see dataservice.PrimeInfoDataService
 */
public class PrimeInfo implements PrimeInfoblService{
    
	private PrimeInfoVO primeInfoVO;
	private PrimeInfoDataService primeInfoDataService;
	
	public PrimeInfo(){
		this.primeInfoVO = new PrimeInfoVO();
		primeInfoDataService = DataService.getPrimeInfoDataService();
	}
	@Override
	public boolean createPrimeInfoPO() {
		
		 try {
			 	primeInfoVO.setDate(new Date());
			 	primeInfoDataService.insert(primeInfoVO.getPrimeInfoPO());
			 	
	        	Log log = new Log();
	        	log.createLogPO("期初建账");
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return true;
	}
	
	@Override
	public List<PrimeInfoVO> QueryPrimeInfoVO() {
		List<PrimeInfoVO> vos = new ArrayList<PrimeInfoVO>();
		 try {
	            List<PrimeInfoPO> pos = primeInfoDataService.getAll();
	            for(PrimeInfoPO po : pos)
	            	vos.add(po.getPrimeInfoVO());
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		return vos;
	}
	@Override
	public boolean addAccountVO( AccountVO vo){
		List<AccountVO> accountVOs = primeInfoVO.getAccount();
		accountVOs.add(vo);		
		return true;
	}
	@Override
	public boolean removeAccountVO(AccountVO vo) {		
		List<AccountVO> accountVOs = primeInfoVO.getAccount();
		accountVOs.remove(vo);	
		return true;
	}
	@Override
	public boolean modifyAccountVO(AccountVO vo) {		
		List<AccountVO> accountVOs = primeInfoVO.getAccount();
		for(AccountVO accountVO : accountVOs){
			if(accountVO.getId().equals(vo.getId())){
				accountVO.setName(vo.getName());
				accountVO.setMoney(vo.getMoney());
			}
		}		
		return true;
	}
	 
	@Override
	public boolean addTruckVO(TruckVO vo) {
		List<TruckVO> truckVOs = primeInfoVO.getTruck();
		truckVOs.add(vo);		
		return true;
	}
	@Override
	public boolean removeTruckVO(TruckVO vo) {
		List<TruckVO> truckVOs = primeInfoVO.getTruck();
		truckVOs.remove(vo);	
		return true;
	}	
	@Override
	public boolean modifyTruckVO(TruckVO vo) {
		List<TruckVO> truckVOs = primeInfoVO.getTruck();
		for(TruckVO truckVO : truckVOs){
			if(truckVO.getId().equals(vo.getId())){
				truckVO.setEngineNumber(vo.getEngineNumber());
				truckVO.setTruckNumber(vo.getTruckNumber());
				truckVO.setChassisNumber(vo.getChassisNumber());
				truckVO.setPurchaseDate(vo.getPurchaseDate());
				truckVO.setTruckImage(vo.getTruckImage());
			}
		}
		return true;
	}
	
	@Override
	public boolean addOrganizationVO(OrganizationVO vo) {
		List<OrganizationVO> organizationVOs = primeInfoVO.getOrganization();
		organizationVOs.add(vo);		
		return true;
	}
	@Override
	public boolean removeOrganizationVO(OrganizationVO vo) {
		List<OrganizationVO> organizationVOs = primeInfoVO.getOrganization();
		organizationVOs.remove(vo);	
		return true;
	}	
	@Override
	public boolean modifyOrganizationVO(OrganizationVO vo) {
		List<OrganizationVO> organizationVOs = primeInfoVO.getOrganization();
		for(OrganizationVO organizationVO : organizationVOs){
			if(organizationVO.getId().equals(vo.getId())){
				organizationVO.setCity(vo.getCity());
				organizationVO.setName(vo.getName());
			}
		}
		return true;
	}
	
	@Override
	public boolean addEmployeeVO(EmployeeVO vo) {
		List<EmployeeVO> employeeVOs = primeInfoVO.getEmployee();
		employeeVOs.add(vo);		
		return true;
	}
	@Override
	public boolean removeEmployeeVO(EmployeeVO vo) {
		List<EmployeeVO> employeeVOs = primeInfoVO.getEmployee();
		employeeVOs.remove(vo);	
		return true;
	}		
	@Override
	public boolean modifyEmployeeVO(EmployeeVO vo) {
		List<EmployeeVO> employeeVOs = primeInfoVO.getEmployee();
		for(EmployeeVO employeeVO :employeeVOs){
			if(employeeVO.getId().equals(vo.getId())){
				employeeVO.setName(vo.getName());
				employeeVO.setOrganization(vo.getOrganization());
				employeeVO.setPosition(vo.getPosition());
				employeeVO.setTelephone(vo.getTelephone());
				employeeVO.setBirthday(vo.getBirthday());
				employeeVO.setIdentityCardNum(vo.getIdentityCardNum());
				employeeVO.setSex(vo.getSex());
				employeeVO.setPay(vo.getPay()); 
			}
		}
		return true;
	}
	
	@Override
	public boolean addStoreinCheckResultVO(StoreinCreateVO vo) {
		List<StoreinCreateVO> storeinCreateVOs = primeInfoVO.getStorage();
		storeinCreateVOs.add(vo);		
		return true;
	}
	@Override
	public boolean removeStoreinCheckResultVO(StoreinCreateVO vo) {
		List<StoreinCreateVO> storeinCreateVOs = primeInfoVO.getStorage();
		storeinCreateVOs.remove(vo);		
		return true;
	}
	@Override
	public boolean modifyStoreinVO(StoreinCreateVO vo) {
		List<StoreinCreateVO> storeinCreateVOs = primeInfoVO.getStorage();
		for(StoreinCreateVO storeinCreateVO :storeinCreateVOs){
			if(storeinCreateVO.getId().equals(vo.getId())){
				storeinCreateVO.setOrganization(vo.getOrganization());
			}
		}
		return true;
	}
	@Override
	public boolean addOrderCheckResultVO(OrderCreateVO vo) {
		List<OrderCreateVO> orderCreateVOs = primeInfoVO.getOrder();
		orderCreateVOs.add(vo);		
		return true;
	}
	@Override
	public boolean removeOrderCheckResultVO(OrderCreateVO vo) {
		List<OrderCreateVO> orderCreateVOs = primeInfoVO.getOrder();
		orderCreateVOs.remove(vo);		
		return true;
	}
	@Override
	public boolean modifyOrderVO(OrderCreateVO vo) {
		List<OrderCreateVO> orderCreateVOs = primeInfoVO.getOrder();
		for(OrderCreateVO orderCreateVO :orderCreateVOs){
			if(orderCreateVO.getId().equals(vo.getId())){
				orderCreateVO.setCost(vo.getCost());
				orderCreateVO.setOrganization(vo.getOrganization());
			}
		}
		return true;
	}

	@Override
	public boolean execute() {
		List<AccountVO> accountVOs = primeInfoVO.getAccount();
		Account account = new Account();
		for(AccountVO vo : accountVOs)
			account.execute(vo);
		
		List<TruckVO> truckVOs = primeInfoVO.getTruck();
		Truck truck = new Truck();
		for(TruckVO vo :truckVOs)
			truck.execute(vo);
		
		List<EmployeeVO> employeeVOs = primeInfoVO.getEmployee();
		Employee employee = new Employee();
		for(EmployeeVO vo: employeeVOs)
			employee.execute(vo);
			
		List<OrganizationVO> organizationVOs = primeInfoVO.getOrganization();
		Organization organization = new Organization();
		for(OrganizationVO vo: organizationVOs)
			organization.execute(vo);
		
		List<StoreinCreateVO> vos = primeInfoVO.getStorage();
		Storein Storein = new Storein();
		for(StoreinCreateVO vo : vos)
			Storein.execute(vo);
		
		List<OrderCreateVO> orderVOs = primeInfoVO.getOrder();
		Order order = new Order();		
		for(OrderCreateVO vo : orderVOs)
			order.execute(vo);
		
    	Log log = new Log();
    	log.createLogPO("完成期初建账");
		return true;
	}

	@Override
	public List<String> getOrganizationName(){
		List<String> names = new ArrayList<String>();
		for(OrganizationVO vo : primeInfoVO.getOrganization())
			names.add(vo.getName());
		return null;
	}
	
	@Override
	public String getOrganizationId(String name) {
		String id = "";
		Organization organization = new Organization();
		List<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		List<OrganizationVO> list = primeInfoVO.getOrganization();
		vos = organization.getOrganizationVO();
		if(!list.isEmpty()){
			for(OrganizationVO vo : list){
				vos.add(vo);
			}
		}
		for(OrganizationVO vo : vos){
			 if(name.equals(vo.getName())){
				 id = vo.getId();
			 }
		}
		return id;
	}


}
