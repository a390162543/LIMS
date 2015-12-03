package businesslogic.primeinfobl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.PrimeInfoPO;
import dataservice.PrimeInfoDataService;
import vo.AccountVO;
import vo.EmployeeVO;
import vo.OrderCreateVO;
import vo.OrganizationVO;
import vo.PrimeInfoVO;
import vo.StoreinCreateVO;
import vo.TruckVO;
import businesslogic.accountbl.Account;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfo implements PrimeInfoblService{
    
	private PrimeInfoVO primeInfoVO;
	
	public PrimeInfo(){
		this.primeInfoVO = new PrimeInfoVO();
	}
	@Override
	public boolean createPrimeInfoPO() {
		
		 try {
			 	primeInfoVO.setDate(new Date());
	        	PrimeInfoDataService ads = (PrimeInfoDataService) Naming.lookup("rmi://localhost/PrimeInfoData");
	            ads.insert(primeInfoVO.getPrimeInfoPO());
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
	        return true;
	}
	
	@Override
	public List<PrimeInfoVO> QueryPrimeInfoVO() {
		List<PrimeInfoVO> vos = new ArrayList<PrimeInfoVO>();
		 try {
	        	PrimeInfoDataService ads = (PrimeInfoDataService) Naming.lookup("rmi://localhost/PrimeInfoData");
	            List<PrimeInfoPO> pos = ads.getAll();
	            for(PrimeInfoPO po : pos)
	            	vos.add(po.getPrimeInfoVO());
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
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean addStoreinCheckResultVO(StoreinCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeStoreinCheckResultVO(StoreinCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean modifyStoreinVO(StoreinCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addOrderCheckResultVO(OrderCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeOrderCheckResultVO(OrderCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean modifyOrderVO(OrderCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean execute() {
		Account account = new Account();
		account.execute(primeInfoVO.getAccount());
//		Truck truck = new Truck();
//		truck.execute(primeInfoVO.getTruck());
//		Employee employee = new Employee();
//		employee.execute(primeInfoVO.getEmployee());
//		Organization organization = new Organization();
//		organization.execute(primeInfoVO.getOrganization());
//		Storein Storein = new Storein();
//		Storein.primeInfoExecute(primeInfoVO.getAccount());
		return true;
	}

	@Override
	public List<String> getOrganizationName(){
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		for(OrganizationVO vo : primeInfoVO.getOrganization())
			names.add(vo.getName());
		return null;
	}
	

}
