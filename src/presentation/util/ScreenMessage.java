package presentation.util;

import java.awt.*;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.*;

import presentation.mainui.MainFrame;
import presentation.mainui.StatePanel;

/**
 * 暂时废弃
 * @author 林祖华
 *
 */
public class ScreenMessage{
    
    private static final ImageIcon BACKGROUND_ICON = 
            new ImageIcon(Checker.class.getResource("image/bg.png"));
    public static final String SAVE_SUCCESS = "保存成功";
    public static final String SAVE_FAILURE = "保存失败,请检查填写内容";
    public static final String EXCEPTION_CONNECTION = "网络连接异常";
    public static final String NO_CHOOSE_IN_TABLE = "表格中无选中项";
    public static final String EXPORT_SUCCESS = "导出成功";
    
    
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
        textLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
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
