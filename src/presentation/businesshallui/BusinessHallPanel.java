package presentation.businesshallui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.businesshallui.arrivalui.ArrivalDialog;
import presentation.businesshallui.deliverui.DeliverDialog;
import presentation.businesshallui.loadui.LoadDialog;
import presentation.businesshallui.revenueui.RevenueDialog;
import presentation.businesshallui.truckui.TruckPanel;

public class BusinessHallPanel extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = -7570872020990366584L;
    
    private JButton deliverButton;
    private JButton arrivalButton;
    private JButton loadButton;
    private JButton revenueButton;
    private JButton driverButton;
    private JButton truckButton;
    private JPanel frameworkPanel;
    
    public BusinessHallPanel(){
        //set buttons
        deliverButton = new JButton("派件管理");
        arrivalButton = new JButton("货物验收");
        loadButton = new JButton("装车管理");
        revenueButton = new JButton("收款管理");
        driverButton = new JButton("司机管理");
        truckButton = new JButton("车辆管理");
        
        deliverButton.setBounds(30, 140, 150, 40);
        arrivalButton.setBounds(30, 200, 150, 40);
        loadButton.setBounds(30, 260, 150, 40);
        revenueButton.setBounds(30, 320, 150, 40);
        driverButton.setBounds(30, 380, 150, 40);
        truckButton.setBounds(30, 440, 150, 40);
        
        deliverButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeliverDialog();
            }
        });
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
        revenueButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new RevenueDialog();
            }
        });
        driverButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                frameworkPanel.removeAll();
                frameworkPanel.repaint();
            }
        });
        truckButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                frameworkPanel.removeAll();
                frameworkPanel.add(new TruckPanel());
                frameworkPanel.repaint();
            }
        });

        // set framework panel
        frameworkPanel = new JPanel();
        frameworkPanel.setBounds(220, 30, 560, 470);
        
        
        this.add(deliverButton);
        this.add(arrivalButton);
        this.add(loadButton);
        this.add(revenueButton);
        this.add(driverButton);
        this.add(truckButton);
        this.add(frameworkPanel);
        
        this.setSize(800, 540);
        this.setLayout(null);
        this.setVisible(true);
    }
}
