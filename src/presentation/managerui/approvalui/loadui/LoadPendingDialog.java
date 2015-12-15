package presentation.managerui.approvalui.loadui;

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









import presentation.businesshallui.loadui.DriverComboBox;
import presentation.businesshallui.loadui.TruckComboBox;
import presentation.util.DialogLayoutManager;
import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import businesslogic.BusinessLogicService;
import businesslogic.userbl.LoginController;
import businesslogicservice.LoadblService;
import vo.LoadVO;

/**
 * 审批时装车单的{@code Jdialog}
 * @author 林祖华
 * @version 1.8
 * @see businesslogicservice.ApprovalblService
 */
public class LoadPendingDialog extends JDialog {
	
	/**
     * 
     */
    private static final long serialVersionUID = 4875938402353589894L;

    private static final String[] LABEL_NAMES = {"装车单编号","出发地","目的地","司机编号","车辆编号","装车日期"};
    
    private LoadPendingTableModel loadPendingTableModel;
    
    private LoadblService loadblService;
    private JTextField[] textFields;
    private OrderTableModel tableModel;
    private JTextField costTextField;
    private JComboBox<String> departComboBox;
    private JComboBox<String> destinationComboBox;
    private DriverComboBox driverComboBox;
    private TruckComboBox truckComboBox;
    
      
    public LoadPendingDialog(LoadPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.loadPendingTableModel = tm;

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
        textFields[0].setEnabled(false);

        departComboBox = new OrganizationComboBox();
        departComboBox.setSelectedItem(LoginController.getOrganizationName());
        departComboBox.setEnabled(false);
        departComboBox.setBounds(100, 10+35*2, 180, 25);
        this.add(departComboBox);
        
        destinationComboBox = new OrganizationComboBox();
        destinationComboBox.setBounds(100, 10+35*3, 180, 25);
        destinationComboBox.setEnabled(false);
        this.add(destinationComboBox);
        
        driverComboBox = new DriverComboBox();
        this.add(driverComboBox);

        truckComboBox = new TruckComboBox();
        truckComboBox.setBounds(100, 10+35*1, 150, 25);
        this.add(truckComboBox);
        
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
 
        JLabel costLabel = new JLabel();
        costLabel.setText("运费");
        costLabel.setBounds(20, 20+35*8, 100, 25);
        this.add(costLabel);
        
        costTextField = new JTextField();
        costTextField.setBounds(100, 20+35*8, 60, 25);
        costTextField.setEnabled(false);

        
        LoadVO vo = loadPendingTableModel.getLoadVO(modelRow);
        textFields[0].setText(vo.getId());
        departComboBox.setSelectedItem(vo.getDepart());
        destinationComboBox.setSelectedItem(vo.getDestination());
        truckComboBox.update(vo.getDepart(), vo.getDestination());
        driverComboBox.update(vo.getDepart(), vo.getDestination());
        truckComboBox.setSelectedTruck(vo.getTruckId());;
        driverComboBox.setSelectedDriver(vo.getDriverId());;

        datePickPanel.setDate(vo.getLoadingDate());
        personTextFields[0].setText(vo.getLoadMan());
        personTextFields[1].setText(vo.getTransman());
        costTextField.setText(""+vo.getCost());
        
        tableModel = new OrderTableModel(loadblService , vo.getOrderId());
        TableRowSorter<TableModel>  tableSorter = new TableRowSorter<TableModel>(tableModel);
        JTable orderTable = new JTable(tableModel);
        orderTable.getTableHeader().setPreferredSize(new Dimension(180, 25));
        orderTable.setSize(250, 100);
        orderTable.setRowSorter(tableSorter);   
        
        
        JScrollPane OrderScrollPane = new JScrollPane(orderTable);
        OrderScrollPane.setBounds(100, 10+35*6, 150, 75);          
        this.add(OrderScrollPane);
        this.add(costTextField);


        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 340, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    LoadPendingDialog.this.dispose();
                    return;
                }
                String loadMan = personTextFields[0].getText();
                String transMan = personTextFields[1].getText();
                vo.setLoadMan(loadMan);
                vo.setTransman(transMan);
                loadPendingTableModel.modify(modelRow, vo);
                System.out.println("you've clicked confirm button..");
                LoadPendingDialog.this.dispose();
                
            }
        });
        this.add(confirmButton);
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 340, 80, 30);
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    LoadPendingDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }
        

        this.setSize(340, 430);
        this.setLayout(new DialogLayoutManager());
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
