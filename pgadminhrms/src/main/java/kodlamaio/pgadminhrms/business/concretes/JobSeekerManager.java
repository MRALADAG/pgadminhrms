package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.EmailValidationService;
import kodlamaio.pgadminhrms.business.abstracts.JobSeekerService;
import kodlamaio.pgadminhrms.business.abstracts.UserCheckService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.ErrorResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessDataResult;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.pgadminhrms.dataAccess.abstracts.UserDao;
import kodlamaio.pgadminhrms.entities.concretes.JobSeeker;
import kodlamaio.pgadminhrms.entities.concretes.User;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserDao userDao;
	private UserCheckService userCheckService;

	@Autowired
	private EmailValidationService emailValidationService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserDao userDao,
			@Qualifier("FakeMernisValidateServiceJobSeeker") UserCheckService userCheckService) {

		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userDao = userDao;
		this.userCheckService = userCheckService;
		// this.emailValidationService = new EmailValidationManager();

	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelenmiştir.");
	}

	@Override
	public Result addJobSeeker(JobSeeker jobSeeker) {

		if (!isEmailExist(jobSeeker).isSuccess()) {

			return new ErrorResult(isEmailExist(jobSeeker).getMessage());

		} else if (!isNatIdExist(jobSeeker).isSuccess()) {

			return new ErrorResult(isNatIdExist(jobSeeker).getMessage());

		} else if (!this.userCheckService.checkIfRealPerson(jobSeeker).isSuccess()) {

			return new ErrorResult(this.userCheckService.checkIfRealPerson(jobSeeker).getMessage());

		}

		// this.emailValidationService.isEmailValid().getMessage();
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(
				"İş arayan sisteme eklenmiştir. " + this.emailValidationService.isEmailValid().getMessage() + " ");

	}

	private Result isNatIdExist(JobSeeker jobSeeker) {

		List<JobSeeker> jobSeekerId = this.jobSeekerDao.findAll();
		for (JobSeeker jobSeeker1 : jobSeekerId) {
			if (jobSeeker.getNationalityNumber().equals(jobSeeker1.getNationalityNumber()))
				return new ErrorResult("Daha önce aynı kimlik numarasıyla sistemde kayıt mevcuttur. ");

		}

		return new SuccessResult();

	}

	private Result isEmailExist(JobSeeker jobSeeker) {

		List<User> userList = this.userDao.findAll();
		for (User user : userList) {
			if (jobSeeker.getEmail().equals(user.getEmail()))
				return new ErrorResult("Daha önce aynı eposta adresiyle sistemde kayıt mevcuttur. ");
		}

		return new SuccessResult();

	}

	@Override
	public DataResult<JobSeeker> findById(int id) {

		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(id));

	}

	@Override
	public Result deleteInJobSeeker(int id) {

		this.jobSeekerDao.deleteById(id);
		return new SuccessResult("İş arayan kişinin kaydı silinmiştir. ");

	}
}
