This application connects to twitter streaming API (https://stream.twitter.com/1.1/) and performs simple analytics over the tweets calculation. It calculates the percent of tweets that have an odd number of words in the tweet text and prints this statistics on screen.

Following filters are supported, you can add or update filters in twitter.stream.constant.ApplicationConstants.java file.
- Language - Current implementation is for English.
- Location - Current implementation is for tweets coming from NY, Chicago or San Francisco.

To get started:

- Clone this repository or download zip
- Import into your favorite IDE
- Add twitter credentials (consumer key, consumer secret, outh token and outh secret) to the constants defined at the top of twitter.stream.constant.ApplicationConstants.java file. Twitter credentials can be obtained from https://dev.twitter.com/.
- Run twitter.stream.statistics.TwitterProcessStreamTest.java

Application will print statistics in the following manner:

Total tweets -> 5.0
Tweets containing odd number of words -> 3.0
Percent of tweets containing odd number of words -> 60.000004
