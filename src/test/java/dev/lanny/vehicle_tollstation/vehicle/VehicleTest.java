package dev.lanny.vehicle_tollstation.vehicle;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VehicleTest {

    @Test
    @DisplayName("Validate create a Vehicle with license plate, VehicleType and toll amount")
    void test_Should_Create_Vehicle_With_Fields() {

        VehicleType type = VehicleType.CAR;
        String licensePlate = "ABC123";
        BigDecimal tollAmount = new BigDecimal("100.00");

        Vehicle vehicle = new Vehicle(licensePlate, tollAmount, type);

        assertEquals(licensePlate, vehicle.getLicensePlate());
        assertEquals(tollAmount, vehicle.getTollAmount());
        assertEquals(type, vehicle.getType());
    }

    @Test
    @DisplayName("Validate allow updating vehicle fields through setters")
    void test_Should_Update_Vehicle_Fields() {
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate("ZZZ999");
        vehicle.setTollAmount(new BigDecimal("75.00"));
        vehicle.setType(VehicleType.TRUCK);

        assertEquals("ZZZ999", vehicle.getLicensePlate());
        assertEquals(new BigDecimal("75.00"), vehicle.getTollAmount());
        assertEquals(VehicleType.TRUCK, vehicle.getType());
    }

}
