package businesslogic.checkbl;

/**
 * {@code CheckInfo}是检查机制中待检查项的抽象接口，
 *所有的待检查项需要实现此接口
 * @author 林祖华
 * @version 1.0
 * @see CheckResultMessage
 */
public interface CheckInfo {
    
    public CheckResultMessage check();
    
}
