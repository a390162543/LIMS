package presentation.managerui.organizationui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businesslogic.citybl.City;
import businesslogic.organizationbl.Organization;
import businesslogicservice.CityblService;
import businesslogicservice.OrganizationblService;
import vo.OrganizationVO;

public class OrganizationDialog extends JDialog{

 
	/**
	 * 
	 */
	private static final long serialVersionUID = 3380122615488984030L;

	private JLabel infoLabel;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel idLabel;
	private JTextField idField;
	private JLabel cityLabel;
	private JComboBox<String> cityBox;
	private JButton cancleButton;
	private JButton sureButton;
	private OrganizationTableModel tableModel;
	private CityblService cityblService;
	

	public OrganizationDialog(OrganizationTableModel tm){
		init();
		tableModel = tm;		
		cancleButton.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OrganizationDialog.this.dispose();
			}
		});
		
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 update(0,true);
				 OrganizationDialog.this.dispose();
			}
		});
	}
	
	public OrganizationDialog(OrganizationTableModel em, int modelRow,boolean isEdit){
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
					OrganizationDialog.this.dispose();
				}
			});
		}
		else{
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					update(modelRow,false);
					OrganizationDialog.this.dispose();
				}
			});
		}		
	}
	
	public void init(){		 
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
		 		
		this.setBounds(0, 0, 380, 300);
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
		
		this.add(infoLabel);
		this.add(nameLabel);
		this.add(nameField);
		this.add(cityLabel);
		this.add(cityBox);
		this.add(idLabel);
		this.add(idField);
		this.add(cancleButton);
		this.add(sureButton);
		
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public void update( int modelRow,boolean isNew){
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
