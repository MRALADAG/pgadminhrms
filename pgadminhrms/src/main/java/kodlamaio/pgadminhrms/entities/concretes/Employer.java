package kodlamaio.pgadminhrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
// Burada bu Class'ın bir veritabanı nesnesi olduğunu belirtiyoruz.
@Table(name = "employers")
// Burada entity'nin veritabanınnda hangi tabloya karşılık geldiğini
// belirtiyoruz.
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

public class Employer extends User {

	// @Id
	// @GeneratedValue
	// Bu kısımda primary key olan user id nin ardışık olarak birer birer artacağı
	// belirtiliyor.
	// @Column(name = "id")
	// private int id;
	// Bu kısım base tabloda olduğu için iptal edildi.

	@NotBlank(message = "Şirket ismi boş bırakılamaz. ")
	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = "Web adresi boş bırakılamaz. ")
	@Column(name = "website")
	private String website;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> advertisements;

}
