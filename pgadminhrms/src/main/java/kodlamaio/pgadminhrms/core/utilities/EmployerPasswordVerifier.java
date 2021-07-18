package kodlamaio.pgadminhrms.core.utilities;

import kodlamaio.pgadminhrms.entities.concretes.Employer;

public class EmployerPasswordVerifier implements PasswordCheckService<Employer> {

	@Override
	public boolean passwordVerifier(Employer employer) {

		return employer.getPassword().equals(employer.getPasswordRepetition());

	}

}
