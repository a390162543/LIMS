package presentation.managerui.approvalui.revenueui;

import java.awt.Dimension;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import businesslogic.BusinessLogicService;
import businesslogicservice.RevenueblService;
import presentation.managerui.approvalui.revenueui.OrderTableModel;
import vo.RevenueVO;

public class RevenuePendingDialog extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 6428790754440378980L;

    private static final String[] LABEL_NAMES = {"收款单编号","快递员编号","收款营业厅","收款账户","收款日期","收款订单号"};
    
    private RevenueblService revenueblService;
    private RevenuePendingTableModel revenuePendingTableModel;
    private OrderTableModel tableModel;
      
    @SuppressWarnings("deprecation")
    public RevenuePendingDialog(RevenuePendingTableModel tm, int modelRow, boolean isEditable) {
        revenueblService = BusinessLogicService.getRevenueblService();
        
        this.revenuePendingTableModel = tm;

        JLabel[] labels = new JLabel[6];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel("",JLabel.CENTER);
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(0, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        JTextField textFields[];
        textFields = new JTextField[2];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }
        
        JComboBox<String> organizationComboBox = new JComboBox<String>();
        organizationComboBox.addItem("南京市栖霞区中转中心");
        organizationComboBox.addItem("上海市浦东新区中转中心");
        organizationComboBox.setBounds(100, 10+35*2, 180, 25);
        this.add(organizationComboBox);
        
        JTextField accountIdTextField = new JTextField();
        accountIdTextField.setBounds(100, 10+35*3, 180, 25);
        this.add(accountIdTextField);
        
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
        

        
        JLabel costLabel = new JLabel("", JLabel.CENTER);
        costLabel.setText("收款金额");
        costLabel.setBounds(0, 25+35*7, 100, 25);
        this.add(costLabel);
        
        JTextField costTextField = new JTextField();
        costTextField.setBounds(100, 25+35*7, 60, 25);
        this.add(costTextField);
        
        RevenueVO vo = revenuePendingTableModel.getRevenueVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getCourierId());
        organizationComboBox.setSelectedItem(vo.getOrganization());
        accountIdTextField.setText(vo.getAccountId());
        yearComboBox.setSelectedItem(vo.getRevenueDate().getYear());
        monthComboBox.setSelectedItem(vo.getRevenueDate().getMonth());
        dayComboBox.setSelectedItem(vo.getRevenueDate().getDate());
        costTextField.setText(""+vo.getRevenue());

        tableModel = new OrderTableModel(revenueblService,vo.getOrderId());  
        TableRowSorter<TableModel>  tableSorter = new TableRowSorter<TableModel>(tableModel);
        JTable orderTable = new JTable(tableModel);
        orderTable.getTableHeader().setPreferredSize(new Dimension(180, 25));
        orderTable.setSize(250, 100);
        orderTable.setRowSorter(tableSorter);   
        
        
        JScrollPane OrderScrollPane = new JScrollPane(orderTable);
        OrderScrollPane.setBounds(100, 10+35*4, 150, 75);    
        this.add(OrderScrollPane);
        // 如果textfield的编号和表格列号一一对应，上述代码也可以用for循环 
        // textFields[i].setText((String) tableModel.getValueAt(modelRow, i));
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 320, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    RevenuePendingDialog.this.dispose();
                    return;
                }
                List<String> orderIdList = new ArrayList<String>();
                for(int i = 0; i < orderTable.getRowCount(); i ++)
                    orderIdList.add((String)orderTable.getValueAt(i, 0));
                RevenueVO vo = new RevenueVO(textFields[0].getText(), new Date(), textFields[1].getText(), new Double(costTextField.getText()), orderIdList,accountIdTextField.getText(),(String)organizationComboBox.getSelectedItem());
                revenuePendingTableModel.modify(modelRow, vo);
                System.out.println("you've clicked confirm button..");
                RevenuePendingDialog.this.dispose();
                
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 320, 80, 30);
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    RevenuePendingDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }
        this.add(confirmButton);

        this.setSize(340, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
