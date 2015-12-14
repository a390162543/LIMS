package businesslogicservice;

import java.util.List;
import java.util.Date;

import vo.LogVO;

/**
 * {@code LogblService}�ṩ���������Ҫ������¼�����ҵ���߼�����
 * @author ���¿�
 * @version 1.4
 */
public interface LogblService {
    /**
     * ��������¼��־��Ϣ
     * @param vo ����㴫����{@code LogVO}
     * @return �ɹ������򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean createLogPO (String operation);
	
    /**
     * �������ڲ�ѯ��ȡ��Ӧ����־��Ϣ
     * @param date ����㴫����{@code Date}
     * @return {@code LogVO}���б����û����־��Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
	public List<LogVO>  queryLogVO (Date date);
	
    /**
     * ��ȡ��һ��־����ľ�����Ϣ
     * @param vo ����㴫����{@code LogVO}
     * @return {@code String}�����û���˻���Ϣ���ȡʧ�ܣ��򷵻ؿ��ַ���
     */
	public String getLogInfo(LogVO vo);
}
