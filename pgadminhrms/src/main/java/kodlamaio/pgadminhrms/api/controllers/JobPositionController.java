package kodlamaio.pgadminhrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.pgadminhrms.business.abstracts.JobPositionService;
import kodlamaio.pgadminhrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobposition")
public class JobPositionController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getAllJobTitle")
	public List<JobPosition> getAllJobTitle() {

		return this.jobPositionService.getAllJobTitle();

	}

	@PostMapping("/addjobposition")
	public void addJobPosition(@RequestBody JobPosition jobPosition) {

		this.jobPositionService.addJobPosition(jobPosition);

	}

}
