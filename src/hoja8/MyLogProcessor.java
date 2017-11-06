/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja8;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
/**
 *
 * @author mario
 */
public class MyLogProcessor implements Processor{


    @Override
    public void process(Exchange exchng) throws Exception {
        System.out.println("Now Processing the String: " + exchng.getIn().getBody(String.class));
    }
    
}
