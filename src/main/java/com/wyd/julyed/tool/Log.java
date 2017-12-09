package com.wyd.julyed.tool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	private static Logger logger = LogManager.getLogger(Log.class);

	public static Logger getLogger() {
		return logger;
	}

	public static void log(String info) {
		logger.info(info);
	}
}