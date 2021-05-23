package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();

	Result addEmployer(Employer employer);

}
