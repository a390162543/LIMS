package presentation.storageui.storagemanageui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import presentation.util.ScreenMessage;
import vo.StorageSetAreaVO;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.storageinfo.AirCapacity;
import businesslogic.checkbl.storageinfo.Alarm;
import businesslogic.checkbl.storageinfo.CarCapacity;
import businesslogic.checkbl.storageinfo.FreeCapacity;
import businesslogic.checkbl.storageinfo.TrainCapacity;
import businesslogic.storagebl.Storage;
import businesslogic.userbl.LoginController;
import businesslogicservice.StorageblService;


/**
 * 库存分区调整的界面
 * @author lc
 * @version 1.3
 *
 */
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
		
		this.setTitle("库存规划");	
		this.setSize(380, 420);
		
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
		
		
	
        Checker airAreaChecker = new Checker(planeAreaTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				
				if (!planeAreaTextField.getText().equals("")&&!planeAreaTextField.getText().contains("-")) {
					return new AirCapacity(Integer.valueOf(planeAreaTextField.getText()));
				}
				return new AirCapacity(-1);
				
			}
		});
        
        planeAreaTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				airAreaChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        Checker trainAreaChecker = new Checker(trainAreaTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				
				if (!trainAreaTextField.getText().equals("")&&!trainAreaTextField.getText().contains("-")) {
					return new TrainCapacity(Integer.valueOf(trainAreaTextField.getText()));
				}
				return new TrainCapacity(-1);
				
			}
		});
        
        trainAreaTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				trainAreaChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        Checker carAreaChecker = new Checker(carAreaTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				
				if (!carAreaTextField.getText().equals("")&&!carAreaTextField.getText().contains("-")) {
					return new CarCapacity(Integer.valueOf(carAreaTextField.getText()));
				}
				return new CarCapacity(-1);
				
			}
		});
        
        carAreaTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				carAreaChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        Checker freeAreaChecker = new Checker(freeAreaTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				
				if (!freeAreaTextField.getText().equals("")&&!freeAreaTextField.getText().contains("-")) {
					return new FreeCapacity(Integer.valueOf(freeAreaTextField.getText()));
				}
				return new FreeCapacity(-1);
				
			}
		});
        
        freeAreaTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				freeAreaChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        Checker alarmChecker = new Checker(warnTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				if (!warnTextField.getText().equals("")&&!warnTextField.getText().contains("-")) {
					return new Alarm(Double.valueOf(warnTextField.getText()));
				}
				return new Alarm(-1);
			}
		});
        
        warnTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				alarmChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (airAreaChecker.check()&&trainAreaChecker.check()&&carAreaChecker.check()&&freeAreaChecker.check()) {
					StorageSetAreaVO vo = new StorageSetAreaVO(LoginController.getOrganizationId(), Integer.parseInt(planeAreaTextField.getText()), 
							Integer.parseInt(freeAreaTextField.getText()), Integer.parseInt(carAreaTextField.getText()),
							Integer.parseInt(trainAreaTextField.getText()), Double.parseDouble(warnTextField.getText()));
					StorageblService storageblService = BusinessLogicService.getStorageblService();
					storageblService.setArea(vo);
					StorageManageDialog.this.dispose();
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
				}
				else {
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_FAILURE);
				}
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StorageManageDialog.this.dispose();
				
			}
		});
	
		
		StorageblService storageblService = new Storage();
		StorageSetAreaVO vo = storageblService.getStorageData(LoginController.getOrganizationId());
		if (vo == null) {
			planeAreaTextField.setText("0");
			carAreaTextField.setText("0");
			trainAreaTextField.setText("0");
			freeAreaTextField.setText("0");
			warnTextField.setText("0");
		}
		else {
			planeAreaTextField.setText(vo.getAirCapacity()+"");
			trainAreaTextField.setText(vo.getTrainCapacity()+"");
			carAreaTextField.setText(vo.getCarCapacity()+"");
			freeAreaTextField.setText(vo.getMotorCapacity()+"");
			warnTextField.setText(vo.getAlarm()+"");
		}
		
		this.setLayout(new DialogLayoutManager());
		this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setResizable(false);
        this.setVisible(true);
}

}
