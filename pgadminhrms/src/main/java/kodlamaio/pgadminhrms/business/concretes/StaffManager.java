package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.DtoConverterService;
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
import kodlamaio.pgadminhrms.entities.dtos.StaffDto;

@Service
public class StaffManager implements StaffService {

	private StaffDao staffDao;
	private EmployerService employerService;
	private UserVerificationService userVerificationService;
	private DtoConverterService dtoConverterService;
	private UserVerification userVerification;
	private Employer employer = null;

	@Autowired
	public StaffManager(StaffDao staffDao, DtoConverterService dtoConverterService, EmployerService employerService,
			UserVerificationService userVerificationService) {
		super();
		this.staffDao = staffDao;
		this.employerService = employerService;
		this.userVerificationService = userVerificationService;
		this.dtoConverterService = dtoConverterService;

//		this.employer = new Employer();
//		this.userVerification = new UserVerification();
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
	public Result addStaffDto(StaffDto staffDto) {

		this.staffDao.save((Staff) dtoConverterService.dtoClassConverter(staffDto, Staff.class));
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

//		this.employer = new Employer();
		this.employer = this.employerService.getById(employerId);
		this.employer.setConfirmedByStaff(state);
		// Burada employers tablosunun onay kolonu sistem personeli tarafından set
		// ediliyor.

		this.userVerification = new UserVerification();
		this.userVerification.setCompany(this.employer);
		this.userVerification.setValidationState(state);
		this.userVerification.setAdminUser(this.staffDao.findById(staffId));
		this.userVerificationService.addValidEmployer(this.userVerification);

	}

	@Override
	public Result activateEmployer(int employerId, int staffId, boolean state) {

		confirmEmployer(employerId, staffId, state);
		return new SuccessResult("İş veren kaydı sistem personeli tarafından onaylanmıştır.");

	}

}
