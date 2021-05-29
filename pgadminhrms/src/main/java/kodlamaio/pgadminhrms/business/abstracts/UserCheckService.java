package kodlamaio.pgadminhrms.business.abstracts;

import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.User;

public interface UserCheckService {

	Result checkIfRealPerson(User user);

}
