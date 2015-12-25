package presentation.transitcenterui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import presentation.businesshallui.arrivalui.ArrivalDialog;
import presentation.businesshallui.loadui.LoadDialog;
import presentation.storageui.storagecheckui.StorageCheckDialog;
import presentation.transitcenterui.transferui.TransferDialog;

public class TransitcenterPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 9195711423344814167L;
 


    
    public TransitcenterPanel(){
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

        tabbedPane.addTab("  货物验收   ", null);
        tabbedPane.addTab("装车管理", null);
        tabbedPane.addTab("中转管理", null);
        tabbedPane.addTab("库存查看", null);
        tabbedPane.setBounds(0, 30, 800, 480);
        this.add(tabbedPane);
        tabbedPane.setSelectedIndex(-1);
        tabbedPane.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(ChangeEvent e) {
                int index = tabbedPane.getSelectedIndex();
                if(index<3)
                    tabbedPane.setSelectedIndex(-1);
                switch (index) {
                case 0:
                    new ArrivalDialog();
                    break;
                case 1:
                    new LoadDialog();
                    break;
                case 2:
                    new TransferDialog();
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
