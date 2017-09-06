package airline.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {

    private String source;
    private String destination;
    private String flightNumber;
    private LocalDate flightDepartureDate;
    private List<TravelClass> travelClassList;

    public Flight(){
        travelClassList=new ArrayList<TravelClass>();
    }
    public Flight(String source, String destination, String flightNumber,LocalDate flightDepartureDate,List<TravelClass> travelClassList)
    {
        this.source = source;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.flightDepartureDate = flightDepartureDate;
        this.travelClassList=travelClassList;

    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getFlightNumber()
    {
        return this.flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getTotalNumberOfSeats() {
        int noOfSeats=0;
        for(TravelClass travelClass:travelClassList)
            noOfSeats+=travelClass.getTotalSeats();
        return noOfSeats ;
    }
    public int getBookedSeats() {
        int noOfSeats=0;
        for(TravelClass travelClass:travelClassList)
            noOfSeats+=travelClass.getBookedSeats();
        return noOfSeats ;
    }

    public int getNumberOfAvailableSeats(){
        int noOfSeats=0;
        for(TravelClass travelClass:travelClassList)
            noOfSeats+=travelClass.getNumberOfAvailableSeats();
        return noOfSeats ;
    }

    public LocalDate getFlightDepartureDate() {
        return flightDepartureDate;
    }

    public void setFlightDepartureDate(LocalDate flightDepartureDate) {
        this.flightDepartureDate = flightDepartureDate;
    }

    public List<TravelClass> getTravelClassList() {
        return travelClassList;
    }

    public void setTravelClassList(List<TravelClass> travelClassList) {
        this.travelClassList = travelClassList;
    }

    public TravelClass getTravelClass(String travelClass) {
        return travelClassList.stream()
                .filter(x -> x.getTravelClassName().toString().equals(travelClass))
                .collect(Collectors.toList()).get(0);
    }
}
