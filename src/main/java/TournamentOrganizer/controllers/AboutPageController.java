package TournamentOrganizer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutPageController {

    //about page controllers and handling

    @GetMapping(value = "about")
    public String displayAboutPage(Model model) {
        model.addAttribute("title", "about");
        String viewAboutPage = "/about";
        return viewAboutPage;
    }
}
