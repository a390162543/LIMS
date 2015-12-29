package presentation.financeui.accountui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.accountinfo.AccountId;
import businesslogic.checkbl.accountinfo.AccountMoney;
import businesslogic.checkbl.accountinfo.AccountName;
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.ScreenMessage;
import vo.AccountVO;
/**
 * {@code AccountDialog}继承{@code JDialog}，是账户增删改查的界面层对话框展示
 * @author 刘德宽
 *
 */
public class AccountDialog extends JDialog{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -6086435113401063915L;

	private static final String[] LABEL_NAMES = {"账户编号","账户名称","账户金额"};
	    
	    private AccountTableModel tableModel;
	    private JTextField[] textFields;
	    
	    public AccountDialog(AccountTableModel tm){
	        
	        this.tableModel = tm;

	        JLabel[] labels = new JLabel[3];
	        for(int i=0;i<labels.length;i++){
	            labels[i] = new JLabel();
	            labels[i].setText(LABEL_NAMES[i]);
	            labels[i].setBounds(70, 40+40*i, 100, 25);
	            this.add(labels[i]);
	        }
	        
	        textFields = new JTextField[3];
	        for(int i=0;i<textFields.length;i++){
	            textFields[i] = new JTextField();           
	            if(i==2)
	            	textFields[i].setBounds(140, 40+40*i, 90, 25);
	            else
	            	textFields[i].setBounds(140, 40+40*i, 180, 25);
	            this.add(textFields[i]);
	        }
	        //检查机制
	        Checker accountIdChecker = new Checker(textFields[0] , new CheckInfoGetter(){

				@Override
				public CheckInfo getCheckInfo() {
					return new AccountId(textFields[0].getText());
				}
	        	
	        });
	        textFields[0].addKeyListener(new KeyListener(){

				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					accountIdChecker.check();
				}

				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
	        	
	        });
	        Checker accountNameChecker = new Checker(textFields[1] , new CheckInfoGetter(){

					@Override
					public CheckInfo getCheckInfo() {
						return new AccountName(textFields[1].getText());
					}
		        	
		        });
		        textFields[1].addKeyListener(new KeyListener(){

					@Override
					public void keyPressed(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						accountNameChecker.check();
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
		        	
		        });
		        Checker accountMoneyChecker = new Checker(textFields[2] , new CheckInfoGetter(){

						@Override
						public CheckInfo getCheckInfo() {
							return new AccountMoney(textFields[2].getText());
						}
			        	
			        });
			        textFields[1].addKeyListener(new KeyListener(){

						@Override
						public void keyPressed(KeyEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void keyReleased(KeyEvent arg0) {
							accountMoneyChecker.check();
						}

						@Override
						public void keyTyped(KeyEvent arg0) {
							// TODO Auto-generated method stub
							
						}
			        	
			        });
	        
	        JButton confirmButton = new JButton("确认");
	        confirmButton.setBounds(250, 170, 70, 30);
	        confirmButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	boolean isCorrect = accountIdChecker.check()&&accountNameChecker.check()&&accountMoneyChecker.check();
	            	if(isCorrect){
		            	AccountVO vo = new AccountVO(textFields[0].getText(),textFields[1].getText(),Double.parseDouble(textFields[2].getText()));
		                tableModel.create(vo);
		                AccountDialog.this.dispose();
	                    ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
	            	}else{
	                    ScreenMessage.putOnScreen(ScreenMessage.SAVE_FAILURE);
	                }
	            	
	            }
	        });
	        JButton cancleButton = new JButton("取消");
	        cancleButton.setBounds(160, 170, 70, 30);
	        cancleButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	AccountDialog.this.dispose();
	            }
	        });
	        
	        this.add(confirmButton);
	        this.add(cancleButton);
	        
	        this.setSize(380, 260);
	        this.setTitle("账户信息");
	        this.setLayout(null);
	        this.setLocationRelativeTo(null);
	        this.setModalityType(ModalityType.APPLICATION_MODAL);
	        this.setVisible(true);
	    }

	    
	    public AccountDialog(AccountTableModel tm, int modelRow, boolean isEditable) {
	        
	        this.tableModel = tm;

	        JLabel[] labels = new JLabel[3];
	        for(int i=0;i<labels.length;i++){
	            labels[i] = new JLabel();
	            labels[i].setText(LABEL_NAMES[i]);
	            labels[i].setBounds(70, 40+40*i, 100, 25);
	            this.add(labels[i]);
	        }
	        
	        JTextField[] textFields = new JTextField[3];
	        for(int i=0;i<textFields.length;i++){
	  
	            textFields[i] = new JTextField();
	            if(i==2)
	            	textFields[i].setBounds(140, 40+40*i, 90, 25);
	            else
	            	textFields[i].setBounds(140, 40+40*i, 180, 25);
	            textFields[i].setEditable(isEditable);
	            if(i==0)
		      		textFields[i].setEditable(false);	
		
	            this.add(textFields[i]);
	        }
	      //检查机制
	        Checker accountIdChecker = new Checker(textFields[0] , new CheckInfoGetter(){

				@Override
				public CheckInfo getCheckInfo() {
					return new AccountId(textFields[0].getText());
				}
	        	
	        });
	        textFields[0].addKeyListener(new KeyListener(){

				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					accountIdChecker.check();
				}

				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
	        	
	        });
	        Checker accountNameChecker = new Checker(textFields[1] , new CheckInfoGetter(){

					@Override
					public CheckInfo getCheckInfo() {
						return new AccountName(textFields[1].getText());
					}
		        	
		        });
		        textFields[1].addKeyListener(new KeyListener(){

					@Override
					public void keyPressed(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						accountNameChecker.check();
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
		        	
		        });
		        Checker accountMoneyChecker = new Checker(textFields[2] , new CheckInfoGetter(){

						@Override
						public CheckInfo getCheckInfo() {
							return new AccountMoney(textFields[2].getText());
						}
			        	
			        });
			        textFields[2].addKeyListener(new KeyListener(){

						@Override
						public void keyPressed(KeyEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void keyReleased(KeyEvent arg0) {
							accountMoneyChecker.check();
						}

						@Override
						public void keyTyped(KeyEvent arg0) {
							// TODO Auto-generated method stub
							
						}
			        	
			        });
	        AccountVO vo = tableModel.getAccountVO(modelRow);
	        textFields[0].setText(vo.getId());
	        textFields[1].setText(vo.getName());
	        textFields[2].setText(vo.getMoney()+"");
       
	        JButton confirmButton = new JButton("确认");
	        confirmButton.setBounds(250, 170, 70, 30);
	        confirmButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(!isEditable){
	                	AccountDialog.this.dispose();
	                	return;
	                }
	            	boolean isCorrect = accountIdChecker.check()&&accountNameChecker.check()&&accountMoneyChecker.check();
	            	if(isCorrect){
		            	AccountVO vo = new AccountVO(textFields[0].getText(),textFields[1].getText(),Double.parseDouble(textFields[2].getText()));
		                tableModel.create(vo);
		                AccountDialog.this.dispose();
	                    ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
	            	}else{
	                    ScreenMessage.putOnScreen(ScreenMessage.SAVE_FAILURE);
	                }
	                
	            }
	        });
	        if(isEditable){
	            JButton cancleButton = new JButton("取消");
	            cancleButton.setBounds(160, 170, 70, 30);
	            cancleButton.addActionListener(new ActionListener() {
	                
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	AccountDialog.this.dispose();
	                }
	            });
	            this.add(cancleButton);
	        }
	        this.add(confirmButton);

	        this.setSize(380, 260);
	        this.setLayout(null);
	        this.setLocationRelativeTo(null);
	        this.setModalityType(ModalityType.APPLICATION_MODAL);
	        this.setVisible(true);
	    }
}
