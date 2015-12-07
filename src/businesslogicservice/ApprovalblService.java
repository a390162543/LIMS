package businesslogicservice;

import java.util.List;
import vo.ArrivalVO;
import vo.DeliverVO;
import vo.LoadVO;
import vo.OrderCreateVO;
import vo.PaymentVO;
import vo.RevenueVO;
import vo.StoreinCreateVO;
import vo.StoreoutCreateVO;
import vo.TransferVO;

/**
 * {@code ApprovalbiService}�ṩ��������ؽ��洦���ҵ���߼�����
 * @author ������
 * @version 1.4
 */
public interface ApprovalblService {
	
	/**
	 * ��������
	 * @param vo, ����㴫������{@code OrderCreateVO}
	 * @return �ɹ���������true, ���򷵻�false
	 */
	public boolean approveOrderVO(OrderCreateVO vo);
	
	/**
	 * �������ﵥ
	 * @param vo, ����㴫������{@code DeliverVO}
	 * @return �ɹ���������true, ���򷵻�false
	 */
	public boolean approveDeliverVO(DeliverVO vo);
	
	/**
	 * ����װ����
	 * @param vo, ����㴫������{@code LoadVO}
	 * @return �ɹ���������true, ���򷵻�false
	 */
	public boolean approveLoadVO(LoadVO vo);
	
	/**
	 * �������
	 * @param vo, ����㴫������{@code PaymentVO}
	 * @return �ɹ���������true, ���򷵻�false
	 */	 
	public boolean apprivePaymentVO(PaymentVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code RevenueVO}
	 * @return �ɹ���������true, ���򷵻�false
	 */
	public boolean approveRevenueVO(RevenueVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code StoreinVO}
	 * @return �ɹ���������true, ���򷵻�false
	 */
	public boolean approveStoreinVO(StoreinCreateVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code StoreoutVO}
	 * @return �ɹ���������true, ���򷵻�false
	 */
	public boolean approveStoreoutVO(StoreoutCreateVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code TransferVO}
	 * @return �ɹ���������true, ���򷵻�false
	 */
	public boolean approveTransferVO(TransferVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code ArrivalVO}
	 * @return �ɹ���������true, ���򷵻�false
	 */
	public boolean approveArrivalVO(ArrivalVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code OrderVO}
	 * @return �ɹ��޸ķ���true, ���򷵻�false
	 */
	public boolean modifyOrderVO(OrderCreateVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code DeliverVO}
	 * @return �ɹ��޸ķ���true, ���򷵻�false
	 */
	public boolean modifyDeliverVO(DeliverVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code LoadVO}
	 * @return �ɹ��޸ķ���true, ���򷵻�false
	 */
	public boolean modifyLoadVO(LoadVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code PaymentVO}
	 * @return �ɹ��޸ķ���true, ���򷵻�false
	 */
	public boolean modifyPaymentVO(PaymentVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code RevenueVO}
	 * @return �ɹ��޸ķ���true, ���򷵻�false
	 */
	public boolean modifyRevenueVO(RevenueVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code StoreinVO}
	 * @return �ɹ��޸ķ���true, ���򷵻�false
	 */
	public boolean modifyStoreinVO(StoreinCreateVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code StoreoutVO}
	 * @return �ɹ��޸ķ���true, ���򷵻�false
	 */
	public boolean modifyStoreoutVO(StoreoutCreateVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code TransferVO}
	 * @return �ɹ��޸ķ���true, ���򷵻�false
	 */
	public boolean modifyTransferVO(TransferVO vo);
	
	/**
	 * 
	 * @param vo, ����㴫������{@code ArrivalVO}
	 * @return �ɹ��޸ķ���true, ���򷵻�false
	 */
	public boolean modifyArrivalVO(ArrivalVO vo);
	
	/**��ȡδ�����Ķ���
	 * 
	 * @return {@code List<OrderCreateVO>}
	 */
	public List<OrderCreateVO>  getOrderVO();
	
	/**
	 * ��ȡδ�������ɼ���
	 * @return {@code List<DeliverVO>}
	 */
	public List<DeliverVO>  getDeliverVO();
	
	/**
	 * ��ȡδ������װ����
	 * @return {@code List<LoadVO>}
	 */
	public List<LoadVO>  getLoadVO();
	
	/**
	 * ��ȡδ�����ĸ��
	 * @return {@code List<PaymentVO> }
	 */
	public List<PaymentVO>  getPaymentVO();
	
	/**
	 * ��ȡδ�������տ
	 * @return {@code List<RevenueVO>}
	 */
	public List<RevenueVO>  getRevenueVO();
	
	/**
	 * ��ȡδ��������ⵥ
	 * @return {@code List<StoreinCreateVO>}
	 */
	public List<StoreinCreateVO>  getStoreinVO();
	
	/**
	 * ��ȡδ�����ĳ��ⵥ
	 * @return {@code List<StoreoutCreateVO>}
	 */
	public List<StoreoutCreateVO>  getStoreoutVO();
	
	/**
	 * ��ȡδ������װ����
	 * @return {@code List<TransferVO>}
	 */
	public List<TransferVO>  getTransferVO();
	
	/**
	 * ��ȡδ�����ĵ��ﵥ
	 * @return {@code List<ArrivalVO>}
	 */
	public List<ArrivalVO>  getArrivalVO();
}
