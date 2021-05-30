package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAllAdvertise();

	Result addJobAdvertise(JobAdvertisement advertisement);

	DataResult<List<JobAdvertisement>> getAllJobAdvertisementByActivationState(boolean activationState);

}
