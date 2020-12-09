package com.example.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.Employee;

@Repository
public interface EmployeePageAndSortRepository extends PagingAndSortingRepository<Employee, Integer> {

	@Query("SELECT e FROM Employee e WHERE e.name LIKE %?1% Or e.phone LIKE %?1% Or e.address LIKE %?1% ")
	Page<Employee> findAllBySearch(String textSearch, Pageable pageable);
}
