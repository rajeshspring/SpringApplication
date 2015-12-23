package com.validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Test
{
	
public static void main(String args[])
{
	Properties properties = null;
	try {
		File file = new File("D:/spring_workspace/EMP/resource/messages_en.properties");
		FileInputStream fileInput = new FileInputStream(file);
		properties = new Properties();
		properties.load(fileInput);
		
		
		System.out.println(">>>>>>>>>>>>>>>>>>>"+properties.getProperty("username.required"));
		fileInput.close();

		Enumeration enuKeys = properties.keys();
		while (enuKeys.hasMoreElements()) {
			String key = (String) enuKeys.nextElement();
			String value = properties.getProperty(key);
			System.out.println(key + ": " + value);
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}

