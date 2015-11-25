package presentation.managerui.approvalui.loadui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import vo.LoadVO;

public class LoadPendingDialog extends JDialog {
	
	/**
     * 
     */
    private static final long serialVersionUID = 4875938402353589894L;

    private static final String[] LABEL_NAMES = {"装车单编号","汽运编号","车辆代号","出发地","目的地","装车日期"};
    
    private LoadPendingTableModel tableModel;
    
      
    @SuppressWarnings("deprecation")
    public LoadPendingDialog(LoadPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[6];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        JTextField textFields[];
        textFields = new JTextField[3];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }

        JComboBox<String> departComboBox = new JComboBox<String>();
        departComboBox.addItem("南京市栖霞区中转中心");
        departComboBox.addItem("上海市浦东新区中转中心");
        departComboBox.setBounds(100, 10+35*3, 180, 25);
        this.add(departComboBox);
        
        JComboBox<String> destinationComboBox = new JComboBox<String>();
        destinationComboBox.addItem("南京市栖霞区中转中心");
        destinationComboBox.addItem("上海市浦东新区中转中心");
        destinationComboBox.setBounds(100, 10+35*4, 180, 25);
        this.add(destinationComboBox);
        
        JComboBox<Integer> yearComboBox = new JComboBox<Integer>();
        JComboBox<Integer> monthComboBox = new JComboBox<Integer>();
        JComboBox<Integer> dayComboBox = new JComboBox<Integer>();
        for(int i=1960;i<=2015;i++)  yearComboBox.addItem(i);
        for(int i=1;i<=12;i++)  monthComboBox.addItem(i);
        for(int i=1;i<=31;i++)  dayComboBox.addItem(i);
        yearComboBox.setBounds(100, 10+35*5, 70, 25);
        monthComboBox.setBounds(170, 10+35*5, 60, 25);
        dayComboBox.setBounds(230, 10+35*5, 60, 25);
        this.add(yearComboBox);
        this.add(monthComboBox);
        this.add(dayComboBox);
        
        JLabel[] personLabels = new JLabel[2];
        String[] personLabelNames = {"监装员","押运员"};
        JTextField[] personTextFields = new JTextField[2];
        for(int i=0;i<2;i++){
            personLabels[i] = new JLabel();
            personLabels[i].setText(personLabelNames[i]);
            personLabels[i].setBounds(20+160*i, 10+35*6, 100, 25);
            this.add(personLabels[i]);
            personTextFields[i] = new JTextField();
            personTextFields[i].setBounds(100+140*i, 10+35*6, 70, 25);
            this.add(personTextFields[i]);
        }
        
        JLabel orderLabel = new JLabel();
        orderLabel.setText("装车订单号");
        orderLabel.setBounds(20, 10+35*7, 100, 25);
        this.add(orderLabel);
        
        JTextArea orderTextArea = new JTextArea();
        JScrollPane orderScrollPane = new JScrollPane(orderTextArea);
        orderScrollPane.setBounds(100, 10+35*7, 150, 75);
        this.add(orderScrollPane);
        
        JLabel costLabel = new JLabel();
        costLabel.setText("运费");
        costLabel.setBounds(20, 20+35*9, 100, 25);
        this.add(costLabel);
        
        JTextField costTextField = new JTextField();
        costTextField.setBounds(100, 20+35*9, 60, 25);
        this.add(costTextField);
        
        LoadVO vo = tableModel.getLoadVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getTransportId());
        textFields[2].setText(vo.getTruckId());
        departComboBox.setSelectedItem(vo.getDepart());
        destinationComboBox.setSelectedItem(vo.getDestination());
        yearComboBox.setSelectedItem(vo.getLoadingDate().getYear());
        monthComboBox.setSelectedItem(vo.getLoadingDate().getMonth());
        dayComboBox.setSelectedItem(vo.getLoadingDate().getDay());
        
        // 如果textfield的编号和表格列号一一对应，上述代码也可以用for循环 
        // textFields[i].setText((String) tableModel.getValueAt(modelRow, i));
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 380, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    LoadPendingDialog.this.dispose();
                    return;
                }
                List<String> orderIdList = new ArrayList<String>();
                orderIdList.add(orderTextArea.getText());
                LoadVO vo = new LoadVO(textFields[0].getText(), new Date(), textFields[1].getText(), (String)departComboBox.getSelectedItem(), (String)destinationComboBox.getSelectedItem(), textFields[2].getText(), personTextFields[0].getText(), personTextFields[1].getText(), orderIdList, new Double(costTextField.getText()));
                tableModel.modify(modelRow, vo);
                System.out.println("you've clicked confirm button..");
                LoadPendingDialog.this.dispose();
                
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 380, 80, 30);
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    LoadPendingDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }
        this.add(confirmButton);

        this.setSize(340, 470);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
