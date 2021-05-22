package kodlamaio.pgadminhrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_verification")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserVerification {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "validation_date")
	private Date validationDate;

	@Column(name = "email_validation")
	private boolean emailValidation;

}
