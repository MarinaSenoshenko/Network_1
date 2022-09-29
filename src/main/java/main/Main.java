package main.java.main;

import main.java.core.MulticastApp;
import main.java.parser.NetworkParser;

public class Main {
    public static void main(String[] args)  {
    	 try {
    	      if (args.length < 1) {
                  System.out.println("Not enough arguments\nYou should type ip address");    
                  System.exit(0);
              }    		
              new MulticastApp(new NetworkParser().getNetworkContext("/config.properties", args[0]));
	 } catch (InterruptedException e) {
	      e.printStackTrace();
         }    
    }
}

