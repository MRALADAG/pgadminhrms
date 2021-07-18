package kodlamaio.pgadminhrms.business.concretes;

import kodlamaio.pgadminhrms.business.abstracts.AuthenticationService;
import kodlamaio.pgadminhrms.business.abstracts.JobSeekerService;
import kodlamaio.pgadminhrms.business.abstracts.EmployerService;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.JobSeeker;
import kodlamaio.pgadminhrms.entities.concretes.Employer;

public class AuthenticationManager implements AuthenticationService {

	private JobSeekerService jobSeekerService;
	private EmployerService employerService;

	@Override
	public Result checkIfValidJobSeeker(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result checkIfValidEmployer(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}

}
