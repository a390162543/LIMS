package presentation.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class PresentationUtil {
	
	   public static void fitTableColumns(JTable myTable){
	       TableColumnModelListener tableColumnModelListener = new TableColumnModelListener() {
                
                @Override
                public void columnSelectionChanged(ListSelectionEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                
                @Override
                public void columnRemoved(TableColumnModelEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                
                @Override
                public void columnMoved(TableColumnModelEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                
                @Override
                public void columnMarginChanged(ChangeEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                
                @Override
                public void columnAdded(TableColumnModelEvent e) {
                    JTableHeader header = myTable.getTableHeader();
                    int rowCount = myTable.getRowCount();
                    int columnCount = myTable.getColumnCount();
                    Enumeration<TableColumn> columns = myTable.getColumnModel().getColumns();
                    int tableWidth = myTable.getWidth();
                    int[] widths = new int[columnCount];
    
                    for(int i=0;i<columnCount;i++){
                        TableColumn column = (TableColumn)columns.nextElement();
                        int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
                        int width = (int)myTable.getTableHeader().getDefaultRenderer()
                                .getTableCellRendererComponent(myTable, column.getIdentifier()
                                        , false, false, -1, col).getPreferredSize().getWidth();
                        for(int row = 0; row<rowCount; row++){
                            int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
                                      myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                            width = Math.max(width, preferedWidth);
                        }
    
                        header.setResizingColumn(column);
                        int newWidth = width+myTable.getIntercellSpacing().width + 10;
                        column.setWidth(newWidth);
                        widths[i] = newWidth;
                    }
                    int totalWidth = myTable.getColumnModel().getTotalColumnWidth();
                    if(totalWidth < tableWidth){
                        tableWidth -= 8;
                        for(int i=0;i<columnCount;i++){
                            TableColumn column = myTable.getColumnModel().getColumn(i);;
                            header.setResizingColumn(column);
                            int newWidth = (int) (widths[i]*1.0*tableWidth/totalWidth);
                            column.setWidth(newWidth);
                            column.setPreferredWidth(newWidth);
                        }
                    }
                    
                }
                    
                
            };
            myTable.getColumnModel().addColumnModelListener(tableColumnModelListener);
            tableColumnModelListener.columnAdded(null);
            
            DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
            r.setHorizontalAlignment(JLabel.LEFT);
            myTable.setDefaultRenderer(Object.class,r);
            
            myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

	   }
	   
	   
	    public static String getDate(Date date){
	        return new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ").format(date);
	    }
}
