package data;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;


import presentation.mainui.LoginFrame;
 

public class Main {
   
		public static void main(String[] args) {
		   try{
		       BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
		       org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		   }
		   catch(Exception e){}
		   
		   DataBase.initDataBase();

		   new LoginFrame(); 	 
		} 

	
}
