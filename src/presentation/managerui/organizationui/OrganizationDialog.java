package presentation.managerui.organizationui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import businesslogic.organizationbl.Organization;
import businesslogicservice.OrganizationblService;
import vo.OrganizationVO;

public class OrganizationDialog {
	private JDialog organizationDialog;
	private JLabel infoLabel;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel idLabel;
	private JTextField idField;
	private JLabel cityLabel;
	private JTextField cityField;
	private JButton cancleButton;
	private JButton sureButton;
	private OrganizationTableModel tableModel;
	
	public void init(){
		organizationDialog = new JDialog();
		infoLabel = new JLabel();
		nameLabel = new JLabel();
		nameField = new JTextField();
		cityField = new JTextField();
		cityLabel = new JLabel();
		idField = new JTextField();
		idLabel = new JLabel();
		cancleButton = new JButton("取消");
		sureButton = new JButton("确定");
		
		organizationDialog.setBounds(0, 0, 380, 240);
		infoLabel.setText("机构信息");
		infoLabel.setBounds(170, 15, 170, 35);
		nameLabel.setText("机构名称");
		nameLabel.setBounds(27, 65, 100, 20);
		nameField.setBounds(135, 65, 180, 20);
		cityLabel.setText("所在城市");
		cityLabel.setBounds(27, 100, 100, 20);
		cityField.setBounds(137, 100, 60, 20);
		idLabel.setText("机构编号");
		idLabel.setBounds(27, 135, 100, 20);
		idField.setBounds(137, 135, 180, 20);
		idField.setEnabled(false);
		cancleButton.setBounds(180, 185, 70, 30);
		sureButton.setBounds(270, 185, 70, 30);
		
		organizationDialog.add(infoLabel);
		organizationDialog.add(nameLabel);
		organizationDialog.add(nameField);
		organizationDialog.add(cityLabel);
		organizationDialog.add(cityField);
		organizationDialog.add(idLabel);
		organizationDialog.add(idField);
		organizationDialog.add(cancleButton);
		organizationDialog.add(sureButton);
		
		organizationDialog.setLayout(null);
		organizationDialog.setVisible(true);
	}
	
	public void showCreateDialog(OrganizationTableModel tm){

		init();
		tableModel = tm;
		idField.setVisible(false);
		idLabel.setVisible(false);
		
		cancleButton.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				organizationDialog.dispose();
			}
		});
		
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 update(0,true);
			}
		});
	}
	
	public void showQueryDialog(OrganizationTableModel em, int modelRow,boolean isEdit){

		init();
		this.tableModel = em;
		OrganizationVO vo = tableModel.getOrganizationVO(modelRow);
		nameField.setText(vo.getName());
		cityField.setText(vo.getCity());
		idField.setText(""+vo.getId());
		if(!isEdit){
			nameField.setEnabled(false);
			cityField.setEnabled(false);
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					organizationDialog.dispose();
				}
			});
		}
		else{
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					update(modelRow,false);
					organizationDialog.dispose();
				}
			});
		}
			
		
	}
	
	public void update( int modelRow,boolean isNew){
		OrganizationblService organizationblService = new Organization();
		String name = nameField.getText();
		String city = cityField.getText();
		String id;
		if(isNew)
			id = "001";
		else 
			id = new String(idField.getText());
		OrganizationVO vo= new OrganizationVO(id, name, city);
		organizationblService.CreatOrganizationPO(vo);
		if(isNew)
			tableModel.create(vo);
		else
			tableModel.modify(modelRow, vo);
	}
	
}
