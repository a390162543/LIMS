package systemenum;

public enum GoodsState {
    
    COMPLETE("���"),BROKEN("����"),LOST("��ʧ");
    
    private String name;
    
    private GoodsState(String name) {
		this.name = name;
	}
    
    public String getName(){
    	return name;
    }
    
}
