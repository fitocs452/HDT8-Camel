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
        from("file:C:/Users/mario/Desktop/UVG/10. Decimo Semestre/CC3048 - Programacion y Tecnologias Integradoras/HDT/8/hoja8/input")
                .process(new MyLogProcessor())
                .bean(new MyTransformer(), "TransformContent")
                .to("file:C:/Users/mario/Desktop/UVG/10. Decimo Semestre/CC3048 - Programacion y Tecnologias Integradoras/HDT/8/hoja8/output");
    }
    
}
