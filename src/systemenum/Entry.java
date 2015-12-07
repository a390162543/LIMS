package systemenum;
/**
 * 付款单条目的枚举类
 * @author 刘德宽
 *
 */
public enum Entry {
      
	RENT("租金"),
	FRIGHT("运费"),
	WAGES("人员工资"),
	AWARDS("奖励");
	
	private String name;
	
	Entry(String s){
		this.name = s;
	}
	public String getName(){
		return name;
	}
}
