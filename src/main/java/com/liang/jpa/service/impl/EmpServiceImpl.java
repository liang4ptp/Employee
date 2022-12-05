package com.liang.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liang.jpa.dao.EmpDAOJpa;
import com.liang.jpa.entity.Emp;
import com.liang.jpa.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpDAOJpa empDAOJpa;
	
	@Override
	public void addEmp(Emp emp) {
					
		empDAOJpa.save(emp);
		
	}
	@Override
	public void updateEmp(Emp emp) {
		empDAOJpa.save(emp);
	}
	
	@Override
	public void deleteEmpById(long empId) {
		
		empDAOJpa.deleteById(empId);
	}

	@Override
	public Optional<Emp> findByID(long empId) {

		return empDAOJpa.findById(empId);
	}

	@Override
	public List<Emp> findAllEmps() {

		return empDAOJpa.findAll();
	}




}
