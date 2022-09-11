package main;

import core.MulticastApp;
import parser.NetworkParser;

public class Main {
    public static void main(String[] args) {
    	new MulticastApp(new NetworkParser().getNetworkContext("config.properties"));
    }
}

