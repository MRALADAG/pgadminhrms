package kodlamaio.pgadminhrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = false)

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotBlank(message = "telefon alanı boş bırakılamaz. ")
	@Column(name = "telephone")
	private String telephone;

	@NotBlank(message = "mail alanı boş bırakılamaz. ")
	@Email(message = "Lütfen geçerli bir E-posta adresi giriniz. ", regexp = "^[a-z A-Z 0-9]+[\\.|_]?[a-z A-Z 0-9]+@[a-z A-Z 0-9]+\\.[a-z A-Z 0-9]{2,4}(\\.[a-z A-Z 0-9]{2})?$")
	@Column(name = "email")
	private String email;

	@NotBlank(message = "Parola alanı boş bırakılamaz. ")
	@Size(min = 9, message = "Parola alanı en az 9 karakter olmalıdır. ")
	@Column(name = "password")
	private String password;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "record_date")
	private Date recordDate;

	// Burada dikkat edilmesi gereken husus eğer tarihle ilgili bir field
	// tanımlanacaksa değişken türünün java.util.date belirtilmesi gerekir. Ayrıca
	// tarihle ilgili alanlarda @Temporal anatasyonunun kullanılması şarttır. Bu
	// anotasyonun içerisinde ise örneğin; @Temporal(TemporalType.TIMESTAMP)
	// şeklinde değişkene atanacak değerin hangi türde tarih verisinin olduğu
	// belirtilmelidir. Bu anatasyonun içerisine duruma göre TemporalType.TIMESTAMP,
	// TemporalType.DATE, TemporalType.TIME şeklinde atanacak olan tarih türü
	// belirtilmelidir.

}