package kodlamaio.pgadminhrms.business.concretes;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.UserCheckService;
import kodlamaio.pgadminhrms.core.utilities.results.ErrorResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.entities.concretes.Staff;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service("MernisCheckForStaff")
public class MernisCheckForStaffManagerAdapter implements UserCheckService<Staff> {

	@Override
	public Result checkIfRealPerson(Staff staff) {

		KPSPublicSoap client = new KPSPublicSoapProxy();
		boolean result = true;

		try {

			result = client.TCKimlikNoDogrula(
					
					Long.parseLong(staff.getNationalityNumber()),
					staff.getFirstName().toUpperCase(new Locale("tr", "TR")),
					staff.getLastName().toUpperCase(new Locale("tr", "TR")), 
					staff.getBirthDay().getYear() + 1900);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return (result ? new SuccessResult("Mernis sorgusu başarılı. ")
				: new ErrorResult("Mernis sorgusu hatalıdır. "));

	}

}
