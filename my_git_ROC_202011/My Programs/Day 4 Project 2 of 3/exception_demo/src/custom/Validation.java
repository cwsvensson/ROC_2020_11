package custom;

public class Validation {

	public boolean isValidId(String id) throws MyBusinessCheckedException {
		System.out.println("Checking ID = "+id);
		if (!id.matches("[a-zA-Z]{2}-[1-9][0-9]{4}")) {
			throw new MyBusinessCheckedException("Invalid ID - "+
					"It should be xx-99999 and first digit >0");
		}
		return true;
	}
}
