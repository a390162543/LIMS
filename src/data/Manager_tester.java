package data;
 


import javax.swing.JFrame;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import presentation.managerui.ManagerPanel;
 

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
		  DataBase.initDataBase();
		JFrame testFrame = new JFrame();
		testFrame.add(new ManagerPanel(   ));
		testFrame.setBounds(100, 100, 800, 540);
		testFrame.setVisible(true);
		testFrame.setLayout(null);		 
	}

}
