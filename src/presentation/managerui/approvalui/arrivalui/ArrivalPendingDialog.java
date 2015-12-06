package presentation.managerui.approvalui.arrivalui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.arrivalinfo.ArrivalTransferId;
import businesslogic.userbl.LoginController;
import businesslogicservice.ArrivalblService;
import systemenum.GoodsState;
import vo.ArrivalVO;
import vo.LoadVO;
import vo.TransferVO;

public class ArrivalPendingDialog extends JDialog {
	
	/**
     * 
     */
    private static final long serialVersionUID = 4875938402353589894L;

    private static final String[] LABEL_NAMES = {"到达单编号","中转单编号","出发地","到达地","到达日期","到达状况"};
    
    private ArrivalPendingTableModel tableModel;
    private JTextField[] textFields;
      
    public ArrivalPendingDialog(ArrivalPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[6];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        textFields = new JTextField[2];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            textFields[i].setEnabled(false);
            this.add(textFields[i]);
        }
        
        OrganizationComboBox departComboBox = new OrganizationComboBox();
        departComboBox.setEnabled(false);
        departComboBox.setBounds(100, 10+35*2, 180, 25);
        this.add(departComboBox);
        
        OrganizationComboBox destinationComboBox = new OrganizationComboBox();
        destinationComboBox.setSelectedItem(LoginController.getOrganizationName());
        destinationComboBox.setEnabled(false);
        destinationComboBox.setBounds(100, 10+35*3, 180, 25);
        this.add(destinationComboBox);
        
        RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
        datePickPanel.setEnabled(false);
        datePickPanel.setBounds(100, 10+35*4, 200, 25);
        this.add(datePickPanel);
        
        //set arrival state
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton[] jRadioButtons = new JRadioButton[3];
        String[] radioButtonNames = {"完好","破损","丢失"};
        for(int i=0;i<jRadioButtons.length;i++){
            jRadioButtons[i] = new JRadioButton(radioButtonNames[i]);
            jRadioButtons[i].setBounds(90+60*i, 10+35*5, 60, 25);
            buttonGroup.add(jRadioButtons[i]);
            this.add(jRadioButtons[i]);
        }
        jRadioButtons[0].setSelected(true);
        DialogLayoutManager.fix(jRadioButtons);
        
        ArrivalVO vo = tableModel.getArrivalVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getTransferId());
        departComboBox.setSelectedItem(vo.getDepart());
        destinationComboBox.setSelectedItem(vo.getDestination());
        datePickPanel.setTime(vo.getArrivalDate());
        jRadioButtons[vo.getGoodsState().ordinal()].setSelected(true);

        if(isEditable){
            Checker transferIdChecker = new Checker(textFields[1], new CheckInfoGetter() {
                
                @Override
                public CheckInfo getCheckInfo() {
                    return new ArrivalTransferId(textFields[1].getText());
                }
            });
            
            textFields[1].addKeyListener(new KeyListener() {
                
                @Override
                public void keyTyped(KeyEvent e) {
                }
                
                @Override
                public void keyReleased(KeyEvent e) {
                    boolean isTransferRight = transferIdChecker.check();
                    if(isTransferRight){
                        ArrivalblService arrivalblService = BusinessLogicService.getArrivalblService();
                        LoadVO loadVO;
                        TransferVO transferVO;
                        if((loadVO = arrivalblService.getLoadVO(textFields[1].getText())) != null){
                            departComboBox.setSelectedItem(loadVO.getDepart());
                        }else{
                            transferVO = arrivalblService.getTransferVO(textFields[1].getText());
                            departComboBox.setSelectedItem(transferVO.getDepart());
                        }
                    }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {
                }
            });
        }
        
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 240, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    ArrivalPendingDialog.this.dispose();
                    return;
                }
                GoodsState goodsState = GoodsState.COMPLETE;
                if(jRadioButtons[0].isSelected())
                    goodsState = GoodsState.COMPLETE;
                else if(jRadioButtons[1].isSelected())
                    goodsState = GoodsState.BROKEN;
                else if(jRadioButtons[2].isSelected())
                    goodsState = GoodsState.LOST;
                vo.setGoodsState(goodsState);
                tableModel.modify(modelRow, vo);
                System.out.println("you've clicked confirm button..");
                ArrivalPendingDialog.this.dispose();
                
            }
        });
        this.add(confirmButton);
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 240, 80, 30);
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrivalPendingDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }
        if(!isEditable){
            jRadioButtons[0].setEnabled(false);
            jRadioButtons[1].setEnabled(false);
            jRadioButtons[2].setEnabled(false);
        }

        this.setSize(340, 320);
        this.setLayout(new DialogLayoutManager());
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
