package businesslogicservice;

import java.io.File;
import java.io.IOException;

import javax.swing.JTable;
 
/**
 * {@code ExcelExporterService}�ṩ������㵼��Excel����ط���
 * @author ���¿�
 *
 */
public interface ExcelExporterService {
	/**
	 * �������{@code JTable}������д��{@code File} �ļ���
	 * @param table {@code JTable}
	 * @param file {@code File}
	 * @return �ɹ��򷵻�{@code True},���򷵻�{@code False}
	 * @throws IOException
	 */
	public boolean export(JTable table ,File file) throws IOException;
	
	/**
	 * �����������{@code JTable}������д��{@code File} �ļ���
	 * @param table1 {@code JTable}
	 * @param table2 {@code JTable}
	 * @param file {@code File}
	 * @return �ɹ��򷵻�{@code True},���򷵻�{@code False}
	 * @throws IOException
	 */
	public boolean export(JTable table1 ,JTable table2 ,File file) throws IOException;
}
