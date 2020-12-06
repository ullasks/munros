package com.java.munro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.munro.orm.Munro;

@Repository
public interface MunroDao  extends JpaRepository<Munro, Long>,MunroRepositoryCustom{

}
