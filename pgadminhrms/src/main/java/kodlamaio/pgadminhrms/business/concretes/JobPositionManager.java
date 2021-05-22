package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.JobPositionService;
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
	public List<JobPosition> getAllJobTitle() {

		return this.jobPositionDao.findAll();
	}

	@Override
	public void addJobPosition(JobPosition jobPosition) {

		this.jobPositionDao.save(jobPosition);

	}

}
