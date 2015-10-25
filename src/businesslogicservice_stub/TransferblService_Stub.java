package businesslogicservice_stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.IOP.TransactionService;

import po.TransferPO;
import systemenum.DocumentState;
import vo.TransferVO;
import businesslogicservice.TransferblService;

public class TransferblService_Stub implements TransferblService{
	 long id;
	 Date loadDate;
	 long flightNumbe;
	  String depart;
	  String destination;
	  long containerId;
	  String loadMan;
	  List<Long> orderId;
	  double expenses;
	  DocumentState documentState;
	  
	  
	public TransferblService_Stub(long id, Date loadDate, long flightNumbe,
			String depart, String destination, long containerId,
			String loadMan, List<Long> orderId, 
			double expenses,DocumentState documentState) {
		super();
		this.id = id;
		this.loadDate = loadDate;
		this.flightNumbe = flightNumbe;
		this.depart = depart;
		this.destination = destination;
		this.containerId = containerId;
		this.loadMan = loadMan;
		this.orderId = orderId;
		this.expenses = expenses;
		this.documentState = documentState;
	}

	@Override
	public TransferPO createTransferPO(TransferVO vo) {
		// TODO Auto-generated method stub
		return new TransferPO(id,loadDate,flightNumbe,depart,destination,
				containerId,loadMan,orderId,expenses );
	}

	@Override
	public double getCost(TransferVO vo) {
		// TODO Auto-generated method stub
		return expenses;
	}

	@Override
	public List<TransferVO> getTransferPO() {
		// TODO Auto-generated method stub
		 List<TransferVO> transfervo= new ArrayList<TransferVO>();
		 transfervo.add(new TransferVO(id,loadDate,flightNumbe,depart,destination,
				containerId,loadMan,orderId,expenses));
		return transfervo;
	}

	@Override
	public boolean execute(TransferVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean modify(TransferVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

}
