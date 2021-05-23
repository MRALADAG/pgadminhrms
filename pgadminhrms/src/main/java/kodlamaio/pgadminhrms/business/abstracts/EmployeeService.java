package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.entities.concretes.Employee;

public interface EmployeeService {

	List<Employee> getAll();

	void addEmployee(Employee employees);

}
