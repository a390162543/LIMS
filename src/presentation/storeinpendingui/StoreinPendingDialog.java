package presentation.storeinpendingui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.StoreinCreateVO;

public class StoreinPendingDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2406984068078187551L;

	private static final String[] LABEL_NAMES = {"入库单号","入库日期","入库地点","目的地","入库货物数量"};
    
    private StoreinPendingTableModel tableModel;
    
      
    public StoreinPendingDialog(StoreinPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[5];
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
        
        
        
        
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 280, 80, 30);
        
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    StoreinPendingDialog.this.dispose();
                    return;
                }
   
                @SuppressWarnings("deprecation")
				StoreinCreateVO vo = new StoreinCreateVO(textFields[0].getText(), null, new Date(textFields[1].getText()), 
                		textFields[2].getText(), null, null, null, null);
                tableModel.modify(modelRow, vo);
                System.out.println("you've clicked confirm button..");
                StoreinPendingDialog.this.dispose();
                
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 280, 80, 30);
            cancleButton.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    StoreinPendingDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }
        
        this.add(confirmButton);
        this.setSize(340, 360);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
