package kodlamaio.pgadminhrms.business.abstracts;

import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.JobSeeker;
import kodlamaio.pgadminhrms.entities.concretes.Employer;

public interface AuthenticationService {

	Result checkIfValidJobSeeker(JobSeeker jobSeeker);

	Result checkIfValidEmployer(Employer employer);

}
