package businesslogicservice;

import systemenum.DocumentState;

public abstract class LogisticsDocument {
    
    protected DocumentState documentState = DocumentState.EDITING;
    
    public abstract void execute();

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }
    
    
}
