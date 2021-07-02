package kodlamaio.pgadminhrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.pgadminhrms.business.abstracts.JobAdvertisementService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.JobAdvertisement;
import kodlamaio.pgadminhrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("api/jobadvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/addJobAdvertise")
	public Result addJobAdvertise(@Valid @RequestBody JobAdvertisement advertisement) {

		return this.jobAdvertisementService.addJobAdvertise(advertisement);

	}

	@GetMapping("/getAllAdvertise")
	public DataResult<List<JobAdvertisement>> getAllAdvertise() {

		return this.jobAdvertisementService.getAllAdvertise();

	}

	@GetMapping("/getAllJobAdvertisementByActivationState")
	public DataResult<List<JobAdvertisement>> getAllJobAdvertisementByActivationState(
			@RequestParam boolean activationState) {

		return this.jobAdvertisementService.getAllJobAdvertisementByActivationState(activationState);

	}

//	@GetMapping("/isAdvertiseActivationStateTrue")
//	public DataResult<JobAdvertisement> isAdvertiseActivationStateTrue(@RequestParam int id) {
//
//		return this.jobAdvertisementService.isAdvertiseActivationStateTrue(id);
//
//	}

	@GetMapping("/existsByIdAndActivationStateIsTrue")
	public Result existByIdAndActivationStateIsTrue(@RequestParam int id) {

		return this.jobAdvertisementService.existsByIdAndActivationStateIsTrue(id);

	}

	@GetMapping("/getById")
	public DataResult<JobAdvertisement> getById(@RequestParam int id) {

		return this.jobAdvertisementService.findById(id);

	}

	@GetMapping("/getAllJobAdvertisementByEmployerId")
	public DataResult<List<JobAdvertisement>> getAllJobAdvertisementByEmployerId(@RequestParam int id) {

		return this.jobAdvertisementService.getAllJobAdvertisementByEmployerId(id);

	}

	@GetMapping("/getAllActiveJobAdvertisement")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisement() {

		return this.jobAdvertisementService.getAllActiveJobAdvertisement();

	}

	@GetMapping("/getAllActiveJobAdvertisementByEmployerId")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployerId(@RequestParam int id) {

		return this.jobAdvertisementService.getAllActiveJobAdvertisementByEmployerId(id);

	}

	@GetMapping("/getAllActiveJobAdvertisementByEmployerName")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployerName(
			@RequestParam String companyName) {

		return this.jobAdvertisementService.getAllActiveJobAdvertisementByEmployerName(companyName);

	}

	@GetMapping("/getByCompanyNameAndJobTitle")
	public DataResult<JobAdvertisement> getByCompanyNameAndJobTitle(@RequestParam("companyName") String companyName,
			@RequestParam("jobTitle") String jobTitle) {

		return this.jobAdvertisementService.getByCompanyNameAndJobTitle(companyName, jobTitle);

	}

	@GetMapping("/getAllByCompanyName")
	public DataResult<List<JobAdvertisement>> getAllByCompanyName(@RequestParam String companyName) {

		return this.jobAdvertisementService.getAllByCompanyName(companyName);

	}

	@GetMapping("/getAllAdvertiseByDateOfCreationAsc")
	public DataResult<List<JobAdvertisement>> getAllAdvertiseByDateOfCreationAsc() {

		return this.jobAdvertisementService.getAllAdvertiseByDateOfCreationAsc();

	}

	@GetMapping("/getAllActiveJobAdvertisementOrderByDateOfCreationAsc")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementOrderByDateOfCreationAsc() {

		return this.jobAdvertisementService.getAllActiveJobAdvertisementOrderByDateOfCreationAsc();

	}

	@GetMapping("/getAllAdvertiseByDateOfCreationDesc")
	public DataResult<List<JobAdvertisement>> getAllAdvertiseByDateOfCreationDesc() {

		return this.jobAdvertisementService.getAllAdvertiseByDateOfCreationDesc();

	}

	@GetMapping("/getAllActiveJobAdvertisementOrderByDateOfCreationDesc")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementOrderByDateOfCreationDesc() {

		return this.jobAdvertisementService.getAllActiveJobAdvertisementOrderByDateOfCreationDesc();

	}

	@GetMapping("/getByIdAndEmployer_Id")
	public DataResult<JobAdvertisement> getByIdAndEmployer_Id(@RequestParam("id") int id,
			@RequestParam("employerId") int employerId) {

		return this.jobAdvertisementService.getByIdAndEmployer_Id(id, employerId);

	}

	@GetMapping("/setActivationStateOfJobAdvertisement")
	public Result setActivationStateOfJobAdvertisementByEmployerIdAndAdvertisementId(@RequestParam("id") int id,
			@RequestParam("employerId") int employerId, @RequestParam("activationState") boolean state) {

		return this.jobAdvertisementService.setActivationStateOfJobAdvertisementByEmployerIdAndAdvertisementId(id,
				employerId, state);

	}

	@GetMapping("/getAllJobAdvertisementDto")
	public DataResult<List<JobAdvertisementDto>> getAllJobAdvertisementDto() {

		return this.jobAdvertisementService.getAllJobAdvertisementDto();

	}

	@PostMapping("/addJobAdvertisementDto")
	Result addJobAdvertisementDto(@RequestBody JobAdvertisementDto advertisementDto) {

		return this.jobAdvertisementService.addJobAdvertisementDto(advertisementDto);

	}

}
