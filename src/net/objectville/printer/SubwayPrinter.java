package net.objectville.printer;

import net.objectville.subway.Connection;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class SubwayPrinter {
    PrintStream stream;

    public SubwayPrinter(PrintStream stream) {
        this.stream = stream;
    }

    public OutputStream printDirections(List<Connection> path) {
        Connection connection = path.get(0);
        String currentLine = connection.getLineName();
        String prevousLine = currentLine;
        stream.println("Start out at " + connection.getStation1() + ".\n");
        stream.println("Get on the " + connection.getLineName() + " heading towards " + connection.getStation2());

        for (int i = 1; i < path.size(); i++) {
            connection = path.get(i);
            currentLine = connection.getLineName();
            if (currentLine.equals(prevousLine)) {
                stream.println("\tContinue past " + connection.getStation1() + "...");
            } else {
                stream.println("When you get to " + connection.getStation1() + ", get off the " + prevousLine);
                stream.println("Switch over to the " + currentLine + " heading towards " + connection.getStation2() + ".");
                prevousLine = currentLine;
            }

        }
        stream.println("Get off at " + connection.getStation2() + " and enjoy yourself!");

        return stream;
    }
}
