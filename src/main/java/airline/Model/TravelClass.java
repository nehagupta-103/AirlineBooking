package airline.Model;

public class TravelClass {

    public enum TravelClassName{
        Economy,
        Business,
        First
    };
    private TravelClassName travelClassName;
    private int totalSeats;
    private int bookedSeats;

    public TravelClass(TravelClassName travelClassName,int totalSeats) {
        this.travelClassName = travelClassName;
        this.totalSeats=totalSeats;
    }

    public TravelClass(TravelClassName travelClassName,int totalSeats,int bookedSeats ) {
        this.travelClassName = travelClassName;
        this.totalSeats=totalSeats;
        this.bookedSeats=bookedSeats;
    }

    public TravelClassName getTravelClassName() {
        return travelClassName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getNumberOfAvailableSeats(){
        return totalSeats-bookedSeats;
    }

}
