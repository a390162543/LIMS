package businesslogicservice;

import systemenum.DocumentState;

public abstract class LogisticsDocument {
    
    protected DocumentState documentState = DocumentState.Editing;
    
    public abstract void execute();

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }
    
    
}
