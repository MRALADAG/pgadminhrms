package kodlamaio.pgadminhrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.pgadminhrms.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer> {

}
