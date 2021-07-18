package kodlamaio.pgadminhrms.core.utilities;

import kodlamaio.pgadminhrms.entities.concretes.JobSeeker;

public class JobSeekerPasswordVerifier implements PasswordCheckService<JobSeeker> {

	@Override
	public boolean passwordVerifier(JobSeeker jobSeeker) {

		return jobSeeker.getPassword().equals(jobSeeker.getPasswordRepetition());

	}

}
