/*
 * Contains public global constants.
 */
package twitter.stream.constant;

/**
 *
 * @author Rajneesh Mishra
 */
public class ApplicationConstants {

    //Twitter credentials to connect to streaming API.
    public static final String ConsumerKey = "***";
    public static final String ConsumerSecret = "***";
    public static final String oauth_token = "***";
    public static final String oauth_token_secret = "***";

    public static final String twitter_streaming_api = "https://stream.twitter.com/1.1/";


    /*
    
    - Geocodes taken from https://www.mapdevelopers.com/geocode_bounding_box.php
    
    NYC - North Latitude: 40.917577 South Latitude: 40.477399 East Longitude: -73.700272 West Longitude: -74.259090
    Chicago - North Latitude: 42.023131 South Latitude: 41.644335 East Longitude: -87.523661 West Longitude: -87.940267
    San Francisco - North Latitude: 37.929824 South Latitude: 37.639830 East Longitude: -122.281780 West Longitude: -123.173825
    
    - First block contains west-lon and south-Lat and second block east-lon and north-lat 
    
     */
    public static final double[][] locations = {{-87.940267, 41.644335}, {-87.523661, 42.023131}, {-123.173825, 37.639830}, {-122.281780, 37.929824}, {-74.259090, 40.477399}, {-73.700272, 40.917577}};

    //Language set to English (en)
    public static final String[] language = new String[]{"en"};

}
