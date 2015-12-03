package presentation.financeui.primeinfoui.storeinui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import presentation.storageui.storeinui.StoreinGoodsDialog;
import systemenum.StorageState;
import vo.StorageLocationVO;
import businesslogic.storeinbl.Storein;
import businesslogicservice.StoreinblService;

public class PrimeInfoStoreinGoodsDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 689862824298738060L;
	
	private JLabel orderIdLabel;
	private JTextField orderIdTextField;
	private JLabel areaNumLabel;
	private JTextField areaNUmTextField;
	private JLabel rowNumlaLabel;
	private JTextField rowNumTextField;
	private JLabel frameNumLabel;
	private JTextField frameNumTextField;
	private JLabel itemLabel;
	private JTextField itemTextField;
	
	private JButton confirmButton;
	private JButton cancleButton;
	
	private DefaultTableModel tableModel;

	public PrimeInfoStoreinGoodsDialog(DefaultTableModel tableModel){
		this.tableModel = tableModel;
		init();
		buttonFunction();
	}
	
	public void init(){
		this.setTitle("货物入库");	
		this.setSize(380, 250);
		this.setLayout(null);
		
		orderIdLabel = new JLabel("订单号");
		orderIdLabel.setBounds(30, 60, 60, 22);
		orderIdTextField = new JTextField();
		orderIdTextField.setBounds(100, 60, 180, 22);
		areaNumLabel = new JLabel("区号");
		areaNumLabel.setBounds(35, 95, 40, 22);
		areaNUmTextField = new JTextField();
		areaNUmTextField.setBounds(90, 95, 60, 22);
		rowNumlaLabel = new JLabel("排号");
		rowNumlaLabel.setBounds(180, 95, 40, 22);
		rowNumTextField = new JTextField();
		rowNumTextField.setBounds(230, 95, 60, 22);
		frameNumLabel = new JLabel("架号");
		frameNumLabel.setBounds(35, 125, 40, 22);
		frameNumTextField = new JTextField();
		frameNumTextField.setBounds(90, 125, 60, 22);
		itemLabel = new JLabel("位号");
		itemLabel.setBounds(180, 125, 40, 22);
		itemTextField = new JTextField();
		itemTextField.setBounds(230, 125, 60, 22);
		
		confirmButton = new JButton("确定");
		confirmButton.setBounds(300, 170, 70, 30);
		cancleButton = new JButton("取消");
		cancleButton.setBounds(210, 170, 70, 30);
		
		this.add(cancleButton);
		this.add(confirmButton);
		this.add(itemTextField);
		this.add(itemLabel);
		this.add(frameNumTextField);
		this.add(frameNumLabel);
		this.add(rowNumTextField);
		this.add(rowNumlaLabel);
		this.add(areaNUmTextField);
		this.add(areaNumLabel);
		this.add(orderIdTextField);
		this.add(orderIdLabel);
		
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);		
	}
	
	

	public void buttonFunction(){
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] data = {orderIdTextField.getText(),areaNUmTextField.getText(),
						rowNumTextField.getText(),frameNumTextField.getText(),
						itemTextField.getText()};
				
				StorageLocationVO vo = new StorageLocationVO("0250", Integer.parseInt(areaNUmTextField.getText()),Integer.parseInt(rowNumTextField.getText()), 
						Integer.parseInt(frameNumTextField.getText()), Integer.parseInt(itemTextField.getText()), StorageState.ISSTORING);
				StoreinblService storeinblService = new Storein();
				storeinblService.changeLocationState(vo);		
				tableModel.addRow(data);
				PrimeInfoStoreinGoodsDialog.this.dispose();
							
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		
		
	}


}
