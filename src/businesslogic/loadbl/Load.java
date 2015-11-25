package businesslogic.loadbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.LoadPO;
import systemenum.DocumentState;
import dataservice.LoadDataService;
import vo.LoadVO;
import businesslogicservice.LoadblService;

public class Load implements LoadblService{

    private LoadDataService loadDataService;
    
    public Load(){
        try {
            loadDataService = (LoadDataService) Naming.lookup("rmi://localhost/LoadData");
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
    public boolean createLoadPO(LoadVO vo) {
        try {
            loadDataService.insert(vo.getLoadPO());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean modifyLoadPO(LoadVO vo) {
        LoadPO po;
        try {
            po = loadDataService.find(vo.getId());
            po.update(vo);
            loadDataService.update(po);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean addGoods(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteGoods(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public double getCost(LoadVO vo) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean execute(LoadVO vo) {
        // TODO Auto-generated method stub
        return false;
    }

    public List<LoadVO> getPendingLoadVO(){
        List<LoadPO> pos = null;
        List<LoadVO> vos = new ArrayList<LoadVO>();
        try {
            pos = loadDataService.finds("documentState", DocumentState.PENDING);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(LoadPO po:pos){
            vos.add(po.getLoadVO());
        }
        return vos;
    }

}
