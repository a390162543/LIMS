package presentation.businesshallui.truckui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import org.jb2011.lnf.beautyeye.widget.border.BERoundBorder;

import businesslogic.BusinessLogicService;
import businesslogicservice.IdblService;
import businesslogicservice.TruckblService;
import vo.TruckVO;

public class TruckDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = -5791738856120916225L;
    private static final String[] LABEL_NAMES = {"车辆编号","所在机构","发动机号","车牌号","底盘号","购买日期","服役时间","车辆图片"};
    
    private TruckTableModel tableModel;
    private JTextField[] textFields;
    private JLabel imageLabel;
    private ImageIcon image;
    
    public TruckDialog(TruckTableModel tm){
        
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
        TruckblService truckblService = BusinessLogicService.getTruckblService();
        IdblService idblService = truckblService.getIdblService();
        textFields[0].setText(idblService.createNewId());
        textFields[0].setEnabled(false);
        
        textFields[6].setText("此项由系统自动生成");
        imageLabel = 
               new JLabel("<html>  点击此处选择车辆图片<br>图片格式需求：<br>"
                       + "  图片后缀为jpg,png或gif<br>  图片大小为140*90</html>");
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
                imageChooser.showOpenDialog(TruckDialog.this);
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
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 360, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                TruckVO vo = new TruckVO(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), textFields[3].getText(), textFields[4].getText(), new Date(), image);
                tableModel.create(vo);
                TruckDialog.this.dispose();
            }
        });
        JButton cancleButton = new JButton("取消");
        cancleButton.setBounds(140, 360, 80, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                TruckDialog.this.dispose();
            }
        });
        
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setSize(340, 440);
        this.setTitle("车辆信息");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

    
    public TruckDialog(TruckTableModel tm, int modelRow, boolean isEditable) {
        
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
        
        imageLabel = 
               new JLabel("<html>  点击此处选择车辆图片<br>图片格式需求：<br>"
                       + "  图片后缀为jpg,png或gif<br>  图片大小为140*90</html>");
        imageLabel.setForeground(Color.GRAY);
        imageLabel.setBorder(new BERoundBorder());
        imageLabel.setBounds(100, 15+35*7, 140, 90);
        if(isEditable){
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
                    imageChooser.showOpenDialog(TruckDialog.this);
                    File f = imageChooser.getSelectedFile();
                    if(f == null)
                        return;
                    String fileName = imageChooser.getSelectedFile().getAbsolutePath();
                    image = new ImageIcon(fileName);
                    image = new ImageIcon(image.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), 1));
                    imageLabel.setIcon(image);
                }
            });
        }else{
            imageLabel.setText("      无图片");
        }
        
        this.add(imageLabel);
        
        TruckVO vo = tableModel.getTruckVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getOrganization());
        textFields[2].setText(vo.getEngineNumber());
        textFields[3].setText(vo.getTruckNumber());
        textFields[4].setText(vo.getChassisNumber());
        textFields[5].setText(new SimpleDateFormat().format(vo.getPurchaseDate()));
        textFields[6].setText(vo.getServedTime());
        imageLabel.setIcon(vo.getTruckImage());
        image = vo.getTruckImage();
        
        // 如果textfield的编号和表格列号一一对应，上述代码也可以用for循环 
        // textFields[i].setText((String) tableModel.getValueAt(modelRow, i));
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 360, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    TruckDialog.this.dispose();
                    return;
                }
                TruckVO vo = new TruckVO(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), textFields[3].getText(), textFields[4].getText(), new Date(), image);
                tableModel.modify(modelRow, vo);
                TruckDialog.this.dispose();
                
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 360, 80, 30);
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    TruckDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }
        this.add(confirmButton);

        this.setSize(340, 440);
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
