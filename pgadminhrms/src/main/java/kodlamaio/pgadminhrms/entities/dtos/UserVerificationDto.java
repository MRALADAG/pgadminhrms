package kodlamaio.pgadminhrms.entities.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVerificationDto {

//	@JsonIgnore
	private int id;
	private int companyId;
	private String companyCompanyName;
	private boolean companyConfirmedByStaff;
	private String companyWebsite;
//	private String websiteCompany;
//	yukarıdaki ifadeye alternatif olarak bu şekilde de kullanılabilir.
	private Date validationDate;
	private Date modifyTime;
	private boolean validationState;

//	@JsonIgnore
	private int adminUserId;
	private String adminUserFirstName;
	private String adminUserLastName;

}
