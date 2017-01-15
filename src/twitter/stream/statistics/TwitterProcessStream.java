/*
 * Reads Twitter's live stream feed using the twitter4j library.
 */

package twitter.stream.statistics;

import java.util.logging.Level;
import java.util.logging.Logger;
import twitter.stream.constant.ApplicationConstants;
import twitter.stream.util.CommonUtils;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author Rajneesh Mishra
 */
public class TwitterProcessStream {

    /**
     * This method process twitter live stream. odd.
     *
     * @return Nothing.
     */
    void processStream() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(ApplicationConstants.ConsumerKey)
                .setOAuthConsumerSecret(ApplicationConstants.ConsumerSecret)
                .setOAuthAccessToken(ApplicationConstants.oauth_token)
                .setOAuthAccessTokenSecret(ApplicationConstants.oauth_token_secret)
                .setStreamBaseURL(ApplicationConstants.twitter_streaming_api);

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build())
                .getInstance();
        StatusListener listener;
        listener = new StatusListener() {
            float totalTweets;
            float oddTweets;

            @Override
            public void onStatus(Status status) {
                 /**
                 * Initializes every time it receives a tweet
                 */
                totalTweets++;

                if (CommonUtils.containsOddWords(status.getText())) {
                    oddTweets++;
                }
                try {
                    //Print stream Stats
                    CommonUtils.log("Total tweets", String.valueOf(totalTweets));
                    CommonUtils.log("Tweets containing odd number of words", String.valueOf(oddTweets));
                    CommonUtils.log("Percent of tweets containing odd number of words", String.valueOf(CommonUtils.calculatePercentage(oddTweets, totalTweets)));
                    
                    CommonUtils.log ("","");
                    CommonUtils.log ("","");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onException(Exception ex) {
                ex.printStackTrace();
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {

            }

            @Override
            public void onStallWarning(StallWarning arg0) {
                // TODO Auto-generated method stub
                System.out.println(arg0);
            }

            @Override
            public void onTrackLimitationNotice(int arg0) {
                // TODO Auto-generated method stub
                System.out.println(arg0);
            }

        };

        twitterStream.addListener(listener);
        FilterQuery filterQuery = new FilterQuery();
        //Apply Language Filter
        filterQuery.language(ApplicationConstants.language);
        //Apply Location Filter for NY, Chicago and San Francisco
        filterQuery.locations(ApplicationConstants.locations);
        twitterStream.filter(filterQuery);
        try {
            Thread.sleep(50000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TwitterProcessStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        twitterStream.cleanUp();
        twitterStream.shutdown();

    }

}
