package presentation.util;

import java.util.ArrayList;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

 

import businesslogic.organizationbl.Organization;
import businesslogicservice.OrganizationblService;

public class OrganizationComboBox extends JComboBox<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2948672356782782855L;
	private OrganizationblService organizationblService;
	public OrganizationComboBox(){
		organizationblService = new Organization();
		List<String> nameList = organizationblService.getAllOrganizationName();
		String[] organizationStr = nameList.toArray(new String[nameList.size()]);
		ComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(organizationStr);
		this.removeItem("×Ü²¿");
		this.setModel(comboBoxModel);
		this.setSize(180, 20);
	}
	
	public OrganizationComboBox(String s){
		organizationblService = new Organization();
		List<String> nameList = organizationblService.getAllOrganizationName();
		List<String> list = new ArrayList<String>();
		for(String str : nameList){
			if(str.contains(s))
				list.add(str);
		}

		
		String[] organizationStr = list.toArray(new String[list.size()]);
		ComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(organizationStr);
		this.setModel(comboBoxModel);
		this.setSize(180, 20);
	}
	
	public OrganizationComboBox(boolean s){
		organizationblService = new Organization();
		List<String> nameList = organizationblService.getAllOrganizationName();
		String[] organizationStr = nameList.toArray(new String[nameList.size()]);
		ComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(organizationStr);
		this.setModel(comboBoxModel);
		this.setSize(180, 20);
	}
	public String getSelectedOrganization(){
	    return (String)getSelectedItem();
	}
}
