package kodlamaio.pgadminhrms.business.abstracts;

import java.util.List;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.UserVerification;
import kodlamaio.pgadminhrms.entities.dtos.UserVerificationDto;

public interface UserVerificationService {

	Result addValidUserDto(UserVerificationDto userVerificationDto);

	DataResult<List<UserVerification>> getAllValidUser();

	DataResult<List<UserVerificationDto>> getAllValidUserDto();

	Result addValidEmployer(UserVerification userVerification);

	Result deleteUserById(int id);

}
