package presentation.financeui.primeinfoui.truckui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import org.jb2011.lnf.beautyeye.widget.border.BERoundBorder;

import vo.TruckVO;

public class PrimeInfoTruckDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = -5791738856120916225L;
    private static final String[] LABEL_NAMES = {"�������","���ڻ���","��������","���ƺ�","���̺�","��������","����ʱ��","����ͼƬ"};
    
    private PrimeInfoTruckTableModel tableModel;
    private JTextField[] textFields;
    private JLabel imageLabel;
    private ImageIcon image;
    
    public PrimeInfoTruckDialog(PrimeInfoTruckTableModel tm){
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[8];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        textFields = new JTextField[7];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }
        textFields[6].setText("������ϵͳ�Զ�����");
        imageLabel = 
               new JLabel("<html>  ����˴�ѡ����ͼƬ<br>ͼƬ��ʽ����<br>"
                       + "  ͼƬ��׺Ϊjpg,png��gif<br>  ͼƬ��СΪ140*90</html>");
        imageLabel.setForeground(Color.GRAY);
        imageLabel.setBorder(new BERoundBorder());
        imageLabel.setBounds(100, 15+35*7, 140, 90);
        
        imageLabel.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void mousePressed(MouseEvent e) {

            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                ImageChooser imageChooser = new ImageChooser();
                imageChooser.showOpenDialog(PrimeInfoTruckDialog.this);
                File f = imageChooser.getSelectedFile();
                if(f == null)
                    return;
                String fileName = imageChooser.getSelectedFile().getAbsolutePath();
                image = new ImageIcon(fileName);
                image = new ImageIcon(image.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), 1));
                imageLabel.setIcon(image);
            }
        });
        this.add(imageLabel);
        
        JButton confirmButton = new JButton("ȷ��");
        confirmButton.setBounds(230, 360, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                TruckVO vo = new TruckVO(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), textFields[3].getText(), textFields[4].getText(), new Date(), image);
                tableModel.create(vo);
                PrimeInfoTruckDialog.this.dispose();
            }
        });
        JButton cancleButton = new JButton("ȡ��");
        cancleButton.setBounds(140, 360, 80, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                PrimeInfoTruckDialog.this.dispose();
            }
        });
        
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setSize(340, 440);
        this.setTitle("������Ϣ");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
    
    private class ImageChooser extends JFileChooser{
        
        /**
         * 
         */
        private static final long serialVersionUID = -4240101672436431214L;

        public ImageChooser(){
            super();
            setFileFilter(new FileFilter() {
                
                @Override
                public String getDescription() {
                    // TODO Auto-generated method stub
                    return "";
                }
                
                @Override
                public boolean accept(File f) {
                    if(f.isDirectory())
                        return true;
                    String fileName = f.getName();
                    if(fileName.endsWith(".jpg")||fileName.endsWith(".png")
                            ||fileName.endsWith(".gif"))
                        return true;
                    return false;
                }
            }); 
            
        }
        
    }
}
