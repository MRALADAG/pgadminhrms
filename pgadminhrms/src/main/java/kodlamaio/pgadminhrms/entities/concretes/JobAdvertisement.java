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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

	@NotBlank(message = "İş tanımı alanı boş bırakılamaz. ")
	@Column(name = "job_description")
	private String jobDescription;

//	@NotBlank(message = "Şehir seçimi yapılmalıdır.")
//	@Column(name = "city_name")
//	private String city;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
//	private java.util.Date dateOfCreation;
	private Date dateOfCreation;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	private Date updateTime;

	@Column(name = "activation_state")
	private boolean activationState;

	@Temporal(TemporalType.DATE)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
//	@NotBlank(message = "Son başvuru tarihi belirtilmelidir.")
	@Column(name = "deadline")
//	private java.util.Date deadline;
	private Date deadline;

	@NotNull(message = "Açık pozisyon adedi belirtilmelidir. ")
	@Min(value = 1, message = "İşe alınacak personel adedi belirtilmelidir. ")
	@Column(name = "number_of_recruited")
	private int numberOfRecruited;

	@ManyToOne(targetEntity = Employer.class)
	@JoinColumn(name = "employer_id")
	private Employer employer;

//	@NotBlank(message = "İş tanımı pozisyonu seçilmelidir. ")
//	@Column(name = "job_position_id")
	@ManyToOne(targetEntity = JobPosition.class)
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@ManyToOne(targetEntity = City.class)
	@JoinColumn(name = "city_name_id")
	private City city;

}
