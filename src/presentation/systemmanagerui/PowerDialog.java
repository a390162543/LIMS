package presentation.systemmanagerui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import systemenum.Power;
import vo.UserVO;
import businesslogic.userbl.User;
import businesslogicservice.UserblService;
 

public class PowerDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1629346825313324971L;

	private UserblService userblService;
	
	public PowerDialog(){
		userblService = new User();
		String[] powerStr = new String[]{"�ܾ���","Ӫҵ��ҵ��Ա","��ת����ҵ��Ա","���Ա",
				 "��ת���Ĳֿ����Ա","�߼�������Ա","������Ա","����Ա","˾��"};
		JLabel infoLabel = new JLabel("Ȩ�޹���");
		infoLabel.setBounds(105, 10, 170, 34);
		JLabel idLabel = new JLabel("�û��ʺ�");
		idLabel.setBounds(30, 70, 100, 25);
		JTextField idField = new JTextField();
		idField.setBounds(145, 70, 180, 20);
		JButton sureButton = new JButton("ȷ��");
		sureButton.setBounds(255, 100, 70, 20);
		JLabel powerLabel = new JLabel("Ȩ��");
		powerLabel.setBounds(50, 137, 100, 25);
		JComboBox<String> powerBox = new JComboBox<String>(powerStr);
		powerBox.setBounds(145, 137, 60, 20);
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(idField.getText().equals(""))
					return;
				else {
					UserVO vo = userblService.find(idField.getText());
					powerBox.setSelectedIndex(vo.getPower().ordinal());
					 
				}
			}
		});
		
		
		
		JButton cancelButton = new JButton("ȡ��");
		cancelButton.setBounds(205, 185, 70, 30);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PowerDialog.this .dispose();
			}
		});
		
		JButton saveButton = new JButton("����");
		saveButton.setBounds(295, 185, 70, 30);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(idField.getText().equals(""))
					return;
				else {
					UserVO vo = userblService.find(idField.getText());
					vo.setPower(Power.values()[powerBox.getSelectedIndex()]);
					userblService.modifyPower(vo);
				}
			}
		});
		
	}
}
