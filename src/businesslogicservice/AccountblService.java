package businesslogicservice;

import java.util.List;

import vo.AccountVO;

/**
 * {@code AccountblService}�ṩ��������˻������ҵ���߼�����
 * @author ���¿�
 * @version 1.4
 */
public interface AccountblService {
    /**
     * ��������¼�˻���Ϣ
     * @param vo ����㴫����{@code AccountVO}
     * @return �ɹ������򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean createAccountPO(AccountVO vo);
	
    /**
     * ɾ���˻���Ϣ
     * @param vo ����㴫����{@code AccountVO}
     * @return �ɹ�ɾ���򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean deleteAccountPO(AccountVO vo);
	
    /**
     * �޸��˻���Ϣ
     * @param vo ����㴫����{@code AccountVO}
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean modifyAccountPO(AccountVO vo);
	
    /**
     * ��ȡ���е��˻���Ϣ
     * @return {@code AccountVO}���б����û���˻���Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
	public List<AccountVO> getAccountVO();

}
