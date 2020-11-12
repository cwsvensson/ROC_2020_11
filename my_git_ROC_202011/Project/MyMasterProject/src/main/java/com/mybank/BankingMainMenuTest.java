package com.mybank;

import java.util.Scanner;

import com.mybank.exception.BankingException;
import com.mybank.service.menu.FirstMenu;
import com.mybank.service.menu.Sv;

public class BankingMainMenuTest {

	public static void main(String[] args) {
		
		Sv.log.debug("Main Menu Test Program");
		Scanner scanner = new Scanner(System.in);
		
		try {
			FirstMenu.firstMenu(scanner);
		} catch (BankingException err) {
			Sv.log.error(err);
			err.printStackTrace();
		}
		
		Sv.log.debug("");
		Sv.log.debug("Main Menu Test Program");
	    scanner.close();
	}
}