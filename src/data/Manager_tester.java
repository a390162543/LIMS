package data;

import java.rmi.RemoteException;
import javax.swing.JFrame;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import presentation.managerui.ManagerPanel;
import dataservice.CityDataService;
import dataservice.ConstantDataService;
import dataservice.EmployeeDataService;
import dataservice.OrganizationDataService;
import dataservice.TransferDataService;
import dataservice.UserDataService;

public class Manager_tester {
	public static void main(String[] args) {
		try
	    {
        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }			 
		try {
			EmployeeDataService e = new EmployeeData() ;
			e.init();
			OrganizationDataService o = new OrganizationData();
			o.init();
			ConstantDataService c = new ConstantData();
			c.init();
			CityDataService city = new CityData();
			city.init();
			UserDataService userDataService = new UserData();
			userDataService.init();
			TransferDataService transferDataService = new TransferData();
			transferDataService.init();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame testFrame = new JFrame();
		testFrame.add(new ManagerPanel(   ));
		testFrame.setBounds(100, 100, 800, 540);
		testFrame.setVisible(true);
		testFrame.setLayout(null);		 
	}

}
