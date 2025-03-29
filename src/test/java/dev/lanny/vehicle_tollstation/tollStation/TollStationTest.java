package dev.lanny.vehicle_tollstation.tollStation;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
