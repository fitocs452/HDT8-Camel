package org.apache.camel.example.websocket;

import org.apache.camel.main.Main;

public final class CamelTwitterWebSocketMain {

    private static String consumerKey = "HqHOnhDl9dVtvIgH51HHacGby";
    private static String consumerSecret = "eKiRuSFh6SBiEWzbN1ZXagLbJ1OlRmEuS1Cpz9dMn2rZIy8Hvw";
    private static String accessToken = "81978272-46rRm1Uhp6AHZuCNbeEO9vlJN3pKKrZaqNRaQU3P0";
    private static String accessTokenSecret = "xGEk8Hz1EsYSlUwYiz9N1wqsFpvnuw1r1JjJQlY2j0kDD";

    private CamelTwitterWebSocketMain() {
        // to pass checkstyle we have a private constructor
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\n\n\n\n");
        System.out.println("===============================================");
        System.out.println("Open your web browser on http://localhost:9090/index.html");
        System.out.println("Press ctrl+c to stop this example");
        System.out.println("===============================================");
        System.out.println("\n\n\n\n");

        // create a new Camel Main to start Camel
        Main main = new Main();

		// create a ROUTE
        TwitterWebSocketRoute route = new TwitterWebSocketRoute();

        // setup twitter application authentication
        route.setAccessToken(accessToken);
        route.setAccessTokenSecret(accessTokenSecret);
        route.setConsumerKey(consumerKey);
        route.setConsumerSecret(consumerSecret);

		//FILTERING A SEARCH WORD
        route.setSearchTerm("partido");
		
		
        // twitter rate limits 180 per 15 min, so that is 0.2/sec, eg 1/5sec.
        // so to be safe we do 6 seconds
        route.setDelay(6000);

        // web socket on port 9090
        route.setPort(9090);

        // add our routes to Camel
        main.addRouteBuilder(route);
		
        main.run();
    }

}
