package com.liang.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liang.jpa.entity.Emp;

@Repository
public interface EmpDAOJpa extends JpaRepository<Emp, Long> {

}
