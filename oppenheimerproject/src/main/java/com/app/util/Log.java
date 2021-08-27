package com.app.util;

import org.apache.log4j.Logger;

public class Log {

	public static Logger Log = Logger.getLogger(Log.class);//

	public static void startTestCase(String sTestCaseName){

		Log.info("-----------------"
				+ "$$$$$                Start_"+sTestCaseName+ "       $$$$"
						+ "-----------------");

	}

	public static void endTestCase(String sTestCaseName){
		Log.info("-----------------"
				+ "$$$$$                 End"+sTestCaseName+ "       $$$$$"
						+ "-----------------");
		}

	public static void info(String message) {
		Log.info(message);
	}


	public static void error(String message) {
		Log.error(message);
	}



}
