package presentation.managerui.approvalui.storeinui;

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

import vo.StoreinCreateVO;

public class StoreinPendingDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2406984068078187551L;

	private static final String[] LABEL_NAMES = {"入库单号","入库日期","入库地点","目的地","入库货物数量","货物信息"};
	
	private String[] column = {"订单号","区号","排号","架号","位号"};
	
    private DefaultTableModel ordertableModel = new DefaultTableModel(null, column);
    
    private StoreinPendingTableModel tableModel;
    
      
    public StoreinPendingDialog(StoreinPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[6];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        JTextField[] textFields = new JTextField[5];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);

            textFields[i].setEditable(isEditable);
            this.add(textFields[i]);
        }
        StoreinCreateVO vo = tableModel.getStoreinPendingVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[3].setText(vo.getInDate().toString());
        textFields[2].setText(vo.getOrganization());
        textFields[1].setText(vo.getDestination());
        textFields[4].setText(String.valueOf(vo.getOrderId().size()));
        
        List<String> orderIdList = vo.getOrderId();
        List<Integer> areaNum = vo.getAreaNum();
        List<Integer> rowNum = vo.getRowNum();
        List<Integer> frameNum = vo.getFrameNum();
        List<Integer> item = vo.getItem();
        
        JTable goodsInfoTable = new JTable(ordertableModel);
        goodsInfoTable.setSize(250, 180);  
        goodsInfoTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        JScrollPane scrollpane = new JScrollPane(goodsInfoTable);
        scrollpane.setBounds(40, 220, 290, 180); 
        for (int i = 0; i < orderIdList.size(); i++) {
        	String[] data = {orderIdList.get(i),String.valueOf(areaNum.get(i)),String.valueOf(rowNum.get(i)),
        			String.valueOf(frameNum.get(i)),String.valueOf(rowNum.get(i))};
        	ordertableModel.addRow(data);
		}
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 410, 80, 30);
        
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    StoreinPendingDialog.this.dispose();
                    return;
                }
   
                @SuppressWarnings("deprecation")
                //完整的信息构造可以根据tablemodel显示
				StoreinCreateVO vo = new StoreinCreateVO(textFields[0].getText(), null, new Date(textFields[1].getText()), 
                		textFields[2].getText(), null, null, null, null);
                tableModel.modify(modelRow, vo);
                System.out.println("you've clicked confirm button..");
                StoreinPendingDialog.this.dispose();
                
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 410, 80, 30);
            cancleButton.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    StoreinPendingDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }
        
        this.add(confirmButton);
        this.add(scrollpane);
        this.setSize(360, 510);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
