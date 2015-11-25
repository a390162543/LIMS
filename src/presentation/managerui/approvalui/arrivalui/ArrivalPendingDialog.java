package presentation.managerui.approvalui.arrivalui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import systemenum.GoodsState;
import vo.ArrivalVO;

public class ArrivalPendingDialog extends JDialog {
	
	/**
     * 
     */
    private static final long serialVersionUID = 4875938402353589894L;

    private static final String[] LABEL_NAMES = {"到达单编号","中转单编号","出发地","到达地","到达日期","到达状况"};
    
    private ArrivalPendingTableModel tableModel;
    
      
    @SuppressWarnings("deprecation")
    public ArrivalPendingDialog(ArrivalPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[5];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        JTextField textFields[];
        textFields = new JTextField[2];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }
        
        JComboBox<String> departComboBox = new JComboBox<String>();
        departComboBox.addItem("南京市栖霞区中转中心");
        departComboBox.addItem("上海市浦东新区中转中心");
        departComboBox.setBounds(100, 10+35*2, 180, 25);
        this.add(departComboBox);
        
        JComboBox<String> destinationComboBox = new JComboBox<String>();
        destinationComboBox.addItem("南京市栖霞区中转中心");
        destinationComboBox.addItem("上海市浦东新区中转中心");
        destinationComboBox.setBounds(100, 10+35*3, 180, 25);
        this.add(destinationComboBox);
        //set birth chooser
//        JLabel[] birthLabels = new JLabel[3];
//        String[] birthLabelNames = {"年","月","日"};
//        for(int i=0;i<birthLabels.length;i++){
//            birthLabels[i] = new JLabel();
//            birthLabels[i].setText(birthLabelNames[i]);
//            birthLabels[i].setBounds(145+50*i, 8+35*3, 20, 25);
//            this.add(birthLabels[i]);
//        }
        JComboBox<Integer> yearComboBox = new JComboBox<Integer>();
        JComboBox<Integer> monthComboBox = new JComboBox<Integer>();
        JComboBox<Integer> dayComboBox = new JComboBox<Integer>();
        for(int i=1960;i<=2015;i++)  yearComboBox.addItem(i);
        for(int i=1;i<=12;i++)  monthComboBox.addItem(i);
        for(int i=1;i<=31;i++)  dayComboBox.addItem(i);
        yearComboBox.setBounds(100, 10+35*4, 70, 25);
        monthComboBox.setBounds(170, 10+35*4, 60, 25);
        dayComboBox.setBounds(230, 10+35*4, 60, 25);
        this.add(yearComboBox);
        this.add(monthComboBox);
        this.add(dayComboBox);
        
        //set arrival state
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton[] jRadioButtons = new JRadioButton[3];
        String[] radioButtonNames = {"完好","破损","丢失"};
        for(int i=0;i<jRadioButtons.length;i++){
            jRadioButtons[i] = new JRadioButton(radioButtonNames[i]);
            jRadioButtons[i].setBounds(90+60*i, 10+35*5, 60, 25);
            buttonGroup.add(jRadioButtons[i]);
            this.add(jRadioButtons[i]);
        }
        
        ArrivalVO vo = tableModel.getArrivalVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getTransferId());
        departComboBox.setSelectedItem(vo.getDepart());
        destinationComboBox.setSelectedItem(vo.getDepart());
        yearComboBox.setSelectedItem(vo.getArrivalDate().getYear());
        monthComboBox.setSelectedItem(vo.getArrivalDate().getMonth());
        dayComboBox.setSelectedItem(vo.getArrivalDate().getDate());
        jRadioButtons[0].setSelected(true);

        
        // 如果textfield的编号和表格列号一一对应，上述代码也可以用for循环 
        // textFields[i].setText((String) tableModel.getValueAt(modelRow, i));
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 240, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    ArrivalPendingDialog.this.dispose();
                    return;
                }
                ArrivalVO vo = new ArrivalVO(textFields[0].getText(), new Date(), textFields[1].getText(), (String)departComboBox.getSelectedItem(), (String)destinationComboBox.getSelectedItem(), GoodsState.COMPLETE);
                tableModel.modify(modelRow, vo);
                System.out.println("you've clicked confirm button..");
                ArrivalPendingDialog.this.dispose();
                
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 240, 80, 30);
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrivalPendingDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }
        this.add(confirmButton);

        this.setSize(340, 320);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
