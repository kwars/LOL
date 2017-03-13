package test1;

import java.util.ArrayList;  
import java.util.List;  

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>This is a code example of Twitter4J Streaming API - sample method support.<br>
 * Usage: java twitter4j.examples.PrintSampleStream<br>
 * </p>
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public class PrintSampleStream {
    /**
     * Main entry of this application.
     *
     * @param args arguments doesn't take effect with this example
     * @throws TwitterException when Twitter service or network is unavailable
     * @throws IOException 
     * @throws InterruptedException 
     */
	public List<Map<String,Object>> tweets = new ArrayList<Map<String,Object>>();
	public void hahaha() throws TwitterException, IOException, InterruptedException{
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("i0n6tTbAS7wGHXxeCJqVYFg67")
		  .setOAuthConsumerSecret("iYwGt1ybCdYt5pSm4OXG7Yt9bD2OsCXrNOp07ZLTdy5JdXAutx")
		  .setOAuthAccessToken("757886108755648512-zHNQeNHslw82XC63xMo2Ia7C3uL5o4R")
		  .setOAuthAccessTokenSecret("vgBJxpk0dUUq5u5OwZKqmoz9tYivFTVAAXHnqx1Ad23eb");
		TwitterStreamFactory tf = new TwitterStreamFactory(cb.build());

		 TwitterStream twitterStream = tf.getInstance();
	        StatusListener listener = new StatusListener() {
	            @Override
	            public void onStatus(Status status) {					
							Map<String,Object> map = new HashMap<String,Object>();
							map.put("username",status.getUser().getScreenName());
							map.put("text", status.getText());
							map.put("latitude", (status.getGeoLocation()) != null?status.getGeoLocation().getLatitude():40.75);
							map.put("longitude", (status.getGeoLocation())!=null?status.getGeoLocation().getLongitude():-73.97);
							tweets.add(map);
	            }

	            @Override
	            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
	                /*try {
						//fw.write("Got a status deletion notice id:" + statusDeletionNotice.getStatusId()+"\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
	            }

	            @Override
	            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
	                /*try {
						//fw.write("Got track limitation notice:" + numberOfLimitedStatuses+"\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
	            }

	            @Override
	            public void onScrubGeo(long userId, long upToStatusId) {
	               /* try {
						//fw.write("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId+"\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
	            }

	            @Override
	            public void onStallWarning(StallWarning warning) {
	                //try {
						//fw.write("Got stall warning:" + warning+"\n");
					//} catch (IOException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					//}
	            }

	            @Override
	            public void onException(Exception ex) {
	                ex.printStackTrace();
	            }
	        };
	        FilterQuery fq = new FilterQuery();
	        fq.locations(new double[][]{new double[]{-126.562500,30.448674},
                new double[]{-61.171875,44.087585
                }}); 
	        fq.language(new String[]{"en"});
	        //String keywords = "pepsi";
	        //fq.track(keywords);
	        twitterStream.addListener(listener);
	        twitterStream.filter(fq);
	        Thread.sleep(8000);
	        twitterStream.shutdown();
	       // fw.close();
	}
	
	
   // public static void main(String[] args) throws TwitterException, IOException, InterruptedException {
    //	PrintSampleStream ps = new PrintSampleStream();
    	//ps.hahaha();
    //}
}