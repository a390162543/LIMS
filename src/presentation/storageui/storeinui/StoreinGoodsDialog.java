package presentation.storageui.storeinui;

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
import presentation.util.DialogLayoutManager;
import systemenum.StorageState;
import vo.StorageLocationVO;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.storeininfo.AreaNum;
import businesslogic.checkbl.storeininfo.FrameNum;
import businesslogic.checkbl.storeininfo.Item;
import businesslogic.checkbl.storeininfo.RowNum;
import businesslogic.checkbl.storeininfo.StoreinOrderId;
import businesslogic.userbl.LoginController;
import businesslogicservice.StoreinblService;



/**
 * 这是添加入库货物显示的界面
 * @author lc
 * @version 1.4
 *
 */
public class StoreinGoodsDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2452402342609603668L;
	
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
	
	@SuppressWarnings("unused")
	private DefaultTableModel tableModel;

	public StoreinGoodsDialog(DefaultTableModel tableModel){
		
		this.tableModel = tableModel;
	
	
		this.setTitle("货物入库");	
		this.setSize(380, 250);
		
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
		
		
						
		this.add(orderIdLabel);
		this.add(orderIdTextField);
		this.add(areaNumLabel);		
		this.add(areaNUmTextField);
		this.add(rowNumlaLabel);
		this.add(rowNumTextField);
		this.add(frameNumLabel);
		this.add(frameNumTextField);
		this.add(itemLabel);
		this.add(itemTextField);
			
		this.add(confirmButton);	
		this.add(cancleButton);
		
		this.setLayout(new DialogLayoutManager());
        this.setResizable(false);
        this.setVisible(true);		
	
        Checker storeinOrderIdChecker = new Checker(orderIdTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				return new StoreinOrderId(orderIdTextField.getText());
			}
		});
        
        orderIdTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				storeinOrderIdChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        Checker areaNumChecker = new Checker(areaNUmTextField, new CheckInfoGetter() {
		
			@Override
			public CheckInfo getCheckInfo() {
				int araeNum = -1;
				if (!areaNUmTextField.getText().equals("")) {
					try {
						araeNum = Integer.valueOf(areaNUmTextField.getText());
					} catch (Exception e) {
						araeNum = -1;
					}
					return new AreaNum(araeNum);
				}
				return new AreaNum(-1);
			}
		});
        
		Checker rowNumChecker = new Checker(rowNumTextField,
				new CheckInfoGetter() {

					@Override
					public CheckInfo getCheckInfo() {
						int areaNum = -1;
						int rowNum = -1;
						if (!areaNUmTextField.getText().equals("")
								&& !rowNumTextField.getText().equals("")) {
							try {
								areaNum = Integer.valueOf(areaNUmTextField
										.getText());
								rowNum = Integer.valueOf(rowNumTextField
										.getText());
							} catch (Exception e) {
								// TODO: handle exception
							}
							return new RowNum(areaNum, rowNum);
						}
						if (areaNUmTextField.getText().equals("")
								&& !rowNumTextField.getText().equals("")) {
							return new RowNum(-1, Integer.valueOf(rowNumTextField.getText()));
						}
						
						if (!areaNUmTextField.getText().equals("")
								&& rowNumTextField.getText().equals("")) {
							return new RowNum(Integer.valueOf(areaNUmTextField.getText()), -1);
						}

						return new RowNum(-1, -1);
					}
				});
        
        areaNUmTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (areaNUmTextField.getText()!="") {
					areaNumChecker.check();
					if (!rowNumTextField.getText().equals("")) {
						rowNumChecker.check();
					}
					
					
				}
							
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        
        rowNumTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				rowNumChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        Checker frameNumChecker = new Checker(frameNumTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {				
				int frameNum = -1;
				if (!frameNumTextField.getText().equals("")) {
					try {
						frameNum = Integer.valueOf(frameNumTextField.getText());
					} catch (Exception e) {
						frameNum = -1;
					}
					return new FrameNum(frameNum);
				}
				return new FrameNum(-1);
			}
		});
        
        frameNumTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				frameNumChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        Checker itemChecker = new Checker(itemTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				StorageLocationVO vo = null;
				if (!areaNUmTextField.getText().equals("")&&!rowNumTextField.getText().equals("")
						&&!frameNumTextField.getText().equals("")&&!itemTextField.getText().equals("")) {
					vo = new StorageLocationVO(LoginController.getOrganizationId(),
							Integer.valueOf(areaNUmTextField.getText()), Integer.valueOf(rowNumTextField.getText()), 
							Integer.valueOf(frameNumTextField.getText()), Integer.valueOf(itemTextField.getText()));
					return new Item(vo);
				}
				vo = new StorageLocationVO(LoginController.getOrganizationId(), -1, -1, -1, -1);
				return new Item(vo) ;
				
			}
		});
        
        itemTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				itemChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] data = {orderIdTextField.getText(),areaNUmTextField.getText(),
						rowNumTextField.getText(),frameNumTextField.getText(),
						itemTextField.getText()};
				
				StorageLocationVO vo = new StorageLocationVO(LoginController.getOrganizationId(), Integer.parseInt(areaNUmTextField.getText()),Integer.parseInt(rowNumTextField.getText()), 
						Integer.parseInt(frameNumTextField.getText()), Integer.parseInt(itemTextField.getText()), StorageState.ISSTORING, orderIdTextField.getText());
				StoreinblService storeinblService = BusinessLogicService.getStoreinblService();
				storeinblService.changeLocationState(vo);		
				tableModel.addRow(data);
				StoreinGoodsDialog.this.dispose();
							
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				StoreinGoodsDialog.this.dispose();		
			}
		});
		
		
	}

}
