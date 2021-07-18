package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();

	Result addEmployer(Employer employer);

	Employer getById(int id);

	boolean existsByEmailIgnoreCase(String email);

	DataResult<Employer> findByEmailIgnoreCase(String email);

}
