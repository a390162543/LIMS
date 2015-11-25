package businesslogic.storagebl;

import java.io.Serializable;
import java.util.Date;

import systemenum.StorageState;

public class StorageHelper implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2724272598818684539L;
	
	private Date operation;
	private StorageState state;
	
	public StorageHelper() {
		
	}
	
	public StorageHelper(Date operation, StorageState state) {
		super();
		this.operation = operation;
		this.state = state;
	}

	public Date getOperation() {
		return operation;
	}

	public void setOperation(Date operation) {
		this.operation = operation;
	}

	public StorageState getState() {
		return state;
	}

	public void setState(StorageState state) {
		this.state = state;
	}
	
	

}
