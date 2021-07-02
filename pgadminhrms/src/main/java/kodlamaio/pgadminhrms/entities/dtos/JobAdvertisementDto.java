package kodlamaio.pgadminhrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {

	private int id;
	private int employerId;
	private String employerCompanyName;
	private String employerWebsite;
	private String employerEmail;
	private int jobPositionId;
	private String jobPositionJobTitle;
	private String jobDescription;
	private int numberOfRecruited;
	private int cityId;
	private String cityName;
	private int maxSalary;
	private int minSalary;
	private Date dateOfCreation;
	private Date deadline;
	private Date modifyDate;
	private boolean activationState;

}
