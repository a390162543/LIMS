package presentation.businesshallui.revenueui;

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

import vo.RevenueVO;
import businesslogic.revenuebl.Revenue;
import businesslogicservice.RevenueblService;

public class RevenueDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = 6468749815012470915L;
    private static final String[] LABEL_NAMES = {"�տ���","���Ա���","�տ�Ӫҵ��","�տ�����","�տ����"};
    
    private RevenueblService revenueblService;
    private JTextField[] textFields;
    
    public RevenueDialog(){
        
        revenueblService = new Revenue();
        
        JLabel[] labels = new JLabel[5];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel("",JLabel.CENTER);
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(0, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        textFields = new JTextField[2];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }
        
        JComboBox<String> organizationComboBox = new JComboBox<String>();
        organizationComboBox.addItem("�Ͼ�����ϼ����ת����");
        organizationComboBox.addItem("�Ϻ����ֶ�������ת����");
        organizationComboBox.setBounds(100, 10+35*2, 180, 25);
        this.add(organizationComboBox);
        
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
        
        JTextArea orderTextArea = new JTextArea();
        JScrollPane orderScrollPane = new JScrollPane(orderTextArea);
        orderScrollPane.setBounds(100, 10+35*4, 150, 75);
        this.add(orderScrollPane);
        
        JLabel costLabel = new JLabel("", JLabel.CENTER);
        costLabel.setText("�տ���");
        costLabel.setBounds(0, 25+35*6, 100, 25);
        this.add(costLabel);
        
        JTextField costTextField = new JTextField();
        costTextField.setBounds(100, 25+35*6, 60, 25);
        this.add(costTextField);
        
        JButton confirmButton = new JButton("ȷ��");
        confirmButton.setBounds(230, 280, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> orderIdList = new ArrayList<String>();
                orderIdList.add(orderTextArea.getText());
                RevenueVO vo = new RevenueVO(textFields[0].getText(), new Date(), textFields[1].getText(), new Double(costTextField.getText()), orderIdList, (String)organizationComboBox.getSelectedItem());
                revenueblService.createRevenuePO(vo);
                RevenueDialog.this.dispose();
            }
        });
        JButton cancleButton = new JButton("ȡ��");
        cancleButton.setBounds(140, 280, 80, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                RevenueDialog.this.dispose();
            }
        });
        
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setTitle("װ����");
        this.setSize(340, 370);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
