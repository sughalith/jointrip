package pl.jointrip.controllers.logged.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.jointrip.dao.CommentsRepository;
import pl.jointrip.dao.TripRepository;
import pl.jointrip.dao.UserRepository;
import pl.jointrip.models.Comments;
import pl.jointrip.models.Trip;
import pl.jointrip.services.tripService.TripService;
import pl.jointrip.services.userService.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TripController {

    @Autowired
    TripRepository tripRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    TripService tripService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/addTrip", method = RequestMethod.GET)
    public ModelAndView addTripForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("trip_form", new Trip());
        modelAndView.setViewName("trip/add-trip-form");
        return modelAndView;
    }

    @RequestMapping(value = "/addTrip", method = RequestMethod.POST)
    public ModelAndView addTripForm(@Valid Trip tripEntity) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("trip_form", new Trip());
        modelAndView.addObject("message", tripService.addedTripNotification(tripEntity));
        modelAndView.setViewName("trip/add-trip-form");
        return modelAndView;

    }

    @RequestMapping(value = "/showTrip", params = "ide", method = RequestMethod.GET)
    public ModelAndView showTrip(@RequestParam("ide") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Comments> comments = commentsRepository.findAll();
        modelAndView.addObject("userInfo", userService.getLoggedUser());
        modelAndView.addObject("tripInfo", tripRepository.findById(id));
        modelAndView.addObject("commentForm", new Comments());
        modelAndView.setViewName("trip/show-trip");
        return modelAndView;
    }

    @RequestMapping(value = "/showTrip", params = "ide", method = RequestMethod.POST)
    public ModelAndView addCommentForm(@Valid Comments comment, @RequestParam("ide") int tripId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tripInfo", tripRepository.findById(tripId));
        modelAndView.addObject("commentForm", new Comments());
        modelAndView.addObject("message", tripService.addedCommentNotification(comment, tripId));
        modelAndView.setViewName("trip/show-trip");
        return modelAndView;
    }

    @RequestMapping(value = "/showTrip", params = "join", method = RequestMethod.GET)
    public ModelAndView joinToTrip(@RequestParam("join") int id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("commentForm", new Comments());
        modelAndView.addObject("tripInfo", tripRepository.findById(id));
        modelAndView.addObject("message", tripService.joinedTripNotification(id));
        modelAndView.setViewName("trip/show-trip");
        return modelAndView;
    }

    @RequestMapping(value = "/showTrips", method = RequestMethod.GET)
    public ModelAndView showTrips() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Trip> trips = tripService.findTripByTripMembersNot();
        modelAndView.addObject("userInfo", userService.getLoggedUser());
        modelAndView.addObject("show_trips", trips);
        modelAndView.setViewName("trip/trips");
        return modelAndView;
    }

    @RequestMapping(value = "/myTrips", method = RequestMethod.GET)
    public ModelAndView myTrips() {
        ModelAndView modelAndView = new ModelAndView();
        List<Trip> trips = tripService.joinedTripsByUser();
        modelAndView.addObject("userInfo", userService.getLoggedUser());
        modelAndView.addObject("show_trips", trips);
        modelAndView.setViewName("trip/trips");
        return modelAndView;
    }
}