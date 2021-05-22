package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.EmployeeService;
import kodlamaio.pgadminhrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.pgadminhrms.entities.concretes.Employees;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employees> getAll() {

		return this.employeeDao.findAll();
	}

	@Override
	public void addEmployee(Employees employees) {

		this.employeeDao.save(employees);

	}

}
