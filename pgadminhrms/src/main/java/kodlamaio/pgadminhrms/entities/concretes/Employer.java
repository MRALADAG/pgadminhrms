package kodlamaio.pgadminhrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "advertisements" })

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

	@JsonIgnore
	@Column(name = "is_confirmed_by_staff")
	private boolean isConfirmedByStaff;

	@JsonIgnore
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserVerification userVerification;

//	@OneToMany(mappedBy = "employer")
//	private List<JobAdvertisement> advertisements;

// Eğer JobAdvertisement ile ilgili field'lar swagger'ı 
// çalıştırdığımızda bir employer nesnesi görünmesin istiyorsak burada 
// JobAdvertisement ile ilgili alanı mapped etmememiz gereklidir.

}
