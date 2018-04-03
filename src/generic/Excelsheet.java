package generic;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excelsheet {
	public static String getValue(String path,String sheet, int row,int col){
		String val = "";
		System.out.println(sheet);
		System.out.println(path);
		System.out.println(row);
		System.out.println(col);
		try{
			System.out.println("inside try");
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			System.out.println(wb.getSheet(sheet));
			System.out.println(wb.getSheet(sheet).getRow(row));
			System.out.println(wb.getSheet(sheet).getRow(row).getCell(col));
			val = wb.getSheet(sheet).getRow(row).getCell(col).toString();
			System.out.println(val);
			System.out.println("inside try");
			System.out.println(val);
		}
		catch(Exception e)
		{
		}
		return val;
	}
	
	public static int getRowCount(String path,String sheet){
		int row_count = 0;
		try{
		
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			row_count = wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
		}
		
		return row_count;
	}
	
	public static int getColumnCount(String path,String sheet,int row){
		int column_count = 0;
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			column_count = wb.getSheet(sheet).getRow(row).getLastCellNum();
		}
		catch(Exception e)
		{
		}
		return column_count;
	}
	
}