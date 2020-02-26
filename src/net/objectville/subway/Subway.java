package net.objectville.subway;

import java.util.*;

public class Subway {
    private List<Station> stations;
    private List<Connection> connections;
    private Map<Station, List<Station>> network;

    public Subway() {
        this.stations = new LinkedList<>();
        this.connections = new LinkedList<>();
        this.network = new HashMap<>();
    }

    public void addStation(String stationName) {
        if (!this.hasStation(stationName)) {
            Station station = new Station(stationName);
            stations.add(station);
        }
    }

    public boolean hasStation(String stationName) {
        return stations.contains(new Station(stationName));
    }

    public void addConnection(String stationName1, String stationName2, String lineName) {
        if ((this.hasStation(stationName1)) &&
                (this.hasStation(stationName2))) {
            Station station1 = new Station(stationName1);
            Station station2 = new Station(stationName2);
            Connection connection = new Connection(station1, station2, lineName);
            if (!hasConnection(stationName1, stationName2, lineName))
                connections.add(connection);
            connections.add(new Connection(station2, station1, lineName));
            addToNetwork(station1, station2);
            addToNetwork(station2, station1);
        } else {
            throw new RuntimeException("Invalid connection!");
        }
    }


    private void addToNetwork(Station station1, Station station2) {
        if (network.keySet().contains(station1)) {
            List<Station> connectingStations = network.get(station1);
            if (!connectingStations.contains(station2)) {
                connectingStations.add(station2);
            }
        } else {
            List<Station> connectingStations = new LinkedList<>();
            connectingStations.add(station2);
            network.put(station1, connectingStations);
        }
    }

    public List<Connection> getDirections(String startStationName, String endStationName) {
        if (!this.hasStation(startStationName) || !this.hasStation(endStationName))
        {
            throw new RuntimeException("Stations entered do not exist on this subway");
        }

        Station start = new Station(startStationName);
        Station end = new Station(endStationName);
        List<Connection> route = new LinkedList<>();
        List<Station> reachableStations = new LinkedList<>();
        Map<Station, Station> previousStations = new HashMap<>();
        List<Station> neighbors = network.get(start);

        for (Station station : neighbors) {
            if (station.equals(end)) {
                route.add(getConnection(start, end));
                return route;
            } else {
                reachableStations.add(station);
                previousStations.put(station, start);
            }
        }

        List<Station> nextStations = new LinkedList<>(neighbors);
        Station currentStation;

        searchLoop:
        for (int i = 1; i < stations.size(); i++) {
            List<Station> tmpNextStations = new LinkedList<>();
            for (Station station : nextStations) {
                reachableStations.add(station);
                currentStation = station;
                List<Station> currentNeighbors = network.get(currentStation);
                for (Station neighbor : currentNeighbors) {
                    if (neighbor.equals(end)) {
                        reachableStations.add(neighbor);
                        previousStations.put(neighbor, currentStation);
                        break searchLoop;
                    } else if (!reachableStations.contains(neighbor)) {
                        reachableStations.add(neighbor);
                        tmpNextStations.add(neighbor);
                        previousStations.put(neighbor, currentStation);
                    }
                }
            }
            nextStations = tmpNextStations;
        }

        //We've found the path now!
        boolean keepLooping = true;
        Station keyStation = end;
        Station station;

        while (keepLooping) {
            station = previousStations.get(keyStation);
            route.add(0, getConnection(station, keyStation));
            if (start.equals(station)) {
                keepLooping = false;
            }
            keyStation = station;
        }

        return route;
    }

    private Connection getConnection(Station station1, Station station2) {
        for (Connection connection : connections) {
            Station one = connection.getStation1();
            Station two = connection.getStation2();
            if ((station1.equals(one)) && station2.equals(two)) {
                return connection;
            }
        }
        return null;
    }


    public boolean hasConnection(String station1Name, String station2Name, String lineName) {
        Station station1 = new Station(station1Name);
        Station station2 = new Station(station2Name);
        for (Connection connection : connections) {
            if (connection.getLineName().equalsIgnoreCase(lineName)) {
                if ((connection.getStation1().equals(station1)) &&
                        (connection.getStation2().equals(station2))) {
                    return true;
                }
            }
        }
        return false;
    }

}
