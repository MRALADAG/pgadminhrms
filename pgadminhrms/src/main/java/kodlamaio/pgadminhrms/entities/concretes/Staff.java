package kodlamaio.pgadminhrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staff")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

public class Staff extends User {

	// @Id
	// @GeneratedValue
	// @Column(name = "id")
	// private int id;

	@NotBlank(message = "İsim alanı boş bırakılamaz. ")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Soyisim alanı boş bırakılamaz. ")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "Kimlik numarası alanı boş bırakılamaz. ")
	@Size(min = 11, max = 11, message = "Kimlik numarası 11 haneli olmalıdır. ")
	@Column(name = "nationality_number")
	private String nationalityNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthDay;

}
