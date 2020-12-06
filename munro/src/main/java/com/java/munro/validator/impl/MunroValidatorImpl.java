package com.java.munro.validator.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.java.munro.model.MunroFilterModel;
import com.java.munro.model.MunroFilterResponse;
import com.java.munro.validator.MunroValidator;

@Service
public class MunroValidatorImpl implements MunroValidator {

	@Override
	public boolean validate(MunroFilterModel filter, MunroFilterResponse response) {
		validateHeight(filter, response);
		validateLimit(filter, response);
		return CollectionUtils.isEmpty(response.getErrorMessages());
	}

	private void validateLimit(MunroFilterModel filter, MunroFilterResponse response) {
		if (null != filter.getLimit() && filter.getLimit() < 1) {
			response.getErrorMessages().add("Limit must be greater than 0");
		}
	}

	private void validateHeight(MunroFilterModel filter, MunroFilterResponse response) {
		if (filter.getMaxHeight() != null && filter.getMinHeight() != null
				&& filter.getMaxHeight() < filter.getMinHeight()) {
			response.getErrorMessages().add("Maximum munro height must be greater than or equal to min munro height");
		}
	}

}
