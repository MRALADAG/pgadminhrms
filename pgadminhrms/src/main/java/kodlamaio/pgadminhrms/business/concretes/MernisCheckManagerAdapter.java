package kodlamaio.pgadminhrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.UserCheckService;
import kodlamaio.pgadminhrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.pgadminhrms.entities.concretes.Employee;
import kodlamaio.pgadminhrms.mernisServices.MernisCheck;

@Service
public class MernisCheckManagerAdapter implements UserCheckService {

	private EmployeeDao employeeDao;

	@Autowired
	public MernisCheckManagerAdapter(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public boolean CheckIfRealPerson(Employee employee) {

		return new MernisCheck().isRealPerson();

	}

}
