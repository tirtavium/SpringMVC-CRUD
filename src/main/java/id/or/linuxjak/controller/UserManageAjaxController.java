package id.or.linuxjak.controller;

import java.util.List;

import id.or.linuxjak.controller.domain.UserControllerDomain;
import id.or.linuxjak.controller.validator.UserValidator;
import id.or.linuxjak.service.UserService;
import id.or.linuxjak.util.DomainControllertoDomain;
import id.or.linuxjak.util.DomainToControllerDomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping(value = "/users")
public class UserManageAjaxController {

	@Autowired
	UserValidator userValidator;

	@Autowired
	UserService userService;
	
	private Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(@RequestBody String ucd) {

//UserControllerDomain usd = gson.fromJson(ucd, UserControllerDomain.class);
		userService.create(DomainControllertoDomain.UserControllertoUser(gson.fromJson(ucd, UserControllerDomain.class)));
return "Oke";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable Long id){
	
		userService.delete(userService.findUserbyId(id));
		
		
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody String listUserPage(){
	
		List<UserControllerDomain> listUcd = DomainToControllerDomain.domaintoControllerList(userService.getAll());
	
		return gson.toJson(listUcd);
		
		
	}
	
	
	
}
