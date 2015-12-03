package businesslogicservice;

import java.io.File;
import java.io.IOException;

import javax.swing.JTable;

public interface ExcelExporterService {
	
	public boolean export(JTable table ,File file) throws IOException;
	
	public boolean export(JTable table1 ,JTable table2 ,File file) throws IOException;
}
