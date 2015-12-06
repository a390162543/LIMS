package presentation.financeui.primeinfoui.storeinui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;








import businesslogic.storeinbl.Storein;
import businesslogicservice.IdblService;
import businesslogicservice.StoreinblService;
import presentation.storageui.storeinui.StoreinGoodsDialog;
import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import vo.OrganizationVO;
import vo.StoreinCreateVO;

public class PrimeInfoStoreinDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1952513564210206454L;

	private PrimeInfoStoreinTableModel primeInfoStoreinTableModel;
	
	private JLabel storeinIdLabel;
	private JTextField storeinIdTextField;
	
	private JLabel storeinDateLabel;
	private RecentDatePickPanel datePickPanel;
	
	private JLabel destinationLabel;
	private OrganizationComboBox destinationComboBox;
	private JLabel organizationLabel;
	private OrganizationComboBox organizationComboBox;
	
	private JLabel goodsInfoLabel;
	private JTable goodsInfoTable;
	
	
	private JButton addButton;
	private JButton deleteButton;
	private JButton confirmButton;
	private JButton cancleButton;

	private String[] column = {"订单号","区号","排号","架号","位号"};
	private static final String[] LABEL_NAMES = {"入库单号","入库日期","入库地点","目的地","入库货物数量","货物信息"};
    private DefaultTableModel tableModel = new DefaultTableModel(null, column);
   
    
    
	public PrimeInfoStoreinDialog(PrimeInfoStoreinTableModel tm){
		
		this.primeInfoStoreinTableModel = tm;
		
		this.setTitle("货物入库");	
		this.setSize(380, 440);
		this.setLayout(null);
		
		storeinIdLabel = new JLabel("入库单号");
		storeinIdLabel.setBounds(20, 9, 80, 22);
		storeinIdTextField = new JTextField();
		storeinIdTextField.setBounds(110, 9, 180, 22);
				
		storeinDateLabel = new JLabel("入库日期");
		storeinDateLabel.setBounds(20, 40, 80, 22);
		datePickPanel = new RecentDatePickPanel();
		datePickPanel.setBounds(110, 40, 200, 22);
        
		organizationLabel = new JLabel("入库地");
		organizationLabel.setBounds(28, 72, 60, 22);
		organizationComboBox = new OrganizationComboBox();
		organizationComboBox.setBounds(110, 72, 180, 22);
		
        destinationLabel = new JLabel("目的地");
        destinationLabel.setBounds(28, 105, 60, 22);
        destinationComboBox = new OrganizationComboBox();
        destinationComboBox.setBounds(110, 105, 180, 22);
        goodsInfoLabel = new JLabel("货物信息");
        goodsInfoLabel.setBounds(2, 140, 80, 22);
        
        goodsInfoTable = new JTable(tableModel);
        goodsInfoTable.setSize(250, 180);  
        goodsInfoTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        
        JScrollPane scrollpane = new JScrollPane(goodsInfoTable);
        scrollpane.setBounds(82, 130, 290, 180); 
        
        addButton = new JButton("新增");
        addButton.setBounds(210, 325, 70, 30);
        deleteButton = new JButton("删除");
        deleteButton.setBounds(295, 325, 70, 30);
        confirmButton = new JButton("确定");
        confirmButton.setBounds(295, 360, 70, 30);
        cancleButton = new JButton("取消");
        cancleButton.setBounds(210, 360, 70, 30);
       
        organizationComboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			//需要organiza提供根据名字获取ID的方法
				StoreinblService storeinblService = new Storein();
				IdblService idblService = storeinblService.getIdblService();
				//这里获取ID
				storeinIdTextField.setText(idblService.createNewId("0250"));
				storeinIdTextField.setEditable(false);
				
			}
		});
        
        
		this.add(storeinIdLabel);
		this.add(storeinIdTextField);
		this.add(organizationLabel);
		this.add(organizationComboBox);
		
        this.add(cancleButton);
        this.add(confirmButton);
        this.add(deleteButton);
        this.add(addButton);
        this.add(scrollpane);
        this.add(goodsInfoLabel);
        this.add(destinationComboBox);
        this.add(destinationLabel);
        this.add(datePickPanel);
		this.add(storeinDateLabel);
		
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
	
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PrimeInfoStoreinGoodsDialog(tableModel,storeinIdTextField.getText().substring(0, 5));
			}			
		});
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				  int selectedRow = goodsInfoTable.getSelectedRow();
	              if(selectedRow == -1)
	            	  return;    
	              tableModel.removeRow(selectedRow); 
			}
		});
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int totalRow = goodsInfoTable.getRowCount(); 
				ArrayList<String> orderId = new ArrayList<String>();
				ArrayList<Integer> areaNum = new ArrayList<Integer>();
				ArrayList<Integer> rowNum = new ArrayList<Integer>();
				ArrayList<Integer> frameNum = new ArrayList<Integer>();
				ArrayList<Integer> item = new ArrayList<Integer>();
				for(int i=0;i<totalRow;i++){
					orderId.add(new String((String)tableModel.getValueAt(i, 0)));
					areaNum.add(Integer.parseInt((String)tableModel.getValueAt(i, 1)));
					rowNum.add(Integer.parseInt((String)tableModel.getValueAt(i, 2)));
					frameNum.add(Integer.parseInt((String)tableModel.getValueAt(i, 3)));
					item.add(Integer.parseInt((String)tableModel.getValueAt(i, 4)));
				}
				for(int i=0;i<totalRow;i++)
					System.out.println(orderId.get(i));
				
				Date inDate = datePickPanel.getDate();
				
				String destination = destinationComboBox.getItemAt(destinationComboBox.getSelectedIndex());
				
				StoreinCreateVO vo = new StoreinCreateVO(storeinIdTextField.getText(), orderId, inDate, destination, areaNum, rowNum,
						frameNum, item, organizationComboBox.getItemAt(organizationComboBox.getSelectedIndex()));
				primeInfoStoreinTableModel.create(vo);
				PrimeInfoStoreinDialog.this.dispose();	
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimeInfoStoreinDialog.this.dispose();
			}
		});
	}
	

	public PrimeInfoStoreinDialog(PrimeInfoStoreinTableModel tm, int modelRow, boolean isEditable) {
        
        this.primeInfoStoreinTableModel = tm;

        JLabel[] labels = new JLabel[6];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        JTextField[] textFields = new JTextField[5];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);

            textFields[i].setEditable(isEditable);
            this.add(textFields[i]);
        }
        StoreinCreateVO vo = primeInfoStoreinTableModel.getStoreinCreateVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[3].setText(vo.getInDate().toString());
        textFields[2].setText(vo.getOrganization());
        textFields[1].setText(vo.getDestination());
        textFields[4].setText(String.valueOf(vo.getOrderId().size()));
        
        List<String> orderIdList = vo.getOrderId();
        List<Integer> areaNum = vo.getAreaNum();
        List<Integer> rowNum = vo.getRowNum();
        List<Integer> frameNum = vo.getFrameNum();
        List<Integer> item = vo.getItem();
        
        JTable goodsInfoTable = new JTable(tableModel);
        goodsInfoTable.setSize(250, 180);  
        goodsInfoTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        JScrollPane scrollpane = new JScrollPane(goodsInfoTable);
        scrollpane.setBounds(40, 220, 290, 180); 
        for (int i = 0; i < orderIdList.size(); i++) {
        	String[] data = {orderIdList.get(i),String.valueOf(areaNum.get(i)),String.valueOf(rowNum.get(i)),
        			String.valueOf(frameNum.get(i)),String.valueOf(rowNum.get(i))};
        	tableModel.addRow(data);
		}
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 410, 80, 30);
        
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    PrimeInfoStoreinDialog.this.dispose();
                    return;
                }
   
                @SuppressWarnings("deprecation")
                //完整的信息构造可以根据tablemodel显示
     
				StoreinCreateVO vo = new StoreinCreateVO(textFields[0].getText(), orderIdList, new Date(textFields[1].getText()), 
                		textFields[2].getText(), areaNum, rowNum, frameNum, item);
                primeInfoStoreinTableModel.modify(modelRow, vo);
                PrimeInfoStoreinDialog.this.dispose();
                
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 410, 80, 30);
            cancleButton.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    PrimeInfoStoreinDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }
        
        this.add(confirmButton);
        this.add(scrollpane);
        this.setSize(360, 510);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
