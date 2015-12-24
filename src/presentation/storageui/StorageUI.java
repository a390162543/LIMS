package presentation.storageui;

import java.util.List;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	
	
	public StorageUI(){
		
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

		StorageblService storageblService = BusinessLogicService.getStorageblService();
		List<StorageQueryResultVO> storageQueryResultVOs = storageblService.storageQuery("organization", "�Ͼ���ת����");
		StorageQueryPanel storageQueryPanel = new StorageQueryPanel(storageQueryResultVOs);
        tabbedPane.addTab("  �������   ", null);
        tabbedPane.addTab("�������", null);
        tabbedPane.addTab("������", null);
        tabbedPane.addTab("���鿴", null);
        tabbedPane.addTab("����̵�", storageQueryPanel);
        
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
                    new StoreinDialogUI();
                    break;
                case 1:
                    new StoreoutDialogUI();
                    break;
                case 2:
                    new StorageManageDialog();
                    break;
                case 3:
                    new StorageCheckDialog(tabbedPane);
                    break;
                default:
                    break;
                }
            }
        });
        
        this.setSize(800, 540);
        this.setLayout(null);
	}
	

}
