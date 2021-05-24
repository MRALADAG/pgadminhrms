package kodlamaio.pgadminhrms.business.abstracts;

import kodlamaio.pgadminhrms.entities.concretes.Employee;

public interface UserCheckService {

	boolean CheckIfRealPerson(Employee employee);

}
