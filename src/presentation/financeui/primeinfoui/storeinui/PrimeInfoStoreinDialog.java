package presentation.financeui.primeinfoui.storeinui;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import presentation.storageui.storeinui.StoreinGoodsDialog;

import vo.StoreinCreateVO;

public class PrimeInfoStoreinDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1952513564210206454L;

	private PrimeInfoStoreinTableModel primeInfoStoreinTableModel;
	
	private JLabel storeinDateLabel;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private JComboBox<String> yearComboBox;
	private JComboBox<String> monthComboBox;
	private JComboBox<String> dayComboBox;
	
	private JLabel destinationLabel;
	private JComboBox<String> destinationComboBox;
	private JLabel goodsInfoLabel;
	private JTable goodsInfoTable;
	
	private JButton addButton;
	private JButton deleteButton;
	private JButton confirmButton;
	private JButton cancleButton;
	
	private String[] year = {"2015","2016","2017","2018","2019","2010"};
    private String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    private String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
    		"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String[] column = {"订单号","区号","排号","架号","位号"};
    private DefaultTableModel tableModel = new DefaultTableModel(null, column);
    private String[] totalDestination = {"北京中转中心","上海中转中心","南京中转中心"};

	public PrimeInfoStoreinDialog(PrimeInfoStoreinTableModel tm){
		primeInfoStoreinTableModel = tm;
		init();
		buttonFunction();
	}

	public void init(){
		this.setTitle("库存期初建账");	
		this.setSize(380, 440);
		this.setLayout(null);
			
		storeinDateLabel = new JLabel("日期");
		storeinDateLabel.setBounds(20, 64, 80, 22);
		       
        yearComboBox = new JComboBox<String>(year);
        yearComboBox.setBounds(110, 62, 70, 25);
        yearComboBox.setEditable(false);
        monthComboBox = new JComboBox<String>(month);
        monthComboBox.setBounds(200, 60, 50, 25);
        monthComboBox.setEditable(false);
        dayComboBox = new JComboBox<String>(day);
        dayComboBox.setBounds(270, 60, 50, 25);
        dayComboBox.setEditable(false);
        yearLabel = new JLabel("年");
        yearLabel.setBounds(180, 62, 20, 22);
        monthLabel = new JLabel("月");
        monthLabel.setBounds(250, 62, 20, 22);
        dayLabel = new JLabel("日");
        dayLabel.setBounds(320, 60, 20, 22);
        destinationLabel = new JLabel("机构名");
        destinationLabel.setBounds(28, 90, 60, 22);
        destinationComboBox = new JComboBox<String>(totalDestination);
        destinationComboBox.setBounds(110, 92, 180, 22);
        goodsInfoLabel = new JLabel("货物信息");
        goodsInfoLabel.setBounds(2, 125, 80, 22);
        
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
        this.add(cancleButton);
        this.add(confirmButton);
        this.add(deleteButton);
        this.add(addButton);
        this.add(scrollpane);
        this.add(goodsInfoLabel);
        this.add(destinationComboBox);
        this.add(destinationLabel);
        this.add(yearLabel);
        this.add(monthLabel);
        this.add(dayLabel);
        this.add(dayComboBox);
        this.add(monthComboBox);
        this.add(yearComboBox);
        this.add(dayComboBox);
        this.add(monthComboBox);
        this.add(yearComboBox);
		this.add(storeinDateLabel);
		
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
	}
	
	public void buttonFunction(){
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
	              if(selectedRow == -1)
	            	  return;

	              tableModel.removeRow(selectedRow); 
			}
		});
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int totalRow = goodsInfoTable.getRowCount(); //行
				//int totalColumn = goodsInfoTable.getColumnCount();  //列
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
				
				
				int yearDate = Integer.parseInt(year[yearComboBox.getSelectedIndex()]);
				int monthDate = Integer.parseInt(month[monthComboBox.getSelectedIndex()]);
				int dayDate = Integer.parseInt(day[dayComboBox.getSelectedIndex()]);
				@SuppressWarnings("deprecation")
				Date inDate = new Date(yearDate-1900, monthDate-1, dayDate);
				String organization = totalDestination[destinationComboBox.getSelectedIndex()];
				StoreinCreateVO vo = new StoreinCreateVO(new String("2015112000000001"), orderId, inDate, areaNum, rowNum, frameNum, item, organization);
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
	

}
