package kodlamaio.pgadminhrms.entities.concretes;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_verification")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "user" })

public class UserVerification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

//	@JsonProperty(access = Access.READ_ONLY)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private Employer user;

//	@Column(name = "company_id")
//	private int userId;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "validation_date")
	private Date validationDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_time")
	private Date modifyTime;

	@Column(name = "validation_state")
	private boolean validationState = false;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "system_admin_id")
	private Staff adminUser;

//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL)
//	private User user;

}
