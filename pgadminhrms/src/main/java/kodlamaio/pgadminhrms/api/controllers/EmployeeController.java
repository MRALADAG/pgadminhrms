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

import kodlamaio.pgadminhrms.business.abstracts.EmployeeService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.Result;
import kodlamaio.pgadminhrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll() {

		return this.employeeService.getAll();

	}

	@PostMapping("/addemployee")
	public Result addEmployee(@Valid @RequestBody Employee employee) {

		return this.employeeService.addEmployee(employee);

	}

	@GetMapping("/findById")
	public DataResult<Employee> findById(@RequestParam int id) {

		return this.employeeService.findById(id);

	}

	@PostMapping("/deleteInEmployee")
	public Result deleteInEmployee(@RequestBody int id) {

		return this.employeeService.deleteInEmployee(id);

	}
}
