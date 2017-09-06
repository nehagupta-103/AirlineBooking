package airline.Model;

public class City {
    private String cityId;



    private String cityName;

    public String getCityId() {
        return cityId;
    }
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public String getPlaceName() {
        return this.cityName;
    }
}
