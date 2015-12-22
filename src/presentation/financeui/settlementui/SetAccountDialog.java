package presentation.financeui.settlementui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import presentation.util.ScreenMessage;
import businesslogic.BusinessLogicService;
import businesslogicservice.SettlementblService;
import vo.RevenueVO;

/**
 * {@code SetAccountDialog}继承{@code JDialog}，是设置收款账户的界面层对话框展示
 * @author 刘德宽
 *
 */
public class SetAccountDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7483943739022897155L;
	private RevenueTableModel tableModel;
	
	public SetAccountDialog(RevenueTableModel tm , int modelrow){
		this.tableModel = tm;
		
		int dialogx = 380;
		int dialogy = 210;
		this.setSize(dialogx, dialogy); 
		this.setLocationRelativeTo(null);
		
		
		JLabel promptLabel = new JLabel("您可以选择账户进行付款:");
		promptLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		promptLabel.setSize(217,22);
		promptLabel.setLocation((dialogx-190)/2, dialogy/8);
		promptLabel.setVisible(true);
		int labelWidth = 80;
		int labelHeight = 25;
		int labelx = 62;
		int labely = 75;
		JLabel accountLabel = new JLabel("账户编号");
		accountLabel.setSize(labelWidth,labelHeight);
		accountLabel.setLocation(labelx, labely);
		
		SettlementblService settlementblService = BusinessLogicService.getSettlementblService();
		String[] account = settlementblService.getAllAccountId();
		JComboBox<String> accountBox = new JComboBox<String>(account);
		accountBox.setSize(180, 25);
		accountBox.setLocation(140, 75);
		
		RevenueVO vo = tableModel.getRevenueVO(modelrow);
		JButton confirmButton = new JButton("确认");
		confirmButton.setBounds(280,130, 70, 30);
		confirmButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SettlementblService settlementblService = BusinessLogicService.getSettlementblService();
				settlementblService.setAccountId(vo, accountBox.getSelectedItem().toString());
				tableModel.delete(modelrow);
				SetAccountDialog.this.dispose();
				ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
			}		
		});
		JButton cancelButton = new JButton("取消");
		cancelButton.setBounds(190,130, 70, 30);
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SetAccountDialog.this.dispose();
			}	
		});
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setLayout(null);
		this.add(promptLabel);
		this.add(promptLabel);
		this.add(accountLabel);
		this.add(accountBox);
		this.add(confirmButton);
		this.add(cancelButton);
		
		this.setVisible(true);
	}
}
