package presentation.managerui.approvalui.revenueui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import presentation.mainui.MainFrame;
import presentation.managerui.approvalui.revenueui.OrderTableModel;
import presentation.util.DialogLayoutManager;
import presentation.util.RecentDatePickPanel;
import presentation.util.ScreenMessage;
import vo.RevenueVO;

/**
 * 审批时收款单的{@code Jdialog}
 * @author 林祖华
 * @version 1.5
 * @see businesslogicservice.ApprovalblService
 */
public class RevenuePendingDialog extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 6428790754440378980L;

    private static final String[] LABEL_NAMES = {"收款单编号","快递员编号","收款营业厅","收款账户","收款日期","收款订单号"};

    private RevenueblService revenueblService;
    private RevenuePendingTableModel revenuePendingTableModel;
    private OrderTableModel tableModel;
    private JTextField[] textFields;
      
    
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
        textFields = new JTextField[2];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            textFields[i].setEnabled(false);
            this.add(textFields[i]);
        }

        
        JComboBox<String> organizationComboBox = new JComboBox<String>();
        organizationComboBox.addItem("南京市栖霞区中转中心");
        organizationComboBox.addItem("上海市浦东新区中转中心");
        organizationComboBox.setBounds(100, 10+35*2, 180, 25);
        organizationComboBox.setEnabled(false);
        this.add(organizationComboBox);
        
        JTextField accountIdTextField = new JTextField();
        accountIdTextField.setBounds(100, 10+35*3, 180, 25);
        this.add(accountIdTextField);
        
        RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
        datePickPanel.setBounds(100, 10+35*3, 200, 25);
        datePickPanel.setEnabled(false);
        this.add(datePickPanel);
        
        RevenueVO vo = revenuePendingTableModel.getRevenueVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getCourierId());
        organizationComboBox.setSelectedItem(vo.getOrganization());
        accountIdTextField.setText(vo.getAccountId());
        datePickPanel.setDate(vo.getRevenueDate());


        tableModel = new OrderTableModel(revenueblService,vo.getOrderId());  
        TableRowSorter<TableModel>  tableSorter = new TableRowSorter<TableModel>(tableModel);
        JTable orderTable = new JTable(tableModel);
        orderTable.getTableHeader().setPreferredSize(new Dimension(180, 25));
        orderTable.setSize(250, 100);
        orderTable.setRowSorter(tableSorter);   
        
        
        JScrollPane OrderScrollPane = new JScrollPane(orderTable);
        OrderScrollPane.setBounds(100, 10+35*4, 150, 75);    
        this.add(OrderScrollPane);
        
        
        JLabel costLabel = new JLabel("", JLabel.CENTER);
        costLabel.setText("收款金额");
        costLabel.setBounds(0, 25+35*7, 100, 25);
        this.add(costLabel);
        
        JTextField costTextField = new JTextField();
        costTextField.setBounds(100, 25+35*7, 60, 25);
        costTextField.setEnabled(false);
        this.add(costTextField);
        
        costTextField.setText(""+vo.getRevenue());
        
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 320, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    RevenuePendingDialog.this.dispose();
                    return;
                }
                
                vo.setAccountId(accountIdTextField.getText());
                revenuePendingTableModel.modify(modelRow, vo);
                RevenuePendingDialog.this.dispose();
                ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
            }
        });
        this.add(confirmButton);
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
        if(!isEditable){
            accountIdTextField.setEnabled(false);
        }

        this.setSize(340, 400);
        this.setLayout(new DialogLayoutManager());
        this.setLocationRelativeTo(MainFrame.getMainFrame());
        this.setTitle("收款单");
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
