package presentation.storageui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;




import presentation.storageui.storagecheckui.StorageCheckDialog;
import presentation.storageui.storagemanageui.StorageManageDialog;
import presentation.storageui.storagequeryui.StorageQueryPanel;
import presentation.storageui.storeinui.StoreinDialogUI;
import presentation.storageui.storeoutui.StoreoutDialogUI;
import businesslogic.storagebl.Storage;
import businesslogicservice.StorageblService;
import vo.StorageQueryResultVO;

public class StorageUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 78172403747318376L;
	
	private JButton storeinButton;
	private JButton storeoutButton;
	private JButton storageManageButton;
	private JButton storageCheckButton;  //当前在库存中的货物
	private JButton storageQueryButton;  //出入库的情况
	
	private JPanel contentPanel;
	

	public StorageUI(){
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		init();
		buttonFunction();
	}
	
	public void init(){
		this.setSize(800, 540);
        this.setLayout(null);
        contentPanel = new JPanel();
        contentPanel.setBounds(200, 50, 580, 540);
        storeinButton = new JButton("货物入库");
        storeinButton.setBounds(30, 200, 150, 40);
        storeoutButton = new JButton("货物出库");
        storeoutButton.setBounds(30, 260, 150, 40);
        storageManageButton = new JButton("库存规划");
        storageManageButton.setBounds(30, 320, 150, 40);
        storageCheckButton = new JButton("库存查看");
        storageCheckButton.setBounds(30, 380, 150, 40);
        storageQueryButton = new JButton("库存盘点");
        storageQueryButton.setBounds(30, 440, 150, 40);
        this.add(contentPanel);
        this.add(storageQueryButton);
        this.add(storageCheckButton);
        this.add(storageManageButton);
        this.add(storeoutButton);
        this.add(storeinButton);
        
        this.setVisible(true);
	}

	public void buttonFunction(){
		
		storeinButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new StoreinDialogUI();
			}
		});
		
		storeoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreoutDialogUI();	
			}
		});
		
		storageManageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StorageManageDialog();
				
			}
		});
		
		storageCheckButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StorageCheckDialog(contentPanel);
			}
		});
		
		storageQueryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				StorageblService storageblService = new Storage();
				List<StorageQueryResultVO> storageQueryResultVOs = storageblService.storageQuery("organization", "南京中转中心");
				StorageQueryPanel storageQueryPanel = new StorageQueryPanel(storageQueryResultVOs);
				storageQueryPanel.setBounds(10, 40, 540, 400);
				contentPanel.setLayout(null);
				contentPanel.add(storageQueryPanel);
			}
		});
	}
	

}
