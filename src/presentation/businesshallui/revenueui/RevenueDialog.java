package presentation.businesshallui.revenueui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.businesshallui.revenueui.OrderTableModel;
import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import vo.RevenueVO;
import businesslogic.BusinessLogicService;
import businesslogic.userbl.LoginController;
import businesslogicservice.RevenueblService;

public class RevenueDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = 6468749815012470915L;
    private static final String[] LABEL_NAMES = {"收款单编号","快递员编号","收款营业厅","收款日期","收款订单号"};
    
    private RevenueblService revenueblService;
    private JTextField[] textFields;
    private OrderTableModel tableModel;
    private JTextField costTextField;
    
    public RevenueDialog(){
        
        revenueblService = BusinessLogicService.getRevenueblService();
        
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
        
        OrganizationComboBox organizationComboBox = new OrganizationComboBox();
        organizationComboBox.setSelectedItem(LoginController.getOrganizationName());
        organizationComboBox.setEnabled(false);
        organizationComboBox.setBounds(100, 10+35*2, 180, 25);
        this.add(organizationComboBox);
        
        RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
        datePickPanel.setBounds(100, 10+35*3, 200, 25);
        this.add(datePickPanel);
        
        tableModel = new OrderTableModel(revenueblService);  
        TableRowSorter<TableModel>  tableSorter = new TableRowSorter<TableModel>(tableModel);
        JTable orderTable = new JTable(tableModel);
        orderTable.getTableHeader().setPreferredSize(new Dimension(180, 25));
        orderTable.setSize(250, 100);
        orderTable.setRowSorter(tableSorter);   
        
        
        JScrollPane OrderScrollPane = new JScrollPane(orderTable);
        OrderScrollPane.setBounds(100, 10+35*4, 150, 75);          
        JButton addOrderButton = new JButton("添加订单");
        addOrderButton.setBounds(260, 10+35*4, 70, 20);
        JButton deleteOrderButton = new JButton("删除订单");
        deleteOrderButton.setBounds(260, 10+35*5, 70, 20);
        addOrderButton.addActionListener(new ActionListener() {
                
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // new AddOrderDialog(tableModel, dialog);
                     new AddOrderDialog();
            }
        });
            
        deleteOrderButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int row = orderTable.getSelectedRow();
                   if(row == -1)
                       return;
                   int modelRow = orderTable.convertRowIndexToModel(row);
                   tableModel.delete(modelRow);
            }
        });
        
        this.add(OrderScrollPane);
        this.add(addOrderButton);
        this.add(deleteOrderButton);
        
        JLabel costLabel = new JLabel("", JLabel.CENTER);
        costLabel.setText("收款金额");
        costLabel.setBounds(0, 25+35*6, 100, 25);
        this.add(costLabel);
        
        costTextField = new JTextField();
        costTextField.setBounds(100, 25+35*6, 60, 25);
        this.add(costTextField);
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 280, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String id = textFields[0].getText();
                Date revenueDate = datePickPanel.getTime();
                String courierId = textFields[1].getText();
                double revenue = new Double(costTextField.getText());
                String accountId = "";
                String organization = (String) organizationComboBox.getSelectedItem();
                
                List<String> orderIdList = new ArrayList<String>();
                for(int i = 0; i < orderTable.getRowCount(); i ++)
                    orderIdList.add((String)orderTable.getValueAt(i, 0));
                
                RevenueVO vo = new RevenueVO(id, revenueDate, courierId, revenue, orderIdList, accountId, organization);
                revenueblService.createRevenuePO(vo);
                RevenueDialog.this.dispose();
            }
        });
        JButton cancleButton = new JButton("取消");
        cancleButton.setBounds(140, 280, 80, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                RevenueDialog.this.dispose();
            }
        });
        
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setTitle("装车单");
        this.setSize(340, 370);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
    
    private void setRevenueField(){
        costTextField.setText(""+revenueblService.getSum());
    }
    
    class AddOrderDialog extends JDialog{

        
    /**
         * 
         */
        private static final long serialVersionUID = -5436641251910399740L;
     
    
    
        public AddOrderDialog( ){
            
            JLabel infoLanel = new JLabel("订单");
            infoLanel.setBounds(105, 10, 170, 35);
            JLabel orderLabel = new JLabel("订单号");
            orderLabel.setBounds(35, 85, 100, 24);
            JTextField orderField = new JTextField();
            orderField.setBounds(145, 85, 180, 20);
            JButton cancelButton = new JButton("取消");
            cancelButton.setBounds(190, 150, 70, 30);
            JButton confirmButton = new JButton("确定");
            confirmButton.setBounds(275, 150, 70, 30);
            
            cancelButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    AddOrderDialog.this.dispose();
                }
            });
            
            confirmButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    tableModel.add(orderField.getText());
                    setRevenueField();
                                        
                }
            });
            
            this.add(infoLanel);
            this.add(orderLabel);
            this.add(orderField);
            this.add(cancelButton);
            this.add(confirmButton);
            this.setLayout(null);
            this.setBounds(100, 100, 380, 240);
            this.setModalityType(ModalityType.APPLICATION_MODAL);
            this.setVisible(true);      
        }

    }
}
