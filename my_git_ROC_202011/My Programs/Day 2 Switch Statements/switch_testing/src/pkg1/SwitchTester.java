package pkg1;

public class SwitchTester {

	public static void main(String[] args) {
		
		int day = 4;
		switch (day) {		// Works on int

		case 1:
			System.out.println("Its Monday");
			break;
		case 2:
			System.out.println("Its Tuesday");
			break;
		case 3:
			System.out.println("Its Wednesday");
			break;
		default:
			System.out.println("Some other day.....");
		}
		System.out.println("Works for integer");
		
		float tryFloat = 0.2f;
		// switch (tryFloat) {}		// No Good
		System.out.println("Doesn't work for short");
		
		double tryDouble = 0.0d;
		// switch tryDouble {}		// No Good
		System.out.println("Doesn't work for double");
		
		boolean bb = false;
		// switch (bb) {}			// No Good
		System.out.println("Doesn't work for boolean");
		
		byte b1 = 1;	// OK
		switch (b1) {}
		System.out.println("Works for byte");
		
		short s1 = 4;	// OK
		switch (s1) {}
		System.out.println("Works for short");
		
		char c1 = 'p';
		switch (c1) {}	// OK
		System.out.println("Works for char");
		
		long l1 = 12345678L;	// No good
		// switch (l1) {}
		System.out.println("Doesn't work for long");
		
		String str = "str";
		switch (str) {}
		System.out.println("Works for String");
		
	}

}
