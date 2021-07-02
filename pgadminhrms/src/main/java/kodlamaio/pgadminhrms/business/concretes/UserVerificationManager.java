package kodlamaio.pgadminhrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pgadminhrms.business.abstracts.DtoConverterService;
import kodlamaio.pgadminhrms.business.abstracts.UserVerificationService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessDataResult;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessResult;
import kodlamaio.pgadminhrms.dataAccess.abstracts.UserVerificationDao;
import kodlamaio.pgadminhrms.entities.concretes.UserVerification;
import kodlamaio.pgadminhrms.entities.dtos.UserVerificationDto;

@Service
public class UserVerificationManager implements UserVerificationService {

	private UserVerificationDao userVerificationDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public UserVerificationManager(UserVerificationDao userVerificationDao, DtoConverterService dtoConverterService) {

		super();
		this.userVerificationDao = userVerificationDao;
		this.dtoConverterService = dtoConverterService;

	}

	@Override
	public DataResult<List<UserVerification>> getAllValidUser() {

		return new SuccessDataResult<List<UserVerification>>(this.userVerificationDao.findAll(),
				"Onaylanmış kullanıcılar listelenmiştir. ");

	}

	@Override
	public Result addValidEmployer(UserVerification userVerification) {

		this.userVerificationDao.save(userVerification);
		return new SuccessResult("Onaylanmış işveren sisteme kayıt edilmiştir.");
	}

	@Override
	public Result deleteUserById(int id) {

		this.userVerificationDao.deleteById(id);
		return new SuccessResult("Kayıt silinmiştir.");

	}

	@Override
	public DataResult<List<UserVerificationDto>> getAllValidUserDto() {

		return new SuccessDataResult<List<UserVerificationDto>>(
				dtoConverterService.dtoConverter(userVerificationDao.findAll(), UserVerificationDto.class),
				"Dto'lar getirildi");

	}

	@Override
	public Result addValidUserDto(UserVerificationDto userVerificationDto) {

		this.userVerificationDao.save(
				(UserVerification) dtoConverterService.dtoClassConverter(userVerificationDto, UserVerification.class));
		return new SuccessResult("VerificationDto eklendi.");

	}

}
