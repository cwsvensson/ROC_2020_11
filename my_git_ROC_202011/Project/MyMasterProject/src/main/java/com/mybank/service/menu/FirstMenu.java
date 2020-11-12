package com.mybank.service.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mybank.exception.BankingException;

public class FirstMenu<inRead> {
	
	public static void firstMenu(Scanner scanner) throws BankingException {
		
		String firstMenuName = "First_Menu.txt";
		FileActions ff = new FileActions();
		List<String> wholeMenu = new ArrayList<>();

		try {
			wholeMenu = ff.fileReads(firstMenuName);
			
		} catch(BankingException err) {
			throw new BankingException("Rethrown from First Menu");
		}
		
		boolean exit = false;
		int loop = 0;
		int cnt, cntr, slct= 0;
		
		while(!exit && loop++ <= 10) {
			
			cntr = 0;
			cnt = ff.printMenu(wholeMenu, cntr);

			if (--cnt == cntr) {
				throw new BankingException("Error - "+ firstMenuName +" has no selections available");
			}
			
			slct = ff.getMenuSelection(scanner, cnt);
			exit = (slct >= 0 && slct <= cnt);
		}
		
		if (slct > 0) {
			String menuLine = ff.parseMenuForAction(wholeMenu, slct);
			Sv.log.debug("Returned from parseMenuForAction :" + menuLine);
			
			if (slct==1) {
				ReturningLogin rl = new ReturningLogin();
				rl.oldLogin(scanner);
			} else if (slct == 2) {
				NewLogon nl = new NewLogon();
				nl.makeNewLogin(scanner);
			}
		}
		
		Sv.log.info("");
		Sv.log.info("Thank you for stopping by.  Come back soon.");
		Sv.log.info("");
		
		return; // not really needed...
	}
}