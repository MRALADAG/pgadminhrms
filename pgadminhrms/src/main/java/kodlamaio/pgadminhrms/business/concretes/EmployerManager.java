package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.EmailValidationService;
import kodlamaio.pgadminhrms.business.abstracts.EmployerService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.ErrorResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessDataResult;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.pgadminhrms.entities.concretes.Employer;
import kodlamaio.pgadminhrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	private EmailValidationService emailValidationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),
				"İşverenler başarılı bir şekilde listelenmiştir. "
						+ this.emailValidationService.isEmailValid().getMessage());

	}

	@Override
	public Result addEmployer(Employer employer) {

		if (!isEmailExist(employer).isSuccess()) {
			return new ErrorResult(isEmailExist(employer).getMessage());
		} else if (!domainController(employer).isSuccess()) {
			return new ErrorResult(domainController(employer).getMessage());
		} else if (!confirmationOfSystemAdmin(true).isSuccess()) {
			return new ErrorResult(confirmationOfSystemAdmin(false).getMessage());
		}

		employer.setVerified(false);

		this.employerDao.save(employer);
		return new SuccessResult("İşveren sisteme eklenmiştir. " + " " + this.emailValidationService.isEmailValid()
				+ " " + domainController(employer).getMessage() + " " + confirmationOfSystemAdmin(true).getMessage()
				+ " ");

	}

	private Result isEmailExist(Employer employer) {

		List<Employer> userList = this.employerDao.findAll();
		for (User user : userList) {
			if (employer.getEmail().equals(user.getEmail()))
				return new ErrorResult("Daha önce aynı eposta adresiyle sistemde kayıt mevcuttur. ");
		}

		return new SuccessResult();

	}

	private Result domainController(Employer employer) {

		String[] employerWebsite = employer.getWebsite().split("www.", 2);
		String webDomain = employerWebsite[1];
		String[] mail = employer.getEmail().split("@", 2);
		String employerEmail = mail[1];

		if (!webDomain.equals(employerEmail)) {
			return new ErrorResult("Lütfen geçerli Email ve Web adresi giriniz. ");
		} else {
			return new SuccessResult("İşveren Domain doğrulaması başarılıdır. ");
		}

	}

	private Result confirmationOfSystemAdmin(boolean validate) {

		if (!validate) {
			return new ErrorResult("Sistem personeli tarafından üyelik talebiniz reddedildi. ");
		}
		return new SuccessResult("Sistem personeli tarafından onaylandınız. ");
	}

	@Override
	public Employer getById(int id) {

		return this.employerDao.findById(id);

	}

}
