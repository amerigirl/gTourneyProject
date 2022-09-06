package TournamentOrganizer.controllers;

import TournamentOrganizer.models.Login;
import TournamentOrganizer.models.Registration;
import TournamentOrganizer.models.data.LoginPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.sql.SQLException;


@Controller
public class LoginPageController {

    @Autowired
    LoginPageRepository loginPageRepository;


    @GetMapping("login")
    public String displayLoginPage(Model model) {
        model.addAttribute("title", "create login");
        model.addAttribute(new Login());
        return "login";
    }


    @PostMapping("login")
    public String processLoginForm(@ModelAttribute @Valid Login newLogin,
                                   Errors errors, Model model, @RequestParam String userLogin,
                                   @RequestParam String userPassword) {

        Login login = new Login(userLogin, userPassword);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create title"); //not sure if we need this first set of error handling
            model.addAttribute("loginError", "Please check details");

            if (userLogin.length() <= 2) {
                model.addAttribute("title", "Create title");
                model.addAttribute("usernameLengthError", "username must be at least 3 characters in length");
            }

            if (userPassword.length() <= 2) {
                model.addAttribute("title", "Create title");
                model.addAttribute("passwordLengthError", "password must be at least 3 characters in length");
                return "login";
            }


        }
        loginPageRepository.save(login);
        return "index";
    }
}



//how does the login page talk to the main page??

