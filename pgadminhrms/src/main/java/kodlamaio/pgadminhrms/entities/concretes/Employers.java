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
// Burada bu Class'ın bir veritabanı nesnesi olduğunu belirtiyoruz.
@Table(name = "employers")
// Burada entity'nin veritabanınnda hangi tabloya karşılık geldiğini
// belirtiyoruz.
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employers {

	@Id
	@GeneratedValue
	// Bu kısımda primary key olan user id nin ardışık olarak birer birer artacağı
	// belirtiliyor.
	@Column(name = "id")
	private int id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;

}
