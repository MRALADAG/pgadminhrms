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
@Table(name = "employee_verification")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeVerification {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "mernis_verification")
	private boolean mernisVerification;

}
