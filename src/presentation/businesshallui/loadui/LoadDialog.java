package presentation.businesshallui.loadui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import vo.LoadVO;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.loadinfo.LoadOrderId;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdblService;
import businesslogicservice.LoadblService;

/**
 * 装车单的{@code Jdialog}
 * @author 林祖华
 * @version 1.3
 * @see businesslogicservice.LoadblService
 */
public class LoadDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = 6468749815012470915L;
    private static final String[] LABEL_NAMES = {"装车单编号","出发地","目的地","司机编号","车辆编号","装车日期"};
    
    private LoadblService loadblService;
    private JTextField[] textFields;
    private OrderTableModel tableModel;
    private JTextField costTextField;
    private OrganizationComboBox departComboBox;
    private OrganizationComboBox destinationComboBox;
    private DriverComboBox driverComboBox;
    private TruckComboBox truckComboBox;
    
    public LoadDialog(){
        
        loadblService = BusinessLogicService.getLoadblService();
        
        JLabel[] labels = new JLabel[6];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        textFields = new JTextField[1];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }
        IdblService idblService = loadblService.getIdblService();
        textFields[0].setText(idblService.createNewId());
        textFields[0].setEnabled(false);
        

        
        departComboBox = new OrganizationComboBox();
        departComboBox.setSelectedItem(LoginController.getOrganizationName());
        departComboBox.setEnabled(false);
        departComboBox.setBounds(100, 10+35*2, 180, 25);
        this.add(departComboBox);
        
        destinationComboBox = new OrganizationComboBox();
        destinationComboBox.setBounds(100, 10+35*3, 180, 25);
        this.add(destinationComboBox);
      
        driverComboBox = new DriverComboBox();
        this.add(driverComboBox);

        truckComboBox = new TruckComboBox();
        truckComboBox.setBounds(100, 10+35*1, 150, 25);
        this.add(truckComboBox);
        
        ActionListener comboBoxActionListener = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String organization1 = departComboBox.getSelectedOrganization();
                String organization2 = destinationComboBox.getSelectedOrganization();
                driverComboBox.update(organization1, organization2);;
                driverComboBox.repaint();
                truckComboBox.update(organization1, organization2);;
                truckComboBox.repaint();
            }
        };
        departComboBox.addActionListener(comboBoxActionListener);
        destinationComboBox.addActionListener(comboBoxActionListener);
        
        RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
        datePickPanel.setBounds(100, 10+35*4, 200, 25);
        this.add(datePickPanel);
        
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
        
        tableModel = new OrderTableModel(loadblService);  
        TableRowSorter<TableModel>  tableSorter = new TableRowSorter<TableModel>(tableModel);
        JTable orderTable = new JTable(tableModel);
        orderTable.getTableHeader().setPreferredSize(new Dimension(180, 25));
        orderTable.setSize(250, 100);
        orderTable.setRowSorter(tableSorter);   
        
        
        JScrollPane OrderScrollPane = new JScrollPane(orderTable);
        OrderScrollPane.setBounds(100, 10+35*6, 200, 100);          
        JButton addOrderButton = new JButton("添加订单");
        addOrderButton.setBounds(160, 10+35*9, 70, 20);
        JButton deleteOrderButton = new JButton("删除订单");
        deleteOrderButton.setBounds(230, 10+35*9, 70, 20);

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
                   setExpensesField();
            }
        });
        
        this.add(OrderScrollPane);
        this.add(addOrderButton);
        this.add(deleteOrderButton);
        DialogLayoutManager.fix(OrderScrollPane,addOrderButton,deleteOrderButton);
        
        JLabel costLabel = new JLabel();
        costLabel.setText("运费");
        costLabel.setBounds(20, 20+35*8, 100, 25);
        this.add(costLabel);
        
        costTextField = new JTextField();
        costTextField.setBounds(100, 20+35*8, 60, 25);
        this.add(costTextField);
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 340, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String id = textFields[0].getText();
                Date loadingDate = datePickPanel.getTime();
                String transportId = id;
                String depart = departComboBox.getSelectedOrganization();
                String destination = destinationComboBox.getSelectedOrganization();
                String driverId = driverComboBox.getSelectedDriver();
                String truckId = truckComboBox.getSelectedTruck();
                String loadMan = personTextFields[0].getText();
                String transman = personTextFields[1].getText();
                double cost = new Double(costTextField.getText());
                
                List<String> orderIdList = new ArrayList<String>();
                for(int i = 0; i < orderTable.getRowCount(); i ++)
                    orderIdList.add((String)orderTable.getValueAt(i, 0));
                
                LoadVO vo = new LoadVO(id, loadingDate, transportId, depart, destination, driverId, truckId, loadMan, transman, orderIdList, cost);
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
        this.setLayout(new DialogLayoutManager());
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
    
    private void setExpensesField(){
        costTextField.setText("" + loadblService.getCost
                ((String)departComboBox.getSelectedItem(),(String) destinationComboBox.getSelectedItem() ));
    }
    
    class AddOrderDialog extends JDialog{

        
    /**
         * 
         */
        private static final long serialVersionUID = -5436641251910399740L;
     
    
    
    public AddOrderDialog( ){
        

        JLabel orderLabel = new JLabel("订单号");
        orderLabel.setBounds(35, 85, 100, 24);
        JTextField orderField = new JTextField();
        orderField.setBounds(145, 85, 180, 20);
        JButton cancelButton = new JButton("取消");
        cancelButton.setBounds(190, 150, 80, 30);
        JButton confirmButton = new JButton("确定");
        confirmButton.setBounds(275, 150, 80, 30);
        
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
                setExpensesField();
                                    
            }
        });
        
        this.setTitle("添加订单");
        this.add(orderLabel);
        this.add(orderField);
        this.add(confirmButton);
        this.add(cancelButton);
        
        Checker orderIdChecker = new Checker(orderField, new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new LoadOrderId(orderField.getText());
            }
        });
        orderField.addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                orderIdChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });


        this.setLayout(new DialogLayoutManager());
        this.setBounds(100, 100, 380, 240);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);      
    }

}
}
