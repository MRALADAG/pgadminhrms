package kodlamaio.pgadminhrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.pgadminhrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {

}
