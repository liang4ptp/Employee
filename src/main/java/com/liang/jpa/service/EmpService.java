package com.liang.jpa.service;

import java.util.List;
import java.util.Optional;

import com.liang.jpa.entity.Emp;

public interface EmpService {
	
	void addEmp(Emp emp);
	
	void updateEmp(Emp emp);
	
	void deleteEmpById(long empId);
	
	Optional<Emp> findByID(long empId);
	
	List<Emp> findAllEmps();
}
