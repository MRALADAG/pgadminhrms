package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.JobAdvertisementService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.ErrorDataResult;
import kodlamaio.pgadminhrms.core.utilities.results.ErrorResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessDataResult;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
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

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),
				"Bütün ilanlar listelenmiştir. ");

	}

	@Override
	public Result addJobAdvertise(JobAdvertisement advertisement) {

		this.jobAdvertisementDao.save(advertisement);
		return new SuccessResult("İlan sisteme başarıyla eklenmiştir. ");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllJobAdvertisementByActivationState(boolean activationState) {

		List<JobAdvertisement> advertiseList = this.jobAdvertisementDao.findAll();

		for (JobAdvertisement jobAdvertise : advertiseList) {
			if (!jobAdvertise.isActivationState())
				return new ErrorDataResult<List<JobAdvertisement>>("Sistemde aktif iş ilanı bulunmamaktadır. ");
		}

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByActivationState(activationState), "Aktif iş ilanları listelenmiştir. ");

	}

//	@Override
//	public DataResult<JobAdvertisement> isAdvertiseActivationStateTrue(int id) {
//
////		Boolean state = this.jobAdvertisementDao.isActivationStateTrue(id).isActivationState();
//		Boolean state = this.jobAdvertisementDao.getByIdAndActivationStateIsTrue(id).isActivationState();
//		if (state) {
//			return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByIdAndActivationStateIsTrue(id),
//					"İlan aktiftir. ");
//		} else if (!this.jobAdvertisementDao.getByIdAndActivationStateIsTrue(id).isActivationState()) {
//
//			return new ErrorDataResult<JobAdvertisement>("İş ilanı artık aktif değildir. ");
//
//		}
//
//		return new ErrorDataResult<JobAdvertisement>("Sistemde böyle bir ilan yoktur. ");
//
//	}

	@Override
	public Result existsByIdAndActivationStateIsTrue(int id) {

		if (!existsById(id)) {
			return new ErrorResult("Sistemde böyle bir ilan bulunmamaktadır. ");
		} else if (this.jobAdvertisementDao.existsByIdAndActivationStateIsTrue(id)) {
			return new SuccessResult("Aranan iş ilanı aktiftir.");
		}
		return new ErrorResult("Aranan iş ilanı yayından kaldırılmıştır. ");
	}

	@Override
	public DataResult<JobAdvertisement> findById(int id) {

		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id),
				"İlanlar id'ye göre listelenmiştir. ");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllJobAdvertisementByEmployerId(int id) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_Id(id),
				"İlanlar iş verene göre listelenmiştir. ");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisement() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActivationStateIsTrue(),
				"Sistemde kayıtlı bütün aktif iş ilanları listelenmiştir. ");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployerId(int id) {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByEmployer_IdAndActivationStateIsTrue(id),
				"İş verenin vermiş olduğu bütün aktif iş ilanları iş veren id'sine göre listelenmiştir. ");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployerName(String companyName) {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao
						.findByEmployer_CompanyNameContainsIgnoreCaseAndActivationStateIsTrue(companyName),
				"İş verenin vermiş olduğu bütün aktif iş ilanları iş veren id'sine göre listelenmiştir. ");

	}

	@Override
	public DataResult<JobAdvertisement> getByCompanyNameAndJobTitle(String companyName, String jobTitle) {

		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao
				.getByEmployer_CompanyNameAndJobPosition_JobTitleContainsIgnoreCase(companyName, jobTitle),
				"İlan işveren ismine ve iş pozisyonuna göre getirilmiştir. \n");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByCompanyName(String companyName) {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByEmployer_CompanyNameContainsIgnoreCase(companyName),
				"İş verenin bütün ilanları listelenmiştir. ");

	}

	@Override
	public boolean existsById(int id) {

		return this.jobAdvertisementDao.existsById(id);

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllAdvertiseByDateOfCreationAsc() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByOrderByDateOfCreationAsc(),
				"İlan tarihine göre aktif ilanlar artan sırada listelenmiştir. ");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementOrderByDateOfCreationAsc() {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByActivationStateIsTrueOrderByDateOfCreationAsc(),
				"İlan tarihine göre aktif ilanlar artan sırada listelenmiştir. ");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllAdvertiseByDateOfCreationDesc() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByOrderByDateOfCreationDesc(),
				"İlan tarihine göre aktif ilanlar azalan sırada listelenmiştir. ");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementOrderByDateOfCreationDesc() {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByActivationStateIsTrueOrderByDateOfCreationDesc(),
				"İlan tarihine göre aktif ilanlar azalan sırada listelenmiştir. ");

	}

	@Override
	public DataResult<JobAdvertisement> getByIdAndEmployer_Id(int id, int employerId) {

		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByIdAndEmployer_Id(id, employerId),
				"İlan numarası ve işveren no'ya göre ilan getirildi. ");

	}

	@Override
	public Result setActivationStateOfJobAdvertisementByEmployerIdAndAdvertisementId(int id, int employerId,
			boolean state) {

		JobAdvertisement temp = this.jobAdvertisementDao.getByIdAndEmployer_Id(id, employerId);
		temp.setActivationState(state);
		this.jobAdvertisementDao.save(temp);
		return new SuccessResult("İlanın yayın güncellenmiştir. ");

	}

}
