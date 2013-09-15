package id.or.linuxjak.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import id.or.linuxjak.controller.domain.UserControllerDomain;
import id.or.linuxjak.controller.validator.UserValidator;
import id.or.linuxjak.domain.User;
import id.or.linuxjak.domain.UserInfo;
import id.or.linuxjak.service.UserService;
import id.or.linuxjak.util.DomainControllertoDomain;
import id.or.linuxjak.util.DomainToControllerDomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/user")
public class UserManageController {

	@Autowired
	UserValidator userValidator;
	
	@Autowired
	UserService userService;
	
	private String message="";
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 dateFormat.setLenient(false); 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView addUserPage(){
		ModelAndView modelAndView = new ModelAndView("useradd");
		UserControllerDomain ucd = new UserControllerDomain();
		ucd.setJob("1");
		modelAndView.addObject("ucd",ucd);
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addUserProsses(@ModelAttribute("ucd") UserControllerDomain ucd,
			BindingResult result, SessionStatus status){
		ModelAndView modelAndViewUser = new ModelAndView("useradd");
		ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
		
		userValidator.validate(ucd, result);
		
	//	BindingResult errors = getBindingResult(result, ucd);
		
		if(result.hasErrors()){
			
			return modelAndViewUser;
		}else{
			status.setComplete();
			userService.create(DomainControllertoDomain.UserControllertoUser(ucd));
			message = "User successfull add";
		
			return modelAndView;
		}
		
		
	}
	
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Long id){
		ModelAndView modelAndView = new ModelAndView("useredit");
		UserControllerDomain ucd = DomainToControllerDomain.domaintoController(userService.findUserbyId(id));
		modelAndView.addObject("action","/user/edit/proccess");				
		modelAndView.addObject("url","/user");		
		modelAndView.addObject("ucd",ucd);
		return modelAndView;
	}
	
	/*
	 * @ModelAttribute untuk model form dan ("ucd") untuk validator BindingResult result
	 */
	@RequestMapping(value="/edit/proccess",method=RequestMethod.POST)
	public ModelAndView editUserprosses(@ModelAttribute("ucd") UserControllerDomain ucd,BindingResult result, SessionStatus status){
		ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
		ModelAndView modelAndViewError = new ModelAndView("useredit");
		System.out.println(ucd.getId()+" id");
		userValidator.validate(ucd, result);
		if(result.hasErrors()){
			modelAndViewError.addObject("action","/user/edit/proccess");				
			modelAndViewError.addObject("url","/user");		
			modelAndViewError.addObject("ucd",ucd);
			
		return modelAndViewError;
		}else{
		
		User user1 = userService.findUserbyId(ucd.getId());
		UserInfo usi = user1.getUserInfo();
		usi.setName(ucd.getName());
		usi.setJob(ucd.getJob());
		usi.setLastName(ucd.getLastName());
		usi.setAddress(ucd.getAddress());
		
		user1.setUsername(ucd.getUsername());
		user1.setPassword(ucd.getPassword());
		user1.setUserInfo(usi);
	
	
		userService.update(user1);
		message = "User successfull updated";
		return modelAndView;
		}
		}
	
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ModelAndView deleteUserPage(@PathVariable Long id){
		ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
		userService.delete(userService.findUserbyId(id));
		message = "User successfull delete";
		return modelAndView;
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView listUserPage(){
		ModelAndView modelandView = new ModelAndView("userList");
		List<UserControllerDomain> listUcd = DomainToControllerDomain.domaintoControllerList(userService.getAll());
		
		modelandView.addObject("userList", listUcd);
		modelandView.addObject("message", message);
		
		message = "";
		return modelandView;
		
		
	}


	
	
	@ModelAttribute("jobList")
	public Map<String,String> getJobList(){
		Map<String,String> job = new LinkedHashMap<String,String>();
		job.put("1", "Pelajar");
		job.put("2", "Karyawan");
		job.put("3", "Wirausahawan");
		
		return job;
	}
	
	
	/*
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@ModelAttribute("ucd") UserControllerDomain ucd,
			BindingResult result, SessionStatus status){
		
		userValidator.validate(ucd, result);
		
		if(result.hasErrors()){
			
			return "userView";
		}else{
			status.setComplete();
			userService.create(DomainControllertoDomain.UserControllertoUser(ucd));
			
			return "userSuccess";
		}
		
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String initForm(ModelMap model) {
		// TODO Auto-generated method stub
		UserControllerDomain ucd = new UserControllerDomain();
		ucd.setJob("1");
		model.addAttribute("ucd",ucd);
		return "userView";
		
	}
	

	
	*/
	
	
	
	
}
