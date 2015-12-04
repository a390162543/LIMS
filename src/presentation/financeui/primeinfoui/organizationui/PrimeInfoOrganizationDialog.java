package presentation.financeui.primeinfoui.organizationui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import businesslogicservice.IdblService;
import businesslogicservice.OrganizationblService;

public class PrimeInfoOrganizationDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3066428109151666735L;
	 
 
 
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
	private OrganizationblService organizationblService;
	
	public PrimeInfoOrganizationDialog(PrimeInfoOrganizationTableModel tm){
		init();
		tableModel = tm;	
		organizationblService = new Organization();
		cityBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub			
				setId(nameField.getText());
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrimeInfoOrganizationDialog.this.dispose();
			}
		});
		
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 update(0, true);
				 PrimeInfoOrganizationDialog.this.dispose();
			}
		});
	}
	public PrimeInfoOrganizationDialog(PrimeInfoOrganizationTableModel em, int modelRow,boolean isEdit){

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
					PrimeInfoOrganizationDialog.this.dispose();
				}
			});
		}
		else{
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					update(modelRow,false);
					PrimeInfoOrganizationDialog.this.dispose();
				}
			});
		}					
	}
	public void setId(String organizationName){
		String cityId = cityblService.getId
				((String)cityBox.getSelectedItem());
		if(organizationName.contains("中转中心")){
			IdblService idblService = organizationblService.getIdblService(1);
			idField.setText(idblService.createNewId(cityId));
		}
		else if(organizationName.contains("营业厅")){
			IdblService idblService = organizationblService.getIdblService(3);
			idField.setText(idblService.createNewId(cityId));
		}
		else{
			IdblService idblService = organizationblService.getIdblService();
			idField.setText(idblService.createNewId());
		}
		
	}
	public void init(){		 
		cityblService = new City();
		List<String> cityList = cityblService.getAllName();
		String[] cityStr = cityList.toArray(new String[cityList.size()]);
		 
		nameLabel = new JLabel();
		nameField = new JTextField();
		cityBox = new JComboBox<String>(cityStr);
		cityLabel = new JLabel();
		idField = new JTextField();
		idLabel = new JLabel();
		cancleButton = new JButton("取消");
		sureButton = new JButton("确定");
		 
		
		this.setBounds(0, 0, 380, 300);
		 
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
