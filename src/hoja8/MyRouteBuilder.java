/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja8;

/**
 *
 * @author mario
 */
public class MyRouteBuilder extends org.apache.camel.builder.RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("twitter://search?type=direct&keywords=BigData&consumerKey=HqHOnhDl9dVtvIgH51HHacGby&consumerSecret=eKiRuSFh6SBiEWzbN1ZXagLbJ1OlRmEuS1Cpz9dMn2rZIy8Hvw&accessToken=81978272-46rRm1Uhp6AHZuCNbeEO9vlJN3pKKrZaqNRaQU3P0&accessTokenSecret=xGEk8Hz1EsYSlUwYiz9N1wqsFpvnuw1r1JjJQlY2j0kDD")
                .process(new MyLogProcessor())
                .bean(new MyTransformer(), "TransformContent")
                .to("file:C:/Users/mario/Desktop/UVG/10. Decimo Semestre/CC3048 - Programacion y Tecnologias Integradoras/HDT/8/hoja8/output");
    }
    
}
