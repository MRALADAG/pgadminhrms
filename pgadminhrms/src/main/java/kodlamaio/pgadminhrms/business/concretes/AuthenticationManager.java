package kodlamaio.pgadminhrms.business.concretes;

import kodlamaio.pgadminhrms.business.abstracts.AuthenticationService;
import kodlamaio.pgadminhrms.business.abstracts.EmployeeService;
import kodlamaio.pgadminhrms.business.abstracts.EmployerService;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.Employee;
import kodlamaio.pgadminhrms.entities.concretes.Employer;

public class AuthenticationManager implements AuthenticationService {

	private EmployeeService employeeService;
	private EmployerService employerService;

	@Override
	public Result checkIfValidEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result checkIfValidEmployer(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}

}
