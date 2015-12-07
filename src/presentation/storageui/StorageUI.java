package presentation.storageui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.storageui.storagecheckui.StorageCheckDialog;
import presentation.storageui.storagemanageui.StorageManageDialog;
import presentation.storageui.storagequeryui.StorageQueryPanel;
import presentation.storageui.storeinui.StoreinDialogUI;
import presentation.storageui.storeoutui.StoreoutDialogUI;
import businesslogic.BusinessLogicService;
import businesslogicservice.StorageblService;
import vo.StorageQueryResultVO;


/**
 * ���ǿ�������Ա��¼����ʾ�Ĳ�������
 * @author lc
 * @version 1.4
 *
 */
public class StorageUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 78172403747318376L;
	
	private JButton storeinButton;
	private JButton storeoutButton;
	private JButton storageManageButton;
	private JButton storageCheckButton;  //��ǰ�ڿ���еĻ���
	private JButton storageQueryButton;  //���������
	
	private JPanel contentPanel;
	

	public StorageUI(){
		
	
		this.setSize(800, 540);
        this.setLayout(null);
        contentPanel = new JPanel();
        contentPanel.setBounds(200, 50, 580, 540);
        storeinButton = new JButton("�������");
        storeinButton.setBounds(30, 200, 150, 40);
        storeoutButton = new JButton("�������");
        storeoutButton.setBounds(30, 260, 150, 40);
        storageManageButton = new JButton("���滮");
        storageManageButton.setBounds(30, 320, 150, 40);
        storageCheckButton = new JButton("���鿴");
        storageCheckButton.setBounds(30, 380, 150, 40);
        storageQueryButton = new JButton("����̵�");
        storageQueryButton.setBounds(30, 440, 150, 40);
        this.add(contentPanel);
        this.add(storageQueryButton);
        this.add(storageCheckButton);
        this.add(storageManageButton);
        this.add(storeoutButton);
        this.add(storeinButton);
        
        this.setVisible(true);
	
		
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
				contentPanel.removeAll();
				contentPanel.repaint();
				new StorageCheckDialog(contentPanel);
				
			}
		});
		
		storageQueryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				StorageblService storageblService = BusinessLogicService.getStorageblService();
				List<StorageQueryResultVO> storageQueryResultVOs = storageblService.storageQuery("organization", "�Ͼ���ת����");
				StorageQueryPanel storageQueryPanel = new StorageQueryPanel(storageQueryResultVOs);
				storageQueryPanel.setBounds(10, 40, 540, 400);
				contentPanel.setLayout(null);
				contentPanel.removeAll();
				contentPanel.repaint();
				contentPanel.add(storageQueryPanel);
			}
		});
	}
	

}
