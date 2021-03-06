package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.Staff;
import kodlamaio.pgadminhrms.entities.dtos.StaffDto;

public interface StaffService {

	DataResult<List<Staff>> getAll();

	Result addStaff(Staff staff);

	Result addStaffDto(StaffDto staffDto);

	DataResult<Staff> getByStaffId(int id);

	DataResult<Staff> getByStaffFirstNameOrLastName(String firstName, String LastName);

	Result activateEmployer(int employerId, int staffId, boolean state);

}
