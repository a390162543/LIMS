package businesslogic.checkbl;

import systemenum.CheckResult;

/**
 * {@code CheckResultMessage}�Ǽ����Ʒ��صļ����Ϣ��
 * �����������������ϸ��
 * @author ���滪
 * @version 1.6
 * @see systemenum.CheckResult
 */
public class CheckResultMessage {
    
    /**
     * ���Ľ��
     */
    private CheckResult checkResult;
    
    /**
     * ������Ϣ����������Ϊ{@code WARNING}����Ҫ����Ϣ
     */
    private String warningInfo;
    
    /**
     * ������Ϣ����������Ϊ{@code FALSE}����Ҫ����Ϣ
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
     * ��ȡ�����Ϣ��html��ʽ�����ڽ�����ʾ
     * <p><strong>���ƣ�������֧��html�����������ʾ</Strong>
     * @return {@code checkInfo}��html��ʽ
     */
    public String getCheckInfo() {
        if(checkResult == CheckResult.CORRECT)
            return "<html><span style='color:#009900;'>�� ��ȷ</span></html>";
        else if(checkResult == CheckResult.FALSE){
            falseInfo.subSequence(0, falseInfo.length()-4);
            return "<html>"+falseInfo+"</html>";
        }else {
            warningInfo.subSequence(0, warningInfo.length()-4);
            return "<html>"+warningInfo+"</html>";
        }
    }
    
    /**
     * ��{@code CheckResultMessage}�����һ����Ϣ
     * @param checkResult �������ö�ٳ���
     * @param checkInfo ���ϸ����Ϣ
     */
    public void addInfo(CheckResult checkResult, String checkInfo){
        if(checkResult.getPriority()>this.checkResult.getPriority())
            this.checkResult = checkResult;
        if(checkResult == CheckResult.FALSE)
            this.falseInfo += "<span style='color:#E53333;'>"+"�� "+checkInfo+"</span><br>";
        else if(checkResult == CheckResult.WARNING)
            this.warningInfo += "<span style='color:#D9B300;'>"+"�� "+checkInfo+"</span><br>";
    }
    
}
