package ru.mail.urbanovichalexandr.samples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class LogForBd {

	static Logger log = LogManager.getLogger(LogForBd.class.getName());

	@Test
	public void createTest() {
		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message!");
		log.warn("Warn Message!");
		log.error("Error Message!");
		log.fatal("Fatal Message!");
	}
	
}
