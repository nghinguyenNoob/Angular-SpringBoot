package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.test.model.Employee;
import com.example.test.model.ResponseEmployee;
import com.example.test.repository.EmployeePageAndSortRepository;
import com.example.test.repository.EmployeeRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class EmployeeController {

	@Autowired
	EmployeePageAndSortRepository employeePagAndSortRepo;

	@Autowired
	EmployeeRepository employeeRepo;

	@PostMapping("save-employee/{id}")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
		employee.setId(id);
		try {
			return new ResponseEntity<>(employeeRepo.save(employee), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("employee-list") // not use
	public ResponseEntity<List<Employee>> getListEmployee() {
		List<Employee> listEmployee = employeeRepo.findAll();
		if (listEmployee != null) {
			return new ResponseEntity<>(listEmployee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("max-idemployee")
	public ResponseEntity<Integer> getMaxIdEmployee() {
		int maxIdEmployee = employeeRepo.getMaxIdEmployee();
		return new ResponseEntity<>(maxIdEmployee, HttpStatus.OK);
	}

	@GetMapping("get-employeebyid/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<>(employeeRepo.findById(id).get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("get-employeebysearch/{search}") // not use
	public ResponseEntity<List<Employee>> getEmployeeBySearch(@PathVariable("search") String search) {
		return new ResponseEntity<List<Employee>>(employeeRepo.searchEmployee(search), HttpStatus.OK);
	}

	@GetMapping("pageable")
	public ResponseEntity<ResponseEmployee> list(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "text", defaultValue = "") String text) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id"));
		ResponseEmployee emp;
		if (text.equals("")) {
			Page<Employee> pageResult = employeePagAndSortRepo.findAll(pageRequest);
			emp = new ResponseEmployee(pageResult.getContent(), pageResult.getTotalPages(), pageResult.getNumber(),
					pageResult.getSize());
		} else {
			Page<Employee> pageResult = employeePagAndSortRepo.findAllBySearch(text, pageRequest);
			emp = new ResponseEmployee(pageResult.getContent(), pageResult.getTotalPages(), pageResult.getNumber(),
					pageResult.getSize());
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@DeleteMapping("delete-employee/{id}")
	public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable("id") int id) {
		try {
			employeeRepo.deleteById(id);
			return new ResponseEntity<>(employeeRepo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(employeeRepo.findAll(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("update-employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
		employee.setId(id);
		try {
			return new ResponseEntity<>(employeeRepo.save(employee), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
