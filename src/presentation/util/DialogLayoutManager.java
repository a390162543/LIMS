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

public class DialogLayoutManager implements LayoutManager{
    //�߾�
    private static final int LEFT_DISTANCE = 0;
    private static final int RIGHT_DISTANCE = 20;
    private static final int UP_DISTANCE = 15;
    private static final int DOWN_DISTANCE = 20;
    //���������˱߾�
    private static final int COMPONENT_DISTANCE = 100;

    //�о�
    private static final int ROW_DISTANCE = 10;
    
    //��ͨ����߶�
    private static final int HEIGHT = 25;
    private static final int Y_DISTANCE = HEIGHT + ROW_DISTANCE;
    
    //button��ȣ��߶�
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 30;
    
    //�������߶�
    private static final int TITLE_HEIGHT = 30;
    
    
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
            //���label��container�е�����λ��
            ArrayList<Integer> labels = new ArrayList<Integer>();
            //���button��container�е�����λ��
            ArrayList<Integer> buttons = new ArrayList<Integer>();
            //���label��container�е�λ��
            ArrayList<Point> points = new ArrayList<Point>();
            //�����������ĸ߶�
            int y = UP_DISTANCE;
            //�����������������
            int maxComponentWidth = 0;
            boolean hasButton = false;
            //�ж�ÿһ�����
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
                    //��¼��һ��label��λ��
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
            //����label��λ��
            for(int i=0;i<labels.size();i++){
                components[labels.get(i)].setLocation(points.get(i));
            }
            //����button��λ��
            int button_x = COMPONENT_DISTANCE + maxComponentWidth - BUTTON_WIDTH;
            int button_y = y;
            for(int i=0;i<buttons.size();i++){
                components[buttons.get(i)].setLocation(button_x, button_y);
                button_x -= (BUTTON_WIDTH + ROW_DISTANCE); 
            }
            //����dialog��λ��
            int dialog_x = COMPONENT_DISTANCE + maxComponentWidth + RIGHT_DISTANCE;
            int dialog_y = y + TITLE_HEIGHT + DOWN_DISTANCE;
            
            if(hasButton){
                dialog_y += BUTTON_HEIGHT;
            }
            //�޸�dialog�Ĵ�С
            JDialog dialog = (JDialog) parent.getParent().getParent().getParent();
            dialog.setSize(dialog_x, dialog_y);
        }
    }
    
    public static void fix(JComponent ...components){
        if(components.length <= 1)
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
