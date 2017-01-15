/*
 * Test twitter process stream
 */
package twitter.stream.statistics;

/**
 *
 * @author Rajneesh Mishra
 */
public class TwitterProcessStreamTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TwitterProcessStream tps = new TwitterProcessStream();
        
        try {
            /*
            * Method to initiate the twitter stream processing
            * To change filters and/or supply twitter credentials
            * modify twitter.feed.constant.ApplicationConstant.java
            */
            
            tps.processStream();

        } catch (Exception te) {
            te.printStackTrace();
        }

    }

}
