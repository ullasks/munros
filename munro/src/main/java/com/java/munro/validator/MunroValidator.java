package com.java.munro.validator;

import com.java.munro.model.MunroFilterModel;
import com.java.munro.model.MunroFilterResponse;

public interface MunroValidator {

	boolean validate(MunroFilterModel filter, MunroFilterResponse response);

}
