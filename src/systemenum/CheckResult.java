package systemenum;

public enum CheckResult {
    
    FALSE(3),CORRECT(1),WARNING(2),UNCHECKED(0);
    
    private int priority;
    
    private CheckResult(int priority){
        this.priority = priority;
    }
    
    public int getPriority(){
        return priority;
    }
}
