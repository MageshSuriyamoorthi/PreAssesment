package com.openmrs.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXlxsFile {
	public String[] xlxsvalReturn() throws IOException {

		int i = 0;
		String data[] = new String[11];
		FileInputStream excelFile = new FileInputStream("");

		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);

		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIt = sheet.rowIterator();
		while (rowIt.hasNext()) {
			Row row = rowIt.next();

			Iterator<Cell> cellIt = row.cellIterator();
			while (cellIt.hasNext()) {
				Cell cell = cellIt.next();
				//System.out.println(cell.toString());
				i++;
				data[i] = cell.toString();
				//System.out.println(data[i]);
			}
		}
		
		return data;
		
	}

}
