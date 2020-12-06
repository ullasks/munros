package com.java.munro.dao;

import java.util.List;

import com.java.munro.model.MunroFilterModel;
import com.java.munro.orm.Munro;

public interface MunroRepositoryCustom {
	
	List<Munro> findByFilter(MunroFilterModel filter);
}
