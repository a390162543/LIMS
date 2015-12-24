package presentation.courierui;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import presentation.courierui.ordercreateui.OrderCreateDialog;
import presentation.courierui.ordersignui.OrderSignDialog;



/**
 * 这是快递员登录成功后的界面
 * @author lc
 * @version 1.4
 *
 */
public class OrderUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4720179693668770018L;
	
	
	
	public OrderUI() {

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

        tabbedPane.addTab("  订单创建   ", null);
        tabbedPane.addTab("订单签收", null);
       
        tabbedPane.setBounds(0, 30, 800, 480);
        this.add(tabbedPane);
        tabbedPane.setSelectedIndex(-1);
        
        
        tabbedPane.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(ChangeEvent e) {
                int index = tabbedPane.getSelectedIndex();
                if(index<=1)
                    tabbedPane.setSelectedIndex(-1);
                switch (index) {
                case 0:
                    new OrderCreateDialog();
                    break;
                case 1:
                    new OrderSignDialog();
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
