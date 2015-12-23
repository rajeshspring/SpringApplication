package com.contoller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

@Controller
public class EmployeeController  {
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired(required=true)
	EmployeeSevice employeeSevice;
	
	@Autowired(required=true)
	MasterService masterService;	
	
	@Autowired(required=true)
	private EmployeeValidator employeeValidator;
	
	
	@InitBinder("UserForm")
	private void initBinder(WebDataBinder binder)
	{
	binder.setValidator(employeeValidator);
	}
	
	Employee employee=null;

	@RequestMapping(value="/addemployee",method=RequestMethod.GET)
    public String showForm(@ModelAttribute EmployeeForm userForm, Model model,HttpSession session,HttpServletRequest request,Locale locale)
			{
		    System.out.println("><>?<<?<<?<  url "+request.getRequestURL().toString());
		    //http://localhost:8484/EMP/parentdistrictName.html
		    //D:\spring_workspace\EMP\src\com\contoller
			try
			{
			List stateList=masterService.getStateName();
			List districtList=masterService.getDistrictName();
			
			/*fatch full data of employee on load employee */
			String page=null;
			List<Employee> employeeList=null;
			employeeList=employeeSevice.getAllRecords(page);
     		model.addAttribute("emp_list",employeeList);
     		model.addAttribute("userForm",userForm);
					
							
			if(stateList.size()>0)
			{
			model.addAttribute("stateList",stateList);
			}
			else
			{
			model.addAttribute("stateList", "select");
			}
			}
			
		    catch(Exception e)
			{
			e.printStackTrace();
			logger.error("Test error message ", new Exception("Testing"));
			}
		     if(logger.isDebugEnabled()){
			logger.debug("Test Log messqage!");
		     }
    		return "addemployee";
    		}
	
	@RequestMapping(value = "/saveemployee", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute EmployeeForm userForm, BindingResult result, HttpSession session,
			 HttpServletRequest request,Model model)
    	       {
		       try
		        {
		    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@111111111111111");
			    employeeValidator.validate(userForm,result);
			    model.addAttribute("userForm",userForm);
			    System.out.println("@@@@@@@@@@@@@@@@@@@@@@22222222222222222");
			    {
				if(result.hasErrors())
				{
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@33333333333333333");
				model.addAttribute("userForm",userForm);
				return "addemployee";
				}  
				else
				{
			 System.out.println("@@@@@@@@@@@@@@@@@@@@@@4444444444444444");
		     employeeSevice.addEmpDetails(userForm);
		model.addAttribute("userForm",userForm);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@555555555555555555555555555");
		model.addAttribute("data","Data Saved Sucessfuly ");
        return "redirect:manageEmployee.html";
		        }
				
			    }
		        }
		  catch(Exception e)
		    {
			e.printStackTrace(); 
			logger.error("Employee Action ", new Exception("Employee Action"));
		    }
		  return "redirect:manageEmployee.html";
    	    }
	
