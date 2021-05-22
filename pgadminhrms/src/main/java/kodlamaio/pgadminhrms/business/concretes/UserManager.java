package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.UserService;
import kodlamaio.pgadminhrms.dataAccess.abstracts.UserDao;
import kodlamaio.pgadminhrms.entities.concretes.Users;

@Service
// Bunun anlamı katanlı yapıdaki service görevini üstlenbecek olan class'ı Spring'e gönderiyor.
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<Users> getAll() {
		
		return this.userDao.findAll();
	}

}
