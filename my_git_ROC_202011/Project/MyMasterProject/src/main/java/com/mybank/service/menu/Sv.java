package com.mybank.service.menu;

import org.apache.log4j.Logger;

public class Sv {

	public static Logger log=Logger.getLogger(Sv.class);

	public static void srvs(String name) {
		log.info("Hello from Service with name = "+name);
	}
}