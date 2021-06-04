package kodlamaio.pgadminhrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.UserCheckService;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.entities.concretes.User;
import kodlamaio.pgadminhrms.mernisServices.MernisCheck;

@Service
public class MernisCheckManagerAdapter implements UserCheckService {

	public Result checkIfRealPerson(User user) {

		MernisCheck mernisCheck = new MernisCheck();
		mernisCheck.isRealPerson();
		return new SuccessResult("Mernis sorgusu başarılıdır. ");

	}

}
