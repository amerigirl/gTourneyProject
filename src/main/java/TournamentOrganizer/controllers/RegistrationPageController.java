package TournamentOrganizer.controllers;

import TournamentOrganizer.models.Registration;
import TournamentOrganizer.models.data.RegistrationPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;


@Controller
public class RegistrationPageController {

    @Autowired
    private RegistrationPageRepository registrationPageRepository;

    //display signup page
    @GetMapping("registrationPage")
    public String displayRegistrationPage(Model model) {
        model.addAttribute("title", "create registration");
        model.addAttribute(new Registration());
                return "registrationPage";
    }


    //process user registrations
    @PostMapping("registrationPage")
    public String processUserRegistration(@ModelAttribute @Valid Registration newRegister,    //newRegister is never called...ummm??
                                          Errors errors, Model model, @RequestParam String username,
                                                                      @RequestParam String emailAddress,
                                                                      @RequestParam String password,
                                                                      @RequestParam String verifyPassword) {

        Registration register = new Registration(username,emailAddress,password,verifyPassword); //can newRegister go here?

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create title");
            model.addAttribute("emailError", "Please check email address");

            if(username.length() <= 2){
                model.addAttribute("title", "Create title");
                model.addAttribute("lengthError", "username must be at least 3 characters in length");
            }

            if(!register.getPassword().equals(register.getVerifyPassword())) {
                model.addAttribute("title", "Create title");
                model.addAttribute("PasswordMatchError", "Passwords do not match");
                return "registrationPage";
            }
    }
        registrationPageRepository.save(register);
        return "login";
    }
}
