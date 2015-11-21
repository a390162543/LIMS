package presentation.businesshallui.arrivalui;

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

import businesslogic.arrivalbl.Arrival;
import businesslogicservice.ArrivalblService;
import systemenum.GoodsState;
import vo.ArrivalVO;

public class ArrivalDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = 6468749815012470915L;
    private static final String[] LABEL_NAMES = {"到达单编号","中转单编号","出发地","到达日期","到达状况"};
    
    private ArrivalblService arrivalblService;
    private JTextField[] textFields;
    
    public ArrivalDialog(){
        
        arrivalblService = new Arrival();
        
        JLabel[] labels = new JLabel[5];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        textFields = new JTextField[2];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }
        
        JComboBox<String> destinationComboBox = new JComboBox<String>();
        destinationComboBox.addItem("南京市栖霞区中转中心");
        destinationComboBox.addItem("上海市浦东新区中转中心");
        destinationComboBox.setBounds(100, 10+35*2, 180, 25);
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
        yearComboBox.setBounds(100, 10+35*3, 70, 25);
        monthComboBox.setBounds(170, 10+35*3, 60, 25);
        dayComboBox.setBounds(230, 10+35*3, 60, 25);
        this.add(yearComboBox);
        this.add(monthComboBox);
        this.add(dayComboBox);
        
        //set arrival state
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton[] jRadioButtons = new JRadioButton[3];
        String[] radioButtonNames = {"完好","破损","丢失"};
        for(int i=0;i<jRadioButtons.length;i++){
            jRadioButtons[i] = new JRadioButton(radioButtonNames[i]);
            jRadioButtons[i].setBounds(90+60*i, 10+35*4, 60, 25);
            buttonGroup.add(jRadioButtons[i]);
            this.add(jRadioButtons[i]);
        }


        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 200, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrivalVO vo = new ArrivalVO(textFields[0].getText(), new Date(), textFields[1].getText(), (String)destinationComboBox.getSelectedItem(), GoodsState.COMPLETE);
                arrivalblService.createArrivalPO(vo);
                ArrivalDialog.this.dispose();
            }
        });
        JButton cancleButton = new JButton("取消");
        cancleButton.setBounds(140, 200, 80, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrivalDialog.this.dispose();
            }
        });
        
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setTitle("到达单");
        this.setSize(340, 280);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
