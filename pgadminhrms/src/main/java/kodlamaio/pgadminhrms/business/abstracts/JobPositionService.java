package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.JobPosition;

public interface JobPositionService {

	DataResult<List<JobPosition>> getAllJobTitle();

	Result addJobPosition(JobPosition jobPosition);

}
