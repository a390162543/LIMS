package data;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import presentation.mainui.MainFrame;

public class Main_tester {
   
		public static void main(String[] args) {
		   try{
		       BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
		       org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		   }
		   catch(Exception e){}
		   
		   DataBase.initDataBase();

		   new MainFrame(); 	 
		} 

	
}
