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
 * Ӫҵ��ҵ��Ա����ҵ�������Ҫ��{@code JPanel}
 * @author ���滪
 * @version 1.6
 */
public class BusinessHallPanel extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = -7570872020990366584L;
    
    public BusinessHallPanel(){
        
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

        tabbedPane.addTab("  �ɼ�����   ", null);
        tabbedPane.addTab("��������", null);
        tabbedPane.addTab("װ������", null);
        tabbedPane.addTab("�տ����", null);
        tabbedPane.addTab("˾������", new DriverPanel());
        tabbedPane.addTab("��������", new TruckPanel());
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
