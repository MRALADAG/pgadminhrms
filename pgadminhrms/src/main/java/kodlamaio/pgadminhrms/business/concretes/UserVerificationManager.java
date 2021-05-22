package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.UserVerificationService;
import kodlamaio.pgadminhrms.dataAccess.abstracts.UserVerificationDao;
import kodlamaio.pgadminhrms.entities.concretes.UserVerification;

@Service
public class UserVerificationManager implements UserVerificationService {

	private UserVerificationDao userVerificationDao;

	@Autowired
	public UserVerificationManager(UserVerificationDao userVerificationDao) {
		super();
		this.userVerificationDao = userVerificationDao;
	}

	@Override
	public List<UserVerification> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}