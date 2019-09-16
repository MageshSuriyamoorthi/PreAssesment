package com.openmrs.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlxsReader {

	private Workbook workBook = null;
	private Sheet sheet = null;
	private Row row = null;
	private Cell cell = null;
	private String cellValue;
	public String path = null;
	private FileInputStream fileInputStream = null;
	private FileOutputStream fileOutput = null;
	private String fileExtensionName;

	public String getCellDataByColumnName(String sheetName, String columnName, int rowIndex) {
		int columnIndex = -1;
		try {
			int index = workBook.getSheetIndex(sheetName);
			sheet = workBook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {
					columnIndex = i;
				}
			}
			if (columnIndex == -1) {
				return "Column doesn't exist with given name " + columnName;
			}
			return verifyCellData(rowIndex, columnIndex);
		} catch (Exception exception) {

			return "row " + rowIndex + " or column " + columnIndex + " does not exist  in xls";
		}
	}

	@SuppressWarnings("deprecation")
	public String verifyCellData(int rowIndex, int columnIndex) {
		row = sheet.getRow(rowIndex);
		if (row == null) {
			return "Data doesn't exist in given row";
		}
		cell = row.getCell(columnIndex);
		if (cell == null) {
			return "Data doesn't exist in given cell";
		}
		switch (cell.getCellTypeEnum()) {
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case NUMERIC:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case FORMULA:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case BLANK:
			cellValue = "";
			break;
		case BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;

		default:
			cellValue = "Invalid data type";
			break;
		}
		return cellValue;
	}

	public void setPath(String path) throws IOException {
		this.path = path;
		verifyExcelWorkBook(path);
	}

	private void verifyExcelWorkBook(String filePath) throws IOException {
		try {
			File file = new File(filePath);
			fileInputStream = new FileInputStream(file);
			fileExtensionName = FilenameUtils.getExtension(filePath);
			if (fileExtensionName.equals("xlsx")) {
				workBook = new XSSFWorkbook(fileInputStream);
			} else if (fileExtensionName.equals("xls")) {
				workBook = new HSSFWorkbook(fileInputStream);
			}
			fileInputStream.close();
		} catch (FileNotFoundException fileNotFoundException) {

			throw new FileNotFoundException("File doesn't exist in the given path: " + filePath);
		} catch (IOException ioException) {

			throw new IOException("File doesn't close properly: " + ioException.getMessage());
		}
	}

	public String getData(String filepath, String sheetName, int rowNum, int cellNum) {
		String data = "";

		try {
			setPath(filepath);
			sheet = workBook.getSheet(sheetName);
			data = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	public FileOutputStream getFileOutput() {
		return fileOutput;
	}

	public void setFileOutput(FileOutputStream fileOutput) {
		this.fileOutput = fileOutput;
	}

}