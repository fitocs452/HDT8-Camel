/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja8;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
/**
 *
 * @author mario
 */
public class Hoja8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyRouteBuilder rb = new MyRouteBuilder();
        CamelContext ctx = new DefaultCamelContext();
        
        try{
            ctx.addRoutes(rb);
            ctx.start();
            Thread.sleep(5*60*1000);
            ctx.stop();            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
