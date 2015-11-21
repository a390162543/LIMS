package po;

import java.io.Serializable;

import vo.OrganizationVO;

public class OrganizationPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8270746515695155791L;
	private String id;
	private String name;
	private String city;
	
	
	public OrganizationPO(String id, String name, String city){
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public String getIdString(){
		return String.format("%09d", id);
	}
	public OrganizationVO getOrganizationVO(){
		return new OrganizationVO(id, name, city);
	}

	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	
}
