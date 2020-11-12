package com.myapp;

public class TestComparatorMain {

	public static void main(String[] args) {
		
		TestComparator kk = new TestComparator(4,4);
		TestComparator jj = new TestComparator(8,2);
		TestComparator tt = new TestComparator(3,3);
		TestComparator qq = new TestComparator(1,7);
		
		System.out.println("kk.compareTo(jj) = " + kk.compareTo(jj));
		System.out.println("tt.compareTo(qq) = " + tt.compareTo(qq));
		System.out.println("tt.compareTo(kk) = " + tt.compareTo(kk));
		System.out.println();
		System.out.println("compare(kk,jj) = " + kk.compare(kk,jj));
		System.out.println("compare(tt,qq) = " + tt.compare(tt,qq));
		System.out.println("compare(tt,kk) = " + tt.compare(tt,kk));
	}

}
