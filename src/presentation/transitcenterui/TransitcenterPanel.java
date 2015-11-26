package presentation.transitcenterui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import businesslogic.storagebl.Storage;
import businesslogicservice.StorageblService;
import presentation.businesshallui.arrivalui.ArrivalDialog;
import presentation.businesshallui.loadui.LoadDialog;
import presentation.storageui.storagequeryui.StorageQueryPanel;
import presentation.transitcenterui.transferui.TransferDialog;
import vo.StorageQueryResultVO;

public class TransitcenterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9195711423344814167L;
 
    private JButton arrivalButton;
    private JButton loadButton;
    private JButton transferButton;
    private JButton storageButton;
    private JPanel frameworkPanel;
    
    public TransitcenterPanel(){
    	 
        arrivalButton = new JButton("货物验收");
        loadButton = new JButton("装车管理");
        transferButton = new JButton("中转管理");
        storageButton = new JButton("库存查看");
       
        arrivalButton.setBounds(30, 260, 150, 40);
        loadButton.setBounds(30, 320, 150, 40);
        transferButton.setBounds(30, 380, 150, 40);
        storageButton.setBounds(30, 440, 150, 40);
        
        
        arrivalButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new ArrivalDialog();
            }
        });
        loadButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                 new LoadDialog();
            }
        });
        transferButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransferDialog();
            }
        });
        storageButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	StorageblService storageblService = new Storage();
				List<StorageQueryResultVO> storageQueryResultVOs = storageblService.storageQuery("organization", "南京中转中心");
				StorageQueryPanel storageQueryPanel = new StorageQueryPanel(storageQueryResultVOs);
				storageQueryPanel.setBounds(10, 40, 540, 400);
				frameworkPanel.setLayout(null);
				frameworkPanel.add(storageQueryPanel);
            }
        });

        // set framework panel
        frameworkPanel = new JPanel();
        frameworkPanel.setBounds(220, 30, 560, 470);
        
        
        
        this.add(arrivalButton);
        this.add(loadButton);
        this.add(transferButton);
        this.add(storageButton);
        this.add(frameworkPanel);
        
        this.setSize(800, 540);
        this.setLayout(null);
        this.setVisible(true);
    }
}
