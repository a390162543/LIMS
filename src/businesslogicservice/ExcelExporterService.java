package businesslogicservice;

import java.io.File;
import java.io.IOException;

import javax.swing.JTable;
 
/**
 * {@code ExcelExporterService}提供给界面层导出Excel的相关服务
 * @author 刘德宽
 *
 */
public interface ExcelExporterService {
	/**
	 * 将传入的{@code JTable}的内容写到{@code File} 文件里
	 * @param table {@code JTable}
	 * @param file {@code File}
	 * @return 成功则返回{@code True},否则返回{@code False}
	 * @throws IOException
	 */
	public boolean export(JTable table ,File file) throws IOException;
	
	/**
	 * 将传入的两个{@code JTable}的内容写到{@code File} 文件里
	 * @param table1 {@code JTable}
	 * @param table2 {@code JTable}
	 * @param file {@code File}
	 * @return 成功则返回{@code True},否则返回{@code False}
	 * @throws IOException
	 */
	public boolean export(JTable table1 ,JTable table2 ,File file) throws IOException;
}
