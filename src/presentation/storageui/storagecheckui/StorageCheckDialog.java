package presentation.storageui.storagecheckui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.storageui.storagecheckui.storeincheckui.StoreinCheckPanel;
import presentation.storageui.storagecheckui.storeoutcheckui.StoreoutCheckPanel;
import presentation.util.RecentDatePickPanel;
import vo.StoreinCheckVo;
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
	private JPanel fatherPanel;
	
	
	private JButton confirmButton;
	
	private RecentDatePickPanel fromDatePickPanel;
	private RecentDatePickPanel toDatePickPanel;
	
	public StorageCheckDialog(JPanel panel){
		fatherPanel = panel;

		this.setTitle("库存查看");
		this.setSize(380, 240);
		this.setLayout(null);

		checkDateLabel = new JLabel("请输入要查询的时间段：");
		checkDateLabel.setBounds(80, 40, 220, 22);
		fromDatePickPanel = new RecentDatePickPanel();
		toDatePickPanel = new RecentDatePickPanel();
		fromDatePickPanel.setBounds(80, 80, 200, 22);
		toDatePickPanel.setBounds(80, 112, 200, 22);

		confirmButton = new JButton("确定");
		confirmButton.setBounds(270, 150, 70, 30);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

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
				fatherPanel.setLayout(null);
				storeinCheckPanel.setBounds(0, 10, 560, 300);
				storeoutCheckPanel.setBounds(0, 200, 560, 250);
				fatherPanel.add(storeinCheckPanel);
				fatherPanel.add(storeoutCheckPanel);

			}
		});

		this.add(confirmButton);
		this.add(checkDateLabel);
		this.add(fromDatePickPanel);
		this.add(toDatePickPanel);

		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

	}
}
