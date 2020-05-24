package springauthenticationservice.springauthenticationservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springauthenticationservice.springauthenticationservice.model.User;

@RestController
public class UserController {
	
	@GetMapping("/users")
	public List<User>  getEmployeesList() {
        List<User> users = new ArrayList<User>();
        User emp = new User();
        emp.setUserId(1);
        emp.setUserName("Amit");
        users.add(emp);
        emp = new User();
        emp.setUserId(2);
        emp.setUserName("Akash");
        users.add(emp);
        return users;
    }
	
	@GetMapping("/")
	public String  startApp() {
       return "Application up and Running";
    }
	

}
