package presentation.financeui.primeinfoui.primeinfotruck;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.TruckVO;

public class PrimeInfoTruckDialog extends JDialog{
/**
	 * 
	 */
	private static final long serialVersionUID = 4611628164316810360L;
    private static final String[] LABEL_NAMES = {"�������","��������","���ƺ�","���̺�","��������","����ʱ��","����ͼƬ"};
    private PrimeInfoTruckTableModel tableModel;
    private JTextField[] textFields;

    public PrimeInfoTruckDialog(PrimeInfoTruckTableModel tm ){
        this.tableModel = tm;

        JLabel[] labels = new JLabel[7];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        textFields = new JTextField[5];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }
        JButton confirmButton = new JButton("ȷ��");
        confirmButton.setBounds(250, 170, 70, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	TruckVO vo = new TruckVO(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), textFields[3].getText(), new Date(), null);
                tableModel.create(vo);
                System.out.println("you've clicked confirm button..");
                PrimeInfoTruckDialog.this.dispose();
            }
        });
        JButton cancleButton = new JButton("ȡ��");
        cancleButton.setBounds(160, 170, 70, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	PrimeInfoTruckDialog.this.dispose();
            }
        });
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setSize(380, 260);
        this.setTitle("������Ϣ");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
    
    public PrimeInfoTruckDialog(PrimeInfoTruckTableModel tm  , int modelRow ,boolean isEditable){
          	this.tableModel = tm;

          	JLabel[] labels = new JLabel[7];
            for(int i=0;i<labels.length;i++){
                labels[i] = new JLabel();
                labels[i].setText(LABEL_NAMES[i]);
                labels[i].setBounds(20, 10+35*i, 100, 25);
                this.add(labels[i]);
            }
            
            JTextField[] textFields = new JTextField[5];
            for(int i=0;i<textFields.length;i++){
                textFields[i] = new JTextField();
                textFields[i].setBounds(100, 10+35*i, 150, 25);

                textFields[i].setEditable(isEditable);
                this.add(textFields[i]);
            }
            TruckVO vo = tableModel.getTruckVO(modelRow);
            textFields[0].setText(vo.getId());
            textFields[1].setText(vo.getEngineNumber());
            textFields[2].setText(vo.getTruckNumber());
            textFields[3].setText(vo.getChassisNumber());
            textFields[4].setText(new SimpleDateFormat().format(vo.getPurchaseDate()));
           
            JButton backButton = new JButton("����");
            backButton.setBounds(160, 170, 70, 30);
            backButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                	PrimeInfoTruckDialog.this.dispose();
                }
            });
            JButton confirmButton = new JButton("ȷ��");
	        confirmButton.setBounds(250, 170, 70, 30);
	        confirmButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(!isEditable){
	                	PrimeInfoTruckDialog.this.dispose();
	                }
	                TruckVO vo = new TruckVO(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), textFields[3].getText(), new Date(), null);
	                tableModel.modify(modelRow, vo);
	                PrimeInfoTruckDialog.this.dispose();
	                
	            }
	        });
	        if(isEditable){
	            JButton cancleButton = new JButton("ȡ��");
	            cancleButton.setBounds(160, 170, 70, 30);
	            cancleButton.addActionListener(new ActionListener() {
	                
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	PrimeInfoTruckDialog.this.dispose();
	                }
	            });
	            this.add(cancleButton);
	        }
	        this.add(confirmButton);
 
      
        this.setSize(380, 260);
        this.setTitle("������Ϣ");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }


}




