package presentation.storageui.storagecheckui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import presentation.mainui.MainFrame;
import presentation.storageui.storagecheckui.storeincheckui.StoreinCheckPanel;
import presentation.storageui.storagecheckui.storeoutcheckui.StoreoutCheckPanel;
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DatePickPanel;
import vo.StoreinCheckVo;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.storageinfo.FromDate;
import businesslogic.checkbl.storageinfo.ToDate;
import businesslogic.storagebl.Storage;
import businesslogicservice.StorageblService;

/**
 * 点击库存查看后显示的选择日期的界面
 * @author lc
 * @version 1.4
 *
 */
public class StorageCheckDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7642441651445021545L;


	private JLabel checkDateLabel;
	private JTabbedPane fatherPanel;
	
	
	private JButton confirmButton;
	private JButton cancleButton;
	
	private DatePickPanel fromDatePickPanel;
	private DatePickPanel toDatePickPanel;
	
	public StorageCheckDialog(JTabbedPane panel){
		fatherPanel = panel;

		this.setTitle("库存查看");
		this.setSize(340, 240);
		this.setLayout(null);

		checkDateLabel = new JLabel("请输入要查询的时间段：");
		checkDateLabel.setBounds(35, 30, 220, 22);
		fromDatePickPanel = new DatePickPanel();
		toDatePickPanel = new DatePickPanel();
		fromDatePickPanel.setBounds(60, 70, 200, 25);
		toDatePickPanel.setBounds(60, 102, 200, 25);

		confirmButton = new JButton("确定");
		confirmButton.setBounds(250, 150, 70, 30);
		
		cancleButton = new JButton("取消");
		cancleButton.setBounds(160, 150, 70, 30);
		
		this.add(cancleButton);
		this.add(confirmButton);
		this.add(checkDateLabel);
		this.add(fromDatePickPanel);
		this.add(toDatePickPanel);
		
		
		
		Checker fromDateChecker = new Checker(fromDatePickPanel, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				Date fromDate = fromDatePickPanel.getDate();
				Date toDate = toDatePickPanel.getDate();
				return new FromDate(fromDate, toDate);
			}
		});
		
		Checker toDateChecker = new Checker(toDatePickPanel, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				Date froDate = fromDatePickPanel.getDate();
				Date toDate = toDatePickPanel.getDate();
				return new ToDate(froDate,toDate);
			}
		});
		
		fromDatePickPanel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				fromDateChecker.check();
				toDateChecker.check();
				
			}
		});
		
		
		toDatePickPanel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fromDateChecker.check();
				toDateChecker.check();
				
			}
		});
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fromDateChecker.check();
				toDateChecker.check();
				if (fromDateChecker.isCorrect()&&toDateChecker.isCorrect()) {
					StorageCheckDialog.this.dispose();
					Date fromDate = fromDatePickPanel.getDate();
					Date toDate = toDatePickPanel.getDate();
					StoreinCheckVo storeinCheckVo = new StoreinCheckVo("date",
							fromDate, toDate);
					StorageblService storageblService = new Storage();
					storageblService.storeoutCheck(storeinCheckVo);
					storageblService.storeinCheck(storeinCheckVo);
					StoreinCheckPanel storeinCheckPanel = new StoreinCheckPanel(
							storageblService.storeinCheck(storeinCheckVo));
					StoreoutCheckPanel storeoutCheckPanel = new StoreoutCheckPanel(
							storageblService.storeoutCheck(storeinCheckVo));
					// fatherPanel.setLayout(null);
					storeinCheckPanel.setBounds(0, 0, 645, 250);
					storeoutCheckPanel.setBounds(0, 250, 645, 250);
					JPanel combPanel = new JPanel();
					combPanel.setLayout(null);
					combPanel.setBounds(0, 0, 645, 500);
					combPanel.add(storeinCheckPanel);
					combPanel.add(storeoutCheckPanel);
					fatherPanel.setComponentAt(3, combPanel);
					fatherPanel.repaint();
				}
				

			}
		});

		

		this.setLocationRelativeTo(MainFrame.getMainFrame());
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setResizable(false);
		this.setVisible(true);

	}
}
