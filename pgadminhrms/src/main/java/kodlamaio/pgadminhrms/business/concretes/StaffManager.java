package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.StaffService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessDataResult;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.dataAccess.abstracts.StaffDao;
import kodlamaio.pgadminhrms.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService {

	private StaffDao staffDao;

	@Autowired
	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}

	@Override
	public DataResult<List<Staff>> getAll() {

		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(), "Sistem personelleri başarıyla listelendi.");

	}

	@Override
	public Result addStaff(Staff staff) {

		this.staffDao.save(staff);
		return new SuccessResult("Sistem personeli başarıyla eklendi.");
	}

}
