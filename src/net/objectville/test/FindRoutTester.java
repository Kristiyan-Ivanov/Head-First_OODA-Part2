package net.objectville.test;

import net.objectville.loader.SubwayLoader;
import net.objectville.printer.SubwayPrinter;
import net.objectville.subway.Connection;
import net.objectville.subway.Subway;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class FindRoutTester {

    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\kristiyan.ivanov\\IdeaProjects\\Head-First-OODA-GSF\\src\\net\\objectville\\test\\ObjectvilleSubway.txt");
        SubwayLoader loader = new SubwayLoader();
        Subway subway;
        try {
            subway = loader.loadFromFile(inputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String startStationName = "XHTML Expressway";
        String endStationName = "JSP Junction";
        List<Connection> path = subway.getDirections(startStationName, endStationName);

        PrintStream stream = new PrintStream(System.out);
        SubwayPrinter printer = new SubwayPrinter(stream);
        printer.printDirections(path);
    }
}
