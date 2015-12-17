package presentation.managerui.constantui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import vo.ConstantVO;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.priceinfo.Price;
import businesslogicservice.ConstantblService;

/**
 * 查询，修改价格界面
 * @author 刘航伸
 * @version 1.2
 */
public class PriceDialog extends JDialog{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -4463982469330418268L;
 
	 
	private Checker constantChecker;
	public PriceDialog(){
		 
		this.setBounds(300, 200, 380, 170);
		this.setTitle("价格查询");
		JLabel priceLabel = new JLabel("当前价格");
		priceLabel.setBounds(80, 20, 90, 20);
		JTextField priceField = new JTextField();
		priceField.setBounds(190, 20, 60, 20);
		JLabel unitLabel = new JLabel(" 每公里每吨");
		unitLabel.setBounds(250, 20, 80, 20);
		JButton cancelButton = new JButton("取消");
		cancelButton.setBounds(185, 70, 70, 30);
		JButton sureButton = new JButton("确定");
		sureButton.setBounds(270, 70, 70, 30);
		 
		ConstantblService constantblService =  BusinessLogicService.getConstantblService();
		ConstantVO vo1 = constantblService.getPrice();
		
		priceField.setText(""+vo1.getPrice());
		priceField.addKeyListener(new KeyAdapter() {
			  public void keyTyped(KeyEvent e) {  
	                int keyChar = e.getKeyChar();                 
	                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {  
	                      if(keyChar == KeyEvent.VK_PERIOD){
	                    	  e.consume();  
	                      }
	                }else{  
	                    e.consume();  
	                }  
	            }            
		});
		cancelButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PriceDialog.this.dispose();
			}
		});
		
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(constantChecker.check()){
					 ConstantVO vo2 = new ConstantVO(Double.valueOf(priceField.getText()));
					 constantblService.modifyPrice(vo2);
					 PriceDialog.this.dispose();
				}	
				else{
					return;
				}
			}
		});
		
		this.add(priceLabel);
		this.add(priceField);
		this.add(unitLabel);					
		this.add(sureButton);
		this.add(cancelButton);
		
		//添加检查项
		constantChecker = new Checker(priceField,new  CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(priceField.getText() == null){
					return null;
				}
				else{
					return new Price(priceField.getText());
				}
			}
		});
		priceField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				constantChecker.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		

		DialogLayoutManager.fix(priceField, unitLabel);
		this.setLayout(new DialogLayoutManager());
		this.setVisible(true);
	}
	
}