	@RequestMapping(value="/manageEmployee",method=RequestMethod.GET)
    public String employeeManage(@RequestParam(value = "page", required = false) String page,Model model,HttpSession session,EmployeeForm userForm,HttpServletRequest request,Locale locale)
			{
		List<Employee> employeeList=null;
		List stateList=masterService.getStateName();
		List districtList=masterService.getDistrictName();
				
		if(stateList.size()>0)
		{
		model.addAttribute("stateList",stateList);
		}
		else
		{
		model.addAttribute("stateList", "select");
		}
		
		employeeList=employeeSevice.getAllRecords(page);
		model.addAttribute("emp_list",employeeList);
		model.addAttribute("userForm",userForm);
		return "manageEmployee";
			}
	
	
	//Parent District Name
	@RequestMapping(value="/parentdistrictName", method=RequestMethod.POST)
	public @ResponseBody List<District> getParentStateList(@ModelAttribute(value="parentdistrict")String parentdistrict, BindingResult br, HttpSession session,
			HttpServletRequest request,HttpServletResponse response,Model model)
	    {
		System.out.println("Ajax call >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+request.getParameter("stateId"));
		List<District> list=null;
		try
		{
	    State state=new State();
	    Long stateId = (long) Integer.parseInt(request.getParameter("stateId"));
	    state.setState_id(stateId);
	    list=masterService.getDistrictNameBysate(state);
		model.addAttribute("districtList",list);
	   
	    if(list.size()>0)
	    {
	    return list;
	    }
		}
		catch(Exception e)
		{
		e.printStackTrace();
		//logger.error("parentdistrictName", new Exception("Employee Action"));
		}
	    return list;
		}
	
	//Office District Name
	@RequestMapping(value="/officedistrictName", method=RequestMethod.POST)
	public @ResponseBody List<District> getOfficeStateList(@ModelAttribute(value="parentdistrict")String parentdistrict, BindingResult br, HttpSession session,
			HttpServletRequest request,HttpServletResponse response,Model model)
	    {
		System.out.println("Ajax call >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+request.getParameter("stateId"));
		List<District> list=null;
		try
		{
	    State state=new State();
	    Long stateId = (long) Integer.parseInt(request.getParameter("stateId"));
	    state.setState_id(stateId);
	    list=masterService.getDistrictNameBysate(state);
		//model.addAttribute("districtList",list);
	    
	    if(list.size()>0)
	    {
	    return list;
	    }
		}
		catch(Exception e)
		{
		e.printStackTrace();
		logger.error("getOfficeStateList", new Exception("Employee Action"));
		}
	    return list;
		}
	
	/* Employee view */
	@RequestMapping(value="/viewemployee",method=RequestMethod.GET)
    public String viewEmployeeDetails(@RequestParam(value = "Id", required = false) Long Id, Model model,HttpSession session,EmployeeForm userForm,HttpServletRequest request,Locale locale)
			{
		List<Employee> employeeList=null;
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> employee view call"+Id);
		Employee employee=new Employee();
		employee.setEmpId(Id);
		employeeList=employeeSevice.employeeView(employee);
		model.addAttribute("employeeList",employeeList);
		model.addAttribute("userForm",userForm);
		return "viewemployee";
    		}
	
	
	/* Employee Delete */
	@RequestMapping(value="/deleteEmployee",method=RequestMethod.GET)
   public String deleteEmployeeDetails(@RequestParam(value="Id", required=false)Long Id, Model model, HttpSession session,EmployeeForm userForm,HttpServletRequest request)
   {
	    List<Employee> employeeList=null;
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> employee view call"+Id);
		Employee employee=new Employee();
		employee.setEmpId(Id);
		employeeList=employeeSevice.employeeView(employee);
		for(Employee emp: employeeList)
		{
		userForm.setEmpId(Long.toString(emp.getEmpId()));
		model.addAttribute("userForm",userForm);	
		}
		model.addAttribute("employeeList",employeeList);
		model.addAttribute("userForm",userForm);
	  return "deleteEmployee";
   }
	
	/* delete employee after confirmation by the user */
	@RequestMapping(value="/deleteEmployeeByUser",method=RequestMethod.POST)
	   public String deleteEmployeeDetailsByUser(Model model, HttpSession session,EmployeeForm userForm,HttpServletRequest request)
	   { 
		
		try{
		    List<Employee> employeeList=null;
		    List stateList=masterService.getStateName();
			List districtList=masterService.getDistrictName();
			if(userForm.getEmpId()!=null)
			{
			employee=new Employee();	
			employee.setEmpId(Long.parseLong(userForm.getEmpId()));
			employeeSevice.employeeDelete(employee);
			System.out.println(">>>>>> delete method call controller");			
			}
			
			if(stateList.size()>0)
			{
			model.addAttribute("stateList",stateList);
			}
			else
			{
			model.addAttribute("stateList", "select");
			}
			
			/*get list of full data of employee on load employee */
			String page=null;
			employeeList=employeeSevice.getAllRecords(page);
     		model.addAttribute("emp_list",employeeList);
     		model.addAttribute("userForm",userForm);
		   }
		catch (Exception e)
		{
		e.printStackTrace();	
	   	}
	    return "addemployee";
	    }
	
	/* update employee */
	@RequestMapping(value="/updateEmployee",method=RequestMethod.GET)
	   public String updateEmployeeDetailsByUser(@RequestParam(value="Id", required=false)Long Id,Model model, HttpSession session,EmployeeForm userForm,HttpServletRequest request)
	   { 
		
		try{
			
			List stateList=masterService.getStateName();
			//List districtList=masterService.getDistrictName();
			if(stateList.size()>0)
			{
			model.addAttribute("stateList",stateList);
			}
			else
			{
			model.addAttribute("stateList", "select");
			}
			
		    List<Employee> employeeList=null;
		   	employee=new Employee();	
			employee.setEmpId(Id);
			userForm=employeeSevice.updateEmployee(employee);
			model.addAttribute("userForm",userForm);
			
			/*get list of full data of employee on load employee */
			String page=null;
			employeeList=employeeSevice.getAllRecords(page);
  		    model.addAttribute("emp_list",employeeList);
		   }
		catch (Exception e)
		{
		e.printStackTrace();	
	   	}
	    return "addemployee";
	    }
	
	
	/* Dwr calling */
	@RequestMapping(value="/callDwr",method=RequestMethod.GET)
    public String callDwr(Model model,HttpSession session,HttpServletRequest request,Locale locale)
	{
	
		System.out.println(" DWR calling >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return "callDwr";
	}

	/* Jasper report */
	
	public String jasperReport(@RequestParam(value="Id", required=false)Long Id,Model model, HttpSession session,EmployeeForm userForm,HttpServletRequest request)
	   { 
	    employee.setEmpId(Id);
		employeeSevice.employeeDetailsWithJasper(employee);
	   return "jasper report";
	   }
}







