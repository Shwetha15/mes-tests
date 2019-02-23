package com.mes.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class StoreData {
	
	public static void toExcel(String fileName,String sheetName,int rowIndex,int cellIndex,String data)
	{
	try {
		File f = new File("./test-data/"+fileName+".xlsx");
	    FileInputStream fis = new FileInputStream(f);
	    Workbook wb= WorkbookFactory.create(fis);
	    Sheet st=wb.getSheet(sheetName);
	    Row r=st.getRow(rowIndex);
	    Cell c=r.getCell(cellIndex);
	    c.setCellValue(data);
    FileOutputStream fos = new FileOutputStream(f);
    wb.write(fos);
	}
	catch(Exception e) {
		e.printStackTrace();
		
	}

}
	
	public static void toProperties(String fileName,String key,String value,String comments)
	{
	try {
	File f = new File("./config-data/"+fileName+".properties");
    FileInputStream fis = new FileInputStream(f);
    Properties prop= new Properties();
    prop.load(fis);
    prop.put(key, value);
    FileOutputStream fos = new FileOutputStream(f);
    prop.store(fos, comments);
	}
	catch(Exception e) {
		e.printStackTrace();
		
	}

}


}
