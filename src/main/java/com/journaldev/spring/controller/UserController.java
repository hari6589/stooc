package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.User;
import com.journaldev.spring.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
	}
	
	//For add and update user both
	@RequestMapping(value="/user/add", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user){
		if(user.getId() == 0){
			//new user, add it
			this.userService.addUser(user);
		}else{
			//existing user, call update
			this.userService.updateUser(user);
		}
		return "redirect:/users";
	}
	
	@RequestMapping("/user/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);
        return "redirect:/users";
    }
 
    @RequestMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        return "user";
    }
	
}