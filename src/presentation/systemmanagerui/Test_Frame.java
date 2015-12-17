package presentation.systemmanagerui;
 
import javax.swing.JFrame;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class Test_Frame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1666120227215489798L;
	
	public Test_Frame() {
		// TODO Auto-generated constructor stub
		this.add(new PersonInfoPanel());
		this.setBounds(100, 100, 800, 540);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		 try{
		       BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
		       org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		   }
		   catch(Exception e){}
		new Test_Frame();
		 //new ModifyPasswordDialog();
	}

}
