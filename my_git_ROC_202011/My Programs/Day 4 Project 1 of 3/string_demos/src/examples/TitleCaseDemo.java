package examples;

public class TitleCaseDemo {

	public static void main(String[] args) {
		String s="hello hi good morning I am enjoying programming with java";
		StringBuilder sb1=new StringBuilder();
		String ar[]=s.split(" ");
		for(String s1:ar) {
			sb1.append(Character.toUpperCase(s1.charAt(0))).append(s1.substring(1)).append(" ");
		}
		System.out.println(sb1.toString().trim());
		
		StringBuilder sb2=new StringBuilder();
		
		for(String s1:ar) {
			 sb2.append(s1.substring(0,s1.length()-1)).append(Character.toUpperCase(s1.charAt(s1.length()-1))).append(" ");
		}
		System.out.println(sb2.toString().trim());
		
	}

}
//Task - Convert every word's last char to uppercase