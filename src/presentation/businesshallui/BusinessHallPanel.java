package presentation.businesshallui;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import presentation.businesshallui.arrivalui.ArrivalDialog;
import presentation.businesshallui.deliverui.DeliverDialog;
import presentation.businesshallui.driverui.DriverPanel;
import presentation.businesshallui.loadui.LoadDialog;
import presentation.businesshallui.revenueui.RevenueDialog;
import presentation.businesshallui.truckui.TruckPanel;

/**
 * 营业厅业务员进行业务操作需要的{@code JPanel}
 * @author 林祖华
 * @version 1.6
 */
public class BusinessHallPanel extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = -7570872020990366584L;
    
    public BusinessHallPanel(){
        
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

        tabbedPane.addTab("  派件管理   ", null);
        tabbedPane.addTab("货物验收", null);
        tabbedPane.addTab("装车管理", null);
        tabbedPane.addTab("收款管理", null);
        tabbedPane.addTab("司机管理", new DriverPanel());
        tabbedPane.addTab("车辆管理", new TruckPanel());
        tabbedPane.setBounds(0, 30, 800, 480);
        this.add(tabbedPane);
        tabbedPane.setSelectedIndex(-1);
        tabbedPane.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(ChangeEvent e) {
                int index = tabbedPane.getSelectedIndex();
                if(index<=3)
                    tabbedPane.setSelectedIndex(-1);
                switch (index) {
                case 0:
                    new DeliverDialog();
                    break;
                case 1:
                    new ArrivalDialog();
                    break;
                case 2:
                    new LoadDialog();
                    break;
                case 3:
                    new RevenueDialog();
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
