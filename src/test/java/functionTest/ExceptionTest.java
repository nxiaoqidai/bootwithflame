package functionTest;

public class ExceptionTest {

	public static void main(String[] args) {

		try {
			throwExceptionMethod(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void throwExceptionMethod(int i) {
		if (i == 0) {
			throw new BaseException();
		} else {
			throw new ChildException();
		}
	}

}

class BaseException extends RuntimeException {

	@Override
	public String getMessage() {

		return "BaseException";
	}

}

class ChildException extends BaseException {
	@Override
	public String getMessage() {

		return "ChildException";
	}
}