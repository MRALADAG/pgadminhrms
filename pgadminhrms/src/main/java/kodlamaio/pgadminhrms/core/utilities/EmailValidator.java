package kodlamaio.pgadminhrms.core.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kodlamaio.pgadminhrms.entities.concretes.User;

public class EmailValidator {

	public boolean checkEmail(User user) {

		Pattern mailPattern = Pattern.compile(
				"^[a-z A-Z 0-9]+[\\.|_]?[a-z A-Z 0-9]+@[a-z A-Z 0-9]+\\.[a-z A-Z 0-9]{2,4}(\\.[a-z A-Z 0-9]{2})?$");

		Matcher mailMacher = mailPattern.matcher(user.getEmail().toLowerCase().trim());

		return mailMacher.matches();

	}

}
