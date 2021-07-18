package kodlamaio.pgadminhrms.core.utilities;

public interface PasswordCheckService<T> {

	boolean passwordVerifier(T user);

}
