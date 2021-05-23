package kodlamaio.pgadminhrms.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult() {
		super(null, false);
	}

	public ErrorDataResult(T data) {
		super(data, false);
	}

	public ErrorDataResult(String message) {
		super(null, false, message);
	}

	public ErrorDataResult(T data, boolean success) {
		super(data, success);
	}

	public ErrorDataResult(T data, String message) {
		super(data, false, message);
	}

}
