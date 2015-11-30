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
import dataservice.StorageDataService;
import dataservice.StorageLocationDataService;
import systemenum.StorageState;
import vo.StorageLocationVO;

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
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			for (int j = 0; j < airNum; j++) {
				for (int m = 0; m < 100; m++) {
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
			for (int j = airNum; j < 100; j++) {
				for (int m = 0; m < 100; m++) {
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
				for (int m = 0; m < 100; m++) {
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
			for (int j = trainNum; j < 100; j++) {
				for (int m = 0; m < 100; m++) {
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
				for (int m = 0; m < 100; m++) {
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
			for (int j = carNum; j < 100; j++) {
				for (int m = 0; m < 100; m++) {
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
				for (int m = 0; m < 100; m++) {
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
			for (int j = freeNum; j < 100; j++) {
				for (int m = 0; m < 100; m++) {
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
		File file = new File(path);
		StorageData storageData = new StorageData();
		StoragePO storagePO = storageData.find(po.getStorageId());
		int areaNum = po.getAreaNum();
		int rowNum = po.getRowNum();
		int frameNum = po.getFrameNum();
		int item = po.getItem();
		long checkline = 0;
		switch (areaNum) {
		case 0:
			checkline = rowNum*10000+frameNum*100+item;
			break;
		case 1:
			checkline = 100*10000+rowNum*10000+frameNum*100+item;
			break;
		case 2:
			checkline = 200*10000+rowNum*10000+frameNum*100+item;
			break;
		case 3:
			checkline = 300*10000+rowNum*10000+frameNum*100+item;
			break;
		default:
			break;
		}
		try {
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
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		StorageData storageData = new StorageData();
		StoragePO storagePO = storageData.find(vo.getStorageId());
		int areaNum = vo.getAreaNum();
		int rowNum = vo.getRowNum();
		int frameNum = vo.getFrameNum();
		int item = vo.getItem();
		long checkline = 0;
		switch (areaNum) {
		case 0:
			checkline = rowNum*10000+frameNum*100+item;
			break;
		case 1:
			checkline = 100*10000+rowNum*10000+frameNum*100+item;
			break;
		case 2:
			checkline = 200*10000+rowNum*10000+frameNum*100+item;
			break;
		case 3:
			checkline = 300*10000+rowNum*10000+frameNum*100+item;
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
		File file = new File(path);
		
		int orginalAirNum = orginalPO.getAirCapacity();
		int orginalTrainNum = orginalPO.getTrainCapacity();
		int orginalCarNum = orginalPO.getCarCapacity();
		int orginalFreeNum = orginalPO.getMotorCapacity();
		
		int updateAirNum = updatePO.getAirCapacity();
		int updateTrainNum = updatePO.getTrainCapacity();
		int updateCarNum = updatePO.getCarCapacity();
		int updateFreeNum = updatePO.getMotorCapacity();
		
		
		
		return false;
	}

}