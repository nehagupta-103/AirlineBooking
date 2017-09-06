package airline.Controller;

import airline.Service.FlightService;
import airline.Model.Flight;
import airline.Model.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;
    public FlightController()
    {

    }

    @RequestMapping(value = "/")
    public String populateData(Model model)
    {
        try{
            model.addAttribute("cities",flightService.getPlaces());
            model.addAttribute("travelClasses",flightService.getTravelClassList());
            model.addAttribute("searchCriteria", new SearchCriteria());
        }
        catch(Exception ex){
            ex.printStackTrace();

        }
        return "flightSearch";
    }

    @RequestMapping(value = "/searchFlights", method= RequestMethod.POST)
    public String searchFlights(@ModelAttribute(value = "searchCriteria")SearchCriteria searchCriteria, Model model) {
        //System.out.println(searchCriteria.getDepartureDateString());
        List<Flight> availableFlights = flightService.searchUsingTravelClass(searchCriteria);

        model.addAttribute("searchResults", availableFlights);
        model.addAttribute("cities",flightService.getPlaces());
        model.addAttribute("travelClasses",flightService.getTravelClassList());
        return "flightSearch";
    }



}