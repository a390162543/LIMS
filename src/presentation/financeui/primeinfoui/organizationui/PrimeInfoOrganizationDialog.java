package presentation.financeui.primeinfoui.organizationui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import vo.OrganizationVO;
import businesslogic.citybl.City;
import businesslogic.organizationbl.Organization;
import businesslogicservice.CityblService;
import businesslogicservice.OrganizationblService;

public class PrimeInfoOrganizationDialog {
	private JDialog organizationDialog;
	private JLabel infoLabel;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel idLabel;
	private JTextField idField;
	private JLabel cityLabel;
	private JComboBox<String> cityBox;
	private JButton cancleButton;
	private JButton sureButton;
	private PrimeInfoOrganizationTableModel tableModel;
	private CityblService cityblService;
	
	public void init(){
		organizationDialog = new JDialog();
		cityblService = new City();
		List<String> cityList = cityblService.getAllName();
		String[] cityStr = cityList.toArray(new String[cityList.size()]);
		infoLabel = new JLabel();
		nameLabel = new JLabel();
		nameField = new JTextField();
		cityBox = new JComboBox<String>(cityStr);
		cityLabel = new JLabel();
		idField = new JTextField();
		idLabel = new JLabel();
		cancleButton = new JButton("取消");
		sureButton = new JButton("确定");
		 
		
		organizationDialog.setBounds(0, 0, 380, 300);
		infoLabel.setText("机构信息");
		infoLabel.setBounds(170, 15, 170, 35);
		nameLabel.setText("机构名称");
		nameLabel.setBounds(27, 65, 100, 20);
		nameField.setBounds(135, 65, 180, 20);
		cityLabel.setText("所在城市");
		cityLabel.setBounds(27, 100, 100, 20);
		cityBox.setBounds(137, 100, 60, 20);
		idLabel.setText("机构编号");
		idLabel.setBounds(27, 135, 100, 20);
		idField.setBounds(137, 135, 180, 20);		 
		cancleButton.setBounds(180, 185, 70, 30);
		sureButton.setBounds(270, 185, 70, 30);
		
		organizationDialog.add(infoLabel);
		organizationDialog.add(nameLabel);
		organizationDialog.add(nameField);
		organizationDialog.add(cityLabel);
		organizationDialog.add(cityBox);
		organizationDialog.add(idLabel);
		organizationDialog.add(idField);
		organizationDialog.add(cancleButton);
		organizationDialog.add(sureButton);		
		organizationDialog.setLayout(null);
		organizationDialog.setVisible(true);
	}
	
	public void showCreateDialog(PrimeInfoOrganizationTableModel tm){

		init();
		tableModel = tm;		
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
				 update(0, true);
				 organizationDialog.dispose();
			}
		});
	}
	public void showQueryDialog(PrimeInfoOrganizationTableModel em, int modelRow,boolean isEdit){

		init();
		this.tableModel = em;
		OrganizationVO vo = tableModel.getOrganizationVO(modelRow);
		nameField.setText(vo.getName());
		cityBox.setSelectedItem(vo.getCity());
		idField.setText(""+vo.getId());
		
		idField.setEnabled(false);
		if(!isEdit){
			nameField.setEnabled(false);
			cityBox.setEnabled(false);
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
	 
	
	public void update( int modelRow, boolean isNew){
		OrganizationblService organizationblService = new Organization();
		String name = nameField.getText();
		String city = (String) cityBox.getSelectedItem();
		String id = idField.getText();
		OrganizationVO vo= new OrganizationVO(id, name, city);
		organizationblService.CreatOrganizationPO(vo);	 
		if(isNew)
			tableModel.create(vo);
		else
			tableModel.modify(modelRow, vo);	 
	}
}
