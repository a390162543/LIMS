package presentation.businesshallui.driverui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.Name;
import businesslogic.checkbl.PhoneNumber;
import businesslogic.checkbl.driverinfo.DriverIdCard;
import businesslogic.checkbl.driverinfo.DriverLDDL;
import businesslogic.userbl.LoginController;
import businesslogicservice.EmployeeblService;
import businesslogicservice.IdblService;
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DatePickPanel;
import presentation.util.DialogLayoutManager;
import presentation.util.JNumberTextField;
import presentation.util.OrganizationComboBox;
import presentation.util.ScreenMessage;
import systemenum.Position;
import systemenum.Sex;
import vo.EmployeeVO;
import vo.PayVO;

public class DriverDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = 754881796102105707L;
    private static final String[] LABEL_NAMES = {"姓名","性别","员工编号","所在机构","手机号码","身份证号","出生日期","行驶证期限","工资"};
    private EmployeeblService employeeblService;
    private DriverTableModel driverTableModel;
    
    public DriverDialog(DriverTableModel tm){
        this.employeeblService = BusinessLogicService.getEmployeeblService();
        this.driverTableModel = tm;
        
        JLabel[] labels = new JLabel[9];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        JTextField nameTextField = new JTextField();
        nameTextField.setSize(60, 25);
        this.add(nameTextField);
        
        ButtonGroup sexButtonGroup = new ButtonGroup();
        JRadioButton maleRadioButton = new JRadioButton("男");
        JRadioButton femaleRadioButton = new JRadioButton("女");
        sexButtonGroup.add(maleRadioButton);
        sexButtonGroup.add(femaleRadioButton);
        maleRadioButton.setBounds(0, 0, 60, 25);
        femaleRadioButton.setBounds(60, 0, 60, 25);
        this.add(maleRadioButton);
        this.add(femaleRadioButton);
        maleRadioButton.setSelected(true);
        DialogLayoutManager.fix(maleRadioButton,femaleRadioButton);
        
        JTextField idTextField = new JTextField();
        idTextField.setSize(150, 25);
        
        IdblService idblService = employeeblService.getIdblService();
        String id = idblService.createNewId(LoginController.getOrganizationId());
        idTextField.setText(id);
        idTextField.setEnabled(false);
        this.add(idTextField);
        
        OrganizationComboBox organizationComboBox = new OrganizationComboBox();
        organizationComboBox.setSelectedItem(LoginController.getOrganizationName());
        organizationComboBox.setEnabled(false);
        this.add(organizationComboBox);
        
        JTextField phoneTextField = new JNumberTextField();
        phoneTextField.setSize(150, 25);
        this.add(phoneTextField);
        
        JTextField idcardNumberTextField = new JNumberTextField();
        idcardNumberTextField.setSize(150, 25);
        this.add(idcardNumberTextField);
        
        DatePickPanel birthDatePickPanel = new DatePickPanel();
        this.add(birthDatePickPanel);
        
        DatePickPanel ddlDatePickPanel = new DatePickPanel();
        this.add(ddlDatePickPanel);
        
        JTextField payTextField = new JTextField();
        payTextField.setBounds(0, 0, 60, 25);
        payTextField.setText("60");
        payTextField.setEnabled(false);
        this.add(payTextField);
        
        JLabel payLabel = new JLabel("元/次");
        payLabel.setBounds(60, 0, 60, 25);
        this.add(payLabel);
        
        DialogLayoutManager.fix(payTextField,payLabel);
        

        
        Checker nameChecker = new Checker(nameTextField, new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new Name(nameTextField.getText());
            }
        });
        nameTextField.addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                nameChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        
        Checker phoneNumeberChecker = new Checker(phoneTextField, new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new PhoneNumber(phoneTextField.getText());
            }
        });
        phoneTextField.addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                phoneNumeberChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        Checker idcardNumberChecker = new Checker(idcardNumberTextField, new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new DriverIdCard(idcardNumberTextField.getText());
            }
        });
        idcardNumberTextField.addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                idcardNumberChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        Checker ddlDateChecker = new Checker(ddlDatePickPanel, new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new DriverLDDL(ddlDatePickPanel.getDate());
            }
        });
        ddlDatePickPanel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                ddlDateChecker.check();
            }
        });
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setSize(80, 30);
        this.add(confirmButton);
        
        JButton cancleButton = new JButton("取消");
        cancleButton.setSize(80, 30);
        this.add(cancleButton);
        
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameChecker.check() & phoneNumeberChecker.check() 
                        & idcardNumberChecker.check() & ddlDateChecker.check()){
                    String name = nameTextField.getText();
                    Sex sex;
                    if(maleRadioButton.isSelected())
                        sex = Sex.MALE;
                    else
                        sex = Sex.FAMALE;
                    String id = idTextField.getText();
                    String organization = organizationComboBox.getSelectedOrganization();
                    String phoneNumber = phoneTextField.getText();
                    String idcardNumber = idcardNumberTextField.getText();
                    Date birthday = birthDatePickPanel.getDate();
                    Date ddlDate = ddlDatePickPanel.getDate();
                    double pay = new Double(payTextField.getText());
                    PayVO payVO = new PayVO(0, pay, 0, 0, 0);
                    EmployeeVO vo = new EmployeeVO(id, name, organization, Position.DRIVER, phoneNumber, birthday, idcardNumber, sex, payVO, ddlDate, "");
                    driverTableModel.create(vo);
                    DriverDialog.this.dispose();
                    ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
                }else{
                    ScreenMessage.putOnScreen(ScreenMessage.SAVE_FAILURE);
                }

            }
        });
        
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                DriverDialog.this.dispose();
            }
        });
        this.setLayout(new DialogLayoutManager());
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setTitle("司机信息");
        this.setVisible(true);
    }
    
    public DriverDialog(DriverTableModel tm, int modelRow, boolean isEditable){
        this.employeeblService = BusinessLogicService.getEmployeeblService();
        this.driverTableModel = tm;
        
        JLabel[] labels = new JLabel[9];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        JTextField nameTextField = new JTextField();
        nameTextField.setSize(60, 25);
        this.add(nameTextField);
        
        ButtonGroup sexButtonGroup = new ButtonGroup();
        JRadioButton maleRadioButton = new JRadioButton("男");
        JRadioButton femaleRadioButton = new JRadioButton("女");
        sexButtonGroup.add(maleRadioButton);
        sexButtonGroup.add(femaleRadioButton);
        maleRadioButton.setBounds(0, 0, 60, 25);
        femaleRadioButton.setBounds(60, 0, 60, 25);
        this.add(maleRadioButton);
        this.add(femaleRadioButton);
        DialogLayoutManager.fix(maleRadioButton,femaleRadioButton);
        
        JTextField idTextField = new JTextField();
        idTextField.setSize(150, 25);
        
        idTextField.setEnabled(false);
        this.add(idTextField);
        
        OrganizationComboBox organizationComboBox = new OrganizationComboBox();
        organizationComboBox.setSelectedItem(LoginController.getOrganizationName());
        organizationComboBox.setEnabled(false);
        this.add(organizationComboBox);
        
        JTextField phoneTextField = new JNumberTextField();
        phoneTextField.setSize(150, 25);
        this.add(phoneTextField);
        
        JTextField idcardNumberTextField = new JNumberTextField();
        idcardNumberTextField.setSize(150, 25);
        this.add(idcardNumberTextField);
        
        DatePickPanel birthDatePickPanel = new DatePickPanel();
        this.add(birthDatePickPanel);
        
        DatePickPanel ddlDatePickPanel = new DatePickPanel();
        this.add(ddlDatePickPanel);
        
        JTextField payTextField = new JTextField();
        payTextField.setBounds(0, 0, 60, 25);
        payTextField.setText("60");
        payTextField.setEnabled(false);
        this.add(payTextField);
        
        JLabel payLabel = new JLabel("元/次");
        payLabel.setBounds(60, 0, 60, 25);
        this.add(payLabel);
        
        DialogLayoutManager.fix(payTextField,payLabel);
        
        
        EmployeeVO vo = driverTableModel.getEmployeeVO(modelRow);
        String name = vo.getName();
        Sex sex = vo.getSex();
        String id = vo.getId();
        String organization = vo.getOrganization();
        String phoneNumber = vo.getTelephone();
        String idcardNumber = vo.getIdentityCardNum();
        Date birthday = vo.getBirthday();
        Date ddlDate = vo.getDriverLDDL();
        double pay = vo.getPay().getPayByCount();
        
        nameTextField.setText(name);
        if(sex == Sex.MALE)
            maleRadioButton.setSelected(true);
        else
            femaleRadioButton.setSelected(true);
        idTextField.setText(id);
        organizationComboBox.setSelectedItem(organization);
        phoneTextField.setText(phoneNumber);
        idcardNumberTextField.setText(idcardNumber);
        birthDatePickPanel.setDate(birthday);
        ddlDatePickPanel.setDate(ddlDate);
        payTextField.setText(""+pay);
        
        if(!isEditable){
            nameTextField.setEnabled(false);
            maleRadioButton.setEnabled(false);
            femaleRadioButton.setEnabled(false);
            phoneTextField.setEnabled(false);
            idcardNumberTextField.setEnabled(false);
            birthDatePickPanel.setEnabled(false);
            ddlDatePickPanel.setEnabled(false);
        }
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setSize(80, 30);
        this.add(confirmButton);
        
        if(isEditable){    
            Checker nameChecker = new Checker(nameTextField, new CheckInfoGetter() {
                
                @Override
                public CheckInfo getCheckInfo() {
                    return new Name(nameTextField.getText());
                }
            });
            nameTextField.addKeyListener(new KeyListener() {
                
                @Override
                public void keyTyped(KeyEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                
                @Override
                public void keyReleased(KeyEvent e) {
                    nameChecker.check();
                }
                
                @Override
                public void keyPressed(KeyEvent e) {
                    // TODO Auto-generated method stub
                    
                }
            });
            
            Checker phoneNumeberChecker = new Checker(phoneTextField, new CheckInfoGetter() {
                
                @Override
                public CheckInfo getCheckInfo() {
                    return new PhoneNumber(phoneTextField.getText());
                }
            });
            phoneTextField.addKeyListener(new KeyListener() {
                
                @Override
                public void keyTyped(KeyEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                
                @Override
                public void keyReleased(KeyEvent e) {
                    phoneNumeberChecker.check();
                }
                
                @Override
                public void keyPressed(KeyEvent e) {
                    // TODO Auto-generated method stub
                    
                }
            });
            Checker idcardNumberChecker = new Checker(idcardNumberTextField, new CheckInfoGetter() {
                
                @Override
                public CheckInfo getCheckInfo() {
                    return new DriverIdCard(idcardNumberTextField.getText());
                }
            });
            idcardNumberTextField.addKeyListener(new KeyListener() {
                
                @Override
                public void keyTyped(KeyEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                
                @Override
                public void keyReleased(KeyEvent e) {
                    idcardNumberChecker.check();
                }
                
                @Override
                public void keyPressed(KeyEvent e) {
                    // TODO Auto-generated method stub
                    
                }
            });
            Checker ddlDateChecker = new Checker(ddlDatePickPanel, new CheckInfoGetter() {
                
                @Override
                public CheckInfo getCheckInfo() {
                    return new DriverLDDL(ddlDatePickPanel.getDate());
                }
            });
            ddlDatePickPanel.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    ddlDateChecker.check();
                }
            });

            confirmButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(nameChecker.check() & phoneNumeberChecker.check() 
                            & idcardNumberChecker.check() & ddlDateChecker.check()){
                        String name = nameTextField.getText();
                        Sex sex;
                        if(maleRadioButton.isSelected())
                            sex = Sex.MALE;
                        else
                            sex = Sex.FAMALE;
                        String id = idTextField.getText();
                        String organization = organizationComboBox.getSelectedOrganization();
                        String phoneNumber = phoneTextField.getText();
                        String idcardNumber = idcardNumberTextField.getText();
                        Date birthday = birthDatePickPanel.getDate();
                        Date ddlDate = ddlDatePickPanel.getDate();
                        double pay = new Double(payTextField.getText());
                        PayVO payVO = new PayVO(0, pay, 0, 0, 0);
                        EmployeeVO vo = new EmployeeVO(id, name, organization, Position.DRIVER, phoneNumber, birthday, idcardNumber, sex, payVO, ddlDate, "");
                        driverTableModel.modify(modelRow,vo);
                        DriverDialog.this.dispose();
                        ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
                    }else{
                        ScreenMessage.putOnScreen(ScreenMessage.SAVE_FAILURE);
                    }
                }
            });
            
            JButton cancleButton = new JButton("取消");
            cancleButton.setSize(80, 30);
            this.add(cancleButton);
            
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    DriverDialog.this.dispose();
                }
            });
        }
        if(!isEditable){
            confirmButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {

                        DriverDialog.this.dispose();
                }

            });
        }

        this.setLayout(new DialogLayoutManager());
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setTitle("司机信息");
        this.setVisible(true);
    }
}
