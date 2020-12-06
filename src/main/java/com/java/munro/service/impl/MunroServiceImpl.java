package com.java.munro.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.munro.dao.MunroDao;
import com.java.munro.model.MunroFilterModel;
import com.java.munro.model.MunroFilterResponse;
import com.java.munro.orm.Munro;
import com.java.munro.service.MunroService;
import com.java.munro.validator.MunroValidator;

@Service
public class MunroServiceImpl implements MunroService {

	@Autowired
	private MunroDao repository;

	@Autowired
	private MunroValidator munroValidatorImpl;

	@Override
	public MunroFilterResponse findByFilter(MunroFilterModel filter) {

		MunroFilterResponse response = new MunroFilterResponse();
		if (munroValidatorImpl.validate(filter, response)) {
			response.setMunros(repository.findByFilter(filter));
		}

		return response;
	}

	@Override
	public void save() throws IOException {

		FileInputStream inputStream = new FileInputStream(new File("munro.xlsx"));
		Workbook workbook = new XSSFWorkbook(inputStream);

		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			int rowNumber = nextRow.getRowNum();

			int nameCellNo = 5;
			int heightCellNo = 9;
			int gridRefCellNo = 13;
			int hillCatCellNo = 27;

			if (rowNumber != 0) {
				Munro munro = new Munro();
				if (null != getCellValue(nextRow.getCell(nameCellNo))) {
					munro.setName((String) getCellValue(nextRow.getCell(nameCellNo)));
				}
				if (null != getCellValue(nextRow.getCell(heightCellNo))) {
					munro.setHeight((Double) getCellValue(nextRow.getCell(heightCellNo)));
				}
				if (null != getCellValue(nextRow.getCell(gridRefCellNo))) {
					munro.setGridReference((String) getCellValue(nextRow.getCell(gridRefCellNo)));
				}
				if (null != getCellValue(nextRow.getCell(hillCatCellNo))) {
					munro.setHillCategory((String) getCellValue(nextRow.getCell(hillCatCellNo)));
				}

					repository.save(munro);
			}
		}

		workbook.close();
		inputStream.close();

	}

	private Object getCellValue(Cell cell) {
		if (null != cell) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				return cell.getStringCellValue();
			case Cell.CELL_TYPE_NUMERIC:
				return cell.getNumericCellValue();
			}
		}
		return null;
	}

}
