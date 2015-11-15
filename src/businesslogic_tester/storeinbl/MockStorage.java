package businesslogicservice_tester.storeinbl;

import businesslogic.storagebl.Storage;

public class MockStorage extends Storage{

	double alarm;
	int allCapacity;	
	int nowCapacity;
	
	public MockStorage(double alarm,int allCapacity,int nowCapacity){
		this.alarm = alarm;
		this.allCapacity = allCapacity;
		this.nowCapacity =nowCapacity;		
	}
	
	public boolean isExceeded(){
		return ((double)nowCapacity/allCapacity)>alarm;
	}
	
}
