package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.Employee;

public interface EmployeeService {

	DataResult<List<Employee>> getAll();

	Result addEmployee(Employee employee);

	DataResult<Employee> findById(int id);

	Result deleteInEmployee(int id);

}
