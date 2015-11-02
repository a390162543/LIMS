package businesslogicservice_stub;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.ApprovalblService;
 
import po.ArrivalPO;
import po.DeliverPO;
import po.LoadPO;
import po.OrderPO;
import po.PaymentPO;
import po.RevenuePO;
import po.StoreinPO;
import po.StoreoutPO;
import po.TransferPO;
import vo.ArrivalVO;
import vo.DeliverVO;
import vo.LoadVO;
import vo.OrderCreateVO;
import vo.PaymentVO;
import vo.RevenueVO;
import vo.StoreinCreateVO;
import vo.StoreoutCreateVO;
import vo.TransferVO;

public class ApprovalblService_Stub implements ApprovalblService{
	OrderCreateVO ordercreatevo;
	DeliverVO delivervo;
	LoadVO loadVo;
	PaymentVO paymentVo;
	RevenueVO revenueVo;
	StoreinCreateVO storeinVo;
	StoreoutCreateVO storeoutVo;
	TransferVO transferVo;
	ArrivalVO arrivalVo;
	
	
	
	public ApprovalblService_Stub(OrderCreateVO ordervo, DeliverVO delivervo,
			LoadVO loadvo, PaymentVO paymentvo, RevenueVO revenuevo,
			StoreinCreateVO storeinvo, StoreoutCreateVO storeoutvo, TransferVO transfervo,
			ArrivalVO arrivalvo) {
		super();
		this.ordercreatevo = ordervo;
		this.delivervo = delivervo;
		this.loadVo = loadvo;
		this.paymentVo = paymentvo;
		this.revenueVo = revenuevo;
		this.storeinVo = storeinvo;
		this.storeoutVo = storeoutvo;
		this.transferVo = transfervo;
		this.arrivalVo = arrivalvo;
	}
	 

	@Override
	public List<OrderCreateVO> getOrderVO() {
		// TODO Auto-generated method stub
		List<OrderCreateVO> o = new ArrayList<OrderCreateVO>();
		o.add(ordercreatevo);
		return o;
	}

	@Override
	public List<DeliverVO> getDeliverVO() {
		// TODO Auto-generated method stub
		List<DeliverVO> d = new ArrayList<DeliverVO>();
		d.add(delivervo);
		return d;
	}

	@Override
	public List<LoadVO> getLoadVO() {
		// TODO Auto-generated method stub
		List<LoadVO> l = new ArrayList<LoadVO>();
		l.add(loadVo);
		return l;
	}

	@Override
	public List<PaymentVO> getPaymentVO() {
		// TODO Auto-generated method stub
		List<PaymentVO> o = new ArrayList<PaymentVO>();
		o.add(paymentVo);
		return o;
	}

	@Override
	public List<RevenueVO> getRevenueVO() {
		// TODO Auto-generated method stub
		List<RevenueVO> o = new ArrayList<RevenueVO>();
		o.add(revenueVo);
		return o;
	}

	@Override
	public List<StoreinCreateVO> getStoreinVO() {
		// TODO Auto-generated method stub
		List<StoreinCreateVO> o = new ArrayList<StoreinCreateVO>();
		o.add(storeinVo);
		return o;
	}

	@Override
	public List<StoreoutCreateVO> getStoreoutVO() {
		// TODO Auto-generated method stub
		List<StoreoutCreateVO> o = new ArrayList<StoreoutCreateVO>();
		o.add(storeoutVo);
		return o;
	}

	@Override
	public List<TransferVO> getTransferVO() {
		// TODO Auto-generated method stub
		List<TransferVO> o = new ArrayList<TransferVO>();
		o.add(transferVo);
		return o;
	}

	@Override
	public List<ArrivalVO> getArrivalVO() {
		// TODO Auto-generated method stub
		List<ArrivalVO> o = new ArrayList<ArrivalVO>();
		o.add(arrivalVo);
		return o;
		}


	@Override
	public boolean approve(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean modify(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}

 