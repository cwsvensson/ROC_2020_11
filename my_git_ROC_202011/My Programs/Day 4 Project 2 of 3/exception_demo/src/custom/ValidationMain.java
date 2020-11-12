package custom;

public class ValidationMain {

	public static void main(String[] args) {

		Validation v = new Validation();
		
//		System.out.println("IsValidId = "+ v.isValidId("cs-10008"));  //Error if uncommented

		try {
			if (v.isValidId("CS-20000")) {
				System.out.println("ID Validated");
			}
		} catch (MyBusinessCheckedException e) {
			System.out.println(e.getMessage());
		}
		
// 		This was tried with both the Checked and the Unchecked Exceptions

	}

}
