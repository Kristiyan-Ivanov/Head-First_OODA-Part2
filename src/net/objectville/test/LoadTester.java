package net.objectville.test;

import net.objectville.loader.SubwayLoader;
import net.objectville.subway.Subway;

import java.io.File;
import java.io.IOException;

public class LoadTester {

    public static void main(String[] args) {
        SubwayLoader loader = new SubwayLoader();
        File inputFile = new File("C:\\Users\\kristiyan.ivanov\\IdeaProjects\\Head-First-OODA-GSF\\src\\ObjectvilleSubway.txt");
        Subway subway = testLoadSubway(loader, inputFile);
        testStations(subway, "SRP Square", "Choc-O-Holic, Inc", "OOA&D Oval");
        testConnections(subway, "UML Walk", "Objectville PizzaStore", "Booch Line");
        testConnections(subway, "XHTML Expressway", "Weather-O-Rama, inc.", "Wirfs-Brock Line");
        testConnections(subway, "CSS Center", "Head First Theater", "Meyer Line");
    }

    public static Subway testLoadSubway(SubwayLoader loader, File subwayFile) {
        System.out.println("\nTesting loading subway object from file using the SubwayLoader module.");
        Subway subway;
        try {
            subway = loader.loadFromFile(subwayFile);
            System.out.println("Test passed");
            return subway;
        } catch (IOException e) {
            System.out.println("Test failed: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public static void testStations(Subway subway, String station1, String station2, String station3) {
        System.out.println("\nTesting if the stations are properly loaded from the file");
        if (!subway.hasStation(station1)) {
            System.out.println("Test failed: " + station1 + "is not on the subway network");
            return;
        } else if (!subway.hasStation(station2)) {
            System.out.println("Test failed: " + station2 + "is not on the subway network");
            return;
        } else if (!subway.hasStation(station3)) {
            System.out.println("Test failed: " + station3 + "is not on the subway network");
            return;
        }
        System.out.println("Test passed.");
    }

    public static void testConnections(Subway subway, String station1, String station2, String lineName) {
        System.out.println("\nTesting connections in line: " + lineName);
        if (subway.hasConnection(station1, station2, lineName)) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed: there is no connection between" + station1 + " and " + station2 + "on line " + lineName);
        }
    }
}
