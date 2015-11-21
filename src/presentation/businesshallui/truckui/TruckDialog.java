package presentation.businesshallui.truckui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.TruckVO;

public class TruckDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = -5791738856120916225L;
    private static final String[] LABEL_NAMES = {"车辆编号","发动机号","车牌号","底盘号","购买日期","服役时间","车辆图片"};
    
    private TruckTableModel tableModel;
    private JTextField[] textFields;
    
    public TruckDialog(TruckTableModel tm){
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[7];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        textFields = new JTextField[5];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 280, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                TruckVO vo = new TruckVO(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), textFields[3].getText(), new Date(), null);
                tableModel.create(vo);
                TruckDialog.this.dispose();
            }
        });
        JButton cancleButton = new JButton("取消");
        cancleButton.setBounds(140, 280, 80, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                TruckDialog.this.dispose();
            }
        });
        
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setSize(340, 360);
        this.setTitle("车辆信息");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

    
    public TruckDialog(TruckTableModel tm, int modelRow, boolean isEditable) {
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[7];
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
        TruckVO vo = tableModel.getTruckVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getEngineNumber());
        textFields[2].setText(vo.getTruckNumber());
        textFields[3].setText(vo.getChassisNumber());
        textFields[4].setText(new SimpleDateFormat().format(vo.getPurchaseDate()));
        
        // 如果textfield的编号和表格列号一一对应，上述代码也可以用for循环 
        // textFields[i].setText((String) tableModel.getValueAt(modelRow, i));
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 280, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    TruckDialog.this.dispose();
                }
                TruckVO vo = new TruckVO(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), textFields[3].getText(), new Date(), null);
                tableModel.modify(modelRow, vo);
                TruckDialog.this.dispose();
                
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 280, 80, 30);
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    TruckDialog.this.dispose();
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
