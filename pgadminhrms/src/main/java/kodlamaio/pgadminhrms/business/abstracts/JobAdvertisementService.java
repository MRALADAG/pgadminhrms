package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.JobAdvertisement;
import kodlamaio.pgadminhrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAllAdvertise();

	Result addJobAdvertise(JobAdvertisement advertisement);

	DataResult<List<JobAdvertisement>> getAllJobAdvertisementByActivationState(boolean activationState);
//	List<JobAdvertisement> getByActivationState(boolean activationState);

//	DataResult<JobAdvertisement> isAdvertiseActivationStateTrue(int id);
	Result existsByIdAndActivationStateIsTrue(int id);

	DataResult<JobAdvertisement> findById(int id);

	boolean existsById(int id);

	DataResult<List<JobAdvertisement>> getAllJobAdvertisementByEmployerId(int id);
//	List<JobAdvertisement> getByEmployer_Id(int id);

	DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisement();
//	List<JobAdvertisement> findByActivationStateIsTrue();

	DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployerId(int id);
//	List<JobAdvertisement> findByEmployer_IdAndActivationStateIsTrue(int id);

	DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployerName(String companyName);
//	List<JobAdvertisement> findByEmployer_CompanyNameContainsIgnoreCaseAndActivationStateIsTrue(String companyName);

	DataResult<JobAdvertisement> getByCompanyNameAndJobTitle(String companyName, String jobTitle);
//	JobAdvertisement getByEmployer_CompanyNameAndJobPosition_JobTitleContainsIgnoreCase(String companyName,
//			String jobTitle);

	DataResult<List<JobAdvertisement>> getAllByCompanyName(String companyName);
//	List<JobAdvertisement> findByEmployer_CompanyNameContainsIgnoreCase(String companyName);

	DataResult<List<JobAdvertisement>> getAllAdvertiseByDateOfCreationAsc();
//	List<JobAdvertisement> findAllOrderByDateOfCreationAsc();

	DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementOrderByDateOfCreationAsc();
//	List<JobAdvertisement> findByActivationStateIsTrueOrderByDateOfCreationAsc();

	DataResult<List<JobAdvertisement>> getAllAdvertiseByDateOfCreationDesc();
//	List<JobAdvertisement> findAllOrderByDateOfCreationDesc();

	DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementOrderByDateOfCreationDesc();
//	List<JobAdvertisement> findByActivationStateIsTrueOrderByDateOfCreationDesc();

	DataResult<JobAdvertisement> getByIdAndEmployer_Id(int id, int employerId);

	Result setActivationStateOfJobAdvertisementByEmployerIdAndAdvertisementId(int id, int employerId, boolean state);

	DataResult<List<JobAdvertisementDto>> getAllJobAdvertisementDto();

	Result addJobAdvertisementDto(JobAdvertisementDto advertisementDto);

}
