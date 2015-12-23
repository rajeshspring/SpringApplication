package com.contoller;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;


public class JasperReportTest
{
 public static void main(String args[])
 {
	 try {
		JasperReport jasperReport = JasperCompileManager.compileReport("D:/spring_workspace/EMP/WebContent/WEB-INF/reports/helloworld.jrxml");
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, new HashMap(), new JREmptyDataSource()); 
		JasperExportManager.exportReportToPdfFile(jasperPrint, "HelloJasper.pdf");
		System.out.println("HelloJasper.pdf has been generated!");
		//http://localhost:8484/EMP/employeeJasperReport.html

		
	} catch (JRException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}      

 }
	
}
