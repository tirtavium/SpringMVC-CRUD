package id.or.linuxjak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LinkController {

	@RequestMapping(value="/")
	public ModelAndView mainPage(){
		return new  ModelAndView("redirect:/user/list");
	}
	
	@RequestMapping(value="/index")
	public ModelAndView indexPage(){
		return new  ModelAndView("redirect:/user/list");
	}
	
	@RequestMapping(value="/ajax")
	public ModelAndView ajaxPage(){
		return new  ModelAndView("userAjax");
	}
	
}
