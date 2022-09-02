package Test;

public class TestException {
	public static void main(String[] arg) {
		try {
			int k = 8 / 0;
			throw new CustomException("error created due to user input");
		} catch (CustomException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
