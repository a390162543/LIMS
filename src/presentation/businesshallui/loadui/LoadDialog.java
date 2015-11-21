package presentation.businesshallui.loadui;

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
import businesslogic.loadbl.Load;
import businesslogicservice.LoadblService;

public class LoadDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = 6468749815012470915L;
    private static final String[] LABEL_NAMES = {"装车单编号","汽运编号","车辆代号","目的地","装车日期"};
    
    private LoadblService loadblService;
    private JTextField[] textFields;
    
    public LoadDialog(){
        
        loadblService = new Load();
        
        JLabel[] labels = new JLabel[5];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        textFields = new JTextField[3];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }

        JComboBox<String> destinationComboBox = new JComboBox<String>();
        destinationComboBox.addItem("南京市栖霞区中转中心");
        destinationComboBox.addItem("上海市浦东新区中转中心");
        destinationComboBox.setBounds(100, 10+35*3, 180, 25);
        this.add(destinationComboBox);
        
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
        
        JLabel[] personLabels = new JLabel[2];
        String[] personLabelNames = {"监装员","押运员"};
        JTextField[] personTextFields = new JTextField[2];
        for(int i=0;i<2;i++){
            personLabels[i] = new JLabel();
            personLabels[i].setText(personLabelNames[i]);
            personLabels[i].setBounds(20+160*i, 10+35*5, 100, 25);
            this.add(personLabels[i]);
            personTextFields[i] = new JTextField();
            personTextFields[i].setBounds(100+140*i, 10+35*5, 70, 25);
            this.add(personTextFields[i]);
        }
        
        JLabel orderLabel = new JLabel();
        orderLabel.setText("装车订单号");
        orderLabel.setBounds(20, 10+35*6, 100, 25);
        this.add(orderLabel);
        
        JTextArea orderTextArea = new JTextArea();
        JScrollPane orderScrollPane = new JScrollPane(orderTextArea);
        orderScrollPane.setBounds(100, 10+35*6, 150, 75);
        this.add(orderScrollPane);
        
        JLabel costLabel = new JLabel();
        costLabel.setText("运费");
        costLabel.setBounds(20, 20+35*8, 100, 25);
        this.add(costLabel);
        
        JTextField costTextField = new JTextField();
        costTextField.setBounds(100, 20+35*8, 60, 25);
        this.add(costTextField);
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 340, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> orderIdList = new ArrayList<String>();
                orderIdList.add(orderTextArea.getText());
                LoadVO vo = new LoadVO(textFields[0].getText(), new Date(), textFields[1].getText(), "还没实现", (String)destinationComboBox.getSelectedItem(), textFields[2].getText(), personTextFields[0].getText(), personTextFields[1].getText(), orderIdList, new Double(costTextField.getText()));
                loadblService.createLoadPO(vo);
                LoadDialog.this.dispose();
            }
        });
        JButton cancleButton = new JButton("取消");
        cancleButton.setBounds(140, 340, 80, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                LoadDialog.this.dispose();
            }
        });
        
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setTitle("装车单");
        this.setSize(340, 430);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
