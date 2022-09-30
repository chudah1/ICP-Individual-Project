/**
 * @author Chudah
 * This class serves as an abstraction for encapsulating details about a route's destination airport code, airline code
 * no of stops made, and distance betweeen a destination airport and source airport
 */
public class Data {
    private String destAirportCode;
    private String airlineCode;
    private int stops;
    private double distanceBetweenDestination;

    public Data(String airlineCode, String destAirportCode,  int stops) {
        this.destAirportCode = destAirportCode;
        this.airlineCode = airlineCode;
        this.stops = stops;
        this.distanceBetweenDestination = distanceBetweenDestination;
    }

    public String getDestAirportCode() {
        return destAirportCode;
    }

    public String getAirlineCode() {
        return airlineCode;
    }


    public int getStops() {
        return stops;
    }

    public double getDistanceBetweenDestination() {
        return distanceBetweenDestination;
    }
}
