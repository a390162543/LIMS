package presentation.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.mainui.MainFrame;

/**
 * 专门为{@code JDialog}设计的一种{@code LayoutManager}的实现类
 * <p>将除了{@code JLabel}，{@code JButton}之外的组件由右上方往下
 *排开，{@code JLabel}从左上方往下排开，与右边的组件对齐。{@code JButton}
 *则会从右下方往左排列
 *
 *<p><strong>需要注意组件在{@code JDialog}的添加顺序</strong>
 * @author 林祖华
 * @version 1.9
 *
 */
public class DialogLayoutManager implements LayoutManager{
    //边距
    private static final int LEFT_DISTANCE = 0;
    private static final int RIGHT_DISTANCE = 30;
    private static final int UP_DISTANCE = 15;
    private static final int DOWN_DISTANCE = 20;
    //组件距离左端边距
    private static final int COMPONENT_DISTANCE = 100;

    //行距
    private static final int ROW_DISTANCE = 10;
    
    //普通组件高度
    private static final int HEIGHT = 25;
    private static final int Y_DISTANCE = HEIGHT + ROW_DISTANCE;
    
    //button宽度，高度
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 30;
    
    //标题栏高度
    private static final int TITLE_HEIGHT = 30;
    
    private boolean setCenter = true;
    
    @Override
    public void addLayoutComponent(String name, Component comp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        synchronized (parent.getTreeLock()) {
            Component[] components = parent.getComponents();
            int componentNum = components.length;
            //存放label在container中的索引位置
            ArrayList<Integer> labels = new ArrayList<Integer>();
            //存放button在container中的索引位置
            ArrayList<Integer> buttons = new ArrayList<Integer>();
            //存放label在container中的位置
            ArrayList<Point> points = new ArrayList<Point>();
            //用来标记组件的高度
            int y = UP_DISTANCE;
            //用来标记组件的最大宽度
            int maxComponentWidth = 0;
            boolean hasButton = false;
            //判断每一个组件
            for(int i=0;i<componentNum;i++){
                Component c = components[i];
                if(c instanceof Checker){
                    int checker_x = (int) (c.getLocation().getX() + c.getWidth() - COMPONENT_DISTANCE);
                    maxComponentWidth = Math.max(maxComponentWidth, checker_x);
                    continue;
                }else if(c instanceof JButton){
                    hasButton = true;
                    buttons.add(i);
                }else if(c instanceof JLabel){
                    labels.add(i);
                    labelAdjust((JLabel) c);
                }else {
                    //记录下一个label的位置
                    Point p = new Point(LEFT_DISTANCE, y);
                    points.add(p);
                    c.setLocation(COMPONENT_DISTANCE, y);
                    maxComponentWidth = Math.max(maxComponentWidth, c.getWidth());
                    if(c instanceof JPanel || c instanceof JScrollPane){
                        y += c.getHeight()+ROW_DISTANCE;
                    }else{
                        heightAdjust(c, HEIGHT);
                        y += Y_DISTANCE;
                    }
                }
            }
            //设置label的位置
            for(int i=0;i<labels.size();i++){
                components[labels.get(i)].setLocation(points.get(i));
            }
            //设置button的位置
            int button_x = COMPONENT_DISTANCE + maxComponentWidth - BUTTON_WIDTH;
            int button_y = y;
            for(int i=0;i<buttons.size();i++){
                components[buttons.get(i)].setLocation(button_x, button_y);
                button_x -= (BUTTON_WIDTH + ROW_DISTANCE); 
            }
            //设置dialog的位置
            int dialog_x = COMPONENT_DISTANCE + maxComponentWidth + RIGHT_DISTANCE;
            int dialog_y = y + TITLE_HEIGHT + DOWN_DISTANCE;
            
            if(hasButton){
                dialog_y += BUTTON_HEIGHT;
            }
            //修改dialog的大小
            JDialog dialog = (JDialog) parent.getParent().getParent().getParent();
            dialog.setSize(dialog_x, dialog_y);
            if(setCenter){
                dialog.setLocationRelativeTo(MainFrame.getMainFrame());
                setCenter = false;
            }
        }
    }
    
    /**
     * 固定一个或多个{@code JComponent}的相对位置
     * @param components 需要固定相对位置的组件
     */
    public static void fix(JComponent ...components){
        if(components.length == 0)
            return;
        
        Container container = components[0].getParent();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        container.add(panel);
        int panel_x = 0;
        int panel_y = 0;
        
        Point fixedLocation = components[0].getLocation();
        for(int i=0;i<components.length;i++){
            Point originalLocation = components[i].getLocation();
            int x = originalLocation.x - fixedLocation.x;
            int y = originalLocation.y - fixedLocation.y;
            Point newLocation = new Point(x,y);
            
            container.remove(components[i]);
            panel.add(components[i]);
            components[i].setLocation(newLocation);
            panel_x = Math.max(x+components[i].getWidth(), panel_x);
            panel_y = Math.max(y+components[i].getHeight(), panel_y);
        }
        panel.setSize(panel_x, panel_y);
    }
    
    private void heightAdjust(Component c, int height){
        int width = c.getWidth();
        c.setSize(width, height);
    }
    
    private void labelAdjust(JLabel label){
        label.setSize(COMPONENT_DISTANCE-LEFT_DISTANCE, HEIGHT);
        label.setHorizontalAlignment(JLabel.CENTER);
    }
}
