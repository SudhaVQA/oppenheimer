package com.app.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropValues{

	public String filePath;
	
	public ReadPropValues(String filePath) {
		this.filePath=filePath;
	}
	
	public String readProperty(String propKey) throws Exception {
		String propVal="";
		try {
			int check=0;
			while(check==0) {
				File readPropFile = new File(filePath);
				if(readPropFile.exists()) {
					Properties prop = new Properties();
					FileInputStream fis = new FileInputStream(readPropFile);
					prop.load(fis);
					propVal=prop.getProperty(propKey);
					check=1;					
				}
				else {
					check=0;
				}
			}
			
		}catch (Exception e) {
			
			throw e;
		}
		
		
		return propVal;
		
	}
}
