package kodlamaio.pgadminhrms.core.utilities;

import kodlamaio.pgadminhrms.entities.concretes.Staff;

public class StaffPasswordVerifier implements PasswordCheckService<Staff> {

	@Override
	public boolean passwordVerifier(Staff staff) {

		return staff.getPassword().equals(staff.getPasswordRepetition());

	}

}
