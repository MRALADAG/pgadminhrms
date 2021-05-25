package kodlamaio.pgadminhrms.business.concretes;

import kodlamaio.pgadminhrms.business.abstracts.UserCheckService;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.entities.concretes.Employee;
import kodlamaio.pgadminhrms.mernisServices.MernisCheck;

public class MernisCheckManagerAdapter implements UserCheckService {

	Result CheckIfRealPerson(Employee employee) {

		MernisCheck mernisCheck = new MernisCheck();
		mernisCheck.isRealPerson();
		return new SuccessResult("Mernis sorgusu başarılıdır.");

	}

}
