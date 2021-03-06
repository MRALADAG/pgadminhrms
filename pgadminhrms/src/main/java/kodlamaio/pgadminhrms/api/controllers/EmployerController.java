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

import kodlamaio.pgadminhrms.business.abstracts.EmployerService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {

		return this.employerService.getAll();

	}

	@PostMapping("/addemployer")
	public Result addEmployer(@Valid @RequestBody Employer employer) {

		return this.employerService.addEmployer(employer);

	}

	@GetMapping("/getById")
	public Employer getById(@RequestParam int id) {

		return this.employerService.getById(id);

	}

	@GetMapping("/findByEmailIgnoreCase")
	public DataResult<Employer> findByEmailIgnoreCase(@RequestParam String email) {

		return this.employerService.findByEmailIgnoreCase(email);

	}
}
