import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Route {
    private String sourceAirportId;
    private String destinationAirportId;
    private int stops;
    private String airlineId;


    /**
     * It reads the routes.csv file and creates a HashMap with the source airport as the key and the value is an ArrayList
     * of objects of the Data class
     *
     * @return The method returns a HashMap with the key being the source airport code and the value being an ArrayList of
     * Data objects.
     */
    public static HashMap<String,ArrayList<Data>> routes() throws FileNotFoundException {
        File routesfile = new File("C:\\Users\\USER\\OneDrive - Ashesi University\\routes.csv");
        Scanner scan = new Scanner(routesfile);
        HashMap<String,ArrayList<Data>> airlineCountry = new HashMap<>();
        // Reading the file line by line.
        while (scan.hasNextLine()){
            String [] data = scan.nextLine().split(",");
            String sourceAirportCode = data[2];
            String destinationAirportCode = data[4];
            String airlineCode = data[0];
            int stops = Integer.parseInt(data[7]);
            System.out.println(destinationAirportCode);
            // Getting the latitude and longitude of the source airport and the destination airport and then using the
            // Harvesine formula to calculate the distance between the two airports.
            double sourceAirportIdLat = 0;
            double sourceAirportIdLong = 0;
            double destinationAirportIdLat= 0;
            double destinationAirportIdLong = 0;

            sourceAirportIdLat = Double.parseDouble(Airport.AiportLongLat().get(sourceAirportCode).split(",")[0]);
            sourceAirportIdLong = Double.parseDouble(Airport.AiportLongLat().get(sourceAirportCode).split(",")[1]);
            destinationAirportIdLat = Double.parseDouble(Airport.AiportLongLat().get(destinationAirportCode).split(",")[0]);
            destinationAirportIdLong = Double.parseDouble(Airport.AiportLongLat().get(destinationAirportCode).split(",")[1]);
            double harvesineDistance = Harvesine.haversine(sourceAirportIdLat, sourceAirportIdLong, destinationAirportIdLat, destinationAirportIdLong);
            Data node = new Data(airlineCode, destinationAirportCode, stops, harvesineDistance);
            // Checking if the key is present in the HashMap. If it is not present, it adds the key and the value to the
            // HashMap. If it is present, it adds the value to the key.
            airlineCountry.putIfAbsent(sourceAirportCode, new ArrayList<>());
            airlineCountry.get(sourceAirportCode).add(node);
        }
        scan.close();


    return airlineCountry;
    }

    public static void main(String[] args) throws FileNotFoundException {
        routes();
    }

}
