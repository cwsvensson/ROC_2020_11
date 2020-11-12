package com.myapp;

import java.util.Comparator;

public class TestComparator implements Comparable<TestComparator>,
                                       Comparator<TestComparator > {

	private int x;
	private int y;

	public TestComparator() {
		// TODO Auto-generated constructor stub
	}

	public TestComparator(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int compareTo(TestComparator oo) {
		return (x*y) - (oo.x * oo.y);
//		if (x * y < (oo.x * oo.y)) {
//			return (-1);
//		} else if (x * y > (oo.x * oo.y)) {
//			return 1;	
//		}
//		return 0;
	}

	@Override
	public int compare(TestComparator o1, TestComparator o2) {
		if (o1.x * o1.y < (o2.x * o2.y)) {
			return (-1);
		} else if (o1.x * o1.y > (o2.x * o2.y)) {
			return 1;	
		}
		return 0;
	}
	
	
}