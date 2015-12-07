package systemenum;

/**
 * 记录检查结果的枚举类
 * @author 林祖华
 * @version 1.3
 * @see businesslogic.checkbl.CheckResultMessage
 */
public enum CheckResult {
    
    FALSE(3),CORRECT(1),WARNING(2),UNCHECKED(0);
    
    /**
     * 枚举的优先级
     */
    private int priority;
    
    private CheckResult(int priority){
        this.priority = priority;
    }
    
    public int getPriority(){
        return priority;
    }
}
