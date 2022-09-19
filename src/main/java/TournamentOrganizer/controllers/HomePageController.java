package TournamentOrganizer.controllers;

import TournamentOrganizer.models.data.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/home")
    public String displayEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
        String sendToTemplateViewEventsIndex = "events/homePage";
        return sendToTemplateViewEventsIndex;
    }
}
