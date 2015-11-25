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
 

public class Approval implements ApprovalblService{

	@Override
	public boolean approveOrderVO(OrderCreateVO vo) {
		// TODO Auto-generated method stub
		Order o = new Order();
		o.execute(vo);
		return true;
	}

	@Override
	public boolean approveDeliverVO(DeliverVO vo) {
		// TODO Auto-generated method stub
		Deliver d= new Deliver();
		d.execute(vo);
		return true;
	}

	@Override
	public boolean approveLoadVO(LoadVO vo) {
		// TODO Auto-generated method stub
		Load l = new Load();
		l.execute(vo);
		return true;
	}

	@Override
	public boolean apprivePaymentVO(PaymentVO vo) {
		// TODO Auto-generated method stub
		Payment p = new Payment();
		p.execute(vo);
		return true;
	}

	@Override
	public boolean approveRevenueVO(RevenueVO vo) {
		// TODO Auto-generated method stub
		Revenue r = new Revenue();
		r.execute(vo);
		return true;
	}

	@Override
	public boolean approveStoreinVO(StoreinCreateVO vo) {
		// TODO Auto-generated method stub
		Storein s = new Storein();
		s.excute(vo);
		return true;
	}

	@Override
	public boolean approveStoreoutVO(StoreoutCreateVO vo) {
		// TODO Auto-generated method stub
		
		Storeout s = new Storeout();
		s.excute(vo);
		return true;
	}

	@Override
	public boolean approveTransferVO(TransferVO vo) {
		// TODO Auto-generated method stub
		Transfer t = new Transfer();
		t.execute(vo);
		return true;
	}

	@Override
	public boolean approveArrivalVO(ArrivalVO vo) {
		// TODO Auto-generated method stub
		Arrival a = new Arrival();
		a.execute(vo);
		return true;
	}

	@Override
	public boolean modifyOrderVO(OrderCreateVO vo) {
		// TODO Auto-generated method stub
		Order o = new Order();
		o.modifyOrder(vo);
		return true;
	}

	@Override
	public boolean modifyDeliverVO(DeliverVO vo) {
		// TODO Auto-generated method stub
		Deliver d = new Deliver();
		d.modifyDeliverPO(vo);
		return true;
	}

	@Override
	public boolean modifyLoadVO(LoadVO vo) {
		// TODO Auto-generated method stub
		Load l = new Load();
		l.modifyLoadPO(vo);
		return true;
	}

	@Override
	public boolean modifyPaymentVO(PaymentVO vo) {
		// TODO Auto-generated method stub
		Payment p = new Payment();
		p.modifyPaymentPO(vo);
		return true;
	}

	@Override
	public boolean modifyRevenueVO(RevenueVO vo) {
		// TODO Auto-generated method stub
		Revenue r = new Revenue();
		r.modifyRevenuePO(vo);
		return true;
	}

	@Override
	public boolean modifyStoreinVO(StoreinCreateVO vo) {
		// TODO Auto-generated method stub
		Storein s = new Storein();
		s.modifyStorein(vo);
		return true;
	}

	@Override
	public boolean modifyStoreoutVO(StoreoutCreateVO vo) {
		// TODO Auto-generated method stub
		Storeout s = new Storeout();
		s.modifyStoreout(vo);
		return true;
	}

	@Override
	public boolean modifyTransferVO(TransferVO vo) {
		// TODO Auto-generated method stub
		Transfer t = new Transfer();
		t.modifyTransferPO(vo);
		return true;
	}

	@Override
	public boolean modifyArrivalVO(ArrivalVO vo) {
		// TODO Auto-generated method stub
		Arrival a = new Arrival();
		a.modifyArrivalPO(vo);
		return true;
	}

	@Override
	public List<OrderCreateVO> getOrderVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeliverVO> getDeliverVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoadVO> getLoadVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentVO> getPaymentVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RevenueVO> getRevenueVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreinCreateVO> getStoreinVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreoutCreateVO> getStoreoutVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferVO> getTransferVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArrivalVO> getArrivalVO() {
		// TODO Auto-generated method stub
		return null;
	}

}
