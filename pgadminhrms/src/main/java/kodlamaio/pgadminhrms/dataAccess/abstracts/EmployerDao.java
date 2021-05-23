package kodlamaio.pgadminhrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.pgadminhrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
