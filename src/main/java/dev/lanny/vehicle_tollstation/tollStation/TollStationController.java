package dev.lanny.vehicle_tollstation.tollStation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/report")
    public ResponseEntity<String> printReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== Reporte de: ")
                .append(tollStation.getName()).append(", ")
                .append(tollStation.getCity()).append(" ===\n");
        report.append("Vehículos atendidos:\n");

        for (Vehicle v : tollStation.getRegisteredVehicles()) {
            report.append("Matrícula: ").append(v.getLicensePlate())
                    .append(", Peaje: ").append(v.getTollAmount()).append("$\n");
        }

        report.append("\nTotal recolectado: ").append(tollStation.getTotalCollected()).append("$");
        return ResponseEntity.ok(report.toString());
    }
}
