package pl.sda.urbaniec.movie_mvc.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.urbaniec.movie_mvc.data.entity.User;
import pl.sda.urbaniec.movie_mvc.web.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/user"})
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(@ModelAttribute(value = "user") User user) {
        return "registrationForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationForm(@ModelAttribute(value = "user") @Valid User user, Errors errors) {
        if(errors.hasErrors()){
            return "registrationForm";
        }
        userService.addUser(user);
        return "redirect:/user/register/"+user.getUserName();
    }

    @RequestMapping(value = "/register/{userName}", method = RequestMethod.GET)
    public String showProfile(Model model, @PathVariable String userName) {
        model.addAttribute("userData", userService.findUserByUserName(userName));
        return "profile";
    }
}
