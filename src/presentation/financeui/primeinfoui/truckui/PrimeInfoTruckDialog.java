package presentation.financeui.primeinfoui.truckui;

import java.awt.Color;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DatePickPanel;
import presentation.util.DialogLayoutManager;
import presentation.util.OrganizationComboBox;
import presentation.util.ScreenMessage;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.truckinfo.TruckChassisNumber;
import businesslogic.checkbl.truckinfo.TruckEngineNumber;
import businesslogic.checkbl.truckinfo.TruckNumber;
import businesslogic.checkbl.truckinfo.TruckPurchasedDate;
import businesslogicservice.IdblService;
import businesslogicservice.OrganizationblService;
import businesslogicservice.PrimeInfoblService;
import businesslogicservice.TruckblService;
import vo.TruckVO;


/**
 * 期初建账时车辆信息的{@code Jdialog}
 * @author 林祖华
 * @version 1.2
 * 
 */
public class PrimeInfoTruckDialog extends JDialog{
/**
	 * 
	 */
	private static final long serialVersionUID = 4611628164316810360L;
    private static final String[] LABEL_NAMES = {"车辆编号","所在机构","车牌号","发动机号","底盘号","购买日期","车辆图片"};
    private PrimeInfoTruckTableModel tableModel;
    private JTextField[] textFields;
    private JLabel imageLabel;
    private ImageIcon image;
    private PrimeInfoblService primeInfoblService;
    /**
     * @param tm
     */
    public PrimeInfoTruckDialog(PrimeInfoTruckTableModel tm ){
        primeInfoblService = BusinessLogicService.getPrimeInfoblService();
        this.tableModel = tm;

        JLabel[] labels = new JLabel[7];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        JTextField truckIdTextField = new JTextField("此项由系统自动生成");
        truckIdTextField.setBounds(100, 10+35*0, 150, 25);
        truckIdTextField.setEnabled(false);
        this.add(truckIdTextField);
        
        OrganizationComboBox organizationComboBox = new OrganizationComboBox("营业厅");
        organizationComboBox.setBounds(20, 10+35*1, 180, 25);
        List<String> newOrganizations = primeInfoblService.getOrganizationName();
        for(String s:newOrganizations){
            organizationComboBox.addItem(s);
        }
        this.add(organizationComboBox);
        organizationComboBox.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                TruckblService truckblService = BusinessLogicService.getTruckblService();
                OrganizationblService organizationblService = BusinessLogicService.getOrganizationblService();
                IdblService idblService = truckblService.getIdblService();
                String organizationId = organizationblService.getId(organizationComboBox.getSelectedOrganization());
                if(organizationId == null || organizationId.equals("")){
                    organizationId = primeInfoblService.getOrganizationId(organizationComboBox.getSelectedOrganization());
                }
                truckIdTextField.setText(idblService.createNewId(organizationId));
            }
        });
        organizationComboBox.setSelectedIndex(0);
        
        textFields = new JTextField[3];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }

        DatePickPanel datePickPanel = new DatePickPanel();
        this.add(datePickPanel);

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
        DialogLayoutManager.fix(imageLabel);
        
        
        Checker truckNumberChecker = new Checker(textFields[0],new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new TruckNumber(textFields[0].getText());
            }
        });
        textFields[0].addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                truckNumberChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });

        Checker engineNumberChecker = new Checker(textFields[1], new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new TruckEngineNumber(textFields[1].getText());
            }
        });
        textFields[1].addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                engineNumberChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        
        Checker chassisNumberChecker = new Checker(textFields[2], new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new TruckChassisNumber(textFields[2].getText());
            }
        });
        textFields[2].addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                chassisNumberChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        
        Checker purchaseDateChecker = new Checker(datePickPanel, new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new TruckPurchasedDate(datePickPanel.getDate());
            }
        });
        
        datePickPanel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                purchaseDateChecker.check();
            }
        });
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 360, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(truckNumberChecker.check() & engineNumberChecker.check()
                        & chassisNumberChecker.check() & purchaseDateChecker.check()){
                    String id = truckIdTextField.getText();
                    String organization = organizationComboBox.getSelectedOrganization();
                    String truckNumber = textFields[0].getText();
                    String engineNumber = textFields[1].getText();
                    String chassisNumber = textFields[2].getText();
                    Date purchaseDate = datePickPanel.getDate();
                    ImageIcon truckImage = image;
                    TruckVO vo = new TruckVO(id, organization, engineNumber, truckNumber, chassisNumber, purchaseDate, truckImage);
                    tableModel.create(vo);
                    PrimeInfoTruckDialog.this.dispose();
                    ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
                }else{
                    ScreenMessage.putOnScreen(ScreenMessage.SAVE_FAILURE);
                }

            }
        });
        JButton cancleButton = new JButton("取消");
        cancleButton.setBounds(140, 360, 80, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                PrimeInfoTruckDialog.this.dispose();
            }
        });
        
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setSize(380, 440);
        this.setTitle("车辆信息");
        this.setLayout(new DialogLayoutManager());
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
        JTextField truckIdTextField = new JTextField("此项由系统自动生成");
        truckIdTextField.setBounds(100, 10+35*0, 150, 25);
        truckIdTextField.setEnabled(false);
        this.add(truckIdTextField);
        
        OrganizationComboBox organizationComboBox = new OrganizationComboBox("营业厅");
        organizationComboBox.setBounds(20, 10+35*1, 180, 25);
        List<String> newOrganizations = primeInfoblService.getOrganizationName();
        for(String s:newOrganizations){
            organizationComboBox.addItem(s);
        }
        this.add(organizationComboBox);
        organizationComboBox.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                TruckblService truckblService = BusinessLogicService.getTruckblService();
                OrganizationblService organizationblService = BusinessLogicService.getOrganizationblService();
                IdblService idblService = truckblService.getIdblService();
                String organizationId = organizationblService.getId(organizationComboBox.getSelectedOrganization());
                if(organizationId == null || organizationId.equals("")){
                    organizationId = primeInfoblService.getOrganizationId(organizationComboBox.getSelectedOrganization());
                }
                truckIdTextField.setText(idblService.createNewId(organizationId));
            }
        });
        
        textFields = new JTextField[3];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }

        DatePickPanel datePickPanel = new DatePickPanel();
        this.add(datePickPanel);

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
        }
        this.add(imageLabel);
        DialogLayoutManager.fix(imageLabel);
        
        
        Checker truckNumberChecker = new Checker(textFields[0],new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new TruckNumber(textFields[0].getText());
            }
        });
        textFields[0].addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                truckNumberChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });

        Checker engineNumberChecker = new Checker(textFields[1], new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new TruckEngineNumber(textFields[1].getText());
            }
        });
        textFields[1].addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                engineNumberChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        
        Checker chassisNumberChecker = new Checker(textFields[2], new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new TruckChassisNumber(textFields[2].getText());
            }
        });
        textFields[2].addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                chassisNumberChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        
        Checker purchaseDateChecker = new Checker(datePickPanel, new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new TruckPurchasedDate(datePickPanel.getDate());
            }
        });
        
        datePickPanel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                purchaseDateChecker.check();
            }
        });
        
        TruckVO vo = tableModel.getTruckVO(modelRow);
        truckIdTextField.setText(vo.getId());
        organizationComboBox.setSelectedItem(vo.getOrganization());
        textFields[0].setText(vo.getTruckNumber());
        textFields[1].setText(vo.getEngineNumber());
        textFields[2].setText(vo.getChassisNumber());
        datePickPanel.setDate(vo.getPurchaseDate());
        imageLabel.setIcon(vo.getTruckImage());
        image = vo.getTruckImage();
        
        if(!isEditable){
            organizationComboBox.setEnabled(false);
            textFields[0].setEnabled(false);
            textFields[1].setEnabled(false);
            textFields[2].setEnabled(false);
            datePickPanel.setEnabled(false);
        }
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 360, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    PrimeInfoTruckDialog.this.dispose();
                    return;
                }
                if(truckNumberChecker.check() & engineNumberChecker.check()
                        & chassisNumberChecker.check() & purchaseDateChecker.check()){
                    String truckId = truckIdTextField.getText();
                    String truckNumber = textFields[0].getText();
                    String engineNumber = textFields[1].getText();
                    String chassisNumber = textFields[2].getText();
                    Date purchaseDate = datePickPanel.getDate();
                    ImageIcon truckImage = image;
                    vo.setId(truckId);
                    vo.setTruckNumber(truckNumber);
                    vo.setEngineNumber(engineNumber);
                    vo.setChassisNumber(chassisNumber);
                    vo.setPurchaseDate(purchaseDate);
                    vo.setTruckImage(truckImage);
                    tableModel.modify(modelRow, vo);
                    PrimeInfoTruckDialog.this.dispose();
                    ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
                }else{
                    ScreenMessage.putOnScreen(ScreenMessage.SAVE_FAILURE);
                }

                
            }
        });
        this.add(confirmButton);
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 360, 80, 30);
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    PrimeInfoTruckDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }


        this.setSize(340, 440);
        this.setLayout(new DialogLayoutManager());
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




