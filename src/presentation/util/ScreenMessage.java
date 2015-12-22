package presentation.util;

import java.awt.*;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.*;

import presentation.mainui.MainFrame;
import presentation.mainui.StatePanel;

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
    public static final String EXPORT_SUCCESS = "�����ɹ�";
    
    
    public static void putOnScreen(String message){
//        JOptionPane.showMessageDialog(null, message);
        
        StatePanel.setInfo(message);
        Thread setInfoThread = new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                StatePanel.setInfo("");
            }
        };
        setInfoThread.start();
        
        int width = BACKGROUND_ICON.getIconWidth();
        int height = BACKGROUND_ICON.getIconHeight();
        Dimension dimension = new Dimension(width,height);
        
        JLabel backgroundLabel = new JLabel(BACKGROUND_ICON);
        
        JLabel textLabel = new JLabel(message, JLabel.CENTER);
        textLabel.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        textLabel.setForeground(Color.black);

        textLabel.setOpaque(false);

        
        
        JDialog messageDialog = new JDialog();
        messageDialog.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        messageDialog.setBackground(Color.WHITE);


        messageDialog.getContentPane().add(backgroundLabel);


        backgroundLabel.add(textLabel);
  
        messageDialog.setAlwaysOnTop(true);
        messageDialog.setUndecorated(true);
        messageDialog.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        
        JFrame mainFrame = MainFrame.getMainFrame();
        if(mainFrame != null){
            Point location = mainFrame.getLocation();
            location.x += mainFrame.getWidth()/2 -dimension.width/2;
            location.y += 60;
            messageDialog.setLocation(location);
        }else{
            messageDialog.setLocationRelativeTo(null);
        }
        textLabel.setSize(dimension);
        backgroundLabel.setSize(dimension);
        messageDialog.setSize(dimension);        
        messageDialog.setVisible(true);
  

        
        Thread disposeThread = new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                messageDialog.dispose();
            }
        };
        disposeThread.start();
    }

 
}
