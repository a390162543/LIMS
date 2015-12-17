package businesslogicservice;

import java.util.List;
import vo.UserVO;

/**
 * {@code ArrivalblService}�ṩ��������û������ҵ���߼�����
 * @author ������
 * @version 1.4
 */
public interface UserblService {
	 
	/**
	 * ��ѯ�û��ʺź������Ƿ���ȷ
	 * 
	 * @param id, ���洫�������û��ʺ�
	 * @param password, ���洫����������
	 * @return �û��ʺź����� ��ȷ
	 */
	public boolean queryUserPO(String id,String passWord);
	
	/**
	 * ��ʼ���û�����
	 * @param id
	 * @return �ɹ���ʼ������{@code true}, ���򷵻�{@code false}
	 */
	public boolean initialize(String id);
	/**
	 * �޸��û�Ȩ��
	 * @param vo, ����㴫������{@code UserVO}
	 * @return �ɹ��޸ķ���{@code true}, ���򷵻�{@code false}
	 */
	public boolean modifyPower(UserVO vo);
	
	/**
	 * �޸��û�����
	 * @param vo, ����㴫������{@code UserVO}
	 * @return �ɹ��޸ķ���{@code true}, ���򷵻�{@code false}
	 */
	public boolean modifyPassword(String id, String password);
	 /**
	  * ��ȡ�����û���Ϣ
	  * @return ����һ��{@code List<UserVO>}������� �����ڣ��򷵻�{@code null}
	  */
	public List<UserVO> getUserVO();
	/**
     * ����{@code id}��ȡһ��{@code UserVO}����
     * 
     * @param id {@code UserVO}��{@code id}��ʶ
     * @return ����һ��{@code UserVO}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     */
	public UserVO find(String id);
}
