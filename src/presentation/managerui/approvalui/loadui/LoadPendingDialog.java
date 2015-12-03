package presentation.managerui.approvalui.loadui;

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




import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import businesslogic.loadbl.Load;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdblService;
import businesslogicservice.LoadblService;
import vo.LoadVO;

public class LoadPendingDialog extends JDialog {
	
	/**
     * 
     */
    private static final long serialVersionUID = 4875938402353589894L;

    private static final String[] LABEL_NAMES = {"装车单编号","汽运编号","车辆代号","出发地","目的地","装车日期"};
    
    private LoadPendingTableModel loadPendingTableModel;
    
    private LoadblService loadblService;
    private JTextField[] textFields;
    private OrderTableModel tableModel;
    private JTextField costTextField;
    private JComboBox<String> departComboBox;
    private JComboBox<String> destinationComboBox;
    
    
      
    public LoadPendingDialog(LoadPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.loadPendingTableModel = tm;

        loadblService = new Load();
        
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
        this.add(costTextField);
        
        LoadVO vo = loadPendingTableModel.getLoadVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getTruckId());
        departComboBox.setSelectedItem(vo.getDepart());
        destinationComboBox.setSelectedItem(vo.getDestination());
        datePickPanel.setDate(vo.getLoadingDate());
        
        tableModel = new OrderTableModel(loadblService , vo.getOrderId());
        TableRowSorter<TableModel>  tableSorter = new TableRowSorter<TableModel>(tableModel);
        JTable orderTable = new JTable(tableModel);
        orderTable.getTableHeader().setPreferredSize(new Dimension(180, 25));
        orderTable.setSize(250, 100);
        orderTable.setRowSorter(tableSorter);   
        
        
        JScrollPane OrderScrollPane = new JScrollPane(orderTable);
        OrderScrollPane.setBounds(100, 10+35*6, 150, 75);          
        this.add(OrderScrollPane);

        // 如果textfield的编号和表格列号一一对应，上述代码也可以用for循环 
        // textFields[i].setText((String) tableModel.getValueAt(modelRow, i));
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 340, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    LoadPendingDialog.this.dispose();
                    return;
                }
                List<String> orderIdList = new ArrayList<String>();
                for(int i = 0; i < orderTable.getRowCount(); i ++)
                    orderIdList.add((String)orderTable.getValueAt(i, 0));
                LoadVO vo = new LoadVO(textFields[0].getText(), new Date(), textFields[1].getText(), (String)departComboBox.getSelectedItem(), (String)destinationComboBox.getSelectedItem(), textFields[2].getText(), personTextFields[0].getText(), personTextFields[1].getText(), orderIdList, new Double(costTextField.getText()));
                loadPendingTableModel.modify(modelRow, vo);
                System.out.println("you've clicked confirm button..");
                LoadPendingDialog.this.dispose();
                
            }
        });
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
        this.add(confirmButton);

        this.setSize(340, 430);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
