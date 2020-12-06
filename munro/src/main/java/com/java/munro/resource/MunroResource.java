package com.java.munro.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.munro.dao.MunroDao;
import com.java.munro.model.MunroFilterModel;
import com.java.munro.model.MunroFilterResponse;
import com.java.munro.orm.Munro;
import com.java.munro.service.MunroService;
import com.java.munro.service.impl.MunroServiceImpl;

@RestController
@RequestMapping("/munros")
public class MunroResource {

	Logger LOGGER = LoggerFactory.getLogger(MunroResource.class);

	
	@Autowired
	private MunroService munroServiceImpl;
	
	/*
	 * Suggestions/Assumptions
	 * Data type validation is not implemented , directly mapped the filter variable to MunroFilterModel
	 * and hence minHeight/maxHeight should be passed as double from the postman. 
	 * maxHeight =90 valid
	 * maxHeight=90t  invalid
	 * 
	 * response contains error msg, list of munros
	 * each munro contains the below info (we can avoid Id field if we use a corresponding model)
	 *      "id": 283,
            "name": "Braeriach",
            "height": 1296.0,
            "gridReference": "NN953999",
            "hillCategory": "MUN"
	 */

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public MunroFilterResponse searchMunros(MunroFilterModel filter) {
		LOGGER.info("Fetching the munro informations");
		return munroServiceImpl.findByFilter(filter);
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public void createMunros() throws IOException {
		munroServiceImpl.save();
		LOGGER.info("munros saved successfully in h2 db");
	}

	
}
