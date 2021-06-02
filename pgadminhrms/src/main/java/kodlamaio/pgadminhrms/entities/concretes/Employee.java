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
@Table(name = "employees")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

public class Employee extends User {

	@NotBlank(message = "İsim kısmı boş bırakılamaz.")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Soyisim kısmı boş bırakılamaz.")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "Kimlik numarası alanı boş bırakılamaz.")
	@Size(min = 11, max = 11, message = "Lütfen 11 haneli kimlik nuamaranızı giriniz.")
	@Column(name = "nationality_number")
	private String nationalityNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthDay;

}
