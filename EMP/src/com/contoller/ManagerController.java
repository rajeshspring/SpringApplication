package com.contoller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.MetaValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.formbean.OnsideEmployeesForm;
import com.formbean.ProjectsDetailForm;
import com.pojo.Manager;
import com.service.MasterService;

@Controller
public class ManagerController
{
@Autowired(required=true)
MasterService masterService;	


@RequestMapping(value="/findManager",method=RequestMethod.GET)
public String managerDetails(@ModelAttribute ProjectsDetailForm  projectForm, Model model,HttpSession session,HttpServletRequest request,Locale locale)
{
List<Manager> managerList=null;
try
{
managerList=masterService.getManagerDetails();
if(managerList.size()>0)
{
model.addAttribute("managerLis", managerList);
}
else
{
model.addAttribute("managerList", "No Data Found");
}

}
catch(Exception e)
{
e.printStackTrace();	
}
model.addAttribute("projectForm",projectForm);
return "managerDetails";
}

// Add EmployeesAcording Manager

@RequestMapping(value="/addOnsideEmployees",method=RequestMethod.POST)
public String addOnsideEmployees(@ModelAttribute OnsideEmployeesForm  onsideEmployeesForm, Model model,HttpSession session,HttpServletRequest request,Locale locale)
{
	
System.out.println(">>>>>>>>>>>>  Emp Name"+ onsideEmployeesForm.getEmp_name());	
System.out.println(">>>>>>>>>>>>  Emp Address"+ onsideEmployeesForm.getEmp_address());	
	
	
List<Manager> managerList=null;
try
{
managerList=masterService.getManagerDetails();
if(managerList.size()>0)
{
model.addAttribute("managerLis", managerList);
}
else
{
model.addAttribute("managerList", "No Data Found");
}

}
catch(Exception e)
{
e.printStackTrace();	
}
model.addAttribute("onsideEmployeesForm",onsideEmployeesForm);
return "addOnsideEmployee";
}


}
