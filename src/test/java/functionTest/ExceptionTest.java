package functionTest;

import org.apache.commons.lang3.math.NumberUtils;

public class ExceptionTest {

	public static void main(String[] args) {
		D d = new D();
		Double ddd = NumberUtils.toDouble(d.getD() + "") + NumberUtils.toDouble(d.getD() + "");
		System.out.println(ddd);

	}

	public static void throwExceptionMethod(int i) {
		if (i == 0) {
			throw new BaseException();
		} else {
			throw new ChildException();
		}
	}

}

class D {
	Double double1;

	public Double getD() {
		return double1;
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