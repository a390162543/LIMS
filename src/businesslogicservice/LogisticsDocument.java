package businesslogicservice;

import systemenum.DocumentState;

public interface LogisticsDocument {
    
    public DocumentState documentState = DocumentState.Editing;
    
    public void execute();
}
