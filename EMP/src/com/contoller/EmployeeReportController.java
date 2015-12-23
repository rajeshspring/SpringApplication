package com.contoller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.formbean.EmployeeForm;
import com.master.pojo.District;
import com.master.pojo.State;
import com.pojo.Employee;
import com.service.EmployeeSevice;
import com.service.MasterService;
import com.validator.EmployeeValidator;
import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
/* Jasper report */
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class EmployeeReportController
{
	private static final Logger logger = Logger.getLogger(EmployeeReportController.class);
	
	@Autowired(required=true)
	EmployeeSevice employeeSevice;
	
	@Autowired(required=true)
	MasterService masterService;	
	@RequestMapping(value="/employeeJasperReport",method=RequestMethod.GET)
	public String employeeJasperReport(@RequestParam(value = "type", required = false) String type,@ModelAttribute EmployeeForm userForm, Model model,HttpSession session,HttpServletRequest request,Locale locale) throws JRException
	 {
		System.out.println(">>>>>>>>>>>>>>> Report type"+type);
		Employee employee=null;
		List<Employee> employeeList=employeeSevice.employeeDetailsWithJasper(employee);
		model.addAttribute("url",request.getRequestURL().toString());
		System.out.println("url >>>>>>>>>>>"+request.getRequestURL().toString());
		model.addAttribute("url", request.getRequestURL().toString());
		
		JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(employeeList);
		model.addAttribute("datasource", beanCollectionDataSource);
		
        if(type.equals("PDF"))
        {
        return "employeeJasperpdf";	
        }
        else if(type.equals("CSV"))
        {
        return "employeeJaspercsv";	
        }
        return "employeeJasperxls";	
		
	}
	

}
