package kodlamaio.pgadminhrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.UserCheckService;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.entities.concretes.Staff;

@Service("FakeMernisValidateServiceStaff")
public class FakeMernisValidateServiceForStaff implements UserCheckService<Staff> {

	@Override
	public Result checkIfRealPerson(Staff user) {

		return new SuccessResult("Mernis sorgusu başarılıdır. ");

	}

}
