package TournamentOrganizer.controllers;

import TournamentOrganizer.models.Event;
import TournamentOrganizer.models.data.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    //display event handlers for the main page
    @GetMapping
    public String displayAllEvents(Model model) { //changed to displayAllEvents from displayEvents
        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    //display and process create event form handlers
    @GetMapping(value = "create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return "events/create";
    }

    @PostMapping(value = "create")
    public String processCreateEventForm(
            @ModelAttribute @Valid Event newEvent,
            Errors errors,
            Model model
    ) {
        String sendToTemplateViewEventsCreate = "events/create";

        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return sendToTemplateViewEventsCreate;
        }
        eventRepository.save(newEvent);
        String redirect = "redirect:";
        return redirect;
    }

    //delete event handlers
    @GetMapping(value = "delete")
    public String displayDeleteEventForm(Model model) {

        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", eventRepository.findAll());
            return "events/delete";
    }

    @PostMapping(value = "delete")
    public String processDeleteEventForm(
            @RequestParam(required = false) int[] eventIds) {
        if(eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping(value = "edit/{eventId}")
    public String displayEditEventForm(
            Model model,
            @PathVariable int eventId
    ) {
        Optional<Event> event = eventRepository.findById(eventId);
        Event eventToBeEdit = event.get();
        model.addAttribute("event", eventToBeEdit);
        String title = "Edit Event: " + eventToBeEdit.getName() + " (id=" + eventToBeEdit.getId() + ")";
        model.addAttribute("title", title);
        String sendToTemplateViewEventsEdit =  "events/edit";
        return sendToTemplateViewEventsEdit;
    }

    @PostMapping(value = "edit")
    public String processEditEventForm(
//            Model model,
//            Errors errors,
            int eventId,
            String name,
            String description,
            String city,
            String state,
            String address,
            String competitiveLevel,
            String date,
            String summary,
            String entryFee
    ) {
        String sendToTemplateViewEventsEdit =  "events/edit";
        Optional<Event> event = eventRepository.findById(eventId);
        Event eventToBeEdit = event.get();
        eventToBeEdit.setName(name);
        eventToBeEdit.setDescription(description);
        eventToBeEdit.setCity(city);
        eventToBeEdit.setState(state);
        eventToBeEdit.setAddress(address);
        eventToBeEdit.setCompetitiveLevel(competitiveLevel);
        eventToBeEdit.setDate(date);
        eventToBeEdit.setSummary(summary);
        eventToBeEdit.setEntryFee(entryFee);
//        if(errors.hasErrors()) {
//            model.addAttribute("title", "Edit Event");
//            return sendToTemplateViewEventsEdit;
//        }
        eventRepository.save(eventToBeEdit);
        String redirect = "redirect:";
        return redirect;
    }

    @GetMapping("info/{eventId}")
    public String displayView(Model model, @PathVariable int eventId) {

        Optional optEvent = eventRepository.findById(eventId);
        if (optEvent.isPresent()) {
            Event event = (Event) optEvent.get();
            model.addAttribute("event", event);
            return "events/info";
        } else {
            return "redirect:../";
        }
    }

}