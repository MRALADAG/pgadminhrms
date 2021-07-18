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

import kodlamaio.pgadminhrms.business.abstracts.JobSeekerService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/JobSeeker")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {

		return this.jobSeekerService.getAll();

	}

	@PostMapping("/addJobSeeker")
	public Result addJobSeeker(@Valid @RequestBody JobSeeker jobSeeker) {

		return this.jobSeekerService.addJobSeeker(jobSeeker);

	}

	@GetMapping("/findById")
	public DataResult<JobSeeker> findById(@RequestParam int id) {

		return this.jobSeekerService.findById(id);

	}

	@PostMapping("/deleteInJobSeeker")
	public Result deleteInJobSeeker(@RequestBody int id) {

		return this.jobSeekerService.deleteInJobSeeker(id);

	}
}
