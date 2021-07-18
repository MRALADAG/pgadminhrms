package kodlamaio.pgadminhrms.business.concretes;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.UserCheckService;
import kodlamaio.pgadminhrms.core.utilities.results.ErrorResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service("MernisCheckForJobSeeker")
public class MernisCheckForJobSeekerManagerAdapter implements UserCheckService<JobSeeker> {

	@Override
	public Result checkIfRealPerson(JobSeeker jobSeeker) {

		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = true;

		try {

			result = client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalityNumber()),
					jobSeeker.getFirstName().toUpperCase(new Locale("tr", "TR")),
					jobSeeker.getLastName().toUpperCase(new Locale("tr", "TR")),
					(jobSeeker.getBirthDay().getYear() + 1900));

		} catch (RemoteException | NumberFormatException e) {

			e.printStackTrace();

		}

		return (result ? new SuccessResult("Mernis sorgusu başarılı. ")
				: new ErrorResult("Mernis sorgusu hatalıdır. "));

	}

}
