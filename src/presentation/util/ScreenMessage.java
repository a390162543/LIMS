package presentation.util;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import presentation.mainui.MainFrame;

/**
 * ��ʱ����
 * @author ���滪
 *
 */
public class ScreenMessage{
    
    private static final ImageIcon BACKGROUND_ICON = 
            new ImageIcon(Checker.class.getResource("image/bg.png"));
    public static final String SAVE_SUCCESS = "����ɹ�";
    public static final String SAVE_FAILURE = "����ʧ��,������д����";
    public static final String EXCEPTION_CONNECTION = "���������쳣";
    public static final String NO_CHOOSE_IN_TABLE = "�������ѡ����";
    
    
    public static void putOnScreen(String message){
        JOptionPane.showMessageDialog(null, message);
        if(message.length()!=0 || message.equals(""))
            return;
        int width = message.length()*15;
        if(width>BACKGROUND_ICON.getIconWidth())
            width = BACKGROUND_ICON.getIconWidth();
        int height = BACKGROUND_ICON.getIconHeight();
        Dimension dimension = new Dimension(width,height);
        
        JLabel backgroundLabel = new JLabel(BACKGROUND_ICON);
        
        JLabel textLabel = new JLabel(message, JLabel.CENTER);
        textLabel.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        textLabel.setForeground(Color.black);

//        textLabel.setOpaque(false);

        
        
        JDialog messageDialog = new JDialog();
        messageDialog.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        messageDialog.setBackground(Color.WHITE);


        messageDialog.getContentPane().add(backgroundLabel);


        backgroundLabel.add(textLabel);
  
        messageDialog.setAlwaysOnTop(true);
//        messageDialog.setUndecorated(true);

        messageDialog.pack();
        messageDialog.setVisible(true);
        
        JFrame mainFrame = MainFrame.getMainFrame();
        if(mainFrame != null){
            Point location = mainFrame.getLocation();
            location.x += mainFrame.getWidth()/2 -dimension.width/2;
            location.y += 100;
            messageDialog.setLocation(location);
        }else{
            messageDialog.setLocationRelativeTo(null);
        }
        
        textLabel.setSize(1,1);
        backgroundLabel.setSize(1,1);
        messageDialog.setSize(1,1);
        messageDialog.toFront();
        messageDialog.setVisible(true);
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        textLabel.setSize(dimension);
        backgroundLabel.setSize(dimension);
        messageDialog.setSize(dimension);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        messageDialog.dispose();
    }
    
    
    public static void main(String[] args) {
        ScreenMessage.putOnScreen("��ѡ����Ҫɾ���ĳ�����Ϣ");
        
    }
 
}
