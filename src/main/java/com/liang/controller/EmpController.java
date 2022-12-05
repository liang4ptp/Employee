package com.liang.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liang.jpa.entity.Emp;
import com.liang.jpa.service.EmpService;


@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping(value = "/check")
	public String checkConnection() {
		
		return "The connection is fine!";
	}
	
	@GetMapping(value = "/allEmps")
	public List<Emp> findEmps(){
		
		return empService.findAllEmps();
	}
	
	@GetMapping(value = "/oneEmp/{empId}")
	public Optional<Emp> findEmp(@PathVariable(value = "empId") long empId) {
		
		return empService.findByID(empId);
	};
	
	@PostMapping(value = "/addEmp/{empName}")
	public void addEmp(@PathVariable(value = "empName") String empName) {
		Emp emp = new Emp(empName);
		empService.addEmp(emp);
	}
	
	@PutMapping(value = "/updateEmp/{empId}/{empName}")
	@Transactional
	public void updateEmp(@PathVariable(value = "empId" ) long empId, @PathVariable(value = "empName") String empName) {
		Emp emp = empService.findByID(empId).orElseThrow();
		emp.setEmpName(empName);
		empService.updateEmp(emp);
	}
	
	@DeleteMapping(value = "deleteEmp/{empId}")
	@Transactional
	public void deleteEmp(@PathVariable long empId) {
		
		empService.deleteEmpById(empId);
	}
	
}

