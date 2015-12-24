package presentation.systemmanagerui;

 
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

 

/**
 * ����Ա��ҵ�����
 * @author ������
 * @version 1.3
 */
public class SystemManagerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1851486112316513054L;
	
	public SystemManagerPanel(){
	       JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
	        
	        tabbedPane.addTab(" ��ʼ������ ", null);
	        tabbedPane.addTab("�޸�Ȩ�� ", null);
 
	        tabbedPane.setBounds(0, 30, 800, 480);
	        this.add(tabbedPane);
	        tabbedPane.setSelectedIndex(-1);
	        tabbedPane.addChangeListener(new ChangeListener() {
	            
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                int index = tabbedPane.getSelectedIndex();
	                if(index<=2)
	                    tabbedPane.setSelectedIndex(-1);
	                switch (index) {
	                case 0:
	                   new InitPasswordDialog();
	                    break;
	                case 1:
	                	new PowerDialog();
	                    break;
	        
	                default:
	                    break;
	                }
	            }
	        });
	        
	        this.setSize(800, 540);
	        this.setLayout(null);
//		this.setBounds(0, 0, 800, 540);
//		this.setLayout(null);
//		JButton powerBuuon = new JButton("Ա��Ȩ��");
//		powerBuuon.setBounds(30, 380, 150, 40);
//		powerBuuon.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				new PowerDialog();
//			}
//		});
//		
//		JButton passWordButton = new JButton("��ʼ������");
//		passWordButton.setBounds(30, 440, 150, 40);
//		passWordButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				new InitPasswordDialog();
//			}
//		});
//		this.add(new PersonInfoPanel());
//		this.add(powerBuuon);
//		this.add(passWordButton);
//		this.setVisible(true);
//		
	}

}
