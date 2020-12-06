package com.java.munro.service;

import java.io.IOException;

import com.java.munro.model.MunroFilterModel;
import com.java.munro.model.MunroFilterResponse;

public interface MunroService {

	MunroFilterResponse findByFilter(MunroFilterModel filter);

	void save() throws IOException ;

}
