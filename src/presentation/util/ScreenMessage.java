package presentation.util;

import javax.swing.JOptionPane;

/**
 * ��ʱ����
 * @author ���滪
 *
 */
public class ScreenMessage{
    
    public static final String SAVE_SUCCESS = "����ɹ�";
    public static final String SAVE_FAILURE = "����ʧ��,������д����";
    public static final String EXCEPTION_CONNECTION = "���������쳣";
    public static final String NO_CHOOSE_IN_TABLE = "�������ѡ����";
    public static final String EXPORT_SUCCESS = "�����ɹ�";
    
    
    public static void putOnScreen(String message){
        JOptionPane.showMessageDialog(null, message);

//        int width = message.length()*15;
//        if(width>BACKGROUND_ICON.getIconWidth())
//            width = BACKGROUND_ICON.getIconWidth();
//        int height = BACKGROUND_ICON.getIconHeight();
//        Dimension dimension = new Dimension(width,height);
//        
//        JLabel backgroundLabel = new JLabel(BACKGROUND_ICON);
//        
//        JLabel textLabel = new JLabel(message, JLabel.CENTER);
//        textLabel.setFont(new Font("΢���ź�", Font.PLAIN, 12));
//        textLabel.setForeground(Color.black);
//
//        textLabel.setOpaque(false);
//
//        
//        
//        JDialog messageDialog = new JDialog();
//        messageDialog.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
//        messageDialog.setBackground(Color.WHITE);
//
//
//        messageDialog.getContentPane().add(backgroundLabel);
//
//
//        backgroundLabel.add(textLabel);
//  
//        messageDialog.setAlwaysOnTop(true);
//        messageDialog.setUndecorated(true);
//
//        messageDialog.pack();
//        messageDialog.setVisible(true);
//        
//        JFrame mainFrame = MainFrame.getMainFrame();
//        if(mainFrame != null){
//            Point location = mainFrame.getLocation();
//            location.x += mainFrame.getWidth()/2 -dimension.width/2;
//            location.y += 100;
//            messageDialog.setLocation(location);
//        }else{
//            messageDialog.setLocationRelativeTo(null);
//        }
//        
//        textLabel.setSize(1,1);
//        backgroundLabel.setSize(1,1);
//        messageDialog.setSize(1,1);
//        messageDialog.toFront();
//        messageDialog.setVisible(true);
//        
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        
//        textLabel.setSize(dimension);
//        backgroundLabel.setSize(dimension);
//        messageDialog.setSize(dimension);
//
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//        messageDialog.dispose();
    }

 
}
