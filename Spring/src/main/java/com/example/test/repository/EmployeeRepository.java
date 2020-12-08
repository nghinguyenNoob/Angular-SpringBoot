package com.example.test.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.test.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT COALESCE(MAX(e.id),0) FROM Employee e")
	int getMaxIdEmployee();

	@Modifying
	@Query(value = "INSERT INTO Employee (id,name,sdt,diachi) VALUES (:id,:name,:sdt,:diachi)", nativeQuery = true)
	@Transactional
	void saveEmployee(@Param("id") int id, @Param("name") String name, @Param("sdt") String sdt,
			@Param("diachi") String diachi);

	@Query("SELECT e FROM Employee e WHERE e.name LIKE %?1% Or e.sdt LIKE %?1% Or e.diachi LIKE %?1% ")
	List<Employee> searchEmployee(String textSearch);
}
