package kodlamaio.pgadminhrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.pgadminhrms.entities.concretes.UserVerification;

public interface UserVerificationDao extends JpaRepository<UserVerification, Integer> {

}
