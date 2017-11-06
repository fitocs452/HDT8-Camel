package org.apache.camel.example.websocket;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.twitter.search.TwitterSearchComponent;
import org.apache.camel.component.websocket.WebsocketComponent;
import java.io.FileWriter;
import java.io.IOException;

public class TwitterWebSocketRoute extends RouteBuilder {

    private int port = 9090;
    private String searchTerm;
    private int delay = 5000;
    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void configure() throws Exception {
        // setup Camel web-socket component on the port we have defined
        WebsocketComponent wc = getContext().getComponent("websocket", WebsocketComponent.class);
        wc.setPort(port);
		
        // we can serve static resources from the classpath: or file: system
        wc.setStaticResources("classpath:.");

        // setup Twitter component
        TwitterSearchComponent tc = getContext().getComponent("twitter-search", TwitterSearchComponent.class);
        tc.setAccessToken(accessToken);
        tc.setAccessTokenSecret(accessTokenSecret);
        tc.setConsumerKey(consumerKey);
        tc.setConsumerSecret(consumerSecret);

        //Stream from twitter
        fromF("twitter-search://%s?delay=%s", searchTerm, delay)
            .to("log:tweet")
            .to("websocket:camel-tweet?sendToAll=true");

        // try {
        //     FileWriter writer = new FileWriter("MyFile.txt", true);
        //     writer.write("Hello World");
        //     writer.write("\r\n");   // write new line
        //     writer.write("Good Bye!");
        //     writer.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}
