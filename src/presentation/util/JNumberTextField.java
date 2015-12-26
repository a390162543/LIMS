package presentation.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JNumberTextField extends JTextField{

    /**
     * 
     */
    private static final long serialVersionUID = 1291919605412651987L;

    public JNumberTextField(){
        super();
        
        this.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {  
                    
                }else{  
                    e.consume();
                    
                }  
            }            
      });
        
    }
}
