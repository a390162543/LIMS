package systemenum;

/**
 * ��¼�������ö����
 * @author ���滪
 * @version 1.3
 * @see businesslogic.checkbl.CheckResultMessage
 */
public enum CheckResult {
    
    FALSE(3),CORRECT(1),WARNING(2),UNCHECKED(0);
    
    /**
     * ö�ٵ����ȼ�
     */
    private int priority;
    
    private CheckResult(int priority){
        this.priority = priority;
    }
    
    public int getPriority(){
        return priority;
    }
}
