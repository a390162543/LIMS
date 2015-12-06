package presentation.storageui.storeoutui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.storeoutinfo.StoreoutOrderId;
import businesslogic.storeinbl.Storein;
import businesslogic.storeoutbl.Storeout;
import businesslogicservice.StoreinblService;
import businesslogicservice.StoreoutblService;

public class StoreoutGoodsDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7103785931098225175L;
	
	private JLabel goodsIdLabel;
	private JTextField goodsIdTextField;
	
	private JButton confirmButton;
	private JButton cancleButton;
	
	private DefaultTableModel tableModel;

	public StoreoutGoodsDialog(DefaultTableModel tableModel){
		this.tableModel = tableModel;
		
		this.setTitle("出库货物");	
		this.setSize(380, 160);
		this.setLayout(null);
		
		goodsIdLabel = new JLabel("订单号");
		goodsIdLabel.setBounds(10, 40, 60, 22);
		goodsIdTextField = new JTextField();
		goodsIdTextField.setBounds(80, 40, 180, 22);
		confirmButton = new JButton("确定");
		confirmButton.setBounds(290, 80, 70, 30);
		cancleButton = new JButton("取消");
		cancleButton.setBounds(200, 80, 70, 30);
		
		this.add(goodsIdLabel);
		this.add(goodsIdTextField);
		this.add(confirmButton);
		this.add(cancleButton);
		
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);	

        Checker storeoutIdChecker = new Checker(goodsIdTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				
				return new StoreoutOrderId(goodsIdTextField.getText());
			}
		});
        
        goodsIdTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				storeoutIdChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] data = {goodsIdTextField.getText()};
				StoreoutblService storeoutblService = new Storeout();
				storeoutblService.changeLocationState(goodsIdTextField.getText());
				tableModel.addRow(data);
				StoreoutGoodsDialog.this.dispose();
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StoreoutGoodsDialog.this.dispose();
				
			}
		});
	}
}
