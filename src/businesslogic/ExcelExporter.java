package businesslogic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import businesslogicservice.ExcelExporterService;

public class ExcelExporter implements ExcelExporterService{

	@Override
	public boolean export(JTable table, File file) throws IOException {
		TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);
        
        for(int i=0; i < model.getColumnCount(); i++) {
            out.write(model.getColumnName(i)+"\t");
        }
        out.write("\n");
        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                out.write(model.getValueAt(i,j).toString()+"\t");
            }
            out.write("\n");
        }
        out.close();
        System.out.println("write out to: " + file);
		return true;
	}
	
	@Override
	public boolean export(JTable table1, JTable table2, File file)
			throws IOException {
		TableModel model1 = table1.getModel();
		TableModel model2 = table2.getModel();
        FileWriter out = new FileWriter(file);
        
        for(int i=0; i < model1.getColumnCount(); i++) {
            out.write(model1.getColumnName(i)+"\t");
        }
        out.write("\n");
        for(int i=0; i< model1.getRowCount(); i++) {
            for(int j=0; j < model1.getColumnCount(); j++) {
                out.write(model1.getValueAt(i,j).toString()+"\t");
            }
            out.write("\n");
        }
        for(int i=0; i < model2.getColumnCount(); i++) {
            out.write(model2.getColumnName(i)+"\t");
        }
        out.write("\n");
        for(int i=0; i< model2.getRowCount(); i++) {
            for(int j=0; j < model2.getColumnCount(); j++) {
                out.write(model2.getValueAt(i,j).toString()+"\t");
            }
            out.write("\n");
        }
        out.close();
		return true;
	}

}
