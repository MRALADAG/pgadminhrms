package kodlamaio.pgadminhrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.pgadminhrms.business.abstracts.UserVerificationService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.UserVerification;
import kodlamaio.pgadminhrms.entities.dtos.UserVerificationDto;

@RestController
@RequestMapping("/api/UserVerification")
public class UserVerificationController {

	private UserVerificationService userVerificationService;

	@Autowired
	public UserVerificationController(UserVerificationService userVerificationService) {
		super();
		this.userVerificationService = userVerificationService;
	}

	@PostMapping("/addValidEmployer")
	public Result addValidEmployer(@RequestBody UserVerification userVerification) {

		return this.userVerificationService.addValidEmployer(userVerification);

	}

	@GetMapping("/getAllValidUser")
	public DataResult<List<UserVerification>> getAllValidUser() {

		return this.userVerificationService.getAllValidUser();

	}

	@GetMapping("/deleteUserById")
	public Result deleteUserById(@RequestParam int id) {

		return this.userVerificationService.deleteUserById(id);

	}

	@GetMapping("/getAllValidUserDto")
	public DataResult<List<UserVerificationDto>> getAllValidUserDto() {

		return this.userVerificationService.getAllValidUserDto();

	}

}
