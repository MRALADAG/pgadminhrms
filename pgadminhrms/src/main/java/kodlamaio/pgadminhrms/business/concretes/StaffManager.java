package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.EmployerService;
import kodlamaio.pgadminhrms.business.abstracts.StaffService;
import kodlamaio.pgadminhrms.business.abstracts.UserVerificationService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessDataResult;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.dataAccess.abstracts.StaffDao;
import kodlamaio.pgadminhrms.entities.concretes.Employer;
import kodlamaio.pgadminhrms.entities.concretes.Staff;
import kodlamaio.pgadminhrms.entities.concretes.UserVerification;

@Service
public class StaffManager implements StaffService {

	private StaffDao staffDao;
	private EmployerService employerService;
	private UserVerificationService userVerificationService;
	private UserVerification userVerification;
	private Employer employer;

	@Autowired
	public StaffManager(StaffDao staffDao, EmployerService employerService,
			UserVerificationService userVerificationService) {
		super();
		this.staffDao = staffDao;
		this.employerService = employerService;
		this.userVerificationService = userVerificationService;
		this.userVerification = new UserVerification();
		this.employer = new Employer();
	}

	@Override
	public DataResult<List<Staff>> getAll() {

		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(),
				"Sistem personelleri başarıyla listelendi. ");

	}

	@Override
	public Result addStaff(Staff staff) {

		this.staffDao.save(staff);
		return new SuccessResult("Sistem personeli başarıyla eklendi. ");
	}

	@Override
	public DataResult<Staff> getByStaffId(int id) {

		return new SuccessDataResult<Staff>(this.staffDao.findById(id), "Sistem personeli id'ye göre getirilmiştir. ");
	}

	@Override
	public DataResult<Staff> getByStaffFirstNameOrLastName(String firstName, String LastName) {

		return new SuccessDataResult<Staff>(
				this.staffDao.findByFirstNameOrLastNameContainsIgnoreCase(firstName, LastName),
				"Sistem personeli isim veya soy isime göre getirilmiştir. ");
	}

	private void confirmEmployer(int employerId, int staffId, boolean state) {

		employer = this.employerService.getById(employerId);
		userVerification.setUser(employer);
		userVerification.setValidation_state(state);
		userVerification.setAdminUser(this.staffDao.findById(staffId));
		userVerificationService.addValidEmployer(this.userVerification);

	}

	@Override
	public Result activateEmployer(int employerId, int staffId, boolean state) {

		confirmEmployer(employerId, staffId, state);
		return new SuccessResult("İş veren kaydı sistem personeli tarafından anaylanmıştır.");

	}

}
