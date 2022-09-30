public class Harvesine {
    /**
     * The Haversine formula is used to calculate the distance between two points on a sphere given their longitudes and
     * latitudes
     *
     * @param sourceAirportLatitude Latitude of the source airport
     * @param sourceAirportLongtitude The longtitude of the source airport
     * @param destAirportLat Latitude of the destination airport
     * @param destAirportLong The longitude of the destination airport
     * @return The distance between two airports.
     */
    public static double haversine(double sourceAirportLatitude, double sourceAirportLongtitude, double destAirportLat, double destAirportLong){
        final double RADIUSOFTHEEARTH = 6371;
        // convert to radians
        sourceAirportLatitude = Math.toRadians(sourceAirportLatitude);
        destAirportLat = Math.toRadians(destAirportLat);

        // distance between latitudes and longitudes
        double latDifference = Math.toRadians(destAirportLat - sourceAirportLatitude);
        double longDifference = Math.toRadians(destAirportLong - sourceAirportLongtitude);
        /*
        a = sin²(ΔlatDifference/2) + cos(lat1).cos(lt2).sin²(ΔlonDifference/2)
        c = 2.atan2(√a, √(1−a))
        d = R.c
        // https://www.igismap.com/haversine-formula-calculate-geographic-distance-earth/
         */
        double a = Math.pow(Math.sin(latDifference / 2), 2) + Math.pow(Math.sin(longDifference / 2), 2) * Math.cos(sourceAirportLatitude) * Math.cos(destAirportLat);
        double c = 2 * Math.asin(Math.sqrt(a));
        return RADIUSOFTHEEARTH * c;
    }
}
