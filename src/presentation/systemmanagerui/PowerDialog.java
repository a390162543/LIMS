package presentation.systemmanagerui;


 

 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.mainui.MainFrame;
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import presentation.util.ScreenMessage;
import systemenum.Power;
import vo.UserVO;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.userinfo.UserId;
import businesslogicservice.UserblService;
 
/**
 * ��ѯ���޸��û�Ȩ�޵Ľ���
 * @author ������
 * @see UserblService
 * @version 1.2
 */
public class PowerDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1629346825313324971L;

	private UserblService userblService;
	private Checker idChecker;
	
	public PowerDialog(){
		userblService = BusinessLogicService.getUserblService();
		String[] powerStr = new String[]{"�ܾ���","Ӫҵ��ҵ��Ա","��ת����ҵ��Ա","���Ա",
				 "��ת���Ĳֿ����Ա","�߼�������Ա","������Ա","����Ա","˾��"};
	 
		JLabel idLabel = new JLabel("�û��ʺ�");
		idLabel.setBounds(30, 20, 100, 25);
		JTextField idField = new JTextField();
		idField.setBounds(145, 20, 180, 20);
		idField.addKeyListener(new KeyAdapter() {
			  public void keyTyped(KeyEvent e) {  
	                int keyChar = e.getKeyChar();                 
	                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {  
	 
	                }else{  
	                     e.consume();
	                     
	                }  
	            }      
		});
		
		JLabel powerLabel = new JLabel("Ȩ��");
		powerLabel.setBounds(50, 87, 100, 25);
		JComboBox<String> powerBox = new JComboBox<String>(powerStr);
		powerBox.setBounds(145, 87, 140, 20);
	
		
		
		
		JButton cancelButton = new JButton("ȡ��");
		cancelButton.setBounds(165, 120, 70, 30);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PowerDialog.this .dispose();
			}
		});
		
		JButton saveButton = new JButton("����");
		saveButton.setBounds(255,120, 70, 30);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(idChecker.check()){	
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
					UserVO vo = userblService.find(idField.getText());
					vo.setPower(Power.values()[powerBox.getSelectedIndex()]);
					userblService.modifyPower(vo);
					PowerDialog.this.dispose();
				}
			}
		});
		
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setLocationRelativeTo(MainFrame.getMainFrame());
		this.setBounds(200, 200, 380, 200);	 
		this.add(idLabel);
		this.add(idField);
		this.add(powerLabel);
 		this.add(powerBox);
		this.add(saveButton);
		this.add(cancelButton);
		this.setResizable(false);
		
		//��Ӽ����
				idChecker = new Checker(idField,new CheckInfoGetter() {
					
					@Override
					public CheckInfo getCheckInfo() {
						// TODO Auto-generated method stub
						if(idField.getText() == null){
							return null;
						}
						else{
							return new UserId(idField.getText());
						}
						 
					}
				});
				
				idField.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						if(idChecker.check()){							
							UserVO vo = userblService.find(idField.getText());					 
							powerBox.setSelectedIndex(vo.getPower().ordinal());
							 
						}
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				//�����ö�
				this.setModalityType(ModalityType.APPLICATION_MODAL);	
				
				this.setLayout(new DialogLayoutManager());			
				this.setVisible(true);
	}
}
