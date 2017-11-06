package org.apache.camel.example.websocket;

import org.apache.camel.main.Main;

public final class CamelTwitterWebSocketMain {

    private static String consumerKey = "TPLoe8PN2TCATZYKycwska0Ef";
    private static String consumerSecret = "r3qhYd97xki0CrE54KfWc54cUIf5PXo6Kmpo7yS3mdtofDwAhe";
    private static String accessToken = "51641956-BRMySfya9S3IcnbaiH2VIu3tiq5JxLxf4tUy7tWCw";
    private static String accessTokenSecret = "OYFWoh5D7zsU1MQ12usqHMShLcI78G4HHGzhjp3sIPdB7";

    private CamelTwitterWebSocketMain() {
        // to pass checkstyle we have a private constructor
    }

    public static void main(String[] args) throws Exception {
        // create a new Camel Main to start Camel
        Main main = new Main();

		// create a ROUTE
        TwitterWebSocketRoute route = new TwitterWebSocketRoute();

        // setup twitter application authentication
        route.setAccessToken(accessToken);
        route.setAccessTokenSecret(accessTokenSecret);
        route.setConsumerKey(consumerKey);
        route.setConsumerSecret(consumerSecret);

        route.setSearchTerm("lol");

        route.setDelay(10000);

        // web socket on port 9090
        route.setPort(9090);

        // add our routes to Camel
        main.addRouteBuilder(route);
		
        main.run();
    }

}
