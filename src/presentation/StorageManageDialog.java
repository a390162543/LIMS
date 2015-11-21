package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.StorageSetAreaVO;
import businesslogic.storagebl.Storage;
import businesslogicservice.StorageblService;

public class StorageManageDialog extends JDialog{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4273697290436233616L;
	
	
	private JLabel planeAreaLabel;
	private JTextField planeAreaTextField;
	private JLabel carAraeLabel;
	private JTextField carAreaTextField;
	private JLabel trainAreaLabel;
	private JTextField trainAreaTextField;
	private JLabel freeArearLabel;
	private JTextField freeAreaTextField;
	private JLabel warnLabel;
	private JTextField warnTextField;
	
	private JButton confirmButton;
	private JButton cancleButton;
	
	public StorageManageDialog(){
		init();
		showData();
		buttonFunction();
	}
	
	public void init(){
		this.setTitle("库存规划");	
		this.setSize(380, 380);
		this.setLayout(null);
		
		planeAreaLabel = new JLabel("航空区");
		planeAreaLabel.setBounds(20, 40, 60, 22);
		planeAreaTextField = new JTextField();
		planeAreaTextField.setBounds(100, 40, 60, 22);
		carAraeLabel = new JLabel("汽运区");
		carAraeLabel.setBounds(20,85,60,22);
		carAreaTextField = new JTextField();
		carAreaTextField.setBounds(100, 85, 60, 22);
		trainAreaLabel = new JLabel("铁运区");
		trainAreaLabel.setBounds(20, 130, 60, 22);
		trainAreaTextField = new JTextField();
		trainAreaTextField.setBounds(100, 130, 60, 22);
		freeArearLabel = new JLabel("机动区");
		freeArearLabel.setBounds(20, 175, 60, 22);
		freeAreaTextField = new JTextField();
		freeAreaTextField.setBounds(100, 175, 60, 22);
		warnLabel = new JLabel("警戒值");
		warnLabel.setBounds(20, 220, 60, 22);
		warnTextField = new JTextField();
		warnTextField.setBounds(100, 220, 60, 22);
		
		confirmButton = new JButton("确定");
		confirmButton.setBounds(280, 280, 70, 22);
		cancleButton = new JButton("取消");
		cancleButton.setBounds(190, 280, 70, 22);
		
		this.add(planeAreaLabel);
		this.add(planeAreaTextField);
		this.add(carAraeLabel);
		this.add(carAreaTextField);
		this.add(trainAreaLabel);
		this.add(trainAreaTextField);
		this.add(freeArearLabel);
		this.add(freeAreaTextField);
		this.add(warnLabel);
		this.add(warnTextField);
		this.add(confirmButton);
		this.add(cancleButton);
		
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
	}
	
	public void buttonFunction(){
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StorageSetAreaVO vo = new StorageSetAreaVO(new String("0250"), Integer.parseInt(planeAreaTextField.getText()), 
						Integer.parseInt(freeAreaTextField.getText()), Integer.parseInt(carAreaTextField.getText()),
						Integer.parseInt(trainAreaTextField.getText()), Double.parseDouble(warnTextField.getText()));
				StorageblService storageblService = new Storage();
				storageblService.setArea(vo);
			}
		});
	}
	
	public void showData(){
		StorageblService storageblService = new Storage();
		StorageSetAreaVO vo = storageblService.getStorageData(new String("0250"));
		if (vo == null) {
			planeAreaTextField.setText("0");
			carAreaTextField.setText("0");
			trainAreaTextField.setText("0");
			freeAreaTextField.setText("0");
			warnTextField.setText("0");
		}
		
	}

}
