package airline;

import airline.Model.Flight;
import airline.Model.TravelClass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FlightRepository {


    public List<Flight> getFlightInformation() {
         ArrayList<Flight> flights = new ArrayList<Flight>();
//        flights.add(new Flight("HYD", "BLR","F1",200,190, LocalDate.now()));
//        flights.add(new Flight("HYD", "PUN","F2", 100,98,LocalDate.of(2017, Month.OCTOBER,8)));
//        flights.add(new Flight("BLR", "PUN","F3", 150,149,LocalDate.of(2017, Month.OCTOBER,10)));
//        flights.add(new Flight("HYD", "BLR","F4", 100,98,LocalDate.of(2017, Month.SEPTEMBER,5)));

        flights.add(new Flight("HYD", "BLR","F1", LocalDate.now(),getTravelClassInformation()));
        flights.add(new Flight("HYD", "PUN","F2", LocalDate.of(2017, Month.OCTOBER,8),getTravelClassInformation()));
        flights.add(new Flight("BLR", "PUN","F3", LocalDate.of(2017, Month.OCTOBER,10),getTravelClassInformation()));
        flights.add(new Flight("HYD", "BLR","F4",LocalDate.of(2017, Month.SEPTEMBER,5),getTravelClassInformation()));


        return flights;
    }

    public List<TravelClass> getTravelClassInformation() {
    List<TravelClass> travelClassList=new ArrayList<TravelClass>();
        travelClassList.add(new TravelClass(TravelClass.TravelClassName.Business,15,10));
        travelClassList.add(new TravelClass(TravelClass.TravelClassName.Economy,80,75));
        travelClassList.add(new TravelClass(TravelClass.TravelClassName.First,5,3));
    return travelClassList;
    }
}
