package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.entities.concretes.UserVerification;

public interface UserVerificationService {

	List<UserVerification> getAll();
}
