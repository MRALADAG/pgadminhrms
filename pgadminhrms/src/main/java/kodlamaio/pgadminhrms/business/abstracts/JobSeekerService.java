package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();

	Result addJobSeeker(JobSeeker jobSeeker);

	DataResult<JobSeeker> findById(int id);

	Result deleteInJobSeeker(int id);

}
