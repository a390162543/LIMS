package businesslogic.primeinfobl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import dataservice.PrimeInfoDataService;
import vo.AccountVO;
import vo.EmployeeVO;
import vo.OrganizationVO;
import vo.PrimeInfoVO;
import vo.TruckVO;
import businesslogic.accountbl.Account;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfo implements PrimeInfoblService{
    
	private PrimeInfoVO primeInfoVO;
	
	public PrimeInfo(PrimeInfoVO primeInfoVO){
		this.primeInfoVO = primeInfoVO;
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
	public boolean executeAccountPO() {
		Account account = new Account();
		account.execute(primeInfoVO.getAccount());
		return true;
	}
	@Override
	public boolean executeTruckPO() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean executeOrganizationPO() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean executeEmployeePO() {
		// TODO Auto-generated method stub
		return false;
	}
}
