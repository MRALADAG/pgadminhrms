package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.JobPositionService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessDataResult;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.pgadminhrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAllJobTitle() {

		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "İş pozisyonları listelendi.");

	}

	@Override
	public Result addJobPosition(JobPosition jobPosition) {

		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu başarıyla eklendi.");

	}

}
