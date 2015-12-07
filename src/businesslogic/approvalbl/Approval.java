package businesslogic.approvalbl;

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
import businesslogic.arrivalbl.Arrival;
import businesslogic.deliverbl.Deliver;
import businesslogic.loadbl.Load;
import businesslogic.orderbl.Order;
import businesslogic.paymentbl.Payment;
import businesslogic.revenuebl.Revenue;
import businesslogic.storeinbl.Storein;
import businesslogic.storeoutbl.Storeout;
import businesslogic.transferbl.Transfer;
import businesslogicservice.ApprovalblService;
 
 
/**
 * {@code Approval}是审批单据业务逻辑层是实现类，所有有关审批
 * 单据的业务逻辑服务
 * @author 刘航伸
 *@version 1.6
 */
public class Approval implements ApprovalblService{

	private Order order;
	private Deliver deliver;
	private Load load;
	private Payment payment;
	private Revenue revenue;
	private Storein storein;
	private Storeout storeout;
	private Transfer transfer;
	private Arrival arrival;
	
	 public Approval() {
		// TODO Auto-generated constructor stub
		order = new Order();
		deliver = new Deliver();
		load = new Load();
		payment = new Payment();
		revenue = new Revenue();
		storein = new Storein();
		storeout  = new Storeout();
		transfer = new Transfer();
		arrival = new Arrival();
	}
	@Override
	public boolean approveOrderVO(OrderCreateVO vo) {
		// TODO Auto-generated method stub		
		order.execute(vo);
		return true;
	}

	@Override
	public boolean approveDeliverVO(DeliverVO vo) {
		// TODO Auto-generated method stub		 
		deliver.execute(vo);
		return true;
	}

	@Override
	public boolean approveLoadVO(LoadVO vo) {
		// TODO Auto-generated method stub
		load.execute(vo);
		return true;
	}

	@Override
	public boolean apprivePaymentVO(PaymentVO vo) {
		// TODO Auto-generated method stub
		payment.execute(vo);
		return true;
	}

	@Override
	public boolean approveRevenueVO(RevenueVO vo) {
		// TODO Auto-generated method stub		 
		revenue.execute(vo);
		return true;
	}

	@Override
	public boolean approveStoreinVO(StoreinCreateVO vo) {
		// TODO Auto-generated method stub
 		 storein.execute(vo);
		return true;
	}

	@Override
	public boolean approveStoreoutVO(StoreoutCreateVO vo) {
		// TODO Auto-generated method stub
		storeout.execute(vo);
		return true;
	}

	@Override
	public boolean approveTransferVO(TransferVO vo) {
		// TODO Auto-generated method stub
		transfer.execute(vo);
		return true;
	}

	@Override
	public boolean approveArrivalVO(ArrivalVO vo) {
		// TODO Auto-generated method stub
		arrival.execute(vo);
		return true;
	}

	@Override
	public boolean modifyOrderVO(OrderCreateVO vo) {
		// TODO Auto-generated method stub
 
		order.modifyOrder(vo);
		return true;
	}

	@Override
	public boolean modifyDeliverVO(DeliverVO vo) {
		// TODO Auto-generated method stub
	 
		deliver.modifyDeliverPO(vo);
		return true;
	}

	@Override
	public boolean modifyLoadVO(LoadVO vo) {
		// TODO Auto-generated method stub
	 
		load.modifyLoadPO(vo);
		return true;
	}

	@Override
	public boolean modifyPaymentVO(PaymentVO vo) {
		// TODO Auto-generated method stub
	 
		payment.modifyPaymentPO(vo);
		return true;
	}

	@Override
	public boolean modifyRevenueVO(RevenueVO vo) {
		// TODO Auto-generated method stub
	 
		revenue.modifyRevenuePO(vo);
		return true;
	}

	@Override
	public boolean modifyStoreinVO(StoreinCreateVO vo) {
		// TODO Auto-generated method stub
	 
		storein.modifyStorein(vo);
		return true;
	}

	@Override
	public boolean modifyStoreoutVO(StoreoutCreateVO vo) {
		// TODO Auto-generated method stub
	 
		storeout.modifyStoreout(vo);
		return true;
	}

	@Override
	public boolean modifyTransferVO(TransferVO vo) {
		// TODO Auto-generated method stub
	 
		transfer.modifyTransferPO(vo);
		return true;
	}

	@Override
	public boolean modifyArrivalVO(ArrivalVO vo) {
		// TODO Auto-generated method stub
	 
		arrival.modifyArrivalPO(vo);
		return true;
	}

	@Override
	public List<OrderCreateVO> getOrderVO() {
		// TODO Auto-generated method stub
		
		return order.getPendingOrderCreateVO();
	}

	@Override
	public List<DeliverVO> getDeliverVO() {
		// TODO Auto-generated method stub
		return deliver.getPendingDeliverVO();
	}

	@Override
	public List<LoadVO> getLoadVO() {
		// TODO Auto-generated method stub
		return load.getPendingLoadVO();
	}

	@Override
	public List<PaymentVO> getPaymentVO() {
		// TODO Auto-generated method stub
		return payment.getPendingPaymentVO();
	}

	@Override
	public List<RevenueVO> getRevenueVO() {
		// TODO Auto-generated method stub
		return revenue.getPendingRevenueVO();
	}

	@Override
	public List<StoreinCreateVO> getStoreinVO() {
		// TODO Auto-generated method stub
		return storein.getStoreinPendingVOs();
	}

	@Override
	public List<StoreoutCreateVO> getStoreoutVO() {
		// TODO Auto-generated method stub
		return storeout.getPendingStoreoutCreateVO();
	}

	@Override
	public List<TransferVO> getTransferVO() {
		// TODO Auto-generated method stub
		return transfer.getPendingTransferVO();
	}

	@Override
	public List<ArrivalVO> getArrivalVO() {
		// TODO Auto-generated method stub
		return arrival.getPendingArrivalVO();
	}

}
