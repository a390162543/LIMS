package presentation.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRootPane;

/**
 * 暂时废弃
 * @author 林祖华
 *
 */
@Deprecated
public class ScreenMessage{
    
    @SuppressWarnings("restriction")
    public static void putOnScreen(String message){
        JDialog messageDialog = new JDialog();
        messageDialog.setSize(12*message.length(), 15);
        messageDialog.setAlwaysOnTop(true);
        messageDialog.setLocationRelativeTo(null);
        messageDialog.setUndecorated(true);
        com.sun.awt.AWTUtilities.setWindowOpaque(messageDialog, false);
        messageDialog.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        JLabel textLabel = new JLabel(message, JLabel.CENTER);
        textLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        textLabel.setBackground(new Color(0xFF, 0xFF, 0xCE));
        textLabel.setForeground(Color.BLACK);
        textLabel.setForeground(Color.RED);
        textLabel.setSize(12*message.length(), 15);
        textLabel.setOpaque(true);
        
        
        messageDialog.getContentPane().setBackground(null);
        messageDialog.getContentPane().add(textLabel);
        messageDialog.setVisible(true);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        messageDialog.dispose();
    }
    
    public static void main(String[] args) {
        ScreenMessage.putOnScreen("看看这里");
        
    }
    
 
}
