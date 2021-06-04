package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.UserVerificationService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessDataResult;
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
	public DataResult<List<UserVerification>> getAllValidUser() {

		return new SuccessDataResult<List<UserVerification>>(this.userVerificationDao.findAll(),
				"Onaylanmış kullanıcılar listelenmiştir. ");

	}

}
