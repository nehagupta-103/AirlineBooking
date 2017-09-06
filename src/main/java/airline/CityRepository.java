package airline;

import airline.Model.City;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {
    private List<City> places = new ArrayList<City>();
    public  CityRepository()
    {
        populatePlaces();
    }
    public List<City> getPlaces()
    {
        return places;
    }

    public void populatePlaces()
    {
        places.add(new City("HYD"));
        places.add(new City("BLR"));
        places.add(new City("PUN"));

    }
}
