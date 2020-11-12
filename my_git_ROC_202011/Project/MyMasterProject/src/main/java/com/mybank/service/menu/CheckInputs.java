package com.mybank.service.menu;

import java.util.Scanner;

import com.mybank.exception.BankingException;

public class CheckInputs {

	public String getStringInput(Scanner scanner, String msg, int lowSize, int maxSize, char mask) throws BankingException {

		Sv.log.info(msg);
		boolean repeat = false;
		int cntr = 0;
		String anyString;

		do {
			try {
				repeat = false;
				anyString = scanner.nextLine();
			} catch (NumberFormatException e) {
				throw new BankingException("Error during console read in CheckInputs");
			} 
			cntr++;

			if (cntr >= 5) {
				return " ";
			}

			if (anyString.length() < lowSize || anyString.length() > maxSize) {
				Sv.log.info("Invalid input, please try again.");
				Sv.log.info(msg);
				repeat = true;
			}

			if (mask == 'A') {
//				anyString = anyString.fixedLengthString(anyString,22);
//				repeat = !(anyString.matches("[a-zA-Z ]{22}"));
//				Sv.log.info("Invalid input, please try again.");
//				Sv.log.info(msg);
			}

			if (mask == 'N') {
//				repeat = !(anyString.matches("[0-9])"));
//				Sv.log.info("Invalid input, please try again.");
//				Sv.log.info(msg);
			}

		} while (repeat);

		return anyString;
	}

	public String fixedLengthString(String strIn, int fixedLength) {

		strIn = strIn.concat("           ");
		strIn = strIn.substring(0, 12);
		Sv.log.debug("Length of String = " + strIn.length());

		return strIn;
	}
	
	public String getAccountType(Scanner scanner, String msg, int lowSize, int maxSize) throws BankingException {

		String bnkTyp = getStringInput(scanner, msg, lowSize, maxSize, 'A');
		if (!bnkTyp.equals("B") && !bnkTyp.equals("C") && !bnkTyp.equals("S")) {
			return " ";
		}

		return bnkTyp;
	}
}