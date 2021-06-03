package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.JobAdvertisementService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
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

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByActivationState(activationState), "Aktif iş ilanları listelenmiştir. ");

	}

	@Override
	public DataResult<JobAdvertisement> findById(int id) {

		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id),
				"İlanlar id'ye göre listelenmiştir. ");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllJobAdvertisementByEmployerId(int id) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_id(id),
				"İlanlar iş verene göre listelenmiştir.");

	}

	@Override
	public DataResult<JobAdvertisement> getByCompanyNameAndJobTitle(String companyName, String jobTitle) {

		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao
				.getByEmployer_CompanyNameAndJobPosition_JobTitleContainsIgnoreCase(companyName, jobTitle),
				"İlan işveren ismine ve iş pozisyonuna göre getirilmiştir. ");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByCompanyName(String companyName) {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByEmployer_CompanyNameContainsIgnoreCase(companyName),
				"İş verenin bütün ilanları listelenmiştir. ");

	}

}
