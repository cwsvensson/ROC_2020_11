package com.mybank.service.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mybank.exception.BankingException;

public class FileActions {
	
	public List<String> fileReads(String fileName) throws BankingException  {
		
		List<String> menuItems = new ArrayList<>();
		
		try {
			File fileObj = new File(fileName);
			Scanner myReader = new Scanner(fileObj);
			
			while (myReader.hasNextLine()) {
				String inRead = myReader.nextLine();
				menuItems.add(inRead);
				//Sv.log.debug(inRead);
			}
			myReader.close();
			
		} catch (FileNotFoundException e) {
			Sv.log.warn("Fatal Error: No file found = " + fileName);
			throw new BankingException("File not found - " + fileName + " - Exiting");
			
		} catch (Exception e) {
			Sv.log.error ("Unknown Fatal Error: " + fileName);
			throw new BankingException("File not found - " + fileName + " - Exiting");
		}
		
		if (menuItems != null && menuItems.size() == 0) {
			throw new BankingException("Error - File "+ fileName +" is Empty - Exiting");
		}
		
		return menuItems;
	}

	public int printMenu(List<String> fullMenu, int cnt) {

		for(String fm:fullMenu) {
			if (fm.charAt(1) == 'd') {
				Sv.log.info(fm.substring(3));
			} else if (fm.charAt(1) == 'n') {
				Sv.log.info(cnt++ + ") " + fm.substring(3));
			}	
		}
		return cnt;
	}
	
	public String parseMenuForAction(List<String> fullMenu, int cnt) {
		
		int cntr = 0;
		for(String fm:fullMenu) {
			if (fm.charAt(1) == 'a') {
				if (cntr == cnt) {
					return fm.substring(3);
				}
				cntr++;
			}	
		}
		return " ";
	}
	
	public int getMenuSelection(Scanner scanner, int maxSlct) throws BankingException {

		int tryCnt = 1;
		int slct = -1;
		boolean repeat = false;
		//Scanner scanner = new Scanner(System.in);

		do {
			
			try {
				repeat = false;
				slct = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				slct = -1;
			}

			tryCnt++;

			if ((slct < 0 || slct > maxSlct) && tryCnt < 5) {
				Sv.log.info("Invalid input.  Expected input is from 0 to " +maxSlct);
				Sv.log.info("Please try again > ");
				repeat = true;
			} else if (tryCnt >= 4) {
				slct = 0;
			}

		} while (repeat);
		
		return slct;
	}
}