package systemenum;
/**
 * �����Ŀ��ö����
 * @author ���¿�
 *
 */
public enum Entry {
      
	RENT("���"),
	FRIGHT("�˷�"),
	WAGES("��Ա����"),
	AWARDS("����");
	
	private String name;
	
	Entry(String s){
		this.name = s;
	}
	public String getName(){
		return name;
	}
}
