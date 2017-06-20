package com.govdvla.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileReader {

	String configValue = "";
	

	public String getPropValue(String propHeader) throws IOException
	{
		String result="";
		InputStream inputStream;
				
		try{
			
			Properties prop = new Properties();
			String propFileName = "vehicleinfo.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			
			if (inputStream != null)
			{
				prop.load(inputStream);
				
			}
			else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			result = prop.getProperty(propHeader);


		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}

		return result;
	}
	
	
	public String fetchPropValue(String valueToFetch)
	{

		try{

			configValue = getPropValue(valueToFetch);
		}
		catch(Exception e)
		{
			System.out.println("Exception: " + e);
		}

		return configValue;
	}

	
}
