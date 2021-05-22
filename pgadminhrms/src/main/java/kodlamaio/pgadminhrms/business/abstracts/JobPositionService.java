package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.entities.concretes.JobPosition;

public interface JobPositionService {

	List<JobPosition> getAllJobTitle();

	void addJobPosition(JobPosition jobPosition);

}
