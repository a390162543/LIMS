package businesslogic.checkbl;

import systemenum.CheckResult;

public class CheckResultMessage {
    
    private CheckResult checkResult;
    
    private String warningInfo;
    private String falseInfo;
    
    public CheckResultMessage(){
        this.checkResult = CheckResult.CORRECT;
        this.warningInfo = "";
        this.falseInfo = "";
    }
    
    public CheckResult getCheckResult() {
        return checkResult;
    }

    public String getCheckInfo() {
        if(checkResult == CheckResult.CORRECT)
            return "<html><span style='color:#009900;'>¡ñ ÕýÈ·</span></html>";
        else if(checkResult == CheckResult.FALSE){
            falseInfo.subSequence(0, falseInfo.length()-4);
            return "<html>"+falseInfo+"</html>";
        }else {
            warningInfo.subSequence(0, warningInfo.length()-4);
            return "<html>"+warningInfo+"</html>";
        }
    }
    
    public void addInfo(CheckResult checkResult, String checkInfo){
        if(checkResult.getPriority()>this.checkResult.getPriority())
            this.checkResult = checkResult;
        if(checkResult == CheckResult.FALSE)
            this.falseInfo += "<span style='color:#E53333;'>"+"¡ñ "+checkInfo+"</span><br>";
        else if(checkResult == CheckResult.WARNING)
            this.warningInfo += "<span style='color:#FFE500;'>"+"¡ñ "+checkInfo+"</span><br>";
    }
    
}
