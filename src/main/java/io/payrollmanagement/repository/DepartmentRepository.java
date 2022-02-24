package io.payrollmanagement.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.payrollmanagement.department.Department;

public interface DepartmentRepository extends CrudRepository<Department, String> {
	
	//public List<Company> findByCompanyId(String Id);
	Department findAllBydid(String id);
	List<Department> findAllByDeleted(int l);
	
}