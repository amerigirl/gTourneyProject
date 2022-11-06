package TournamentOrganizer.controllers;

import TournamentOrganizer.models.User;
import TournamentOrganizer.models.data.UserRepository;
import TournamentOrganizer.models.dto.LoginFormDTO;
import TournamentOrganizer.models.dto.RegistrationFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;


@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;


//working with sessions for the user
private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

    Optional<User> user = userRepository.findById(userId);

    if (user.isEmpty()) {
        return null;
        }

        return user.get();
    }

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    //registration page controllers and handling

    @GetMapping("/registrationPage")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegistrationFormDTO());
        model.addAttribute("title", "Register");
        return "registrationPage";
    }



    @PostMapping("/registrationPage")
    public String processRegistrationForm(@ModelAttribute @Valid RegistrationFormDTO registrationFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "registrationPage";
        }


        //get username from repo
        User existingUser = userRepository.findByUsername(registrationFormDTO.getUsername());


        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "register";
        }

        //get password and verify password info
        String password = registrationFormDTO.getPassword();
        String verifyPassword = registrationFormDTO.getVerifyPassword();

            if (!password.equals(verifyPassword)) {
                errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
                model.addAttribute("title", "Register");
                return "registrationPage";
            }

        // saves a user to the repo
        User newUser = new User(registrationFormDTO.getUsername(), registrationFormDTO.getPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:/home";
    }

    //login page controllers and handling(mirrors registration page controllers)

    @GetMapping("/login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        return "/login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors, HttpServletRequest request,
                                   Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "/login";
        }

        //get the user from the repo and error handling

    User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "Username does not exist. Please register or try again");
            model.addAttribute("title", "Log In");
            return "/login";
        }

        String password = loginFormDTO.getPassword();

        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Log In");
            return "/login";
        }
        //give user permissions by setting the user in session
        setUserInSession(request.getSession(), theUser);

        return "redirect:/home";
    }

    //log user out
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }

    }

