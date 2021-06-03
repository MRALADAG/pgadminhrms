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

	@GetMapping("/getById")
	public DataResult<JobAdvertisement> getById(@RequestParam int id) {

		return this.jobAdvertisementService.findById(id);

	}

	@GetMapping("/getAllJobAdvertisementByEmployerId")
	public DataResult<List<JobAdvertisement>> getAllJobAdvertisementByEmployerId(@RequestParam int id) {

		return this.jobAdvertisementService.getAllJobAdvertisementByEmployerId(id);

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

}
