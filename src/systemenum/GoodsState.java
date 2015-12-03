package systemenum;

public enum GoodsState {
    
    COMPLETE("ÍêºÃ"),BROKEN("ÆÆËð"),LOST("¶ªÊ§");
    
    private String name;
    
    private GoodsState(String name) {
		this.name = name;
	}
    
    public String getName(){
    	return name;
    }
    
}
