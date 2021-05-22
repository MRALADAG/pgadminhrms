package kodlamaio.pgadminhrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employer_verification")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployerVerification {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "staff_validation")
	private boolean staffValidation;

}
