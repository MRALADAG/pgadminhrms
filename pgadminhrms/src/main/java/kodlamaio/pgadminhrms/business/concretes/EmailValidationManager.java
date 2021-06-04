package kodlamaio.pgadminhrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.EmailValidationService;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;

@Service
public class EmailValidationManager implements EmailValidationService {

	@Override
	public Result isEmailValid() {

		return new SuccessResult("Eposta doğrulaması başarılıdır. ");

	}

}
