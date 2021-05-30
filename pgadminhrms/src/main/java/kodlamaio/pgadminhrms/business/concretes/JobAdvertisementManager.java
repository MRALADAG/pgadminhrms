package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.JobAdvertisementService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.pgadminhrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllAdvertise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result addJobAdvertise(JobAdvertisement advertisement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllJobAdvertisementByActivationState(boolean activationState) {
		// TODO Auto-generated method stub
		return null;
	}

}
