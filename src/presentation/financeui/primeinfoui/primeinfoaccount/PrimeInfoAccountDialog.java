package presentation.financeui.primeinfoui.primeinfoaccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.AccountVO;

public class PrimeInfoAccountDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2959527949771784570L;
	private static final String[] LABEL_NAMES = {"账户编号","账户名称","账户金额"};
    
    private PrimeInfoAccountTableModel tableModel;
    private JTextField[] textFields;
    
    public PrimeInfoAccountDialog(PrimeInfoAccountTableModel tm){
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[3];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(70, 40+40*i, 100, 25);
            this.add(labels[i]);
        }
        
        textFields = new JTextField[3];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();           
            if(i==2)
            	textFields[i].setBounds(140, 40+40*i, 90, 25);
            else
            	textFields[i].setBounds(140, 40+40*i, 180, 25);
            this.add(textFields[i]);
        }
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(250, 170, 70, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	AccountVO vo = new AccountVO(textFields[0].getText(),textFields[1].getText(),Double.parseDouble(textFields[2].getText()));
                tableModel.create(vo);
                System.out.println("you've clicked confirm button..");
                PrimeInfoAccountDialog.this.dispose();
            }
        });
        JButton cancleButton = new JButton("取消");
        cancleButton.setBounds(160, 170, 70, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	PrimeInfoAccountDialog.this.dispose();
            }
        });
        
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setSize(380, 260);
        this.setTitle("账户信息");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }


}
