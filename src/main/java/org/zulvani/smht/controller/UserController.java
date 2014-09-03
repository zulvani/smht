package org.zulvani.smht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.zulvani.smht.domain.UserAccounts;
import org.zulvani.smht.service.AuthManagerService;

@Controller
public class UserController {

	@Autowired
	private AuthManagerService authManagerService;

	@RequestMapping(method = RequestMethod.GET, value = "welcome.htm")
	public ModelAndView test(
			@RequestParam(value = "name", required = false) String name) {

		List<UserAccounts> userAccounts = authManagerService
				.findAllUserAccounts();
//
		for (UserAccounts ua : userAccounts) {
			name = ua.getUsername();
		}

		ModelAndView model = new ModelAndView("welcome");
		model.addObject("name", (name == null) ? "Test" : name);

		return model;
	}
}