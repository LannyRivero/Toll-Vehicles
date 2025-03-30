package dev.lanny.vehicle_tollstation.tollStation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import dev.lanny.vehicle_tollstation.vehicle.Vehicle;
import dev.lanny.vehicle_tollstation.vehicle.VehicleDTO;

public class TollService {

    private final Map<Long, TollStation> tollStations = new HashMap<>();

    public void addTollStation(Long id, TollStation station) {
        tollStations.put(id, station);
    }

    public TollStation getTollStation(Long id) {
        return tollStations.get(id);
    }

    public Vehicle registerVehicle(VehicleDTO dto) {
        if (dto.getType() == null) {
            throw new IllegalArgumentException("Vehicle type cannot be null");
        }
        BigDecimal tollAmount;

        switch (dto.getType()) {
            case CAR -> tollAmount = new BigDecimal("100.00");
            default -> throw new IllegalArgumentException("Unsupported vehicle type");
        }

        return new Vehicle(dto.getLicensePlate(), tollAmount, dto.getType());
    }

}
