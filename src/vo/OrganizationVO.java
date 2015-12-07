package vo;

 
import po.OrganizationPO;

/**
 * {@code OrganizationPO}是员工业务逻辑层与界面层之间传递的对象，
 * 记录了机构的所有信息
 * @author 刘航伸
 */
public class OrganizationVO {
	private String id;
	private String name;
	private String city;
	 
	public OrganizationVO(String id, String name, String city){
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public String getIdString(){
		return String.format("%09d", id);
	}
	public OrganizationPO getOrganizationPO(){
		return new OrganizationPO(id, name, city);
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
