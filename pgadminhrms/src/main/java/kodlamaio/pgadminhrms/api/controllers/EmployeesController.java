package kodlamaio.pgadminhrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.pgadminhrms.business.abstracts.EmployeeService;
import kodlamaio.pgadminhrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.pgadminhrms.entities.concretes.Employees;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/getall")
	public List<Employees> getAll() {

		return this.employeeService.getAll();

	}

	@PostMapping("/addemployee")
	public void addEmployee(@RequestBody Employees employees) {

		this.employeeService.addEmployee(employees);

	}
}