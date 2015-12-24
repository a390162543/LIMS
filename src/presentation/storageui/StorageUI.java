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
 * 这是库存管理人员登录后显示的操作界面
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
		List<StorageQueryResultVO> storageQueryResultVOs = storageblService.storageQuery("organization", "南京中转中心");
		StorageQueryPanel storageQueryPanel = new StorageQueryPanel(storageQueryResultVOs);
        tabbedPane.addTab("  货物入库   ", null);
        tabbedPane.addTab("货物出库", null);
        tabbedPane.addTab("库存管理", null);
        tabbedPane.addTab("库存查看", null);
        tabbedPane.addTab("库存盘点", storageQueryPanel);
        
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
