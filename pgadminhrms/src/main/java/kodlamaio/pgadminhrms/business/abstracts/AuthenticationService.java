package kodlamaio.pgadminhrms.business.abstracts;

import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.Employee;
import kodlamaio.pgadminhrms.entities.concretes.Employer;

public interface AuthenticationService {

	Result checkIfValidEmployee(Employee employee);

	Result checkIfValidEmployer(Employer employer);

}
