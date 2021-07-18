package kodlamaio.pgadminhrms.business.abstracts;

import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.JobSeeker;

public interface UserCheckService<T> {

	Result checkIfRealPerson(T user);

}
