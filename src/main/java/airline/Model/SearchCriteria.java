package airline.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchCriteria {
    private String source;
    private String destination;
    private int numberOfPassengers=1;
    private LocalDate departureDate;
    private String departureDateString;
    private String travelClass;

    public SearchCriteria() {

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

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public LocalDate getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {

        this.departureDate = departureDate;
    }

    public String getDepartureDateString() {
        return departureDateString;
    }

    public void setDepartureDateString(String departureDateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if(departureDateString!= null && !departureDateString.isEmpty() )
            this.departureDate = LocalDate.parse(departureDateString);
        else
            this.departureDate = null;
        this.departureDateString = departureDateString;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

}
