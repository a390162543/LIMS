package presentation.financeui.statisticsui;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.util.PresentationUtil;
import businesslogic.BusinessLogicService;
import businesslogicservice.StatisticsblService;
import vo.PaymentVO;
/**
 * {@code PaymentPanel}继承{@code JPanel}，是已通过审批的付款单的界面层面板展示
 * @author 刘德宽
 *
 */
public class PaymentPanel extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4715941556745053343L;
	
	private JScrollPane paymentScrollPane;
	
	private JTable paymentTable;
    private PaymentTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;
    private List<PaymentVO> paymentVOs;
    public PaymentPanel(List<PaymentVO> vos){
    	paymentVOs = vos;
    	tableModel = new PaymentTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        paymentTable = new JTable(tableModel);
        paymentTable.setSize(930, 160);
      
        paymentScrollPane = new JScrollPane(paymentTable);
        paymentScrollPane.setBounds(0,0,560,160);
        paymentTable.setRowSorter(tableSorter);
		PresentationUtil.fitTableColumns(paymentTable);
        this.setBounds(0, 0, 560 , 160 );
        this.setLayout(null);
        this.add(paymentScrollPane);    
    }
    
    public Double getTotalExpenditure(){
    	StatisticsblService sbs = BusinessLogicService.getStatisticsblService(); 	
    	return sbs.getTotalExpenditure(paymentVOs);
    }
    
    public JTable getTable(){
    	return paymentTable;
    }
}
