package dev.lanny.vehicle_tollstation.tollStation;

import java.util.HashMap;
import java.util.Map;

public class TollService {

     private final Map<Long, TollStation> tollStations = new HashMap<>();

    public void addTollStation(Long id, TollStation station) {
        tollStations.put(id, station);
    }

    public TollStation getTollStation(Long id) {
        return tollStations.get(id);
    }


}
