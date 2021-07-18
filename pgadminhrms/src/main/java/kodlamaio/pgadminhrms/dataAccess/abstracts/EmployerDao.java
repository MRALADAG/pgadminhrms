package kodlamaio.pgadminhrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	// Employer findById(int id);

	Employer findByEmailIgnoreCase(String email);

	boolean existsByEmailIgnoreCase(String email);

}
