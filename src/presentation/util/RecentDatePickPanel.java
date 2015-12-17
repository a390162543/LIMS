package presentation.util;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.RecentDate;

/**
 * 日期选择控件，用于近期日期选择
 * @author 林祖华
 * @version 1.1
 */
public class RecentDatePickPanel extends JPanel{
    
    
    
    /**
     * 
     */
    private static final long serialVersionUID = -6382895485366872530L;

    private JTextField dateTextField;
    private JButton popUpButton;
    private DatePicker datePicker;
    private Checker checker;
    
    public RecentDatePickPanel(){
        setSize(200, 25);
        setLayout(null);
        
        dateTextField = new JTextField();
        dateTextField.setBounds(0, 0, 120, 25);
        dateTextField.setEditable(false);
        SimpleDateFormat sdf = new SimpleDateFormat(
                "yyyy年MM月dd日");
        Date date = new Date();
        dateTextField.setText(sdf.format(date));
        popUpButton = new JButton("选择日期");
        popUpButton.setBounds(130, 0, 70, 25);
        datePicker = new DatePicker(popUpButton);
        datePicker.setDate(date);
        popUpButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checker == null){
                    checker = new Checker(RecentDatePickPanel.this, new CheckInfoGetter() {
                        
                        @Override
                        public CheckInfo getCheckInfo() {
                            return new RecentDate(RecentDatePickPanel.this.getDate());
                        }
                    });
                }
                datePicker.show();
            }
        });
        
        add(dateTextField);
        add(popUpButton);
        
    }
    
    public Date getDate(){
        return datePicker.getDate();
    }
    
    public Date getTime(){
        return datePicker.getTime();
    }
    
    public void setDate(Date date){
        datePicker.setDate(date);
        SimpleDateFormat sdf = new SimpleDateFormat(
                "yyyy年MM月dd日");
        dateTextField.setText(sdf.format(date));
        checker.check();
    }
    
    public void setTime(Date date){
        setDate(date);
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        // TODO Auto-generated method stub
        super.setEnabled(enabled);
        popUpButton.setEnabled(enabled);
        if(enabled == false)
            checker.discard();
    }
    
    
    public void addActionListener(ActionListener actionListener){
        dateTextField.addActionListener(actionListener);
    }
    
    private class DatePicker{
        private int month = Calendar.getInstance().get(Calendar.MONTH);
        private int year = Calendar.getInstance().get(Calendar.YEAR);
        private JLabel showDateLabel = new JLabel("", JLabel.CENTER);
        private String day = "";
        private JDialog showDateDialog;
        private JButton[] dateButtons = new JButton[49];
        private JComponent parent;
        public DatePicker(JComponent parent) {
            this.parent = parent;
            showDateDialog = new JDialog();
            showDateDialog.setLayout(null);
            showDateDialog.setSize(310, 182);
            showDateDialog.setTitle("日期选择");
            showDateDialog.setModalityType(ModalityType.APPLICATION_MODAL);
            String[] header = { "日", "一", "二", "三", "四", "五", "六" };
            JPanel p1 = new JPanel(new GridLayout(7, 7));
            p1.setBounds(0, 0, 300, 120);

            for (int x = 0; x < dateButtons.length; x++) {
                final int selection = x;
                dateButtons[x] = new JButton();
                dateButtons[x].setFocusPainted(false);
                dateButtons[x].setBackground(Color.white);
                if (x > 6)
                    dateButtons[x].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                            day = dateButtons[selection].getActionCommand();
                            if(day.equals(""))
                                return;
                            dateTextField.setText(getPickedDate());
                            if(RecentDatePickPanel.this.isEnabled()){
                                checker.check();
                            }
                            RecentDatePickPanel.this.getDate();
                            RecentDatePickPanel.this.getTime();
                            showDateDialog.dispose();
                        }
                    });
                if (x < 7) {
                    dateButtons[x].setText(header[x]);
                    dateButtons[x].setForeground(Color.red);
                }
                p1.add(dateButtons[x]);
            }
            JPanel p2 = new JPanel(new GridLayout(1, 3));
            p2.setBounds(0, 120, 300, 25);
            JButton previous = new JButton("上个月");
            previous.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    month--;
                    displayDate();
                }
            });
            p2.add(previous);
            p2.add(showDateLabel);
            JButton next = new JButton("下个月");
            next.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    month++;
                    displayDate();
                }
            });
            p2.add(next);
            showDateDialog.add(p1);
            showDateDialog.add(p2);
            displayDate();
        }
        
        
        private void displayDate() {
            for (int x = 7; x < dateButtons.length; x++)
                dateButtons[x].setText("");
            SimpleDateFormat sdf = new SimpleDateFormat(
                    "yyyy年MM月");
            Calendar cal = Calendar.getInstance();
            cal.set(year, month, 1);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
                dateButtons[x].setText("" + day);
            showDateLabel.setText(sdf.format(cal.getTime()));
        }

        public void show(){
            showDateDialog.setLocation(parent.getLocationOnScreen());
            showDateDialog.setVisible(true);
        }
        
        public String getPickedDate() {
            if (day.equals(""))
                return day;
            SimpleDateFormat sdf = new SimpleDateFormat(
                    "yyyy年MM月dd日");
            Calendar cal = Calendar.getInstance();
            cal.set(year, month, Integer.parseInt(day));
            return sdf.format(cal.getTime());
        }
        
        public Date getTime(){
            Calendar calendar = Calendar.getInstance();
            calendar.set(year,month,new Integer(day));
            return calendar.getTime();
        }
        
        public Date getDate(){
            Calendar calendar = Calendar.getInstance();
            calendar.set(year,month,new Integer(day),0,0,0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.getTime();
        }
        
        public void setDate(Date date){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            month = calendar.get(Calendar.MONTH);
            year = calendar.get(Calendar.YEAR);
            day = ""+calendar.get(Calendar.DATE);
        }
    }

    
    public static void main(String[] args) {
        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
//        RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
        DatePickPanel datePickPanel = new DatePickPanel();
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.getContentPane().add(datePickPanel);
        f.setVisible(true);
    }


    
}


