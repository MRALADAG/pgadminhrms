package kodlamaio.pgadminhrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_advertisement")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@NotBlank(message = "İş tanımı alanı boş bırakılamaz.")
	@Column(name = "job_description")
	private String jobDescription;

//	@NotBlank(message = "İş tanımı pozisyonu seçilmelidir.")
//	@Column(name = "job_position")
	@ManyToOne(targetEntity = JobPosition.class)
	@JoinColumn(name = "job_position")
	private JobPosition jobPosition;

	@NotBlank(message = "Şehir seçimi yapılmalıdır.")
	@Column(name = "city_name")
	private String city;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
//	private java.util.Date dateOfCreation;
	private Date dateOfCreation;

	@Column(name = "activation_state")
	private boolean activationState;

	@Temporal(TemporalType.DATE)
	@NotBlank(message = "Son başvuru tarihi belirtilmelidir.")
	@Column(name = "deadline")
//	private java.util.Date deadline;
	private Date deadline;

	@NotBlank(message = "Açık pozisyon adedi belirtilmelidir.")
	@Column(name = "number_of_recruited")
	private int numberOfRecruited;

	@ManyToOne(targetEntity = Employer.class)
	@JoinColumn(name = "employer_id", referencedColumnName = "id")
	private Employer employer;

}
