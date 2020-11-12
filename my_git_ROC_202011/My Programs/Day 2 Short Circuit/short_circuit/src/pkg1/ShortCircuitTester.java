package pkg1;

public class ShortCircuitTester {

	public static void main(String[] args) {
		boolean b1=false, b2=true;
		int i=1, j=2;
		
		System.out.println("i starts at = "+i+", jstarts at = "+j);
		
		if (b1 && i++==j) {
			System.out.println("And is true");
		} else {
			System.out.println("And is false");
		}
		
		System.out.println("i is now = "+i);  // Short circuit stopped i++
		
		if (b2 && i++==j) {
			System.out.println("And is true");
		} else {
			System.out.println("And is false");
		}
		
		System.out.println("i is now = "+i);  // Still false, but no short circuit
		
		if (b2 || i++==j) {
			System.out.println("Or is true");
		} else {
			System.out.println("Or is false");
		}
		
		System.out.println("i is now = "+i);  // Short circuit stopped i++
		
		if (b1 || i++>=j) {
			System.out.println("Or is true");
		} else {
			System.out.println("Or is false");
		}
		
		System.out.println("i is now = "+i);  // Still true, but no short circuit

	}

}
