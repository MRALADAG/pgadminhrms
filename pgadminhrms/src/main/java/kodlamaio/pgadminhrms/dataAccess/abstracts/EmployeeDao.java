package kodlamaio.pgadminhrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.pgadminhrms.entities.concretes.Employees;

public interface EmployeeDao extends JpaRepository<Employees, Integer> {

}
