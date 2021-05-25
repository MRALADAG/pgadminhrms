package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.entities.concretes.UserVerification;

public interface UserVerificationService {

	DataResult<List<UserVerification>> getAllValidUser();

}
