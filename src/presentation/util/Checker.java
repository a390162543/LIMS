package presentation.util;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class Checker extends JLabel{

    /**
     * 
     */
    private static final long serialVersionUID = -1601645180593740224L;
    
    private static final ImageIcon CORRECT_ICON = 
            new ImageIcon(Checker.class.getResource("image/correct.png"));
    private static final ImageIcon FALSE_ICON = 
            new ImageIcon(Checker.class.getResource("image/false.png"));
    private static final ImageIcon WARNING_ICON = 
            new ImageIcon(Checker.class.getResource("image/warning.png"));
    
    private CheckResult checkResult;
    private CheckInfoGetter checkInfoGetter;

    public Checker(){
        this.setSize(25, 25);
        checkResult = CheckResult.UNCHECKED;
    }
    
    public Checker(JComponent infoComponent, CheckInfoGetter checkInfoGetter){
        this();
        this.setLocation(infoComponent.getX()+infoComponent.getWidth()+10, infoComponent.getY());
        infoComponent.getParent().add(this);
        this.checkInfoGetter = checkInfoGetter;
    }
    
    public boolean check(){
        CheckInfo checkInfo = checkInfoGetter.getCheckInfo();
        CheckResultMessage checkResultMessage = checkInfo.check();
        showResult(checkResultMessage);
        return isCorrect();
    }
    
    private void showResult(CheckResultMessage checkResultMessage){
        this.checkResult = checkResultMessage.getCheckResult();
        this.setToolTipText(checkResultMessage.getCheckInfo());
        
        ImageIcon imageIcon = null;
        switch (checkResult) {
        case CORRECT:
            imageIcon = CORRECT_ICON;
            break;
        case WARNING:
            imageIcon = WARNING_ICON;
            break;
        case FALSE:
            imageIcon = FALSE_ICON;
            break;
        default:
            break;
        }
        this.setIcon(imageIcon);
    }
   
    private boolean isCorrect(){
        return (checkResult != CheckResult.FALSE);
    }

}
