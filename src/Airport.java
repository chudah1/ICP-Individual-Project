import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Airport {
    /**
     * If the string is null or empty, return true. Otherwise, loop through the string and return false if any character is
     * not whitespace
     *
     * @param s The string to check.
     * @return A boolean value.
     */
    public static boolean isBlank(String s) {
        int stringLength;
        if (s == null || (stringLength = s.length()) == 0) {
            return true;
        }
        for (int i = 0; i < stringLength; i++) {
            if ((Character.isWhitespace(s.charAt(i))) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * The function reads the airport file and creates a hashmap with the city and country as the key and the IATA and ICAO
     * codes as the values
     *
     * @return A HashMap of the airport locations and their IATA and ICAO codes.
     */
    public static HashMap<String, ArrayList<String>> readAirports() throws FileNotFoundException {
        File airportfile = new File("C:\\Users\\USER\\OneDrive - Ashesi University\\airports.csv");
        Scanner scan = new Scanner(airportfile);
        //{'London, United Kingdom':['LTN', 'LGW'}
        HashMap<String, ArrayList<String>> airportLocation = new HashMap<>();
        while (scan.hasNextLine()) {
            //Pattern pattern = Pattern.compile(",.*,.*,.*,.*,.*,.*,.*,.*,.*,.*,.*,.*,", Pattern.CASE_INSENSITIVE);
            String data = scan.nextLine();
            //Matcher matcher = pattern.matcher(data);
            String[] dataArray = data.split(",");
            if (dataArray[4].equals("\\N")) continue;
            String airportCode = dataArray[4];
            String cityCountry = dataArray[2] + ',' + dataArray[3];
            airportLocation.putIfAbsent(cityCountry, new ArrayList<String>());
            airportLocation.get(cityCountry).add(airportCode);

        }
        scan.close();
        return airportLocation;

    }

    /**
     * It takes a csv file of airport codes and their corresponding longitudes and latitudes and returns a hashmap of
     * airport codes and their corresponding longitudes and latitudes
     *
     * @return A HashMap of airport codes and their corresponding longitudes and latitudes.
     */
    public static HashMap<String, String> AiportLongLat() throws FileNotFoundException {
        File airportfile = new File("C:\\Users\\USER\\OneDrive - Ashesi University\\airports.csv");
        Scanner scan = new Scanner(airportfile);
        HashMap<String, String> airportLongtitudes = new HashMap<>();
        while (scan.hasNextLine()) {
            //Pattern pattern = Pattern.compile("\\d.*,.*[a-zA-Z].*,[a-zA-Z].*,[a-zA-Z].*,.*,.*,.*,\\d.*,[a-zA-Z].*[a-zA-Z].*,.*,[a-zA-Z]", Pattern.CASE_INSENSITIVE);
            //String [] data = scan.nextLine().split);
            //Matcher matcher = pattern.matcher(data);
            System.out.println(scan.nextLine());
            String[] dataArray = scan.nextLine().split(",", -1);
            System.out.println(dataArray[1]);
            if (dataArray[4].equals("\\N")) continue;
            String airportCode = dataArray[4];
            String LatAndLong = dataArray[6] + ',' + dataArray[7];
            airportLongtitudes.put(airportCode, LatAndLong);
        }
        scan.close();
        return airportLongtitudes;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //for (String airport : readAirports().keySet()) System.out.println(airport + readAirports().get(airport));
        System.out.println(AiportLongLat().get("TRF"));
        //for (String airport : AiportLongLat().keySet()) System.out.println(airport +":" + AiportLongLat().get(airport));

    }

}


