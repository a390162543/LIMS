package presentation.managerui.approvalui.storeoutui;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import javax.swing.table.DefaultTableModel;

import systemenum.ShipForm;
import vo.StoreinCreateVO;
import vo.StoreoutCreateVO;

public class StoreoutPendingDialog extends JDialog {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 370337960788057317L;

	private static final String[] LABEL_NAMES = {"出库单号","出库日期","出库地点","目的地","中转单号","装运形式","货物数量","货物信息"};
	
	private String[] column = {"订单号"};
	
    private DefaultTableModel ordertableModel = new DefaultTableModel(null, column);
    
    private StoreoutPendingTableModel tableModel;
    
      
    public StoreoutPendingDialog(StoreoutPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[8];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        JTextField[] textFields = new JTextField[7];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);

            textFields[i].setEditable(isEditable);
            this.add(textFields[i]);
        }
        StoreoutCreateVO vo = tableModel.getStoreoutPendingVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getDate().toString());
        textFields[2].setText(vo.getOrganization());
        textFields[3].setText(vo.getDestination());
        textFields[4].setText(vo.getTransferId());
        textFields[5].setText(vo.getShipForm().getName());
        textFields[6].setText(String.valueOf(vo.getOrderId().size()));
        
        
        List<String> orderIdList = vo.getOrderId();
        JTable goodsInfoTable = new JTable(ordertableModel);
        goodsInfoTable.setSize(180, 120);  
        goodsInfoTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        JScrollPane scrollpane = new JScrollPane(goodsInfoTable);
        scrollpane.setBounds(100, 260, 180, 120);
        for (int i = 0; i < orderIdList.size(); i++) {
        	String[] data = {orderIdList.get(i)};
			ordertableModel.addRow(data);
		}
        
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 410, 80, 30);
        
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    StoreoutPendingDialog.this.dispose();
                    return;
                }
   
                @SuppressWarnings("deprecation")
                
				StoreoutCreateVO vo = new StoreoutCreateVO(textFields[0].getText(), orderIdList, new Date(textFields[1].getText()), 
                		textFields[3].getText(),ShipForm.valueOf(textFields[5].getText()), textFields[4].getText(),textFields[2].getText());
                tableModel.modify(modelRow, vo);
                StoreoutPendingDialog.this.dispose();  
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 410, 80, 30);
            cancleButton.addActionListener(new ActionListener() {  
                @Override
                public void actionPerformed(ActionEvent e) {
                    StoreoutPendingDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }
        
        this.add(confirmButton);
        this.add(scrollpane);
        this.setSize(340, 510);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

	
	

}
