package dev.lanny.vehicle_tollstation.tollStation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.lanny.vehicle_tollstation.vehicle.Vehicle;

@RestController
public class TollStationController {
    private final TollStation tollStation;

    public TollStationController(TollStation tollStation) {
        this.tollStation = tollStation;
    }

    @PostMapping("/toll")
    public ResponseEntity<?> collectToll(@RequestBody Vehicle vehicle) {
        tollStation.addVehicle(vehicle);
        return ResponseEntity.ok().build();
    }
}
