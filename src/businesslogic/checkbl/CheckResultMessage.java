package businesslogic.checkbl;

import systemenum.CheckResult;

/**
 * {@code CheckResultMessage}是检查机制返回的检查信息，
 * 包括检查结果与检查结果的细节
 * @author 林祖华
 * @version 1.6
 * @see systemenum.CheckResult
 */
public class CheckResultMessage {
    
    /**
     * 检查的结果
     */
    private CheckResult checkResult;
    
    /**
     * 警告信息，如果检查结果为{@code WARNING}则需要此信息
     */
    private String warningInfo;
    
    /**
     * 错误信息，如果检查结果为{@code FALSE}则需要此信息
     */
    private String falseInfo;
    
    public CheckResultMessage(){
        this.checkResult = CheckResult.CORRECT;
        this.warningInfo = "";
        this.falseInfo = "";
    }
    
    public CheckResult getCheckResult() {
        return checkResult;
    }

    /**
     * 获取检查信息的html格式，用于界面显示
     * <p><strong>限制：仅限于支持html的组件进行显示</Strong>
     * @return {@code checkInfo}的html形式
     */
    public String getCheckInfo() {
        if(checkResult == CheckResult.CORRECT)
            return "<html><span style='color:#009900;'>● 正确</span></html>";
        else if(checkResult == CheckResult.FALSE){
            falseInfo.subSequence(0, falseInfo.length()-4);
            return "<html>"+falseInfo+"</html>";
        }else {
            warningInfo.subSequence(0, warningInfo.length()-4);
            return "<html>"+warningInfo+"</html>";
        }
    }
    
    /**
     * 在{@code CheckResultMessage}中添加一则信息
     * @param checkResult 检查结果的枚举常量
     * @param checkInfo 检查细节信息
     */
    public void addInfo(CheckResult checkResult, String checkInfo){
        if(checkResult.getPriority()>this.checkResult.getPriority())
            this.checkResult = checkResult;
        if(checkResult == CheckResult.FALSE)
            this.falseInfo += "<span style='color:#E53333;'>"+"● "+checkInfo+"</span><br>";
        else if(checkResult == CheckResult.WARNING)
            this.warningInfo += "<span style='color:#D9B300;'>"+"● "+checkInfo+"</span><br>";
    }
    
}
