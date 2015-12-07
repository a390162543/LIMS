package presentation.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRootPane;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

/**
 * ÔÝÊ±·ÏÆú
 * @author ÁÖ×æ»ª
 *
 */
@Deprecated
public class ScreenMassage{
    
    @SuppressWarnings("restriction")
    public static void putOnScreen(String message){
        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        JDialog messageDialog = new JDialog();
        messageDialog.setSize(300, 30);
        messageDialog.setAlwaysOnTop(true);
        messageDialog.setLocationRelativeTo(null);
        messageDialog.setUndecorated(true);
        com.sun.awt.AWTUtilities.setWindowOpaque(messageDialog, false);
        messageDialog.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        JLabel textLabel = new JLabel(message, JLabel.CENTER);
        textLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
        textLabel.setBackground(Color.YELLOW);
        textLabel.setForeground(Color.WHITE);
        textLabel.setSize(300, 30);
        textLabel.setOpaque(false);
        
        
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
        ScreenMassage.putOnScreen("hello");
    }
    
 
}
