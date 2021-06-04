package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.EmailValidationService;
import kodlamaio.pgadminhrms.business.abstracts.EmployeeService;
import kodlamaio.pgadminhrms.business.abstracts.UserCheckService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.ErrorResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessDataResult;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.pgadminhrms.dataAccess.abstracts.UserDao;
import kodlamaio.pgadminhrms.entities.concretes.Employee;
import kodlamaio.pgadminhrms.entities.concretes.User;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	private UserDao userDao;

	@Autowired
	private EmailValidationService emailValidationService;

	@Autowired
	private UserCheckService userCheckService;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, UserDao userDao) {
		super();
		this.employeeDao = employeeDao;
		this.userDao = userDao;
		// this.emailValidationService = new EmailValidationManager();
	}

	@Override
	public DataResult<List<Employee>> getAll() {

		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), "İş arayanlar listelenmiştir.");
	}

	@Override
	public Result addEmployee(Employee employee) {

		if (!isEmailExist(employee).isSuccess()) {

			return new ErrorResult(isEmailExist(employee).getMessage());

		} else if (!isNatIdExist(employee).isSuccess()) {

			return new ErrorResult(isNatIdExist(employee).getMessage());

		} else if (!this.userCheckService.checkIfRealPerson(employee).isSuccess()) {

			return new ErrorResult(this.userCheckService.checkIfRealPerson(employee).getMessage());

		}

		// this.emailValidationService.isEmailValid().getMessage();
		this.employeeDao.save(employee);
		return new SuccessResult(
				"İş arayan sisteme eklenmiştir. " + this.emailValidationService.isEmailValid().getMessage() + " ");

	}

	private Result isNatIdExist(Employee employee) {

		List<Employee> emloyeeId = this.employeeDao.findAll();
		for (Employee employee1 : emloyeeId) {
			if (employee.getNationalityNumber().equals(employee1.getNationalityNumber()))
				return new ErrorResult("Daha önce aynı kimlik numarasıyla sistemde kayıt mevcuttur. ");

		}

		return new SuccessResult();

	}

	private Result isEmailExist(Employee employee) {

		List<User> userList = this.userDao.findAll();
		for (User user : userList) {
			if (employee.getEmail().equals(user.getEmail()))
				return new ErrorResult("Daha önce aynı eposta adresiyle sistemde kayıt mevcuttur. \n");
		}

		return new SuccessResult();

	}

	@Override
	public DataResult<Employee> findById(int id) {

		return new SuccessDataResult<Employee>(this.employeeDao.findById(id));

	}

	@Override
	public Result deleteInEmployee(int id) {

		this.employeeDao.deleteById(id);
		return new SuccessResult("İş arayan kişinin kaydı silinmiştir. \n");

	}
}
