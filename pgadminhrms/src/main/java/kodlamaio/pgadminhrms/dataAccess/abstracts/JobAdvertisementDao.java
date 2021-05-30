package kodlamaio.pgadminhrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	DataResult<List<JobAdvertisement>> getByActivationState(boolean activationState);

	DataResult<JobAdvertisement> findById(int id);

	DataResult<List<JobAdvertisement>> getByEmployer_CompanyNameAndJobPosition_JobTitleContainsIgnoreCase(
			String companyName, String jobTitle);

	DataResult<List<JobAdvertisement>> findByEmployer_CompanyNameContainsIgnoreCase(String companyName);

}
