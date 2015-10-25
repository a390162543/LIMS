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

public class ApprovalblService_Stub implements ApprovalblService{
	OrderPO orderpo;
	DeliverPO deliverpo;
	LoadPO loadpo;
	PaymentPO paymentpo;
	RevenuePO revenuepo;
	StoreinPO storeinpo;
	StoreoutPO storeoutpo;
	TransferPO transferpo;
	ArrivalPO arrivalpo;
	
	
	
	public ApprovalblService_Stub(OrderPO orderpo, DeliverPO deliverpo,
			LoadPO loadpo, PaymentPO paymentpo, RevenuePO revenuepo,
			StoreinPO storeinpo, StoreoutPO storeoutpo, TransferPO transferpo,
			ArrivalPO arrivalpo) {
		super();
		this.orderpo = orderpo;
		this.deliverpo = deliverpo;
		this.loadpo = loadpo;
		this.paymentpo = paymentpo;
		this.revenuepo = revenuepo;
		this.storeinpo = storeinpo;
		this.storeoutpo = storeoutpo;
		this.transferpo = transferpo;
		this.arrivalpo = arrivalpo;
	}
	 

	@Override
	public List<OrderPO> getOrderPO() {
		// TODO Auto-generated method stub
		List<OrderPO> o = new ArrayList<OrderPO>();
		o.add(orderpo);
		return o;
	}

	@Override
	public List<DeliverPO> getDeliverPO() {
		// TODO Auto-generated method stub
		List<DeliverPO> d = new ArrayList<DeliverPO>();
		d.add(deliverpo);
		return d;
	}

	@Override
	public List<LoadPO> getLoadPO() {
		// TODO Auto-generated method stub
		List<LoadPO> l = new ArrayList<LoadPO>();
		l.add(loadpo);
		return l;
	}

	@Override
	public List<PaymentPO> getPaymentPO() {
		// TODO Auto-generated method stub
		List<PaymentPO> o = new ArrayList<PaymentPO>();
		o.add(paymentpo);
		return o;
	}

	@Override
	public List<RevenuePO> getRevenuePO() {
		// TODO Auto-generated method stub
		List<RevenuePO> o = new ArrayList<RevenuePO>();
		o.add(revenuepo);
		return o;
	}

	@Override
	public List<StoreinPO> getStoreinPO() {
		// TODO Auto-generated method stub
		List<StoreinPO> o = new ArrayList<StoreinPO>();
		o.add(storeinpo);
		return o;
	}

	@Override
	public List<StoreoutPO> getStoreoutPO() {
		// TODO Auto-generated method stub
		List<StoreoutPO> o = new ArrayList<StoreoutPO>();
		o.add(storeoutpo);
		return o;
	}

	@Override
	public List<TransferPO> getTransferPO() {
		// TODO Auto-generated method stub
		List<TransferPO> o = new ArrayList<TransferPO>();
		o.add(transferpo);
		return o;
	}

	@Override
	public List<ArrivalPO> getArrivalPO() {
		// TODO Auto-generated method stub
		List<ArrivalPO> o = new ArrayList<ArrivalPO>();
		o.add(arrivalpo);
		return o;
		}




	@Override
	public boolean approve(Object o) {
		// TODO Auto-generated method stub
		return true;
	}




	@Override
	public boolean modify(Object o) {
		// TODO Auto-generated method stub
		return true;
	}
}
