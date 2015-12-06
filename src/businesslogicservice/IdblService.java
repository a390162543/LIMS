package businesslogicservice;

/**
 * {@code IdblService}�ṩ��������ȡ�µı�ŵķ���
 * 
 * <p>�����ڽ���㴴���ĵ��ݡ���������Ա��������ҵ���߼��ӿڶ���Ҫ�ṩ��ȡ�ýӿ�ʵ�����
 * ʵ������ķ���
 * 
 * @author ���滪
 * @version 1.1
 */
public interface IdblService {
    
    /**
     * ��ȡһ���µ�{@code id}
     * 
     * @return �½���{@code id}
     */
    public String createNewId();
    
    /**
     * ���ݴ�����{@code tag}��ȡһ���µ�{@code id}
     * @param tag  ����ַ�����һ��Ϊ{@code id}���ɹ����ǰ���Զ�������
     * @return  �½���{@code id}
     */
    public String createNewId(String tag);
    
}
