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
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Users {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "email")
	private String email;

}