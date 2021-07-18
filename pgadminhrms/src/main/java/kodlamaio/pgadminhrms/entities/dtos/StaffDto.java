package kodlamaio.pgadminhrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto {

	private int id;
	private String firstName;
	private String lastName;
	private String nationalityNumber;
	private String telephone;
	private String email;
	private String password;

}
