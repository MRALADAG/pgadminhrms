package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.entities.concretes.Users;

public interface UserService {

	List<Users> getAll();
}
