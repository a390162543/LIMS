package presentation.storageui.storeinui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.storeininfo.AlarmNum;
import businesslogic.storeinbl.Storein;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdblService;
import businesslogicservice.StoreinblService;
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import presentation.util.OrganizationComboBox;
import presentation.util.PresentationUtil;
import presentation.util.RecentDatePickPanel;
import presentation.util.ScreenMessage;
import systemenum.StorageState;
import vo.StorageLocationVO;
import vo.StoreinCreateVO;


/**
 * ���Ǵ�����ⵥ�Ľ���
 * @author lc
 * @version 1.4
 *
 */
public class StoreinDialogUI extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8473388450983247253L;
	/**
	 * 
	 */
	
	private JLabel storeinIdLabel;
	private JTextField storeinIdTextField;
	
	private JLabel storeinDateLabel;
	private RecentDatePickPanel datePickPanel;
	
	private JLabel destinationLabel;
	private OrganizationComboBox destinationComboBox;
	private JLabel goodsInfoLabel;
	private JTable goodsInfoTable;
	
	
	private JButton addButton;
	private JButton deleteButton;
	private JButton confirmButton;
	private JButton cancleButton;

	private String[] column = {"������","����","�ź�","�ܺ�","λ��"};
    private DefaultTableModel tableModel = new DefaultTableModel(null, column);
    
    
    

	public StoreinDialogUI(){
		
		this.setTitle("�������");	
		this.setSize(380, 440);
		
		storeinIdLabel = new JLabel("��ⵥ��");
		storeinIdLabel.setBounds(20, 34, 80, 22);
		storeinIdTextField = new JTextField();
		storeinIdTextField.setBounds(110, 34, 180, 22);
		StoreinblService storeinblService = new Storein();
		IdblService idblService = storeinblService.getIdblService();
		storeinIdTextField.setText(idblService.createNewId());
		storeinIdTextField.setEditable(false);
		
		storeinDateLabel = new JLabel("�������");
		storeinDateLabel.setBounds(20, 64, 80, 22);
		datePickPanel = new RecentDatePickPanel();
		datePickPanel.setBounds(110, 64, 200, 22);
        
        destinationLabel = new JLabel("Ŀ�ĵ�");
        destinationLabel.setBounds(28, 90, 60, 22);
        destinationComboBox = new OrganizationComboBox();
        destinationComboBox.setBounds(110, 92, 180, 22);
        goodsInfoLabel = new JLabel("������Ϣ");
        goodsInfoLabel.setBounds(2, 125, 80, 22);
        
        goodsInfoTable = new JTable(tableModel);
        goodsInfoTable.setSize(250, 180);  
        goodsInfoTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        
        
        JScrollPane scrollpane = new JScrollPane(goodsInfoTable);
        scrollpane.setBounds(82, 130, 290, 180); 
        PresentationUtil.fitTableColumns(goodsInfoTable);
        
        addButton = new JButton("����");
        addButton.setBounds(200, 325, 70, 30);
        deleteButton = new JButton("ɾ��");
        deleteButton.setBounds(295, 325, 70, 30);
        confirmButton = new JButton("ȷ��");
        confirmButton.setBounds(295, 360, 70, 30);
        cancleButton = new JButton("ȡ��");
        cancleButton.setBounds(210, 360, 70, 30);
        this.add(storeinIdLabel);
        this.add(storeinIdTextField);
        this.add(storeinDateLabel);
        this.add(datePickPanel);
        this.add(destinationLabel);
        this.add(destinationComboBox);
        this.add(goodsInfoLabel);       
        this.add(scrollpane);
        this.add(addButton);
        this.add(deleteButton);
        DialogLayoutManager.fix(scrollpane,addButton,deleteButton);        
        
        this.add(confirmButton);
        this.add(cancleButton);
        		
		
        Checker alarmNumChecker = new Checker(addButton, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				
				return new AlarmNum(tableModel.getRowCount());
			}
		});
        
        addButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				alarmNumChecker.check();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreinGoodsDialog(tableModel);
			}			
		});
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				  int selectedRow = goodsInfoTable.getSelectedRow();
	              if(selectedRow == -1){
	            	  ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
	            	  return;
	              }
	              
	              String orderId = (String) tableModel.getValueAt(selectedRow, 0);
	              int areaNum = Integer.parseInt((String)tableModel.getValueAt(selectedRow, 1));
	              int rowNum = Integer.parseInt((String)tableModel.getValueAt(selectedRow, 2));
	              int frameNum = Integer.parseInt((String)tableModel.getValueAt(selectedRow, 3));
	              int item = Integer.parseInt((String)tableModel.getValueAt(selectedRow, 4));
	              //StoreinOrderVO vo = new StoreinOrderVO(orderId, areaNum, rowNum, frameNum, item);
	              StorageLocationVO vo = new StorageLocationVO(LoginController.getOrganizationId(), areaNum, rowNum, frameNum, item, StorageState.ISAVAILABLE, orderId);
	              StoreinblService storeinblService = BusinessLogicService.getStoreinblService();
	              storeinblService.restoreLocationState(vo);   
	              tableModel.removeRow(selectedRow); 
			}
		});
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int totalRow = goodsInfoTable.getRowCount(); //��
				//int totalColumn = goodsInfoTable.getColumnCount();  //��
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
				
				
				Date inDate = datePickPanel.getDate();
				
				String destination = destinationComboBox.getItemAt(destinationComboBox.getSelectedIndex());
				if (orderId.size()!=0&&datePickPanel.check()) {
					StoreinCreateVO vo = new StoreinCreateVO(storeinIdTextField.getText(), orderId, inDate, 
							destination, areaNum, rowNum, frameNum, item, LoginController.getOrganizationName());
					StoreinblService storeinblService = BusinessLogicService.getStoreinblService();
					storeinblService.createStoreinPO(vo);	
					StoreinDialogUI.this.dispose();
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
				}
				else {
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_FAILURE);
				}
				
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int totalRow = goodsInfoTable.getRowCount(); //��
				//int totalColumn = goodsInfoTable.getColumnCount();  //��
				
				for(int i=0;i<totalRow;i++){
					  String orderId = (String) tableModel.getValueAt(i, 0);
		              int areaNum = Integer.parseInt((String)tableModel.getValueAt(i, 1));
		              int rowNum = Integer.parseInt((String)tableModel.getValueAt(i, 2));
		              int frameNum = Integer.parseInt((String)tableModel.getValueAt(i, 3));
		              int item = Integer.parseInt((String)tableModel.getValueAt(i, 4));
		              //StoreinOrderVO vo = new StoreinOrderVO(orderId, areaNum, rowNum, frameNum, item);
		              StorageLocationVO vo = new StorageLocationVO(LoginController.getOrganizationId(), areaNum, rowNum, frameNum, item, StorageState.ISAVAILABLE, orderId);
		              StoreinblService storeinblService = BusinessLogicService.getStoreinblService();
		              //�ı����λ��
		              storeinblService.restoreLocationState(vo); 
		              StoreinDialogUI.this.dispose();
		              
				}
			
			}
		});
		
		this.setLayout(new DialogLayoutManager());
		this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setResizable(false);
        this.setVisible(true);
	}
	
}
