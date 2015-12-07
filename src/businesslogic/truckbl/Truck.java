package businesslogic.truckbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.TruckPO;
import vo.TruckVO;
import businesslogic.idbl.IdManager;
import businesslogicservice.IdblService;
import businesslogicservice.TruckblService;
import dataservice.TruckDataService;

/**
 * {@code Truck}是车辆业务逻辑的实现类，提供所有有关车辆的业务逻辑服务
 * @author 林祖华
 * @version 1.6
 * @see dataservice.TruckDataService
 */
public class Truck implements TruckblService{
    
    /**
     * {@code Truck}的数据层服务引用
     */
    private TruckDataService truckDataService;
    
    public Truck(){
        try {
            truckDataService = (TruckDataService) Naming.lookup("rmi://localhost/TruckData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean createTruckPO(TruckVO vo) {
        try {
            truckDataService.insert(vo.getTruckPO());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteTruckPO(TruckVO vo) {
        try {
            truckDataService.delete(vo.getTruckPO());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean modifyTruckPO(TruckVO vo) {
        TruckPO po;
        try {
            po = truckDataService.find(vo.getId());
            po.update(vo);
            truckDataService.update(po);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<TruckVO> getTruckVO() {
        List<TruckVO> vos = new ArrayList<TruckVO>();
        List<TruckPO> pos;
        try {
            pos = truckDataService.getAll();
            for(TruckPO po : pos){
                vos.add(po.getTruckVO());
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return vos;
    }
    
    @Override
    public List<TruckVO> getTruckVO(String organization) {
        List<TruckVO> vos = new ArrayList<TruckVO>();
        List<TruckPO> pos;
        try {
            pos = truckDataService.finds("organization", organization);
            for(TruckPO po : pos){
                vos.add(po.getTruckVO());
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return vos;
    }
    
    /**
     * 记录车辆信息
     * @param vo 需要记录的{@code TruckVO}
     * @return 成功则返回{@code true}，否则返回{@code false}
     */
    public boolean execute(TruckVO vo){
        return createTruckPO(vo);
    }
    
    /**
     * 根据{@code id}标识返回一个{@code TruckVO}
     * @param id 需要查找的{@code TruckVO}的{@code id}标识
     * @return 对应的{@code TruckVO}，如果查找失败或不存在，则返回{@code null}
     */
    public TruckVO getTruckVOById(String id){
        try {
            TruckPO po = truckDataService.find(id);
            if(po != null)
                return po.getTruckVO();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public IdblService getIdblService() {
        return new IdManager(truckDataService, 3, false);
    }
}
