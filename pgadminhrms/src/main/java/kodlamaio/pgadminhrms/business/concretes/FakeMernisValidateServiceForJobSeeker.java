package kodlamaio.pgadminhrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.UserCheckService;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.entities.concretes.JobSeeker;

@Service("FakeMernisValidateServiceJobSeeker")
public class FakeMernisValidateServiceForJobSeeker implements UserCheckService<JobSeeker> {

	@Override
	public Result checkIfRealPerson(JobSeeker jobSeeker) {

		return new SuccessResult("Mernis sorgusu başarılıdır. ");

	}

}
