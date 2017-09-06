package airline.Service;

import airline.CityRepository;
import airline.FlightRepository;
import airline.Model.Flight;
import airline.Model.City;
import airline.Model.SearchCriteria;
import airline.Model.TravelClass;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    private FlightRepository flightRepository;
    private CityRepository cityRepository;

    public FlightService() {
        this.flightRepository = new FlightRepository();
        this.cityRepository = new CityRepository();
    }


    public List<Flight> getFlightInformation() {
        return flightRepository.getFlightInformation();
    }

    public List<City> getPlaces() {
        return cityRepository.getPlaces();

    }

    public List<Flight> search(SearchCriteria searchCriteria) {
        List<Flight> flights = flightRepository.getFlightInformation();
        if(searchCriteria.getDepartureDate() != null) {
            return flights.stream()
                    .filter(x -> x.getSource().equals(searchCriteria.getSource()))
                    .filter(x -> x.getDestination().equals(searchCriteria.getDestination()))
                    .filter(x -> x.getNumberOfAvailableSeats() >= searchCriteria.getNumberOfPassengers())
                    .filter(x -> x.getFlightDepartureDate().isEqual(searchCriteria.getDepartureDate()))
                    .collect(Collectors.toList());
        }
        else{
            return flights.stream()
                    .filter(x -> x.getSource().equals(searchCriteria.getSource()))
                    .filter(x -> x.getDestination().equals(searchCriteria.getDestination()))
                    .filter(x -> x.getNumberOfAvailableSeats() >= searchCriteria.getNumberOfPassengers())
                    .collect(Collectors.toList());
        }

    }
    public List<Flight> searchUsingTravelClass(SearchCriteria searchCriteria) {
        List<Flight> flights = flightRepository.getFlightInformation();
        if(searchCriteria.getDepartureDate() != null) {
            return flights.stream()
                    .filter(x -> x.getSource().equals(searchCriteria.getSource()))
                    .filter(x -> x.getDestination().equals(searchCriteria.getDestination()))
                    .filter(x->x.getTravelClass(searchCriteria.getTravelClass()).getNumberOfAvailableSeats()>=searchCriteria.getNumberOfPassengers())
                    .filter(x -> x.getFlightDepartureDate().isEqual(searchCriteria.getDepartureDate()))
                    .collect(Collectors.toList());
        }
        else{
            return flights.stream()
                    .filter(x -> x.getSource().equals(searchCriteria.getSource()))
                    .filter(x -> x.getDestination().equals(searchCriteria.getDestination()))
                    .filter(x->x.getTravelClass(searchCriteria.getTravelClass()).getNumberOfAvailableSeats()>=searchCriteria.getNumberOfPassengers())
                    .collect(Collectors.toList());
        }

    }

    public List<String> getTravelClassList(){
        List<String> travelClassList = new ArrayList<String>();
        for(TravelClass.TravelClassName travelClass: TravelClass.TravelClassName.values()) {
            travelClassList.add(travelClass.toString());
        }
        return travelClassList;
    }

}
