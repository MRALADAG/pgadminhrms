package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.entities.concretes.Users;

public interface UserService {

	DataResult<List<Users>> getAll();
}
