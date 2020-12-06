package com.java.munro.validator.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.java.munro.model.MunroFilterModel;
import com.java.munro.model.MunroFilterResponse;
import com.java.munro.validator.MunroValidator;

@RunWith(MockitoJUnitRunner.class)
public class MunroValidatorImplTest {

	MunroValidator testObj = null;

	@Before
	public void setup() {
		testObj = new MunroValidatorImpl();
	}
	@Test
	public void validateMunrosWithNoArgs() {
		MunroFilterModel filter = new MunroFilterModel();
		MunroFilterResponse response = new MunroFilterResponse();
		boolean actual = testObj.validate(filter, response);
		assertTrue(actual);
		
	}

	@Test
	public void validateMunrosLimitError() {
		MunroFilterModel filter = new MunroFilterModel();
		filter.setLimit(0);
		MunroFilterResponse response = new MunroFilterResponse();
		boolean actual = testObj.validate(filter, response);
		assertFalse(actual);
		assertEquals("Limit must be greater than 0", response.getErrorMessages().get(0));
	}
	@Test
	public void validateMunrosLimitSuccess() {
		MunroFilterModel filter = new MunroFilterModel();
		filter.setLimit(1);
		MunroFilterResponse response = new MunroFilterResponse();
		boolean actual = testObj.validate(filter, response);
		assertTrue(actual);
		assertEquals(0, response.getErrorMessages().size());
	}
	@Test
	public void validateMunrosValidHeightValidation() {
		MunroFilterModel filter = new MunroFilterModel();
		filter.setLimit(1);
		filter.setMinHeight(100d);
		filter.setMaxHeight(200d);
		MunroFilterResponse response = new MunroFilterResponse();
		boolean actual = testObj.validate(filter, response);
		assertTrue(actual);
		assertEquals(0, response.getErrorMessages().size());
	}
	@Test
	public void validateMunrosInvalidHeightValidation() {
		MunroFilterModel filter = new MunroFilterModel();
		filter.setLimit(1);
		filter.setMinHeight(1000d);
		filter.setMaxHeight(200d);
		MunroFilterResponse response = new MunroFilterResponse();
		boolean actual = testObj.validate(filter, response);
		assertFalse(actual);
		assertEquals( "Maximum munro height must be greater than or equal to min munro height",response.getErrorMessages().get(0));
	}
}
