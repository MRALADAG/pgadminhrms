package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.UserVerification;

public interface UserVerificationService {

	DataResult<List<UserVerification>> getAllValidUser();

	Result addValidEmployer(UserVerification userVerification);

	Result deleteUserById(int id);

}
