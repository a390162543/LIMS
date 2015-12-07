package presentation.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * 日期选择控件，可选择当前年份+[-70,+20]之间的日期
 * @author 林祖华
 * @version 1.7
 */

public class DatePickPanel extends JPanel{
       
    /**
     * 
     */
    private static final long serialVersionUID = -6116982961568070651L;
    
    private JComboBox<Integer> yearComboBox;
    private JComboBox<Integer> monthComboBox;
    private JComboBox<Integer> dayComboBox;
    private Calendar calendar;

    public DatePickPanel(){
        
        setSize(180, 25);
        setLayout(null);
        
        yearComboBox = new JComboBox<Integer>();
        yearComboBox.setBounds(0, 0, 70, 25);
        monthComboBox = new JComboBox<Integer>();
        monthComboBox.setBounds(70, 0, 55, 25);
        dayComboBox = new JComboBox<Integer>();
        dayComboBox.setBounds(125, 0, 55, 25);
        
        calendar = Calendar.getInstance();
        for(int i=getYear()-70;i<getYear()+20;i++){
            yearComboBox.addItem(i);
        }
        for(int i=1;i<=12;i++){
            monthComboBox.addItem(i);
        }
        for(int i=1;i<=getDayOfMonth();i++){
            dayComboBox.addItem(i);
        }
        yearComboBox.setSelectedItem(calendar.get(Calendar.YEAR));
        monthComboBox.setSelectedItem(calendar.get(Calendar.MONTH)+1);
        dayComboBox.setSelectedItem(calendar.get(Calendar.DATE));
        
        yearComboBox.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.set(Calendar.YEAR, (int)yearComboBox.getSelectedItem());
                int selectedIndex = dayComboBox.getSelectedIndex();
                for(int i=dayComboBox.getItemCount();i>28;i--){
                    dayComboBox.removeItem(i);
                }
                for(int i=29;i<=getDayOfMonth();i++){
                    dayComboBox.addItem(i);
                }
                if(selectedIndex<dayComboBox.getItemCount())
                    dayComboBox.setSelectedIndex(selectedIndex);
            }
        });       
        monthComboBox.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.set(Calendar.MONTH, (int)monthComboBox.getSelectedItem()-1);
                int selectedIndex = dayComboBox.getSelectedIndex();
                for(int i=dayComboBox.getItemCount();i>28;i--){
                    dayComboBox.removeItem(i);
                }
                for(int i=29;i<=getDayOfMonth();i++){
                    dayComboBox.addItem(i);
                }
                if(selectedIndex<dayComboBox.getItemCount())
                    dayComboBox.setSelectedIndex(selectedIndex);
            }
        });

        
        yearComboBox.setToolTipText("年份");
        monthComboBox.setToolTipText("月份");
        dayComboBox.setToolTipText("日期");
        
        add(yearComboBox);
        add(monthComboBox);
        add(dayComboBox);
    }
    
    private int getDayOfMonth(){
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    private int getYear(){
        return calendar.get(Calendar.YEAR);
    }
    
    public Date getDate(){
        calendar.set(Calendar.DATE, (int)dayComboBox.getSelectedItem());
        return calendar.getTime();
    }
    
    public void setDate(Date date){
        calendar.setTime(date);
        yearComboBox.setSelectedItem(calendar.get(Calendar.YEAR));
        monthComboBox.setSelectedItem(calendar.get(Calendar.MONTH)+1);
        
        for(int i=dayComboBox.getItemCount();i>28;i--){
            dayComboBox.removeItem(i);
        }
        for(int i=29;i<=getDayOfMonth();i++){
            dayComboBox.addItem(i);
        }
        
        dayComboBox.setSelectedItem(calendar.get(Calendar.DATE));
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        // TODO Auto-generated method stub
        super.setEnabled(enabled);
        yearComboBox.setEnabled(false);
        monthComboBox.setEnabled(false);
        dayComboBox.setEnabled(false);
    }
    
    public void addActionListener(ActionListener listener){
        yearComboBox.addActionListener(listener);
        monthComboBox.addActionListener(listener);
        dayComboBox.addActionListener(listener);
    }
}
