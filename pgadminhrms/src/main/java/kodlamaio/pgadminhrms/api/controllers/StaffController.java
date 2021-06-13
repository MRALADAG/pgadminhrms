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

import kodlamaio.pgadminhrms.business.abstracts.StaffService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.Staff;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

	private StaffService staffService;

	@Autowired
	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}

	@GetMapping("/getall")
	public DataResult<List<Staff>> gatAll() {

		return this.staffService.getAll();

	}

	@PostMapping("addstaff")
	public Result addStaff(@Valid @RequestBody Staff staff) {

		return this.staffService.addStaff(staff);

	}

	@GetMapping("/getByStaffId")
	public DataResult<Staff> getByStaffId(@RequestParam int id) {

		return this.staffService.getByStaffId(id);

	}

	@GetMapping("/getByStaffFirstNameOrLastName")
	public DataResult<Staff> getByStaffFirstNameOrLastName(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {

		return this.staffService.getByStaffFirstNameOrLastName(firstName, lastName);

	}

	@GetMapping("/activateEmployer")
	public Result activateEmployer(@RequestParam int employerId, @RequestParam int staffId,
			@RequestParam boolean state) {

		return this.staffService.activateEmployer(employerId, staffId, state);

	}

}
