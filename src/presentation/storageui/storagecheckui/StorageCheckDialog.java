package presentation.storageui.storagecheckui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.storageui.storagecheckui.storeincheckui.StoreinCheckPanel;
import presentation.storageui.storagecheckui.storeoutcheckui.StoreoutCheckPanel;
import vo.StoreinCheckVo;
import businesslogic.storagebl.Storage;
import businesslogicservice.StorageblService;

public class StorageCheckDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7642441651445021545L;


	private JLabel checkDateLabel;
	private JPanel fatherPanel;
	
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel fromDayLabel;
	private JLabel toDayLabel;
	private JLabel dotLabel;
	
	private JComboBox<String> yearComboBox;
	private JComboBox<String> monthComboBox;
	private JComboBox<String> fromDayComboBox;
	private JComboBox<String> toDayComboBox;
	
	private JButton confirmButton;
	
	private String[] year = {"2015","2016","2017","2018","2019","2010"};
	private String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    private String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
    		"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	
	public StorageCheckDialog(JPanel panel){
		fatherPanel = panel;
		init();
	}
	
	public void init(){
		this.setTitle("库存查看");	
		this.setSize(380, 240);
		this.setLayout(null);
		
		checkDateLabel = new JLabel("请输入要查询的时间段：");
		checkDateLabel.setBounds(80, 40, 220, 22);
		yearComboBox = new JComboBox<String>(year);
		yearComboBox.setBounds(20, 82, 80, 22);
		yearLabel = new JLabel("年");
		yearLabel.setBounds(100, 82, 20, 22);
		monthComboBox = new JComboBox<String>(month);
		monthComboBox.setBounds(130, 82, 40, 22);
		monthLabel = new JLabel("月");
		monthLabel.setBounds(175, 82, 20, 22);
		fromDayComboBox = new JComboBox<String>(day);
		fromDayComboBox.setBounds(200, 82, 40, 22);
		fromDayLabel = new JLabel("日");
		fromDayLabel.setBounds(240, 82, 20, 22);
		dotLabel = new JLabel("——");
		dotLabel.setBounds(265, 83, 40, 22);
		toDayComboBox = new JComboBox<String>(day);
		toDayComboBox.setBounds(305, 82, 40, 22);
		toDayLabel = new JLabel("日");
		toDayLabel.setBounds(345, 82, 20, 22);
		
		confirmButton = new JButton("确定");
		confirmButton.setBounds(270, 150, 70, 30);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int yearDate = Integer.parseInt(year[yearComboBox.getSelectedIndex()]);
				int monthDate = Integer.parseInt(month[monthComboBox.getSelectedIndex()]);
				int fromDay = Integer.parseInt(day[fromDayComboBox.getSelectedIndex()]);
				int toDay = Integer.parseInt(day[toDayComboBox.getSelectedIndex()]);
				
				@SuppressWarnings("deprecation")
				Date fromDate = new Date(yearDate-1900, monthDate-1, fromDay);
				@SuppressWarnings("deprecation")
				Date toDate = new Date(yearDate-1900, monthDate-1, toDay);
				StoreinCheckVo storeinCheckVo = new StoreinCheckVo("date", fromDate, toDate);
				
				StorageblService storageblService = new Storage();
				storageblService.storeoutCheck(storeinCheckVo);
				storageblService.storeinCheck(storeinCheckVo);	
				StoreinCheckPanel storeinCheckPanel = new StoreinCheckPanel(storageblService.storeinCheck(storeinCheckVo));
				StoreoutCheckPanel storeoutCheckPanel = new StoreoutCheckPanel(storageblService.storeoutCheck(storeinCheckVo));
				fatherPanel.setLayout(null);
				storeinCheckPanel.setBounds(0, 10, 560, 300);
				storeoutCheckPanel.setBounds(0, 200, 560, 250);
				fatherPanel.add(storeinCheckPanel);
				fatherPanel.add(storeoutCheckPanel);
								
			}
		});
		
		this.add(confirmButton);
		this.add(checkDateLabel);
		this.add(yearComboBox);
		this.add(yearLabel);
		this.add(monthComboBox);
		this.add(monthLabel);
		this.add(fromDayComboBox);
		this.add(fromDayLabel);
		this.add(dotLabel);
		this.add(toDayComboBox);
		this.add(toDayLabel);
		
		 this.setLocationRelativeTo(null);
	     this.setResizable(false);
	     this.setVisible(true);
		
	}
}
