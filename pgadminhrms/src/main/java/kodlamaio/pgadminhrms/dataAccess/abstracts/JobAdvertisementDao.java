package kodlamaio.pgadminhrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.pgadminhrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByActivationState(boolean activationState);

//	@Query("From JobAdvertisement WHERE activationState =:true and id=:id")
//	JobAdvertisement isActivationStateTrue(int id);

//	JobAdvertisement getByIdAndActivationStateIsTrue(int id);
	boolean existsByIdAndActivationStateIsTrue(int id);

	JobAdvertisement findById(int id);

	boolean existsById(int id);

	List<JobAdvertisement> getByEmployer_Id(int id);

	List<JobAdvertisement> findByActivationStateIsTrue();

	List<JobAdvertisement> findByEmployer_IdAndActivationStateIsTrue(int id);

	List<JobAdvertisement> findByEmployer_CompanyNameContainsIgnoreCaseAndActivationStateIsTrue(String companyName);

	JobAdvertisement getByEmployer_CompanyNameAndJobPosition_JobTitleContainsIgnoreCase(String companyName,
			String jobTitle);

	List<JobAdvertisement> findByEmployer_CompanyNameContainsIgnoreCase(String companyName);

	List<JobAdvertisement> findByOrderByDateOfCreationAsc();

	List<JobAdvertisement> findByOrderByDateOfCreationDesc();

}
