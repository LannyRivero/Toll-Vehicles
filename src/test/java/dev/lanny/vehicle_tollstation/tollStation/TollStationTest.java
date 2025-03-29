package dev.lanny.vehicle_tollstation.tollStation;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Locale.Category;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.lanny.vehicle_tollstation.vehicle.Vehicle;
import dev.lanny.vehicle_tollstation.vehicle.VehicleType;

public class TollStationTest {

    @Test
    @DisplayName("Validate create a TollStation with initial values")
    void test_Should_Create_TollStation() {
        TollStation station = new TollStation("Station A", "Madrid");

        assertEquals("Station A", station.getName());
        assertEquals("Madrid", station.getCity());
        assertEquals(BigDecimal.ZERO, station.getTotalCollected());
        assertTrue(station.getRegisteredVehicles().isEmpty());
    }

    @Test
    @DisplayName("Validate update TollStation fields using setters")
    void test_Should_Update_TollStation_Fields() {
        TollStation station = new TollStation();

        station.setName("New Station");
        station.setCity("Barcelona");
        station.setTotalCollected(new BigDecimal("250.00"));

        assertEquals("New Station", station.getName());
        assertEquals("Barcelona", station.getCity());
        assertEquals(new BigDecimal("250.00"), station.getTotalCollected());
    }

    @Test
    @DisplayName("Validate add a vehicle to the registered vehicles list")
    void test_Should_Add_Vehicle_To_Registered_Vehicles() {
        TollStation station = new TollStation("Station A", "Madrid");

        Vehicle vehicle = new Vehicle("ABC123", new BigDecimal("100.00"), VehicleType.CAR);
        station.addVehicle(vehicle);

        assertEquals(1, station.getRegisteredVehicles().size());
        assertEquals("ABC123", station.getRegisteredVehicles().get(0).getLicensePlate());
    }

    @Test
    @DisplayName("Validate update totalCollected when a vehicle is added")
    void test_Should_Update_Total_Collected_When_Vehicle_Is_Added() {
        TollStation station = new TollStation("Station A", "Madrid");

        Vehicle car = new Vehicle("CAR001", new BigDecimal("100.00"), VehicleType.CAR);
        Vehicle truck = new Vehicle("TRK001", new BigDecimal("150.00"), VehicleType.TRUCK);

        station.addVehicle(car);
        station.addVehicle(truck);

        assertEquals(new BigDecimal("250.00"), station.getTotalCollected());
    }

}
