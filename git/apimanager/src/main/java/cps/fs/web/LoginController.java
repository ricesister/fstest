package cps.fs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import cps.fs.service.AuthUserService;

/**
 * 
 * @description
 * @author fs
 * @2018年8月23日
 *
 */

@Controller
public class LoginController {
	
	@Autowired
	private AuthUserService authUserService;
	
	public ModelAndView login() {
		
	}
	

}
