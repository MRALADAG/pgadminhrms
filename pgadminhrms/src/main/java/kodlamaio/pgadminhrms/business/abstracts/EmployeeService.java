package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.entities.concretes.Employees;

public interface EmployeeService {

	List<Employees> getAll();

	void addEmployee(Employees employees);

}
