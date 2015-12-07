package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

import po.StorageLocationPO;
import po.StoragePO;
import dataservice.StorageLocationDataService;
import systemenum.StorageState;
import vo.StorageLocationVO;



/**
 * 实现StorageLocationDataService相应的方法，提供对库存位置数据的操作
 * @author lc
 * @version 1.4
 *
 */

public class StorageLocationData extends UnicastRemoteObject implements StorageLocationDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6122172600015206412L;

	protected StorageLocationData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean initLocationInfo(String storageId, int airNum, int carNum, int trainNum, int freeNum) {
		
		String path = "c:/LIMS/database/LocationData/"+storageId+".txt";
		File file = new File(path);
		if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			for (int j = 0; j < airNum; j++) {
				for (int m = 0; m < 10; m++) {
					for (int n = 0; n < 100; n++) {
						String info = String.format("%02d", 0)+String.format("%02d", j)+String.format("%02d", m)
								+String.format("%02d", n)+StorageState.ISAVAILABLE.toString()+"   "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+storageId;
						try {
							writer.write(info);
							
							writer.newLine();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			for (int j = airNum; j < 20; j++) {
				for (int m = 0; m < 10; m++) {
					for (int n = 0; n < 100; n++) {
						String info = String.format("%02d", 0)+String.format("%02d", j)+String.format("%02d", m)
								+String.format("%02d", n)+StorageState.FORBIDDEN.toString()+"   "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+storageId;
						try {
							writer.write(info);
							
							writer.newLine();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			for (int j = 0; j < trainNum; j++) {
				for (int m = 0; m < 10; m++) {
					for (int n = 0; n < 100; n++) {
						String info = String.format("%02d", 1)+String.format("%02d", j)+String.format("%02d", m)
								+String.format("%02d", n)+StorageState.ISAVAILABLE.toString()+"   "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+storageId;
						
						try {
							writer.write(info);
						
							writer.newLine();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			for (int j = trainNum; j < 20; j++) {
				for (int m = 0; m < 10; m++) {
					for (int n = 0; n < 100; n++) {
						String info = String.format("%02d", 1)+String.format("%02d", j)+String.format("%02d", m)
								+String.format("%02d", n)+StorageState.FORBIDDEN.toString()+"   "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+storageId;
						
						try {
							writer.write(info);
							writer.newLine();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			for (int j = 0; j < carNum; j++) {
				for (int m = 0; m < 10; m++) {
					for (int n = 0; n < 100; n++) {
						String info = String.format("%02d", 2)+String.format("%02d", j)+String.format("%02d", m)
								+String.format("%02d", n)+StorageState.ISAVAILABLE.toString()+"   "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+storageId;
						
						try {
							writer.write(info);
							writer.newLine();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			for (int j = carNum; j < 20; j++) {
				for (int m = 0; m < 10; m++) {
					for (int n = 0; n < 100; n++) {
						String info = String.format("%02d", 2)+String.format("%02d", j)+String.format("%02d", m)
								+String.format("%02d", n)+StorageState.FORBIDDEN.toString()+"   "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+storageId;
						
						try {
							writer.write(info);
							writer.newLine();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			for (int j = 0; j < freeNum; j++) {
				for (int m = 0; m < 10; m++) {
					for (int n = 0; n < 100; n++) {
						String info = String.format("%02d", 3)+String.format("%02d", j)+String.format("%02d", m)
								+String.format("%02d", n)+StorageState.ISAVAILABLE.toString()+"   "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+storageId;
						
						try {
							writer.write(info);
							writer.newLine();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			for (int j = freeNum; j < 20; j++) {
				for (int m = 0; m < 10; m++) {
					for (int n = 0; n < 100; n++) {
						String info = String.format("%02d", 3)+String.format("%02d", j)+String.format("%02d", m)
								+String.format("%02d", n)+StorageState.FORBIDDEN.toString()+"   "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+storageId;
						
						try {
							writer.write(info);
							writer.newLine();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			try {
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

		return true;
	}

	@Override
	public boolean update(StorageLocationPO po) throws RemoteException {
		String path = "c:/LIMS/database/LocationData/"+po.getStorageId()+".txt";
		@SuppressWarnings("unused")
		File file = new File(path);
		StorageData storageData = new StorageData();
		@SuppressWarnings("unused")
		StoragePO storagePO = storageData.find(po.getStorageId());
		int areaNum = po.getAreaNum();
		int rowNum = po.getRowNum();
		int frameNum = po.getFrameNum();
		int item = po.getItem();
		long checkline = 0;
		switch (areaNum) {
		case 0:
			checkline = rowNum*1000+frameNum*100+item;
			break;
		case 1:
			checkline = 20*1000+rowNum*1000+frameNum*100+item;
			break;
		case 2:
			checkline = 40*1000+rowNum*1000+frameNum*100+item;
			break;
		case 3:
			checkline = 60*10000+rowNum*1000+frameNum*100+item;
			break;
		default:
			break;
		}
		try {
			@SuppressWarnings("resource")
			RandomAccessFile randomAccessFile = new RandomAccessFile(path,"rw");
			randomAccessFile.seek(38*checkline);
			randomAccessFile.skipBytes(0);
			randomAccessFile.writeBytes(po.getStorageLocationInfo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public StorageState getLocationState(StorageLocationVO vo)
			throws RemoteException {
		String info = "";
		String path = "c:/LIMS/database/LocationData/"+vo.getStorageId()+".txt";
		File file = new File(path);
		InputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		StorageData storageData = new StorageData();
		@SuppressWarnings("unused")
		StoragePO storagePO = storageData.find(vo.getStorageId());
		int areaNum = vo.getAreaNum();
		int rowNum = vo.getRowNum();
		int frameNum = vo.getFrameNum();
		int item = vo.getItem();
		long checkline = 0;
		switch (areaNum) {
		case 0:
			checkline = rowNum*1000+frameNum*100+item;
			break;
		case 1:
			checkline = 20*1000+rowNum*1000+frameNum*100+item;
			break;
		case 2:
			checkline = 40*1000+rowNum*1000+frameNum*100+item;
			break;
		case 3:
			checkline = 60*10000+rowNum*1000+frameNum*100+item;
			break;
		default:
			break;
		}
		try {
			reader.skip(38*checkline);
			info = reader.readLine();
			System.out.println(info);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new StorageLocationPO(info).getState();
	}

	@Override
	public void init() throws RemoteException {
		StorageLocationDataService storageLocationDataService = new StorageLocationData();
		try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception e) {			
		}
		try {
			Naming.rebind("rmi://localhost/LocationData", storageLocationDataService);
		} catch (MalformedURLException e) {
			
		}
		
	}
	
	

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean changeLocationInfo(StoragePO orginalPO,StoragePO updatePO) throws RemoteException {
		String path = "c:/LIMS/database/LocationData/"+orginalPO.getStorageId()+".txt";
		@SuppressWarnings("unused")
		File file = new File(path);
		
		int orginalAirNum = orginalPO.getAirCapacity();
		int orginalTrainNum = orginalPO.getTrainCapacity();
		int orginalCarNum = orginalPO.getCarCapacity();
		int orginalFreeNum = orginalPO.getMotorCapacity();
		
		int updateAirNum = updatePO.getAirCapacity();
		int updateTrainNum = updatePO.getTrainCapacity();
		int updateCarNum = updatePO.getCarCapacity();
		int updateFreeNum = updatePO.getMotorCapacity();
		System.out.println(orginalAirNum);
		System.out.println(updateAirNum);
		long checkLine = 0;
		int changeRow = 0;
		//容量减少
		System.out.println(System.currentTimeMillis());
		for (int j = 0; j < 4; j++) {
			switch (j) {
			case 0:
				checkLine = updateAirNum * 1000;
				changeRow = orginalAirNum - updateAirNum;
				break;
			case 1:
				checkLine = (updateTrainNum + 20) * 1000;
				changeRow = orginalTrainNum - updateTrainNum;
				break;
			case 2:
				checkLine = (updateCarNum + 40) * 1000;
				changeRow = orginalCarNum - updateCarNum;
				break;
			case 3:
				checkLine = (updateFreeNum + 60) * 1000;
				changeRow = orginalFreeNum - updateFreeNum;
				break;
			}
			System.out.println(changeRow);
				for (int i = 0; i < changeRow*1000; i++) {
					try {
						@SuppressWarnings("resource")
						RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
						randomAccessFile.seek(38 * checkLine);
						randomAccessFile.skipBytes(8);
						randomAccessFile.writeBytes(StorageState.FORBIDDEN.toString());
						checkLine++;
				
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
		}	
		//容量增加
		for (int j = 0; j < 4; j++) {
			switch (j) {
			case 0:
				checkLine = orginalAirNum * 1000;
				changeRow = updateAirNum - orginalAirNum;
				break;
			case 1:
				checkLine = (orginalTrainNum + 20) * 1000;
				changeRow = updateTrainNum - orginalFreeNum;
				break;
			case 2:
				checkLine = (orginalCarNum + 40) * 1000;
				changeRow = updateCarNum - orginalCarNum;
				break;
			case 3:
				checkLine = (orginalFreeNum + 60) * 1000;
				changeRow = updateFreeNum - orginalFreeNum;
				break;
			}
	
			for (int i = 0; i < changeRow*1000; i++) {
				try {
					
					@SuppressWarnings("resource")
					RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
					randomAccessFile.seek(38 * checkLine);
					randomAccessFile.skipBytes(8);
					randomAccessFile.writeBytes(StorageState.FORBIDDEN.toString());
					checkLine++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(System.currentTimeMillis());
		return true;
	}

	@Override
	public int getMaxAir(String storageId) throws RemoteException {
		
		int maxRow = 0;
		String path = "c:/LIMS/database/LocationData/"+storageId+".txt";
		File file = new File(path);
		InputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		String info = "";
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				for (int j2 = 0; j2 < 100; j2++) {
					try {
						
						info = reader.readLine();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (info.indexOf(StorageState.ISSTORED.toString())!=-1||info.indexOf(StorageState.ISSTORING.toString())!=-1) {
						
						maxRow = j;
					}
				}
			}
		}

		return maxRow;
	}

	@Override
	public int getMaxTrain(String storageId) throws RemoteException {
		
		int maxRow = 0;
		String path = "c:/LIMS/database/LocationData/"+storageId+".txt";
		File file = new File(path);
		InputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		String info = "";
		try {
			reader.skip(38*20000);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				for (int j2 = 0; j2 < 100; j2++) {
					try {							
						info = reader.readLine();						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (info.indexOf(StorageState.ISSTORED.toString())!=-1||info.indexOf(StorageState.ISSTORING.toString())!=-1) {
						
						maxRow = j;
					}
				}
			}
		}

		return maxRow;
	}

	@Override
	public int getMaxCar(String storageId) throws RemoteException {
		int maxRow = 0;
		String path = "c:/LIMS/database/LocationData/"+storageId+".txt";
		File file = new File(path);
		InputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		String info = "";
		try {
			reader.skip(38*40000);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				for (int j2 = 0; j2 < 100; j2++) {
					try {							
						info = reader.readLine();						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (info.indexOf(StorageState.ISSTORED.toString())!=-1||info.indexOf(StorageState.ISSTORING.toString())!=-1) {
						
						maxRow = j;
					}
				}
			}
		}

		return maxRow;
	}

	@Override
	public int getMaxFree(String storageId) throws RemoteException {
		int maxRow = 0;
		String path = "c:/LIMS/database/LocationData/"+storageId+".txt";
		File file = new File(path);
		InputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		String info = "";
		try {
			reader.skip(38*60000);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				for (int j2 = 0; j2 < 100; j2++) {
					try {							
						info = reader.readLine();						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (info.indexOf(StorageState.ISSTORED.toString())!=-1||info.indexOf(StorageState.ISSTORING.toString())!=-1) {
						
						maxRow = j;
					}
				}
			}
		}

		return maxRow;
	}

}
