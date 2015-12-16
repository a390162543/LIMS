package presentation.managerui.organizationui;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.organizationinfo.OrganizationName;
import businesslogic.organizationbl.Organization;
import businesslogicservice.IdblService;
import businesslogicservice.OrganizationblService;
import vo.OrganizationVO;


/**
 * �������޸ĺͲ�ѯ��������
 * @author ������
 * @see presentation.employeeui.OrganizationTableModel
 * @version 1.2
 */
public class OrganizationDialog extends JDialog{

 
	/**
	 * 
	 */
	private static final long serialVersionUID = 3380122615488984030L;

	 
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel idLabel;
	private JTextField idField;
	private JLabel cityLabel;
	private JComboBox<String> cityBox;
	private JButton cancleButton;
	private JButton sureButton;
	private OrganizationTableModel tableModel;
	private OrganizationblService organizationblService;
	private Checker organizationNameChecker;
/**
 * ����������Dialog
 * @param tm
 */
	public OrganizationDialog(OrganizationTableModel tm){
		init();
		tableModel = tm;	
		organizationblService =  BusinessLogicService.getOrganizationblService();
		cityBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub			
				setId(nameField.getText());
				organizationNameChecker.check();
			}
		});
		
		
		
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean isRight = organizationNameChecker.check();
				if(isRight){
					update(0,true);
					OrganizationDialog.this.dispose();
				}
				else{
					return;
				}
				 
			}
		});
	}
	/**
	 * ��ѯ���޸ĵ�Dialog
	 * @param em
	 * @param modelRow
	 * @param isEdit
	 */
	public OrganizationDialog(OrganizationTableModel em, int modelRow,boolean isEdit){
		init();
		this.tableModel = em;
		OrganizationVO vo = tableModel.getOrganizationVO(modelRow);		 
		nameField.setText(vo.getName());
		cityBox.setSelectedItem(vo.getCity());
		cityBox.setEnabled(false);
		idField.setText(""+vo.getId());
		
		idField.setEnabled(false);
		if(!isEdit){
			nameField.setEnabled(false);
			cityBox.setEnabled(false);
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					OrganizationDialog.this.dispose();
				}
			});
		}
		else{
			cancleButton.setVisible(false);
			cityBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub			
					setId(nameField.getText());
					organizationNameChecker.check();
				}
			});
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					boolean isRight = organizationNameChecker.check();
					if(isRight){
						update(modelRow,false);
						OrganizationDialog.this.dispose();						
					}
					else{
						return;
					}
					
				}
			});
		}		
	}
	
/**
 * ����ID
 * @param organizationName
 */
	public void setId(String organizationName){
		String cityId = organizationblService.getCityId
				((String)cityBox.getSelectedItem());
		if(organizationName.contains("��ת����")){
			IdblService idblService = organizationblService.getIdblService(1);
			idField.setText(idblService.createNewId(cityId));
		}
		else if(organizationName.contains("Ӫҵ��")){
			IdblService idblService = organizationblService.getIdblService(3);
			idField.setText(idblService.createNewId(cityId));
		}
		else{
			IdblService idblService = organizationblService.getIdblService();
			idField.setText(idblService.createNewId());
		}
		
	}
	/**
	 * ��ʼ������
	 */
	public void init(){		 
		organizationblService = BusinessLogicService.getOrganizationblService();
		this.setTitle("������Ϣ");
		List<String> cityList = new ArrayList<String>();
		cityList = organizationblService.getAllCityName();
		String[] cityStr = cityList.toArray(new String[cityList.size()]);
		 
		nameLabel = new JLabel();
		nameField = new JTextField();
		cityBox = new JComboBox<String>(cityStr);
		cityLabel = new JLabel();
		idField = new JTextField();
		idLabel = new JLabel();
		cancleButton = new JButton("ȡ��");
		sureButton = new JButton("ȷ��");
		 		
		this.setBounds(400, 200, 380, 300);
	 
		nameLabel.setText("��������");
		nameLabel.setBounds(27, 65, 100, 20);
		nameField.setBounds(135, 65, 180, 20);
		cityLabel.setText("���ڳ���");
		cityLabel.setBounds(27, 100, 100, 20);
		cityBox.setBounds(137, 100, 80, 20);
		idLabel.setText("�������");
		idLabel.setBounds(27, 135, 100, 20);
		idField.setBounds(137, 135, 180, 20);
		idField.setEnabled(false);
		cancleButton.setBounds(180, 185, 70, 30);
		sureButton.setBounds(270, 185, 70, 30);
		
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OrganizationDialog.this.dispose();
			}
		});
//		
//		this.setModalityType(ModalityType.APPLICATION_MODAL);
//		this.setLocationRelativeTo(MainFrame.getMainFrame()); 
		this.add(nameLabel);
		this.add(nameField);
		this.add(cityLabel);
		this.add(cityBox);
		this.add(idLabel);
		this.add(idField);
		this.add(sureButton);	
		this.add(cancleButton);		
		this.setLayout(new DialogLayoutManager());
		this.setVisible(true);
		
		//��Ӽ����
		organizationNameChecker = new Checker(nameField,new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(nameField.getText() == null){
					return null;
				}
				return new OrganizationName(nameField.getText(), (String)cityBox.getSelectedItem());
			}
		});
		nameField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				organizationNameChecker.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void update( int modelRow,boolean isNew){
		OrganizationblService organizationblService = new Organization();
		String name = nameField.getText();
		String city = (String) cityBox.getSelectedItem();
		String id = idField.getText();
		OrganizationVO vo= new OrganizationVO(id, name, city);
		organizationblService.createOrganizationPO(vo);
		if(isNew)
			tableModel.create(vo);
		else
			tableModel.modify(modelRow, vo);
	}
	
}
